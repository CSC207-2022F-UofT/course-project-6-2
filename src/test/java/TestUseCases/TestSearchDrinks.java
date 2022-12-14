package TestUseCases;

import entities.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.drinkusecases.SearchDrinks;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test the search drinks use case to make sure when the customer search for drinks by keyword, the satisfied drink
 * can be output.
 */
public class TestSearchDrinks {
    private final HashMap<String, HashMap<String, Drink>> drinks = new HashMap<>();

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
        Vector<String> line1 = new Vector<>();
        line1.add("testName1");
        line1.add("store1");
        line1.add("$" + 5.4f);
        line1.add(100 + "ml");
        assert data1.contains(line1);
        /*search for drink's description*/
        Vector data2 = SearchDrinks.addToFiltered("testDiscription2");
        Vector<String> line2 = new Vector<>();
        line2.add("testName2");
        line2.add("store2");
        line2.add("$" + 2.0f);
        line2.add(1 + "ml");
        assert data2.contains(line2);
        /*search for drink does not exist*/
        Vector data3 = new Vector();
        data3.add(line1);
        data3.add(line2);
        Vector data4 = SearchDrinks.addToFiltered("testDiscription3");
        assertEquals(data3, data4);
    }
}
