package UseCases.UserUseCases;

import Entities.Drink;

import java.io.IOException;
import java.util.ArrayList;

public class AddToShoppingCart {
    protected static ArrayList<Drink> drinks = new ArrayList<>();
    private static final Helpers.Deserializer searchDeserializer = new Helpers.Deserializer();
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        searchDeserializer.deserialize("./data/drinks");
        drinks = (ArrayList<Drink>) searchDeserializer.getObject();
    }

    public static void Add_to_Shopping_Cart(String drink_name, String store_name, String quantity){
        for (Drink drink:drinks){
            if(drink_name.toLowerCase() == drink.getName().toLowerCase() &
                    store_name == drink.getStoreName()){
                ShoppingCart.getItemList().put(drink, quantity);
            }
        }
    }

}
