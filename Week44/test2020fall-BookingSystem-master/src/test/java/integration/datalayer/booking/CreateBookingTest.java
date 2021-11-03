package integration.datalayer.booking;

import com.github.javafaker.Faker;
import datalayer.booking.BookingStorage;
import datalayer.booking.BookingStorageImpl;
import datalayer.customer.CustomerStorage;
import datalayer.employee.EmployeeStorage;
import dto.BookingCreation;
import dto.CustomerCreation;
import dto.EmployeeCreation;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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



        bookingStorage = new BookingStorageImpl(getConnectionString(), "root", getDbPassword());

        var numBookings = bookingStorage.getBookings().size();
        if (numBookings < 100) {
            addFakeBookings(100 - numBookings);
        }
    }

    private void addFakeBookings(int numBookings) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numBookings; i++) {
            var time = new Time(12345678);
            var time2 = new Time(12345678);
            java.sql.Date sqlStartDate = new java.sql.Date(faker.date().birthday().getTime());
            CustomerCreation c = new CustomerCreation(faker.name().firstName(), faker.name().lastName(), null, null);
            customerStorage.createCustomer(c);
            EmployeeCreation e = new EmployeeCreation(faker.name().firstName(), faker.name().lastName(), sqlStartDate);
            employeeStorage.createEmployee(e);
            BookingCreation b = new BookingCreation(i+1, i+1, sqlStartDate,time,time2);
            bookingStorage.createBooking(b);
        }

    }

    private void addFakeCustomers(int numCustomers) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numCustomers; i++) {
            CustomerCreation c = new CustomerCreation(faker.name().firstName(), faker.name().lastName(), null, null);
            customerStorage.createCustomer(c);
        }

    }

    private void addFakeEmployees(int numEmployees) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numEmployees; i++) {
            java.sql.Date sqlStartDate = new java.sql.Date(faker.date().birthday().getTime());
            EmployeeCreation e = new EmployeeCreation(faker.name().firstName(), faker.name().lastName(), sqlStartDate);
            employeeStorage.createEmployee(e);
        }

    }

    @Test
    public void mustSaveBookingInDatabaseWhenCallingCreateBooking() throws SQLException {
        // Arrange
        // Act
        int cosid = 123;
        int empid = 1234;
        bookingStorage.createBooking(new BookingCreation(cosid,empid, null, null,null));

        // Assert
        var Bookings = bookingStorage.getBookings();
        //assertTrue(2,2);
    }

    @Test
    public void mustReturnLatestId() throws SQLException {
        // Arrange
        // Act
        var id1 = bookingStorage.createBooking(new BookingCreation(1, 2, null, null,null));
        var id2 = bookingStorage.createBooking(new BookingCreation(3, 4 , null , null,null));

        // Assert
        assertEquals(1, id2 - id1);
    }
}
