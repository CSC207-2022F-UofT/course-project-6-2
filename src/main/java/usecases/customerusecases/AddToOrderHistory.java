package usecases.customerusecases;

import entities.Drink;
import entities.Order;
import entities.users.Seller;
import usecases.orderusecases.CheckTotalOrder;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The add to order history use case is used for when customer checks out, the order would be added into customer's
 * order history.
 */
public class AddToOrderHistory {
    public static void addToOrderHistory(HashMap<Drink, Integer> orderList, Float totalPrice){
        Order newOrder = new Order(orderList, "in progress", totalPrice);
        int totalOrder = newOrder.getTotalOrder();

        if (totalOrder == Order.UNSET_TOTAL_ORDER) {
            Order.setTotalOrder(CheckTotalOrder.checkTotalOrder() + 1);
        } else {
            Order.setTotalOrder(newOrder.getTotalOrder() + 1);
        }

        newOrder.setTotalPrice(totalPrice);
        newOrder.setOrderNum(newOrder.getTotalOrder());
        UserRuntimeDataBase.getCurrentCustomer().addNewOrder(newOrder);

        ArrayList<String> storeNames = new ArrayList<>();
        for (Map.Entry<Drink, Integer> entry : orderList.entrySet()){
            String storeName = entry.getKey().getStoreName();
            if (! storeNames.contains(storeName)){
                storeNames.add(storeName);
            }
        }

        for (Map.Entry<String, Seller> sellerSet : UserRuntimeDataBase.getSellers().entrySet()){
            if (storeNames.contains(sellerSet.getValue().getStoreName())){
                ArrayList<Order> currentOrder = sellerSet.getValue().getAllOrders();
                if (currentOrder == null) {
                    ArrayList<Order> order =  new ArrayList<>();
                    order.add(newOrder);
                    sellerSet.getValue().setAllOrders(order);
                }else{
                    currentOrder.add(newOrder);
                    sellerSet.getValue().setAllOrders(currentOrder);
                }
            }
        }
    }
}