package TestUseCases;

import entities.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.drinkusecases.GetOnSaleDrinks;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test the on sale drink use case, when a new on sale drink is added in, the drink can be added into the on sale list.
 */
public class TestOnSaleDrink {
    /** Setup input cases
     */
    @Test
    @BeforeEach
    public void testOnSaleDrinksSetup() {
        HashMap<String, HashMap<String, Drink>> drinks = new HashMap<>();
        DrinkRuntimeDataBase.addStore("store1");
        DrinkRuntimeDataBase.addStore("store2");
        DrinkRuntimeDataBase.addStore("store3");
        Drink drink1 = new Drink("testName1", 5.4f, "testDiscription1", "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("testName2", 2.0f, "testDiscription2", "milk", 1, new Date(), new Date(), 1f);
        Drink drink3 = new Drink("testName3", 9.0f, "testDiscription3", "soybean", 200, new Date(), new Date(), 1f);
        HashMap<String, Drink> list1 = new HashMap<>();
        HashMap<String, Drink> list2 = new HashMap<>();
        HashMap<String, Drink> list3 = new HashMap<>();
        list1.put("testName1", drink1);
        list2.put("testName2", drink2);
        list3.put("testName3", drink3);
        drinks.put("store1", list1);
        drinks.put("store2", list2);
        drinks.put("store3", list3);
        DrinkRuntimeDataBase.setDrinks(drinks);
    }

    @Test
    // test if the on sale drink has been added by testing it size
    public void testOnSaleDrinksSize() {
        ArrayList<Drink> onSaleDrinks = new GetOnSaleDrinks().onSale();
        assertEquals(1, onSaleDrinks.size());
    }

    @Test
    // test if the on sale drink has been added by testing it's name
    public void testOnSaleDrinksName(){
        ArrayList<Drink> onSaleDrinks = new GetOnSaleDrinks().onSale();
        assertEquals("testName1", onSaleDrinks.get(0).getName());
    }
}
