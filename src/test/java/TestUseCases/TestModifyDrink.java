package TestUseCases;

import entities.Drink;
import entities.users.Seller;
import org.junit.jupiter.api.Test;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.sellerusecases.ModifyDrink;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test the modify drink use case to make sure the seller can modify the drink attribute correctly.
 */
public class TestModifyDrink {
    @Test
    //create the Input Data
    //set up drinks need to be modified
    public void testModifyDrink() {
        Seller seller1 = new Seller("Sara", "6041231234",
                "abcd", "Bay","Sarecoffee");
        UserRuntimeDataBase.getSellers().put(seller1.getPhoneNumber(), seller1);
        UserRuntimeDataBase.constructCurrentSeller("6041231234");
        Drink drink1 = new Drink("apple", 5.4f, "good",
                "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("milk", 2.0f, "great",
                "milk", 1, new Date(), new Date(), 1f);
        ArrayList<Drink> drinklist = new ArrayList<>();
        drinklist.add(drink1);
        seller1.setItems(drinklist);
        // call the usecase to modify the drink
        ModifyDrink modifyDrink = new ModifyDrink();
        modifyDrink.modifyDrink(drink1,drink2);
        assertEquals("milk", drinklist.get(0).getName());
    }
}