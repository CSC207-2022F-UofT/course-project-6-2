package UseCases.OrderUseCases;

import Entities.Order;
import Entities.Users.Seller;
import UseCases.UserUseCases.UserRuntimeDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckTotalOrder {
    public static int checkTotalOrder() {
        HashMap<String, Seller> sellers = UserRuntimeDataBase.getSellers();
        if (sellers != null && sellers.size() != 0) {
            Iterator<Map.Entry<String, Seller>> iterator = sellers.entrySet().iterator();
            Map.Entry<String, Seller> entry = iterator.next();
            ArrayList<Order> allOrder = entry.getValue().getAllOrders();

            // If there exist an order, get the stored totalOrder, otherwise 0 as no order
            if (allOrder.size() != 0) return allOrder.get(0).getTotalOrder();
            else return 0;
        }
        else {
            return 0;
        }
    }
}