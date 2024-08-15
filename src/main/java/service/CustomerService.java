package service;

import bd.DBConnection;
import model.Customer;

import java.util.List;

public class CustomerService {
    static List<Customer> customerList = DBConnection.getInstance().getCustomerList();
    private static int id = DBConnection.getInstance().getCustomerList().size();

    public static String generateID() {
        return "C00" + (++id);
    }

    public static boolean checkCustomerID(String existId) {
        if (customerList.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).getId().equals(existId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkCustomerContactNO(String PhoneNO) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getNumber().equals(PhoneNO)) {
                return true;
            }
        }
        return false;
    }

    public static int searchCustomer(String id){
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
