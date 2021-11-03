package servicelayer.employee;

import dto.Employee;
import servicelayer.customer.CustomerServiceException;

import java.sql.Date;

public interface EmployeeService {
    int createEmployee(String firstName, String lastName, Date birthdate) throws EmployeeServiceException;
    Employee getEmployeeByld(int employeeId);
}
