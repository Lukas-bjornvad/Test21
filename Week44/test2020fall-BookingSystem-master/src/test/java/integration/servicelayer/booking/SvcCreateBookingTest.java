package integration.servicelayer.booking;

import datalayer.booking.BookingStorage;
import datalayer.booking.BookingStorageImpl;
import datalayer.customer.CustomerStorage;
import datalayer.customer.CustomerStorageImpl;
import datalayer.employee.EmployeeStorage;
import datalayer.employee.EmployeeStorageImpl;
import dto.Booking;
import dto.Customer;
import dto.Employee;
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
import servicelayer.employee.EmployeeService;
import servicelayer.employee.EmployeeServiceException;
import servicelayer.employee.EmployeeServiceImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SvcCreateBookingTest extends ContainerizedDbIntegrationTest {

    private BookingService svc;
    private BookingStorage storage;

    private CustomerService svcC;
    private CustomerStorage storageC;

    private EmployeeService svcE;
    private EmployeeStorage storageE;


    @BeforeAll
    public void setup() {
        runMigration(3);
        storage = new BookingStorageImpl(getConnectionString(),"root", getDbPassword());
        svc = new BookingServiceImpl(storage);

        storageC = new CustomerStorageImpl(getConnectionString(),"root", getDbPassword());
        svcC = new CustomerServiceImpl(storageC);

        storageE = new EmployeeStorageImpl(getConnectionString(),"root", getDbPassword());
        svcE = new EmployeeServiceImpl(storageE);
    }

    @Test
    public void mustSaveBookingToDatabaseWhenCallingCreateBooking() throws BookingServiceException, EmployeeServiceException, CustomerServiceException, SQLException {
        // Arrange
        var firstName = "John";
        var lastName = "Johnson";
        var bday = new Date(1239821l);
        var phoneNumb = "+4723894567";
        int customerID = svcC.createCustomer(firstName, lastName, bday, phoneNumb);


        var firstname = "Luke";
        var lastname = "Skywalker";
        var birthdate = new Date(1234l);
        int employeeID = svcE.createEmployee(firstname, lastname, birthdate);


        var date = new Date(123456789l);
        var start = new Time(1234567l);
        var end = new Time(1234567l);
        svc.createBooking(customerID, employeeID, date, start, end);


        // Act
        var createdBooking = storage.getBookings().get(0);


        // Assert
        assertEquals(customerID, createdBooking.getCustomerID());
        assertEquals(employeeID, createdBooking.getEmployeeID());
    }
}
