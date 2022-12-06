package usecases.customerusecases;

import entities.Drink;
import entities.ShoppingCart;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.Map;
import java.util.Objects;

public class AddToShoppingCart {
    public static void addToShoppingCart(Drink drink, Integer quantity){
       ShoppingCart currentShoppingCart = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();
        for (Map.Entry<Drink, Integer> entry: currentShoppingCart.getItemList().entrySet()){
            if (Objects.equals(entry.getKey().getName(), drink.getName()) &&
                    Objects.equals(entry.getKey().getStoreName(), drink.getStoreName())){
                currentShoppingCart.getItemList().replace(entry.getKey(), entry.getValue() + quantity);
                return;
            }
        }
        currentShoppingCart.getItemList().put(drink, quantity);
    }
}
