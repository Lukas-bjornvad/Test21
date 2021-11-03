package servicelayer.employee;

import dto.Employee;

import java.sql.Date;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public int createEmployee(String firstName, String lastName, Date birthdate) throws EmployeeServiceException {
        return 0;
    }

    @Override
    public Employee getEmployeeByld(int employeeId) {
        return null;
    }
}
