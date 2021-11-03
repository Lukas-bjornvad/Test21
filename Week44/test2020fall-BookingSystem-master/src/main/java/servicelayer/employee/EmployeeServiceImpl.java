package servicelayer.employee;

import datalayer.booking.BookingStorage;
import datalayer.employee.EmployeeStorage;
import dto.Employee;
import dto.EmployeeCreation;
import servicelayer.booking.BookingServiceException;

import java.sql.Date;
import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeStorage employeeStorage;

    public EmployeeServiceImpl(EmployeeStorage employeeStorage) {
        this.employeeStorage = employeeStorage;
    }

    @Override
    public int createEmployee(String firstName, String lastName, Date birthdate) throws EmployeeServiceException {
        try {
            return employeeStorage.createEmployee(new EmployeeCreation(firstName,lastName,birthdate));
        } catch (SQLException throwables) {
            throw new EmployeeServiceException(throwables.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return null;
    }
}
