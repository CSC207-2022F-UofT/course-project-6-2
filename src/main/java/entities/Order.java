package entities;

import java.util.HashMap;

public class Order {
    public static final int UNSET_TOTAL_ORDER = -88;
    private int orderNum;
    private final HashMap<Drink, Integer> orderList;
    private String orderStatus;
    private static int totalOrder = UNSET_TOTAL_ORDER;

    /**
     * Construct an instance of the Entity Order
     * @param orderList       The list that has all the items and the corresponding quantities for this order.
     * @param orderStatus     A string indicating the current status of the order, including [inProgress, ready, pickedUp, delivered].
     */
    public Order(HashMap<Drink, Integer> orderList, String orderStatus) {
        this.orderList = orderList;
        this.orderStatus = orderStatus;
    }

    /**
     * The setter method of the instance values.
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public static void setTotalOrder(int totalOrder) {
        Order.totalOrder = totalOrder;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * The getter method of the instance values.
     */
    public int getOrderNum() {
        return orderNum;
    }

    public HashMap<Drink, Integer> getOrderList() {
        return orderList;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public int getTotalOrder() {
        return totalOrder;
    }
}