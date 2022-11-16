package users;

import order.Order;

import java.util.ArrayList;

public class Customer extends User{
    public int age;
    public ArrayList<Order> orderHistory;

    /**
     * Construct an instance of the entity Customer.
     * @param accountName The nickname of the customer.
     * @param passWord The password of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param age The date of birth of the customer.
     * @param address The address of the customer.
     * @param orderHistory The order history of the customer.
     */
    public Customer(String accountName, String passWord, String phoneNumber, int age, String address, ArrayList<Order> orderHistory){
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

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
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

    public String getOrderStatus(Order order){
        for(int i = 0; i < this.orderHistory.size(); i++){
            if (this.orderHistory.get(i).orderNum == order.orderNum){
                return this.orderHistory.get(i).orderStatus;
            }
        }
        return "Order Not Found";
    }
}
