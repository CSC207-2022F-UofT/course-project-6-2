package usecases.userusercases;

import entities.Drink;
import entities.users.Customer;
import entities.users.Seller;
import usecases.drinkusecases.ConstructDrinkDataBase;
import usecases.drinkusecases.DrinkRuntimeDataBase;
import usecases.drinkusecases.SaveDrinkDataBase;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;


public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Seller seller1 = new Seller("123", "778", "123", "Bay", "new");
        UserRuntimeDataBase.sellers.put("778", seller1);

        Customer customer1 = new Customer("ab", "604", "123", 18, "Bay");
        UserRuntimeDataBase.customers.put("604", customer1);

        Drink drink1 = new Drink("apple", 5.4f, "nb", "apple", 100, new Date(), new Date(), 0.1f);
        HashMap<String, Drink> allDrinks = new HashMap<>();
        allDrinks.put("apple juice", drink1);
        allDrinks.put("apple juicy juice", drink1);
        HashMap<String, HashMap<String, Drink>> drinkList = new HashMap<>();
        drinkList.put("KL's Store", allDrinks);
        DrinkRuntimeDataBase.setDrinks(drinkList);

        SaveDrinkDataBase.saveDrinkDataBase();
        SaveUserDataBase.saveUserDataBase();
        ConstructUserDataBase.constructUserDataBase();
        ConstructDrinkDataBase.constructDrinkDataBase();
    }
}
