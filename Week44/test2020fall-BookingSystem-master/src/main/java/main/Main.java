package main;

import dto.Customer;
import datalayer.customer.CustomerStorageImpl;
import dto.CustomerCreation;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String conStr = "jdbc:mysql://localhost:3307/mysql";
    private static final String user = "root";
    private static final String pass = "testuser123";

    public static void main(String[] args) throws SQLException {
        CustomerStorageImpl storage = new CustomerStorageImpl(conStr, user, pass);
        System.out.println("Got customers: ");
        CustomerCreation adder = new CustomerCreation("Jar", "Rule", null, null);
        storage.createCustomer(adder);
        for(Customer c : storage.getCustomers()) {
            System.out.println(toString(c));
        }
        System.out.println("The end.");
    }

    public static String toString(Customer c) {
        return "{" + c.getId() + ", " + c.getFirstname() + ", " + c.getLastname() + "}";
    }
}
