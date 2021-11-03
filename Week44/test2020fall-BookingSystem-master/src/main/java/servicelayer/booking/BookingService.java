package servicelayer.booking;

import dto.Booking;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

public interface BookingService {
    int createBooking(int customerId, int employeeId, Date date, Time start, Time end) throws BookingServiceException;
    Collection<Booking> getBookingsForCustomer(int customerId);
    Collection<Booking> getBookingsForEmployee(int employeeId);
}
