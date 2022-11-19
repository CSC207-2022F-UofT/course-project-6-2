package Controller;

import users.Customer;

import java.util.ArrayList;

public class GetCustomerController extends Customer {

    Customer customer = new Customer(this.getAccountName(), this.getPassWord(), this.getPhoneNumber(), this.getAge(),this.getAddress(),
            this.getOrderHistory());
    /**
     * Construct an instance of the entity Customer.
     *
     * @param accountName  The nickname of the customer.
     * @param passWord     The password of the customer.
     * @param phoneNumber  The phone number of the customer.
     * @param age          The date of birth of the customer.
     * @param address      The address of the customer.
     * @param orderHistory The order history of the customer.
     */
    public GetCustomerController(String accountName, String passWord, String phoneNumber, int age, String address, ArrayList<String> orderHistory) {
        super(accountName, passWord, phoneNumber, age, address, orderHistory);
    }

    // get current user from phone number
    public Customer getCustomer(String phoneNum){
        if (phoneNum.equals(customer.getPhoneNumber())){
            return customer;
        }
        return null;
    }
}
