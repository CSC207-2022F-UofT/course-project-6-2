package usecases.customerusecases;

import entities.Drink;
import entities.ShoppingCart;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.Map;

public class AddToShoppingCart {
    public static void addToShoppingCart(Drink drink, Integer quantity){
       ShoppingCart currentShoppingCart = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();
        for (Map.Entry<Drink, Integer> entry: currentShoppingCart.getItemList().entrySet()){
            if (entry.getKey().getName() == drink.getName() &&
                    entry.getKey().getStoreName() == drink.getStoreName()){
                currentShoppingCart.getItemList().replace(entry.getKey(), entry.getValue() + quantity);
                return;
            }
        }
        currentShoppingCart.getItemList().put(drink, quantity);
    }
}
