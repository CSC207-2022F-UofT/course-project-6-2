package usecases.sellerusecases;

import entities.Drink;
import entities.users.Seller;
import usecases.userusercases.UserRuntimeDataBase;

import java.util.ArrayList;

public class ModifyDrink {
    /**
     * Seller modify only one drink.
     * @param oldDrink The drink that need to be modified.
     * @param newDrink The drink that need to be changed to.
     */
    public void modifyDrink(Drink oldDrink, Drink newDrink){
        Seller seller = UserRuntimeDataBase.getCurrentSeller();
        ArrayList<Drink> drinks = seller.getItems();
        if (drinks == null) {
            seller.setItems(new ArrayList<>());
            drinks = seller.getItems();
        }
        if (oldDrink != null) {
            drinks.remove(oldDrink);
        }
        if (newDrink != null){
            drinks.add(newDrink);
        }
    }
}
