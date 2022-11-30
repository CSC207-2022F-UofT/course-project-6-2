package usecases.customerusecases;

import entities.Drink;
import entities.Order;
import usecases.orderusecases.CheckTotalOrder;
import usecases.userusercases.UserRuntimeDataBase;

import java.util.HashMap;

public class AddToOrderHistory {
    public static void addToOrderHistory(HashMap<Drink, Integer> orderList){
        Order newOrder = new Order(orderList, "in progress");
        int totalOrder = newOrder.getTotalOrder();
        if (totalOrder == Order.UNSET_TOTAL_ORDER) {
            newOrder.setTotalOrder(CheckTotalOrder.checkTotalOrder() + 1);
        } else {
            newOrder.setTotalOrder(newOrder.getTotalOrder() + 1);
        }
        newOrder.setOrderNum(newOrder.getTotalOrder());
        UserRuntimeDataBase.getCurrentCustomer().addNewOrder(newOrder);
    }
}
