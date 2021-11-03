package dto;

import java.sql.Date;

public class EmployeeCreation {
    public String getFirstname() { return firstname; }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() { return birthdate; }

    public final String firstname, lastname;
    private final Date birthdate;

    public EmployeeCreation(String firstname, String lastname, Date birtdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birtdate;
    }
}
