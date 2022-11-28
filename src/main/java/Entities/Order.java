package Entities;

import Helpers.Deserializer;
import Entities.Users.Seller;
import UseCases.OrderUseCases.CheckTotalOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Order {
    public static final int UNSET_TOTAL_ORDER = -88;
    private int orderNum;
    private HashMap<String, Integer> orderList;
    private String orderStatus;
    private static int totalOrder = UNSET_TOTAL_ORDER;

    /**
     * Construct an instance of the Entity Order
     * @param orderList       The list that has all the items and the corresponding quantities for this order.
     * @param orderStatus     A string indicating the current status of the order, including [inProgress, ready, pickedUp, delivered].
     */
    public Order(HashMap<String, Integer> orderList, String orderStatus) {
        this.orderList = orderList;
        this.orderStatus = orderStatus;
        if (totalOrder == UNSET_TOTAL_ORDER) {
            totalOrder = CheckTotalOrder.checkTotalOrder() + 1;
        } else {
            totalOrder += 1;
        }
        orderNum = totalOrder;
    }

    /**
     * The setter method of the instance values.
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * The getter method of the instance values.
     */
    public int getOrderNum() {
        return orderNum;
    }

    public HashMap<String, Integer> getOrderList() {
        return orderList;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public int getTotalOrder() {
        return totalOrder;
    }
}