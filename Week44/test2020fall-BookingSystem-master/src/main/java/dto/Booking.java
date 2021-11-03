package dto;

import java.sql.Time;
import java.util.Date;

public class Booking {

    private int ID;
    private int customerID;
    private int employeeID;
    private Date date;
    private Time start;
    private Time end;

    public Booking(int ID, int customerID, int employeeID, Date date, Time start, Time end) {
        this.ID = ID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.date = date;
        this.start = start;
        this.end = end;
    }

    public int getID() {
        return ID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Date getDate() {
        return date;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }
}
