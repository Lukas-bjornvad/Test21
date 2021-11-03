package datalayer.employee;

import dto.Booking;
import dto.Customer;
import dto.CustomerCreation;
import dto.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class EmployeeStorageImpl implements EmployeeStorage{

    private String connectionString;
    private String username, password;

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }

    @Override
    public int createEmployee(Employee employee) throws SQLException{
        var sql = "insert into Customers(firstname, lastname) values (?, ?)";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, employee.getFistname());
            stmt.setString(2, employee.getLastname());
            stmt.setDate(3, (Date) employee.getDate());
            stmt.executeUpdate();
            // get the newly created id
            try (var resultSet = stmt.getGeneratedKeys()) {
                resultSet.next();
                int newId = resultSet.getInt(1);
                return newId;
            }
        }
    }



    @Override
    public Collection<Employee> getEmployeeWithId(int employeeId) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        var sql = "select ID, firstname, lastname, birthdate from Customers where id = ?";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);

            try (var resultSet = stmt.executeQuery()) {
                if (resultSet.next()){
                    var id = resultSet.getInt("ID");
                    var firstname = resultSet.getString("firstname");
                    var lastname = resultSet.getString("lastname");
                    var date = resultSet.getDate("date");
                    employees.add(new Employee(id, firstname, lastname,date));
                }
                return employees;
            }
        }
    }


}
