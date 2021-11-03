package dto;

import java.sql.Date;

public class CustomerCreation {
    public String getFirstname() { return firstname; }

    public String getLastname() {
        return lastname;
    }

    public String getPhonenumb() { return phonenumb;  }

    public Date getBirthdate() { return birthdate; }

    public final String firstname, lastname, phonenumb;
    private final Date birthdate;

    public CustomerCreation(String firstname, String lastname, Date birtdate, String phonenumb) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumb = phonenumb;
        this.birthdate = birtdate;
    }
}
