package servicelayer.customer;

import datalayer.customer.CustomerStorage;
import dto.Customer;
import dto.CustomerCreation;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

public class CustomerServiceImpl implements CustomerService {

    private CustomerStorage customerStorage;

    public CustomerServiceImpl(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    @Override
    public int createCustomer(String firstName, String lastName, Date birthdate, String phonenumb) throws CustomerServiceException {
        try {
            return customerStorage.createCustomer(new CustomerCreation(firstName, lastName, birthdate, phonenumb));
        } catch (SQLException throwables) {
            throw new CustomerServiceException(throwables.getMessage());
        }
    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        return customerStorage.getCustomerWithId(id);
    }

    @Override
    public Collection<Customer> getCustomersByFirstName(String firstName) {
        return null;
    }
}
