package entities.users;

import entities.Order;
import entities.ShoppingCart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// Entities Layer

public class Customer extends User implements Serializable {
    private int age;
    private ArrayList<Order> orderHistory;
    private ShoppingCart shoppingCart;

    /**
     * Construct an instance of the entity Customer.
     * @param accountName The nickname of the customer.
     * @param passWord The password of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param age The date of birth of the customer.
     * @param address The address of the customer.
     */
    public Customer(String accountName, String phoneNumber, String passWord, int age, String address){
        super(accountName, phoneNumber, passWord, address);
        this.age = age;
        this.shoppingCart = new ShoppingCart(0, new HashMap<>());
    }

    /**
     * Setter methods for the new instance values.
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Getter methods for the new instance values.
     */
    public int getAge() {
        return this.age;
    }

    public ArrayList<Order> getOrderHistory() {
        return this.orderHistory;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void addNewOrder(Order order){
        orderHistory.add(order);
    }
}
