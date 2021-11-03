package servicelayer.employee;

import dto.Employee;
import servicelayer.customer.CustomerServiceException;

import java.sql.Date;
import java.sql.SQLException;

public interface EmployeeService {
    int createEmployee(String firstName, String lastName, Date birthdate) throws EmployeeServiceException;
    Employee getEmployeeById(int employeeId) throws SQLException;
}
