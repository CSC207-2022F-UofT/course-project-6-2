package users;

import java.util.ArrayList;

public class Customer extends User{
    public int dateOfBirth;
    public ArrayList<String> orderHistory;

    /**
     * Construct an instance of the entity Customer.
     * @param accountName The nickname of the customer.
     * @param passWord The password of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param dateOfBirth The date of birth of the customer.
     * @param address The address of the customer.
     * @param orderHistory The order history of the customer.
     */
    public Customer(String accountName, String passWord, String phoneNumber, int dateOfBirth, String address, ArrayList<String> orderHistory){
        super(accountName, passWord, phoneNumber, address);
        this.dateOfBirth = dateOfBirth;
        this.orderHistory = orderHistory;
    }

    /**
     * Setter methods for the new instance values.
     */
    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setOrderHistory(ArrayList<String> orderHistory) {
        this.orderHistory = orderHistory;
    }

    /**
     * Getter methods for the new instance values.
     */
    public int getDateOfBirth() {
        return this.dateOfBirth;
    }

    public ArrayList<String> getOrderHistory() {
        return this.orderHistory;
    }
}
