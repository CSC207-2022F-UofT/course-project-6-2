package Entities;


import java.util.HashMap;

public class ShoppingCart {
    public float totalPrize;
    public HashMap<Drink, Integer> itemList;
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

    public void addItem(Drink drink, int quantity){
        itemList.put(drink, quantity);
    }
}

