package order;

import java.util.ArrayList;
import java.util.HashMap;


public class Order {
    public String orderNum;
    public ArrayList<String> orderItems;
    public ArrayList<String> orderQuantities;
    public HashMap<String, String> orderList;

    /**
     * Construct an instance of the Entity Order.
     * @param orderNum The order number of a single order.
     * @param orderItems The item names in this order.
     * @param orderQuantities The quantities of each item that customer has order.
     * @param orderList The list that has all the items and the corresponding quantities for this order.
     */
    public Order(String orderNum, ArrayList<String> orderItems, ArrayList<String> orderQuantities, HashMap<String, String> orderList){
        this.orderNum = orderNum;
        this.orderItems = orderItems;
        this.orderQuantities = orderQuantities;
        this.orderList = orderList;
    }

    /**
     * The setter method of the instance values.
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderItems(ArrayList<String> orderItems) {
        this.orderItems = orderItems;
    }

    public void setOrderQuantities(ArrayList<String> orderQuantities) {
        this.orderQuantities = orderQuantities;
    }

    public void setOrderList(ArrayList<String> orderItems, ArrayList<String> orderQuantities) {
        for (int i = 0; i < getOrderItems().size(); i++){
            this.orderList.put(orderItems.get(i), orderQuantities.get(i));
        }
    }

    /**
     * The getter method of the instance values.
     */
    public String getOrderNum() {
        return orderNum;
    }

    public ArrayList<String> getOrderItems() {
        return orderItems;
    }

    public ArrayList<String> getOrderQuantities() {
        return orderQuantities;
    }

    public HashMap<String, String> getOrderList() {
        return orderList;
    }
}
