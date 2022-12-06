import entities.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.drinkusecases.GetOnSaleDrinks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TestOnSaleDrink {
    private HashMap<String, HashMap<String, Drink>> drinks = new HashMap<>();

    @Test
    @BeforeEach
    public void testOnSaleDrinksSetup() {
        DrinkRuntimeDataBase.addStore("store1");
        DrinkRuntimeDataBase.addStore("store2");
        Drink drink1 = new Drink("testName1", 5.4f, "testDiscription1", "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("testName2", 2.0f, "testDiscription2", "milk", 1, new Date(), new Date(), 1f);
        HashMap<String, Drink> list1 = new HashMap<>();
        HashMap<String, Drink> list2 = new HashMap<>();
        list1.put("testName1", drink1);
        list2.put("testName2", drink2);
        drinks.put("store1", list1);
        drinks.put("store2", list2);
        DrinkRuntimeDataBase.setDrinks(drinks);
    }

    @Test
    public void testOnSaleDrinks() {
        ArrayList list = DrinkRuntimeDataBase.getDrinkList();
    }
}
