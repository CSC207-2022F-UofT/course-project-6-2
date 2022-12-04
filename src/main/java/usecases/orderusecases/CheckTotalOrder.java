package usecases.orderusecases;

import entities.Order;
import entities.users.Seller;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckTotalOrder {
    public static int checkTotalOrder() {
        // Get hashmap of all sellers
        HashMap<String, Seller> sellers = UserRuntimeDataBase.getSellers();
        int totalOrder = Order.UNSET_TOTAL_ORDER;

        // If there are sellers, check an arbitrary order
        if (sellers != null && sellers.size() != 0) {
            for(Map.Entry<String, Seller> entry : sellers.entrySet()) {
                ArrayList<Order> sellerOrders = entry.getValue().getAllOrders();
                if (sellerOrders != null) {
                    for (Order order : sellerOrders) {
                        if (order.getOrderNum() > totalOrder) totalOrder = order.getOrderNum();
                    }
                }
            }
        }

        if (totalOrder != Order.UNSET_TOTAL_ORDER) return totalOrder;
        return 0;
    }
}