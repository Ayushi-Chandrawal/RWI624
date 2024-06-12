package SERVICE;

import DAO.CustomerDao;
import MODEL.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
        private CustomerDao customerDao;

        public CustomerService() {
            customerDao = new CustomerDao();
        }

        public void addCustomer(Customer customer) throws SQLException{
            customerDao.addCustomer(customer);
        }
        public Customer getCustomerById(int id) throws SQLException {
            return customerDao.getCustomerId(id);
        }

        public List<Customer> getAllCustomer() throws SQLException {
            return customerDao.getAllcustomers();
        }

        public void updateCustomer(Customer customer) throws SQLException {
            customerDao.updateCustomer(customer);
        }

        public void deleteCustomer(int id) throws SQLException {
            customerDao.deleteCustomer(id);
        }
}
