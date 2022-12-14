package TestUseCases;

import entities.Drink;
import usecases.orderusecases.GetWarningMessage;

import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test warning message use case to make sure when the customer wants to check out, he/she can get the correct warning
 * message according to the ingredient in drinks.
 */
public class TestGetWarningMessage {
    @Test
    /*the drinks have one dangerous ingredient*/
    public void oneDangerousIngredientTest() {
        Date date1 = new Date();
        Drink drink1 = new Drink("1", 1.0f, "I am description", "beef milk pig", 10, date1, date1, 1);
        Drink drink2 = new Drink("2", 2.0f, "I am description", "chicken milk pig", 1, date1, date1, 1);
        Drink drink3 = new Drink("3", 1.5f, "I am description", "beef orange superman", 100, date1, date1, 1);
        HashMap<Drink, Integer> itemlist1 = new HashMap<>();
        itemlist1.put(drink1, 1);
        itemlist1.put(drink2, 8);
        itemlist1.put(drink3, 3);
        GetWarningMessage w = new GetWarningMessage();
        String T = w.getWarningMessage(itemlist1);
        assertEquals(T, "Drinks in shopping cart contains milk ");
    }
    @Test
    /*the drinks have no dangerous ingredients*/
    public void noDangerousIngredientTest() {
        Date date1 = new Date();
        Drink drink1 = new Drink("1", 1.0f, "I am description", "beef pig", 10, date1, date1, 1);
        Drink drink2 = new Drink("2", 2.0f, "I am description", "air", 1, date1, date1, 1);
        Drink drink3 = new Drink("3", 1.5f, "I am description", "PS5 orange superman truck", 100, date1, date1, 1);
        HashMap<Drink, Integer> itemlist2 = new HashMap<>();
        itemlist2.put(drink1, 2);
        itemlist2.put(drink2, 1);
        itemlist2.put(drink3, 3);
        GetWarningMessage w = new GetWarningMessage();
        String T = w.getWarningMessage(itemlist2);
        assertEquals(T, "Drinks in shopping cart contains no common allergens ");
    }
}


