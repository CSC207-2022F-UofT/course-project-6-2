import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.Drink;
import entities.Order;
import entities.ShoppingCart;
import entities.users.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.HashMap;

/**
 * This test is testing Customer constructor and some inherited properties like accountname, phonenumber etc.
 */
public class TestCustomer {
    Customer customer1 = new Customer("Amy", "7780000000",
            "abcd", 20, "College St.");

    @Test
    @DisplayName("Get age test")
    void getAgeTest() {
        assertEquals(customer1.getAge(), 20);
    }

    @Test
    @DisplayName("Get phone number test")
    void getPhoneNumTest() {
        assertEquals(customer1.getPhoneNumber(), "7780000000");
    }

    @Test
    @DisplayName("Get age test")
    void getPasswordTest() {
        assertEquals(customer1.getPassWord(), "abcd");
    }

    @Test
    @DisplayName("Get account number test")
    void getAccountNameTest() {
        assertEquals(customer1.getAccountName(), "Amy");
    }

    @Test
    @DisplayName("Get address test")
    void getAddressTest() {
        assertEquals(customer1.getAddress(), "College St.");
    }

    @Test
    public void CustomerTest() {
        //create the Input Data
        //Check that the Output Data passed to the Presenter is correct
        Date date1 = new Date();
        Date date2 = new Date();
        Customer user1 = new Customer("john", "13888671799",
                "1234", 23, "22 College St.");


        Drink drink1 = new Drink("Lemon Iced Tea", 14,
                "Made with health",
                "fresh lemon, green tea", 1050,
                date1, date2, 5);
        Drink drink2 = new Drink("X", 22, "description",
                "CaCo3", 150, date1, date1, 700);

        Drink drink3 = new Drink("Y", 14, "description",
                "water", 100, date1, date1, 550);

        HashMap<Drink, Integer> orderlist1 = new HashMap<>();
        HashMap<Drink, Integer> orderlist2 = new HashMap<>();
        ShoppingCart cart = new ShoppingCart(150, orderlist1);

        orderlist1.put(drink1, 1);
        orderlist1.put(drink2, 8);
        orderlist2.put(drink3, 8);

        Order order = new Order(orderlist1, "inProgress", 10f);
        Order order2 = new Order(orderlist2, "Order Not Found", 10f);

        user1.addNewOrder(order);
        user1.addNewOrder(order2);
        user1.setShoppingCart(cart);


        //Check the functionality of getOrderHistory
        //Check the functionality of addNewOrder
        assertEquals("inProgress", user1.getOrderHistory().get(0).getOrderStatus());
        assertEquals("Order Not Found", user1.getOrderHistory().get(1).getOrderStatus());


        // Check the functionality of getShoppingCart
        assertEquals(8, user1.getShoppingCart().getItemList().get(drink2));
    }
}
