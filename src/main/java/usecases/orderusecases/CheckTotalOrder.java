package usecases.orderusecases;

import entities.Order;
import entities.users.Seller;
import usecases.userusercases.UserRuntimeDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckTotalOrder {
    public static int checkTotalOrder() {
        // Get hashmap of all sellers
        HashMap<String, Seller> sellers = UserRuntimeDataBase.getSellers();

        // If there are sellers, check an arbitrary order
        if (sellers != null && sellers.size() != 0) {
            for(Map.Entry<String, Seller> entry : sellers.entrySet()) {
                ArrayList<Order> sellerOrders = entry.getValue().getAllOrders();
                if (sellerOrders != null && sellerOrders.size() != 0) return sellerOrders.get(0).getTotalOrder();
            }
        }
        // If there's no seller or/and there's no order, total order = 0
        return 0;
    }
}