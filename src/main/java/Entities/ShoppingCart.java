package Entities;


import Entities.Drink;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {
    public float totalPrize;
    public HashMap<Drink, String> itemList;
    public ShoppingCart(float totalPrize, HashMap<Drink, String> itemList){
        this.totalPrize = totalPrize;
        this.itemList = itemList;
    }

    /**
     * The setter methods of the instance values.
     */
    public void setTotalPrize(float totalPrize) {
        this.totalPrize = totalPrize;
    }

    public void setItemList(HashMap<Drink, String> itemList) {
        this.itemList = itemList;
    }

    /**
     * The getter methods of the instance values.
     */
    public float getTotalPrize() {
        return this.totalPrize;
    }

    public HashMap<Drink, String> getItemList() {
        return this.itemList;
    }

    public void addItem(Drink drink, String quantity){
        itemList.put(drink, quantity);
    }
}

