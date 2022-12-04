package usecases.sellerusecases;

import entities.Order;
import entities.users.Seller;
import usecases.databaseusecases.UserRuntimeDataBase;

public class ModifyOrderStatus {
    /**
     * Seller modify the order status for particular order.
     * @param orderNum The order that need to be modified.
     * @param status The changed status of the order.
     */
    public void modifyOrderStatus(String orderNum, String status){
        Seller seller = UserRuntimeDataBase.getCurrentSeller();
        for(Order order : seller.allOrders){
            if (Integer.toString(order.getOrderNum()).equals(orderNum)){
                order.setOrderStatus(status);
            }
        }
    }

}
