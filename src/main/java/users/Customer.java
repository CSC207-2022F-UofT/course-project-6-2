package users;

import order.Order;

import java.io.Serializable;
import java.util.ArrayList;


public class Customer extends User implements Serializable {
    public int age;

    public ArrayList<String> orderHistory;

    /**
     * Construct an instance of the entity Customer.
     * @param accountName The nickname of the customer.
     * @param passWord The password of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param age The date of birth of the customer.
     * @param address The address of the customer.
     * @param orderHistory The order history of the customer.
     */
    public Customer(String accountName, String passWord, String phoneNumber, int age, String address, ArrayList<String> orderHistory){
        super(accountName, passWord, phoneNumber, address);
        this.age = age;
        this.orderHistory = orderHistory;
    }

    /**
     * Setter methods for the new instance values.
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void setOrderHistory(ArrayList<String> orderHistory) {
        this.orderHistory = orderHistory;
    }

    /**
     * Getter methods for the new instance values.
     */
    public int getAge() {
        return this.age;
    }

    public ArrayList<String> getOrderHistory() {
        return this.orderHistory;
    }

    public void recorder(Order order){
        Order newOrder = new Order(order);
    }

}
