package integration.datalayer.booking;

import com.github.javafaker.Faker;
import datalayer.booking.BookingStorage;
import datalayer.booking.BookingStorageImpl;
import datalayer.customer.CustomerStorage;
import datalayer.customer.CustomerStorageImpl;
import datalayer.employee.EmployeeStorage;
import datalayer.employee.EmployeeStorageImpl;
import dto.BookingCreation;
import dto.CustomerCreation;
import dto.EmployeeCreation;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
class CreateBookingTest extends ContainerizedDbIntegrationTest {
    private BookingStorage bookingStorage;
    private CustomerStorage customerStorage;
    private EmployeeStorage employeeStorage;

    /* changed code */

    @BeforeAll
    public void Setup() throws SQLException {
        runMigration(2);
        customerStorage = new CustomerStorageImpl(getConnectionString(), "root", getDbPassword());
        employeeStorage = new EmployeeStorageImpl(getConnectionString(), "root", getDbPassword());
        CustomerCreation c = new CustomerCreation("faker.name().firstName()", "faker.name().lastName()", null, null);
        customerStorage.createCustomer(c);
        java.sql.Date sqlStartDate = new java.sql.Date(12356899);
        EmployeeCreation e = new EmployeeCreation("faker.name().firstName()", "faker.name().lastName()", sqlStartDate);
        employeeStorage.createEmployee(e);
        bookingStorage = new BookingStorageImpl(getConnectionString(), "root", getDbPassword());
            addFakeBookings(100);
    }

    private void addFakeBookings(int numBookings) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numBookings; i++) {
            var time = new Time(12345678);
            var time2 = new Time(12345678);
            java.sql.Date sqlStartDate = new java.sql.Date(faker.date().birthday().getTime());
            BookingCreation b = new BookingCreation(1, 1, sqlStartDate,time,time2);
            bookingStorage.createBooking(b);
        }

    }


    @Test
    public void mustSaveBookingInDatabaseWhenCallingCreateBooking() throws SQLException {
        // Arrange
        // Act

        bookingStorage.createBooking(new BookingCreation(1,1, new Date(21345675), new Time(23456787),new Time(23456787)));

        // Assert
        var Bookings = bookingStorage.getBookings();
        assertEquals(Bookings.size(),104);
    }

    @Test
    public void mustReturnLatestId() throws SQLException {
        // Arrange
        // Act
        var id1 = bookingStorage.createBooking(new BookingCreation(1, 1, new Date(21345675), new Time(23456787),new Time(23456787)));
        var id2 = bookingStorage.createBooking(new BookingCreation(1, 1 , new Date(21345675) , new Time(23456787),new Time(23456787)));

        // Assert
        assertEquals(1, id2 - id1);
    }
}
