package order;

import helpers.Deserializer;
import users.Seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Order {
    public static final int UNSET_TOTAL_ORDER = -88;
    public int orderNum;
    public HashMap<String, Integer> orderList;
    public String orderStatus;
    public static int totalOrder = UNSET_TOTAL_ORDER;

    /**
     * Construct an instance of the Entity Order
     * @param orderList       The list that has all the items and the corresponding quantities for this order.
     * @param orderStatus     A string indicating the current status of the order, including [inProgress, ready, pickedUp, delivered].
     */
    public Order(HashMap<String, Integer> orderList, String orderStatus) throws IOException, ClassNotFoundException {
        this.orderList = orderList;
        this.orderStatus = orderStatus;
        if (totalOrder == UNSET_TOTAL_ORDER) {
            totalOrder = checkTotalOrder() + 1;
        } else {
            totalOrder += 1;
        }
        orderNum = totalOrder;
    }
    @SuppressWarnings("unchecked")
    public int checkTotalOrder() throws IOException, ClassNotFoundException {
        Deserializer deserializer = new Deserializer();
        deserializer.deserialize("./data/users");
        ArrayList<HashMap> data = (ArrayList<HashMap>) deserializer.getObject();
        if (data != null && data.get(0).size() != 0) {
            Iterator<Map.Entry<String, Seller>> iterator = data.get(0).entrySet().iterator();
            Map.Entry<String, Seller> entry = iterator.next();

            if (entry.getValue().getAllOrders().size() != 0) return entry.getValue().getAllOrders().get(0).getTotalOrder();
            else return 0;
        }
        else {
            return 0;
        }
    }

    public Order(Order order) {
        this.orderNum = order.getOrderNum() + 1;
        this.orderList = order.orderList;
        this.orderStatus = "inProgress";
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

    public static int getTotalOrder() {
        return totalOrder;
    }
}
