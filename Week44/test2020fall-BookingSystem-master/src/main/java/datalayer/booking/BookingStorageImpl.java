package datalayer.booking;

import dto.Booking;
import dto.BookingCreation;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class BookingStorageImpl implements BookingStorage{

    private String connectionString;
    private String username, password;

    public BookingStorageImpl(String conStr, String user, String pass){
        connectionString = conStr;
        username = user;
        password = pass;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }

    @Override
    public Collection<Booking> getBookingsForCustomer(int customerId) throws SQLException {
        Collection collection = new HashSet();
        List<Booking> bookings = getBookings();
        for (int i = 0; i < bookings.size(); i++) {
            if(bookings.get(i).getCustomerID() == customerId) {
                collection.add(bookings);
            }
        }
        return collection;
        }

    @Override
    public int createBooking(BookingCreation booking) throws SQLException {
        var sql = "insert into Employees(firstname, lastname) values (?, ?)";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, booking.getCustomerId());
            stmt.setInt(2, booking.getEmployeeId());
            stmt.setDate(3, (Date) booking.getDate());
            stmt.setTime(4, booking.getStart());
            stmt.setTime(5, booking.getEnd());

            stmt.executeUpdate();

            // get the newly created id
            try (var resultSet = stmt.getGeneratedKeys()) {
                resultSet.next();
                int newId = resultSet.getInt(1);
                return newId;
            }
        }
    }


    public List<Booking> getBookings() throws SQLException {
        try (var con = getConnection();
             var stmt = con.createStatement()) {
            var results = new ArrayList<Booking>();

            try (ResultSet resultSet = stmt.executeQuery("select ID, customerID, employeeID, date,start,end from Bookings")) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    int customerID = resultSet.getInt("customerID");
                    int employeeID = resultSet.getInt("employeeID");
                    Date date = resultSet.getDate("date");
                    Time start = resultSet.getTime("start");
                    Time end = resultSet.getTime("end");

                    Booking b = new Booking(id, customerID, employeeID,date,start,end);
                    results.add(b);
                }
            }
            return results;
        }
    }
}
