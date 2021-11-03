package integration.servicelayer.employee;

import datalayer.customer.CustomerStorage;
import datalayer.customer.CustomerStorageImpl;
import datalayer.employee.EmployeeStorage;
import datalayer.employee.EmployeeStorageImpl;
import dto.Booking;
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
class SvcCreateEmployeeTest extends ContainerizedDbIntegrationTest {

    private EmployeeService svc;
    private EmployeeStorage storage;

    @BeforeAll
    public void setup() {
        runMigration(3);
        storage = new EmployeeStorageImpl(getConnectionString(),"root", getDbPassword());
        svc = new EmployeeServiceImpl(storage);
    }

    @Test
    public void mustSaveEmployeeToDatabaseWhenCallingCreateEmployee() throws EmployeeServiceException, SQLException {
        // Arrange
        var employeeID = 987654321;
        var firstname = "Luke";
        var lastname = "Skywalker";
        var birthdate = new Date(1234l);
        int id = svc.createEmployee(firstname, lastname, birthdate);

        // Act
        var createdEmployee = svc.getEmployeeById(employeeID);

        // Assert
        assertEquals(firstname, createdEmployee.getFirstname());
        assertEquals(lastname, createdEmployee.getLastname());
    }
}
