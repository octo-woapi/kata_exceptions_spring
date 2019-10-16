package kataexc.domain;

public class Skooler {

    private String polygram;
    private String firstName;
    private String lastName;
    private String email;

    public Skooler() {
    }

    public Skooler(String polygram, String firstName, String lastName, String email) {
        this.polygram = polygram;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getPolygram() {
        return polygram;
    }

    public void setPolygram(String polygram) {
        this.polygram = polygram;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Skooler{" +
                "polygram='" + polygram + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
