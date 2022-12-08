package TestEntities;

import entities.Drink;
import entities.ShoppingCart;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashMap;

public class TestShoppingCart {
    @Test
    public void testShoppingCart(){
        Date date1 = new Date();
        Drink drink1 = new Drink("1", 1.0f, "I am description", "beef milk pig", 10, date1, date1, 1);
        Drink drink2 = new Drink("2", 2.0f, "I am description", "chicken milk pig", 1, date1, date1, 1);
        Drink drink3 = new Drink("3", 1.5f, "I am description", "beef orange superman", 100, date1, date1, 1);
        HashMap<Drink, Integer> itemlist1 = new HashMap<>();
        HashMap<Drink, Integer> itemlist2 = new HashMap<>();
        itemlist1.put(drink1, 1);
        itemlist2.put(drink2, 8);
        itemlist2.put(drink3, 3);
        ShoppingCart shoppingCart1 = new ShoppingCart(0, itemlist1);
        /*test setItemList() and getItemList()*/
        shoppingCart1.setItemList(itemlist2);
        HashMap<Drink, Integer> itemlist3 = shoppingCart1.getItemList();
        assertEquals(itemlist3, itemlist2);
        /*test setTotalPrize() and getTotalPrize()*/
        shoppingCart1.setTotalPrize(4.0f);
        float totalprize1 = shoppingCart1.getTotalPrize();
        assertEquals(totalprize1, 4.0f);
    }
}
