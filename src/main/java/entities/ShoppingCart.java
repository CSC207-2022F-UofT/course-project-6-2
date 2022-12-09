package entities;


import helpers.Serializer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Entities Layer
public class ShoppingCart implements Serializable {
    private float totalPrize;
    private HashMap<Drink, Integer> itemList;
    public ShoppingCart(float totalPrize, HashMap<Drink, Integer> itemList){
        this.totalPrize = totalPrize;
        this.itemList = itemList;
    }

    /**
     * The setter methods of the instance values.
     */
    public void setTotalPrize(float totalPrize) {
        this.totalPrize = totalPrize;
    }

    public void setItemList(HashMap<Drink, Integer> itemList) {
        this.itemList = itemList;
    }

    /**
     * The getter methods of the instance values.
     */
    public float getTotalPrize() {
        return this.totalPrize;
    }

    public HashMap<Drink, Integer> getItemList() {
        return this.itemList;
    }

    public void addItem(Drink drink, Integer quantity){
        for (Map.Entry<Drink, Integer> entry: itemList.entrySet()){
            if (entry.getKey().getName() == drink.getName() &&
                    entry.getKey().getStoreName() == drink.getStoreName()){
                itemList.replace(entry.getKey(), entry.getValue() + quantity);
                return;
            }
        }
        itemList.put(drink, quantity);
    }
}
