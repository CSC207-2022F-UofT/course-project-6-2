
import entities.Drink;
import entities.users.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecases.customerusecases.AddToShoppingCart;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.databaseusecases.UserRuntimeDataBase;
import java.util.Date;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddtoShoppingCart {

    /** Test AddToShoppingCart use case to make sure order can be added into current customer's shopping cart.
     */

    @Test
    @BeforeEach
    public void testOrderHistorySetup() {
        Customer customer1 = new Customer("Sara", "6041231234", "abcd", 18, "Bay");
        UserRuntimeDataBase.getCustomers().put(customer1.getPhoneNumber(), customer1);
        UserRuntimeDataBase.constructCurrentCustomer("6041231234");
        Drink drink1 = new Drink("apple", 5.4f, "good", "apple", 100, new Date(), new Date(), 0.8f);
        Drink drink2 = new Drink("milk", 2.0f, "great", "milk", 1, new Date(), new Date(), 1f);
        HashMap<String, Drink> searchField = new HashMap<>();
        HashMap<String, HashMap<String, Drink>> searchField2 = new HashMap<>();
        searchField.put(drink1.getName(),drink1);
        searchField.put(drink2.getName(),drink2);
        searchField2.put(drink1.getStoreName(),searchField);
        DrinkRuntimeDataBase.setDrinks(searchField2);
        AddToShoppingCart.addToShoppingCart(drink1, 20);
        AddToShoppingCart.addToShoppingCart(drink2, 10);
        System.out.println(UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getItemList());
    }

    @Test
    @DisplayName("Test total prize")
    public void testTotalOrder(){
        assertEquals(UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getTotalPrize(),
                128);
    }

    @Test
    @DisplayName("Test total prize")
    public void testItemList(){
       assertTrue(UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getItemList().containsValue(20));
    }
}
