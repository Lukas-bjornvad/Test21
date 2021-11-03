package unit.servicelayer.booking;

import datalayer.booking.BookingStorage;
import datalayer.customer.CustomerStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.booking.BookingService;
import servicelayer.booking.BookingServiceException;
import servicelayer.booking.BookingServiceImpl;
import servicelayer.customer.CustomerService;
import servicelayer.customer.CustomerServiceException;
import servicelayer.customer.CustomerServiceImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("unit")
public class CreateBookingTest {

    // SUT (System Under Test)
    private BookingService bookingService;

    // DOC (Depended-on Component)
    private BookingStorage storageMock;


    @BeforeAll
    public void beforeAll(){
        storageMock = mock(BookingStorage.class);
        bookingService = new BookingServiceImpl(storageMock);
    }

    @Test
    public void mustCallStorageWhenCreatingBooking() throws BookingServiceException, SQLException  {
        // Arrange
        // Act
        var customerID = 123456789;
        var employeeID = 987654321;
        var date = new Date(1239821l);
        var start = new Time(1234567l);
        var end = new Time(1234567l);

        bookingService.createBooking(customerID,employeeID,date,start,end);

        // Assert
        // Can be read like: verify that storageMock was called 1 time on the method
        //   'createCustomer' with an argument whose 'firstname' == firstName and
        //   whose 'lastname' == lastName
        verify(storageMock, times(1))
                .createBooking(
                        argThat(x -> x.customerId == customerID &&
                                x.employeeId == employeeID));
    }
}
