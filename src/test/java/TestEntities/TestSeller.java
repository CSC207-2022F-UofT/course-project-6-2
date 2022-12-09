package TestEntities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.Drink;
import entities.Order;
import entities.users.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * This test is testing Seller constructor attributes and some inherited properties.
 */
public class TestSeller {

    Seller Seller1 = new Seller("May", "4165552704",
            "abcd", "200Elm", "Teashop168");

    @Test
    @DisplayName("get StoreName test")
    void getStoreNameTest() {
        assertEquals(Seller1.getStoreName(), "Teashop168");
    }

    @Test
    @DisplayName("get PhoneNumber test")
    void getPhoneNumberTest() {
        assertEquals(Seller1.getPhoneNumber(), "4165552704");
    }

    @Test
    @DisplayName("get Address test")
    void getAddressTest() {
        assertEquals(Seller1.getAddress(), "200Elm");
    }

    @Test
    @DisplayName("get PassWord test")
    void getPassWordTest() {
        assertEquals(Seller1.getPassWord(), "abcd");
    }

    @Test
    @DisplayName("get AccountName test")
    void getAccountNameTest() {
        assertEquals(Seller1.getAccountName(), "May");
    }

    @Test
    public void SellerTest() {
        //create the Input Data
        //Check that the Output Data passed to the Presenter is correct

        ArrayList<Order> orderlist = new ArrayList<>();
        Date date1 = new Date();
        Date date2 = new Date();

        Drink drink1 = new Drink("Lemon Iced Tea", 14,
                "Made with health",
                "fresh lemon, green tea", 1050,
                date1, date2, 5);
        Drink drink2 = new Drink("X", 22, "description",
                "CaCo3", 150, date1, date1, 700);

        HashMap<Drink, Integer> orderlist1 = new HashMap<>();
        ArrayList<Drink> drinklist = new ArrayList<>();

        orderlist1.put(drink1, 1);
        orderlist1.put(drink2, 8);
        drinklist.add(drink1);
        drinklist.add(drink2);

        Order order = new Order(orderlist1, "inProgress", 10f);
        order.setOrderNum(314);

        orderlist.add(order);

        Seller qi = new Seller("May", "4165552704",
                "abcd", "200Elm", "Teashop168");

        //testing change store name
        qi.setStoreName("CoCo");
        assertEquals("CoCo", qi.getStoreName());

        //testing set up AllOrders
        //testing set up Items
        //testing getAllOrders
        //testing getItems
        qi.setAllOrders(orderlist);
        qi.setItems(drinklist);

        assertEquals(314, qi.getAllOrders().get(0).getOrderNum());
        assertEquals("Lemon Iced Tea", qi.getItems().get(0).getName());
    }
}