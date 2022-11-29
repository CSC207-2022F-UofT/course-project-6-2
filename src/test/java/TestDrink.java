import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.Drink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

/**
 * This test is testing Drink constructor does its job, name, price, descriptions, ingredient, volume and discount
 * , further properties like .getStoreName() will be tested in UsecaseTest.
 */
public class TestDrink {
    Date date1 = new Date(2020, Calendar.NOVEMBER, 30);
    Date date2 = new Date(2022, Calendar.NOVEMBER, 30);
    @Test
    @DisplayName("Drink test")
    void testDrink(){
        Drink drink1 = new Drink("Soda Water", 4,
                "also known as sparkling water, water with gas",
                "sodium chloride and sodium citrate", 750,
                date1,date2,9);
        assertEquals(drink1.getPrice(), 4);
        assertEquals(drink1.getDescription(), "also known as sparkling water, water with gas");
        assertEquals(drink1.getName(), "Soda Water");
        assertEquals(drink1.getExpirationDate(), date2);
        assertEquals(drink1.getDiscount(),9);
        assertEquals(drink1.getIngredient(),"sodium chloride and sodium citrate");
    }
}