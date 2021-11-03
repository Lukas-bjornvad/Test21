package integration.datalayer.employee;

import com.github.javafaker.Faker;
import datalayer.customer.CustomerStorage;
import datalayer.customer.CustomerStorageImpl;
import datalayer.employee.EmployeeStorage;
import datalayer.employee.EmployeeStorageImpl;
import dto.CustomerCreation;
import dto.Employee;
import dto.EmployeeCreation;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
class CreateEmployeeTest extends ContainerizedDbIntegrationTest {
    private EmployeeStorage employeeStorage;

    /* changed code */

    @BeforeAll
    public void Setup() throws SQLException {
        runMigration(2);

        employeeStorage = new EmployeeStorageImpl(getConnectionString(), "root", getDbPassword());

        var numEmployees = employeeStorage.getEmployees().size();
        if (numEmployees < 100) {
            addFakeEmployees(100 - numEmployees);
        }
    }

    private void addFakeEmployees(int numEmployees) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numEmployees; i++) {
            java.sql.Date sqlStartDate = new java.sql.Date(faker.date().birthday().getTime());
            EmployeeCreation c = new EmployeeCreation(faker.name().firstName(), faker.name().lastName(), sqlStartDate);
            employeeStorage.createEmployee(c);
        }

    }

    @Test
    public void mustSaveEmployeeInDatabaseWhenCallingCreateCustomer() throws SQLException {
        // Arrange
        // Act
        employeeStorage.createEmployee(new EmployeeCreation("John","Carlssonn", null));

        // Assert
        var employees = employeeStorage.getEmployees();
        assertTrue(
                employees.stream().anyMatch(x ->
                        x.getFirstname().equals("John") &&
                        x.getLastname().equals("Carlssonn")));
    }

    @Test
    public void mustReturnLatestId() throws SQLException {
        // Arrange
        // Act
        var id1 = employeeStorage.createEmployee(new EmployeeCreation("a", "b", null));
        var id2 = employeeStorage.createEmployee(new EmployeeCreation("c", "d" , null));

        // Assert
        assertEquals(1, id2 - id1);
    }
}
