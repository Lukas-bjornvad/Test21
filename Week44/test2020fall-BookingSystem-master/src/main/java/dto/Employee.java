package dto;

import java.util.Date;

public class Employee {
    private int ID;
    private String firstname;
    private String lastname;
    private Date date;

    public Employee(int ID, String firstname, String lastname, Date date) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDate() {
        return date;
    }
}
