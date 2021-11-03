package datalayer.booking;


import dto.Booking;
import dto.BookingCreation;
import dto.Customer;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


public interface BookingStorage {
    Collection<Booking> getBookingsForCustomer(int customerId) throws SQLException;
    public int createBooking(BookingCreation booking) throws SQLException;
    public List<Booking> getBookings() throws SQLException;
}
