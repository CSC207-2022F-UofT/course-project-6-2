import entities.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.drinkusecases.SearchDrinks;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSearchDrinks {
    private HashMap<String, HashMap<String, Drink>> drinks = new HashMap<>();

    @Test
    @BeforeEach
    public void testSearchDrinksSetup() {
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
    public void testSearchDrinks() {
        /*search for drink's name*/
        Vector data1 = SearchDrinks.addToFiltered("testName1");
        assert data1.contains("testDiscription1");
        /*search for drink's discription*/
        Vector data2 = SearchDrinks.addToFiltered("testDiscription2");
        assert data2.contains("testName2");
        /*search for drink does not exist*/
        Vector data3 = new Vector();
        Vector data4 = SearchDrinks.addToFiltered("testDiscription3");
        assertEquals(data3, data4);

    }
}
