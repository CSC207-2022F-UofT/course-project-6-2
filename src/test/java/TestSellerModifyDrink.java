import entities.Drink;
import entities.users.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.sellerusecases.SellerModifyDrink;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestSellerModifyDrink {

    /** Setup input cases
     */

    @Test
    @BeforeEach
    public void SellerModifydrinkSetup() {
        Seller seller1 = new Seller("Sara", "6041231234",
                "abcd", "Bay", "Sarecoffee");
        Seller seller2 = new Seller("Sara2", "6041231234",
                "abcd", "Bay", "Sarecoffee");
        Seller seller3 = new Seller("Sara3", "6041231234",
                "abcd", "Bay", "Sarecoffee");
        HashMap<String, Seller> sellerlist = new HashMap<>();
        sellerlist.put(seller1.getPhoneNumber(), seller1);
        sellerlist.put(seller2.getPhoneNumber(), seller2);
        sellerlist.put(seller3.getPhoneNumber(), seller3);
        UserRuntimeDataBase.setSellers(sellerlist);
        HashMap<String, HashMap<String, Drink>> drinks = new HashMap<>();
        DrinkRuntimeDataBase.addStore("store1");
        DrinkRuntimeDataBase.addStore("store2");
        DrinkRuntimeDataBase.addStore("store3");
        Drink drink1 = new Drink("testName1", 5.4f, "testDiscription1", "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("testName2", 2.0f, "testDiscription2", "milk", 1, new Date(), new Date(), 1f);
        Drink drink3 = new Drink("testName3", 9.0f, "testDiscription3", "soybean", 200, new Date(), new Date(), 1f);
        Drink drink4 = new Drink("testName4", 8.0f, "testDiscription4", "soybean", 200, new Date(), new Date(), 1f);
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
        UserRuntimeDataBase.constructCurrentSeller("6041231234");
        UserRuntimeDataBase.getCurrentSeller().setStoreName("store1");
        // call the use case to add new drink
        DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName()).put("testName4", drink4);
        SellerModifyDrink modifier = new SellerModifyDrink();
        modifier.addDrink("apple2.0", 5.4f, "good",
                "apple", 100, new Date(), new Date(), 0.8f);
        // call the use case to delete drink
        modifier.deleteDrink(drink1);
        modifier.searchedDrinkToModify("testName1");
        System.out.println(modifier.drinkExist("testName1"));

    }
    @Test
    // test if the drink has been added
    public void testSellerAdddrink() {
        assertEquals("apple2.0", DrinkRuntimeDataBase.getDrinks().get("store1").get("apple2.0").getName());
    }
    @Test
    // test if the drink is deleted
    public void testOnSellerDeleteDrink() {
        assertNull(DrinkRuntimeDataBase.getDrinks().get("store1").get("testName1"));
    }
    @Test
    // test if the drink is exist
    public void testExistDrink() {
        assertNull(DrinkRuntimeDataBase.getDrinks().get("store1").get("testName1"));
    }
}
