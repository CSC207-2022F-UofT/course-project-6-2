package usecases.customerusecases;

import entities.Drink;
import entities.ShoppingCart;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.Map;
import java.util.Objects;

/**
 * The minus from shopping cart use case is used when the quantity of the item in shopping cart minus to 0, then it would
 * disappear.
 */
public class MinusFromShoppingCart {
    public static void minusFromShoppingCart(Drink drink, Integer quantity){
        ShoppingCart currentShoppingCart = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();
        for (Map.Entry<Drink, Integer> entry: currentShoppingCart.getItemList().entrySet()){
            if (Objects.equals(entry.getKey().getName(), drink.getName()) &&
                    Objects.equals(entry.getKey().getStoreName(), drink.getStoreName())) {
                if (entry.getValue() == 1) {
                    currentShoppingCart.getItemList().remove(entry.getKey());
                    return;
                } else {
                    currentShoppingCart.getItemList().replace(entry.getKey(), entry.getValue() - quantity);
                }
            }
        }
    }
}
