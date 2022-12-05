
import entities.Drink;
import entities.Order;
import entities.users.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecases.customerusecases.AddToOrderHistory;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.sellerusecases.ModifyDrink;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSellerModifyDrink {
    private ArrayList<Order> orderHistory;

    /** Test AddToOrderHistory use case to make sure order can be added into current customer's order history when
     checkout in the shopping cart.
     */

    @Test
    @BeforeEach
    public void testOrderHistorySetup() {
        Seller seller1 = new Seller("Sara", "6041231234",
                "abcd", "Bay","Sarecoffee");
        UserRuntimeDataBase.constructCurrentSeller("6041231234");
        Drink drink1 = new Drink("apple", 5.4f, "good", "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("milk", 2.0f, "great", "milk", 1, new Date(), new Date(), 1f);

        HashMap<Drink, Integer> orderList = new HashMap<>();
        orderList.put(drink1, 2);
        orderList.put(drink2, 5);
        float totalPrice = drink1.getPrice() * 2 + drink2.getPrice() * 5;
        Order order = new Order(orderList, "in progress", totalPrice);

        AddToOrderHistory.addToOrderHistory(orderList, totalPrice);
        orderHistory = new ArrayList<>();
        orderHistory.add(order);
        ModifyDrink.modifyDrink(drink1,drink2);
    }

    @Test
    @DisplayName("Test total order")
    public void testTotalOrder(){
        assertEquals(UserRuntimeDataBase.getCurrentCustomer().getOrderHistory().get(0).getTotalOrder(), orderHistory.get(0).getTotalOrder());
    }

    @Test
    @DisplayName("Test order number")
    public void testOrderNumber(){
        assertEquals(UserRuntimeDataBase.getCurrentCustomer().getOrderHistory().get(0).getOrderNum(), orderHistory.get(0).getOrderNum());
    }

    @Test
    @DisplayName("Test order status")
    public void testOrderStatus(){
        assertEquals(UserRuntimeDataBase.getCurrentCustomer().getOrderHistory().get(0).getOrderStatus(), orderHistory.get(0).getOrderStatus());
    }

    @Test
    @DisplayName("Test total price")
    public void testTotalPrice(){
        assertEquals(UserRuntimeDataBase.getCurrentCustomer().getOrderHistory().get(0).getTotalPrice(), orderHistory.get(0).getTotalPrice());
    }

    @Test
    @DisplayName("Test order list")
    public void testOrderList(){
        assertEquals(UserRuntimeDataBase.getCurrentCustomer().getOrderHistory().get(0).getOrderList(), orderHistory.get(0).getOrderList());
    }
}
