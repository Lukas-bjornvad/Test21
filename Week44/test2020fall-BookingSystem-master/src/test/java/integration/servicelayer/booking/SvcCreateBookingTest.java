package integration.servicelayer.booking;

import datalayer.customer.CustomerStorage;
import datalayer.customer.CustomerStorageImpl;
import dto.Booking;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
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

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SvcCreateBookingTest extends ContainerizedDbIntegrationTest {

    private BookingService svc;
    //    private BookingStorage storage;

    @BeforeAll
    public void setup() {
        runMigration(3);
//        storage = new BookingStorageImpl(getConnectionString(),"root", getDbPassword());
//        svc = new BookingServiceImpl(storage);
    }

    @Test
    public void mustSaveBookingToDatabaseWhenCallingCreateBooking() throws BookingServiceException, SQLException {
        // Arrange
        var customerID = 123456789;
        var employeeID = 987654321;
        var date = new Date(1239821l);
        var start = new Time(1234567l);
        var end = new Time(1234567l);
        int id = svc.createBooking(customerID, employeeID, date, start, end);

        // Act
//        var createdBooking = ;

        // Assert
//        assertEquals(customerID, createdBooking.getFirstname());
//        assertEquals(employeeID, createdBooking.getLastname());
    }
}
