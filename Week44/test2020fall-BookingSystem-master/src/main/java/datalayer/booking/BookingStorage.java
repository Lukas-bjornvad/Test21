package datalayer.booking;


import dto.Booking;

import java.sql.SQLException;
import java.util.Collection;


public interface BookingStorage {
    Collection<Booking> getBookingsForCustomer(int customerId) throws SQLException;
    public int createBooking(Booking booking) throws SQLException;
}
