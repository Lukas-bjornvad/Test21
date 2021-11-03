package dto;

import java.util.Date;

public class Employee {
    private int ID;
    private String fistname;
    private String lastname;
    private Date date;

    public Employee(int ID, String fistname, String lastname, Date date) {
        this.ID = ID;
        this.fistname = fistname;
        this.lastname = lastname;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public String getFistname() {
        return fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDate() {
        return date;
    }
}
