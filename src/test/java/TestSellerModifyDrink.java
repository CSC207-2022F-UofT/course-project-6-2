
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
        UserRuntimeDataBase.constructCurrentSeller("6041231234");
        Drink drink1 = new Drink("apple", 5.4f, "good", "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("milk", 2.0f, "great", "milk", 1, new Date(), new Date(), 1f);
        HashMap<Drink, Integer> orderList = new HashMap<>();
        orderList.put(drink1, 2);
        orderList.put(drink2, 5);
        float totalPrice = drink1.getPrice() * 2 + drink2.getPrice() * 5;
        Order order = new Order(orderList, "in progress", totalPrice);

        AddToOrderHistory.addToOrderHistory(orderList, totalPrice);
        SellerModifyDrink.getSearchedDrink().setStoreName("XX");
        ModifyDrink.modifyDrink(drink1,drink2);
        System.out.println(drink1.getName());
        System.out.println(drink2.getName());
    }
}
