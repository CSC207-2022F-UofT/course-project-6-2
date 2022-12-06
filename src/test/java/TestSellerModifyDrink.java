
import entities.Drink;
import entities.Order;
import entities.users.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecases.customerusecases.AddToOrderHistory;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.sellerusecases.ModifyDrink;
import usecases.sellerusecases.SellerModifyDrink;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSellerModifyDrink {

    /** Test AddToOrderHistory use case to make sure order can be added into current customer's order history when
     checkout in the shopping cart.
     */

    @Test
    @BeforeEach
    public void testOrderHistorySetup() {
        Seller seller1 = new Seller("Sara", "6041231234",
                "abcd", "Bay","Sarecoffee");
        UserRuntimeDataBase.getSellers().put(seller1.getPhoneNumber(), seller1);
        UserRuntimeDataBase.constructCurrentSeller("6041231234");
        Drink drink1 = new Drink("apple", 5.4f, "good",
                "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("Coffee", 5.4f, "good",
                "Coffee", 100, new Date(), new Date(), 0.8f);
        Drink drink3 = new Drink("QQ milk tea", 6f, "good",
                "black tea and milk", 100, new Date(), new Date(), 0.8f);
        HashMap<Drink, Integer> orderList = new HashMap<>();
        orderList.put(drink1, 2);
        orderList.put(drink2, 5);
        orderList.put(drink3, 1);
        float totalPrice = drink1.getPrice() * 2 + drink2.getPrice() * 5 + drink3.getPrice();
        Order order = new Order(orderList, "in progress", totalPrice);
        ArrayList<Order> Orderlist = new ArrayList<>();
        Orderlist.add(order);
        seller1.setAllOrders(Orderlist);
        String Ordernumber = Integer.toString(order.getOrderNum());

        SellerModifyDrink.addDrink("apple2.0", 5.4f, "good",
                "apple", 100, new Date(), new Date(), 0.8f);
        SellerModifyDrink.deleteDrink(drink1);
        SellerModifyDrink.modifyDrink(drink3.getName(),7f, "good",
                "green tea and milk", 100, new Date(), new Date(), 0.9f);

    }
}
