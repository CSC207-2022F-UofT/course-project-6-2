package order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Order {
    public String orderNum;
    public ArrayList<String> orderItems;
    public ArrayList<String> orderQuantities;
    public HashMap<String, String> orderList;
    public String orderStatus;
    public static HashMap<String, Order> totalOrder;

    /**
     * Construct an instance of the Entity Order.
     *
     * @param orderNum        The order number of a single order with len 10.
     * @param orderItems      The item names in this order.
     * @param orderQuantities The quantities of each item that customer has order.
     * @param orderList       The list that has all the items and the corresponding quantities for this order.
     * @param orderStatus     A string indicating the current status of the order, including [inProgress, ready, pickedUp, delivered].
     * @param totalOrder      A hashmap that keep track of all the orders.
     */
    public Order(String orderNum, ArrayList<String> orderItems, ArrayList<String> orderQuantities, HashMap<String, String> orderList, String orderStatus, HashMap<String, Order> totalOrder) {
        this.orderNum = orderNum;
        this.orderItems = orderItems;
        this.orderQuantities = orderQuantities;
        this.orderList = orderList;
        this.orderStatus = orderStatus;
        this.totalOrder = totalOrder;
    }

    /**
     * The setter method of the instance values.
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = generateOrderNum();
    }

    public void setOrderItems(ArrayList<String> orderItems) {
        this.orderItems = orderItems;
    }

    public void setOrderQuantities(ArrayList<String> orderQuantities) {
        this.orderQuantities = orderQuantities;
    }

    public void setOrderList(ArrayList<String> orderItems, ArrayList<String> orderQuantities) {
        for (int i = 0; i < getOrderItems().size(); i++) {
            this.orderList.put(orderItems.get(i), orderQuantities.get(i));
        }
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public static void setTotalOrder(HashMap<String, Order> totalOrder) {
        Order.totalOrder = totalOrder;
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

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public static HashMap<String, Order> getTotalOrder() {
        return totalOrder;
    }

    /**
     * Generate a random string represent as the order number of the order.
     * Every order number is unique.
     * @return A random generated string with digits and letters.
     */
    public static String generateOrderNum() {
        UUID randomUUID = UUID.randomUUID();
        String orderNumber = randomUUID.toString().replaceAll("-", "").substring(0, 10);
        while (totalOrder.containsKey(orderNumber)) {
            randomUUID = UUID.randomUUID();
            orderNumber = randomUUID.toString().replaceAll("-", "").substring(0, 10);
        }
        return orderNumber;
    }
}