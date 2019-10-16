package kataexc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import static com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@SpringBootApplication
public class KataexcApp implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(KataexcApp.class);

    @Bean
    public ObjectMapper jacksonBuilder() {
        return new ObjectMapper()
                .configure(USE_BIG_DECIMAL_FOR_FLOATS, true)
                .configure(WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public static void main(String[] args) {
        SpringApplication.run(KataexcApp.class, args);
    }

    //initialize database
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");
        jdbc.execute("DROP TABLE IF EXISTS skoolers");
        jdbc.execute("CREATE TABLE skoolers(polygram VARCHAR(8) PRIMARY KEY, first_name VARCHAR(100) NOT NULL, last_name VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL)");
        log.info("Populating skoolers");
        jdbc.batchUpdate("INSERT INTO skoolers (polygram, first_name, last_name, email) values ('QUEN', 'Quentin', 'MINO', 'qmino@octo.com')");
        log.info("Checking skoolers");
        log.info(jdbc.queryForObject("SELECT COUNT(*) FROM skoolers", Integer.class).toString());

    }
}
