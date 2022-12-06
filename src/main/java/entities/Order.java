package entities;

import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable {
    public static final int UNSET_TOTAL_ORDER = -88;
    private int orderNum;
    private final HashMap<Drink, Integer> orderList;
    private String orderStatus;
    private Float totalPrice;
    private static int totalOrder = UNSET_TOTAL_ORDER;

    /**
     * Construct an instance of the Entity Order
     * @param orderList       The list that has all the items and the corresponding quantities for this order.
     * @param orderStatus     A string indicating the current status of the order, including [inProgress, ready, pickedUp, delivered].
     * @param totalPrice      A float indicating the total price of the order.
     */
    public Order(HashMap<Drink, Integer> orderList, String orderStatus, Float totalPrice) {
        this.orderList = orderList;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
    }

    public Order(Order order) {
        this.orderNum = order.getOrderNum() + 1;
        this.orderList = order.orderList;
        this.orderStatus = "in progress";
        this.totalPrice = order.getTotalPrice();
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

    public void setTotalPrice(Float totalPrice){
        this.totalPrice = totalPrice;
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
    public Float getTotalPrice(){
        return totalPrice;
    }
}
