package servicelayer.employee;

import dto.Employee;
import servicelayer.customer.CustomerServiceException;

public class EmployeeServiceImpl implements EmployeService{

    @Override
    public int createEmployee(Employee employee) throws EmployeeServiceException {
        return 0;
    }

    @Override
    public Employee getEmployeeByld(int employeeId) {
        return null;
    }
}
