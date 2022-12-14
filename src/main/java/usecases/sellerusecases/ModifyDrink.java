package usecases.sellerusecases;

import entities.Drink;
import entities.users.Seller;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.ArrayList;

/**
 * The use case is used to modify drink when the seller changes the attribute for a particular drink.
 */
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
            for(int idx = 0; idx < drinks.size(); idx ++) {
                if (drinks.get(idx).getName().equals(oldDrink.getName())) {
                    drinks.remove(idx);
                }
            }
        }
        if (newDrink != null){
            drinks.add(newDrink);
        }
    }
}
