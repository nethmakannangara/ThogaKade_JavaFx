package bd;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    public static DBConnection instance;
    private List<Customer> customerList;

    private DBConnection() {
        customerList = new ArrayList<>();
    }

    public static DBConnection getInstance() {
        return null == instance ? instance = new DBConnection() : instance;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
