package usecases.customerusecases;

import entities.Drink;
import entities.Order;
import usecases.orderusecases.CheckTotalOrder;
import usecases.userusercases.UserRuntimeDataBase;

import java.util.HashMap;

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
        UserRuntimeDataBase.getCurrentCustomer().addNewOrder(newOrder);
    }
}
