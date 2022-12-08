package TestEntities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.Drink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;

/**
 * This test is testing Drink constructor does its job, name, price, descriptions, ingredient, volume and discount
 * , further properties like .getStoreName() will be tested in UsecaseTest.
 */
public class TestDrink {
    Date date1 = new Date();
    Date date2 = new Date();
    Drink drink1 = new Drink("Soda Water", 4,
                "also known as sparkling water, water with gas",
                "sodium chloride and sodium citrate", 750,
                date1,date2,9);

    @Test
    @DisplayName("Get Price test")
    void getAgeTest(){
        assertEquals(drink1.getPrice(), 4);
    }

    @Test
    @DisplayName("Get Description test")
    void getPriceTest(){
        assertEquals(drink1.getDescription(),
                "also known as sparkling water, water with gas");}

    @Test
    @DisplayName("Get name test")
    void getNameTest(){assertEquals(drink1.getName(), "Soda Water");}

    @Test
    @DisplayName("Get ExpirationDate test")
    void getExpirationTest(){assertEquals(drink1.getExpirationDate(), date2);}

    @Test
    @DisplayName("Get Discount test")
    void getDiscountTest(){assertEquals(drink1.getDiscount(),9);}

    @Test
    @DisplayName("Get Ingredient test")
    void getIngredientTest(){assertEquals(drink1.getIngredient(),"sodium chloride and sodium citrate");
    }

    @Test
    @DisplayName("Set up test")
    void SetupTest(){
        Drink drinkX = new Drink(null, 4,
                null,
                null, 750,
                date1,date2,9);
        drinkX.setName("matcha green tea");
        drinkX.setStoreName("TeaShop180");
        drinkX.setIngredient("green tea");
        drinkX.setPrice(5);
        drinkX.setVolume(750);
        drinkX.setProductionData(new Date());
        drinkX.setExpirationDate(new Date());
        drinkX.setDiscount(1);
        assertEquals(drinkX.getIngredient(),"green tea");
        assertEquals(drinkX.getName(),"matcha green tea");
        assertEquals(drinkX.getPrice(), 5);

    }
}