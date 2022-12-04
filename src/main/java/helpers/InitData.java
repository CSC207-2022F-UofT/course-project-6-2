package helpers;

import entities.Drink;
import entities.users.Customer;
import entities.users.Seller;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.databaseusecases.SaveDrinkDataBase;
import usecases.databaseusecases.SaveUserDataBase;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.userinputboundary.DrinkInputBoundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InitData {
    public static void main(String[] args) throws IOException {
        Seller seller1 = new Seller("Jason Wang", "3652768777", "1357", "210 spadina ave", "Soda Treat");
        Seller seller2 = new Seller("Lucas Liu", "4899277216", "9999", "15 Yonge st", "Cocktail Bazaar (alcohol)");
        Seller seller3 = new Seller("Allen", "6478916276", "0411", "100 Spadina ave", "Fountain Drinks");
        Seller seller4 = new Seller("William Liu", "6473222922", "250250", "25 Wellesley st W", "Drinksify");
        Seller seller5 = new Seller("Amanda", "5257688765", "289987", "957 Bay st", "Junction Fizzy");

        Customer customer1 = new Customer("Jack", "6742629786", "1398", 28, "11 Wellesley st W");
        Customer customer2 = new Customer("Lucy", "4287988172", "2208", 31, "832 Bay st");

        Drink drink1a = new Drink("Cherry Vanilla Soda", 8.12f, "A soda juice with cherry vanilla flavour",
                "cherry juice, sugar, vanilla, soda", 125, new DrinkInputBoundary().getDate("2022-09-31"), new DrinkInputBoundary().getDate("2023-09-31"), 1);
        Drink drink1b = new Drink("Lemon Soda", 6.99f, "A soda drink with lemon flavour", "lemon, soda, salt, sugar, water",
                125, new DrinkInputBoundary().getDate("2022-12-01"), new DrinkInputBoundary().getDate("2023-12-01"), 0.7f);
        Drink drink1c = new Drink("Orange Juice Soda", 6.34f, "A soda drink with orange flavour", "orange juice, sugar, soda, ginger",
                125, new DrinkInputBoundary().getDate("2022-08-03"), new DrinkInputBoundary().getDate("2023-11-03"), 1);
        Drink drink1d = new Drink("Masala Soda", 15.99f, "A refreshing Indian summer drink", "mint leaves, ginger, lime juice, sugar, masala, water",
                375, new DrinkInputBoundary().getDate("2022-09-01"), new DrinkInputBoundary().getDate("2023-02-01"), 1);
        Drink drink1e = new Drink("Cream Soda", 7.1f, "A sweet soft soda drink flavoured with vanilla", "sugar, water, vanilla, soda",
                125, new DrinkInputBoundary().getDate("2022-02-18"), new DrinkInputBoundary().getDate("2022-08-18"), 0.9f);
        Drink drink1f = new Drink("Pineapple Soda", 4.8f, "A soda drink with Pineapple flavour", "pineapple, water, sugar, lemon juice, soda",
                125, new DrinkInputBoundary().getDate("2022-11-17"), new DrinkInputBoundary().getDate("2023-11-17"), 0.8f);
        Drink drink2a = new Drink("Aqua Velva", 14.5f, "An alcoholic cocktail known as American first after shave", "wheat, alcohol, vodka, gin, blue curacao, syrup, lemon juice, soda water",
                50, new DrinkInputBoundary().getDate("2022-03-11"), new DrinkInputBoundary().getDate("2023-03-11"), 1);
        Drink drink2b = new Drink("Dirty Martini", 45.25f, "An alcoholic cocktail for olive lovers", "wheat, alcohol, gin, dry vermouth, olive brine",
                375, new DrinkInputBoundary().getDate("2022-08-01"), new DrinkInputBoundary().getDate("2023-02-01"), 0.9f);
        Drink drink2c = new Drink("Lillet Cocktail", 28.88f, "An alcoholic cocktail features the popular fortified wine", "wheat, alcohol, lillet blanc, gin, tonic water",
                375,new DrinkInputBoundary().getDate("2022-11-12"), new DrinkInputBoundary().getDate("2023-05-12"), 0.9f);
        Drink drink2d = new Drink("Salty Dog Cocktail", 65.99f, "A classic alcoholic cocktail that can be made with vodka or gin", "wheat, alcohol, gin, grapefruit juice, salt, syrup, lime",
                500, new DrinkInputBoundary().getDate("2022-11-01"), new DrinkInputBoundary().getDate("2023-11-01"), 1);
        Drink drink2e = new Drink("Blue Lagoon Cocktail", 49.28f, "An alcoholic cocktail with the bright colour and citrusy flavour", "wheat, alcohol, vodka, blue curacao, lemon juice, syrup",
                500, new DrinkInputBoundary().getDate("2022-10-10"), new DrinkInputBoundary().getDate("2023-07-10"), 0.8f);

        // For saveToUserDataBase
        ArrayList<Drink> seller1Drinks = new ArrayList<>(
                Arrays.asList(drink1a, drink1b, drink1c, drink1d, drink1e, drink1f)
        );
        ArrayList<Drink> seller2Drinks = new ArrayList<>(
                Arrays.asList(drink2a, drink2b, drink2c, drink2d, drink2e)
        );

        seller1.setItems(seller1Drinks);
        seller2.setItems(seller2Drinks);

        HashMap<String, Seller> sellers = new HashMap<>();
        HashMap<String, Customer> customers = new HashMap<>();
        sellers.put(seller1.getPhoneNumber(), seller1);
        sellers.put(seller2.getPhoneNumber(), seller2);
        customers.put(customer1.getPhoneNumber(), customer1);
        customers.put(customer2.getPhoneNumber(), customer2);

        // For saveToDrinkDataBase
        HashMap<String, HashMap<String, Drink>> drinkSet = new HashMap<>();
        HashMap<String, Drink> seller1Set = new HashMap<>();
        HashMap<String, Drink> seller2Set = new HashMap<>();

        for(Drink drink : seller1Drinks) {
            seller1Set.put(drink.getName(), drink);
        }
        for(Drink drink : seller2Drinks) {
            seller2Set.put(drink.getName(), drink);
        }

        drinkSet.put(seller1.getStoreName(), seller1Set);
        drinkSet.put(seller2.getStoreName(), seller2Set);

        // Save to RuntimeDB then save to file DB
        UserRuntimeDataBase.setSellers(sellers);
        UserRuntimeDataBase.setCustomers(customers);
        DrinkRuntimeDataBase.setDrinks(drinkSet);

        SaveUserDataBase.saveUserDataBase();
        SaveDrinkDataBase.saveDrinkDataBase();
    }
}
