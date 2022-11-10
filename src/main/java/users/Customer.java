package users;

import java.util.ArrayList;

public class Customer extends User{
    public int dateOfBirth;
    public String address;
    public ArrayList<String> orderHistory;

    /**
     * Construct an instance of the entity Customer.
     * @param name The nickname of the customer.
     * @param password The password of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param dateOfBirth The date of birth of the customer.
     * @param address The address of the customer.
     * @param orderHistory The order history of the customer.
     */
    public Customer(String name, String password, int phoneNumber, int dateOfBirth, String address, ArrayList<String> orderHistory){
        super(name, password, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.orderHistory = orderHistory;
    }

    /**
     * Setter methods for the new instance values.
     */
    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getAddress(){
        return this.address;
    }

    public ArrayList<String> getOrderHistory() {
        return this.orderHistory;
    }
}
