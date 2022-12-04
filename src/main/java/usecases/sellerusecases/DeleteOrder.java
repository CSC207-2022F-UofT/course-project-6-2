package usecases.sellerusecases;

import entities.Order;
import entities.users.Seller;
import usecases.databaseusecases.UserRuntimeDataBase;

public class DeleteOrder {
    public void deleteOrder(String orderNum) {
        Seller seller = UserRuntimeDataBase.getCurrentSeller();
        for (Order order : seller.allOrders) {
            if (Integer.toString(order.getOrderNum()).equals(orderNum)) {
                seller.allOrders.remove(order);
            }
        }
    }
}
