package servicelayer.employee;

import dto.Employee;
import servicelayer.customer.CustomerServiceException;

public interface EmployeService {
    int createEmployee(Employee employee) throws EmployeeServiceException;
    Employee getEmployeeByld(int employeeId);
}
