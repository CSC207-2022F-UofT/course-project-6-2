package usecases.customerusecases;

import entities.Order;
import entities.users.Customer;
import usecases.databaseusecases.UserRuntimeDataBase;

public class GetOrderStatus {
    public String getOrderStatus(Order order){
        Customer customer = UserRuntimeDataBase.getCurrentCustomer();
        for(int i = 0; i < customer.getOrderHistory().size(); i++){
            if (customer.getOrderHistory().get(i).getOrderNum() == order.getOrderNum()){
                return customer.getOrderHistory().get(i).getOrderStatus();
            }
        }
        return "Order Not Found";
    }
}
