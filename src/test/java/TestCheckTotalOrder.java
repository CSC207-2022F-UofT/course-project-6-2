import entities.Drink;
import entities.users.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecases.customerusecases.AddToOrderHistory;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCheckTotalOrder {
    // set up input
    @Test
    @BeforeEach
    public void testChecktotalorderSetUp() {
        Customer customer1 = new Customer("Sara", "6041231234", "abcd", 18, "Bay");
        UserRuntimeDataBase.getCustomers().put(customer1.getPhoneNumber(), customer1);
        UserRuntimeDataBase.constructCurrentCustomer("6041231234");
        Drink drink1 = new Drink("apple", 5.4f, "good", "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("milk", 2.0f, "great", "milk", 1, new Date(), new Date(), 1f);
        HashMap<Drink, Integer> orderList = new HashMap<>();
        HashMap<Drink, Integer> orderList2 = new HashMap<>();
        orderList.put(drink1, 2);
        orderList.put(drink2, 5);
        float totalPrice = drink1.getPrice() * 2 + drink2.getPrice() * 5;
        AddToOrderHistory.addToOrderHistory(orderList, totalPrice);
    }
    @Test
    @DisplayName("Test Total order")
    public void testTotalOrder(){
        Customer customer1 = new Customer("Sara", "6041231234", "abcd", 18, "Bay");
        UserRuntimeDataBase.getCustomers().put(customer1.getPhoneNumber(), customer1);
        UserRuntimeDataBase.constructCurrentCustomer("6041231234");
        Drink drink1 = new Drink("apple", 5.4f, "good", "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("milk", 2.0f, "great", "milk", 1, new Date(), new Date(), 1f);
        HashMap<Drink, Integer> orderList = new HashMap<>();
        HashMap<Drink, Integer> orderList2 = new HashMap<>();
        orderList.put(drink1, 2);
        float totalPrice = drink1.getPrice() * 2 + drink2.getPrice() * 5;
        AddToOrderHistory.addToOrderHistory(orderList, totalPrice);
        assertEquals(UserRuntimeDataBase.getCurrentCustomer().getOrderHistory().get(0).getTotalOrder(),
                2);}
}