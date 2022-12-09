package TestUseCases;

import entities.Drink;
import entities.Order;
import entities.users.Seller;
import org.junit.jupiter.api.Test;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.sellerusecases.ModifyOrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test modify order status use case for the order status can be changed when the seller modify it.
 */
public class TestModifyOrderStatus {
    @Test
    public void testModifyOrderStatus() {
        // set up input Data
        Seller seller1 = new Seller("Sara", "6041231234",
                "abcd", "Bay","Sarecoffee");
        UserRuntimeDataBase.getSellers().put(seller1.getPhoneNumber(), seller1);
        UserRuntimeDataBase.constructCurrentSeller("6041231234");
        Drink drink1 = new Drink("apple", 5.4f, "good",
                "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("Coffee", 5.4f, "good",
                "Coffee", 100, new Date(), new Date(), 0.8f);
        HashMap<Drink, Integer> orderList = new HashMap<>();
        orderList.put(drink1, 2);
        orderList.put(drink2, 5);
        float totalPrice = drink1.getPrice() * 2 + drink2.getPrice() * 5;
        Order order = new Order(orderList, "in progress", totalPrice);
        ArrayList<Order> Orderlist = new ArrayList<>();
        Orderlist.add(order);
        seller1.setAllOrders(Orderlist);
        String Ordernumber = Integer.toString(order.getOrderNum());

        // call the usecase to modify the order status
        ModifyOrderStatus modifier = new ModifyOrderStatus();
        modifier.modifyOrderStatus(Ordernumber,"modified status");
        assertEquals("modified status", order.getOrderStatus());
    }
}
