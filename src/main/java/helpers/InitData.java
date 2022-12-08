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
    /**
     * This is used to initialize all the database for this project including 5 seller data, 26 drink data, and 12 customer data.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Create 5 new sellers.
        Seller seller1 = new Seller("Jason Wang", "3652768777", "1357", "210 spadina ave", "Soda Treat");
        Seller seller2 = new Seller("Lucas Liu", "4899277216", "9999", "15 Yonge st", "Cocktail Bazaar (alcohol)");
        Seller seller3 = new Seller("Allen", "6478916276", "0411", "100 Spadina ave", "Fountain Drinks");
        Seller seller4 = new Seller("William Liu", "6473222922", "250250", "25 Wellesley st W", "Drinksify");
        Seller seller5 = new Seller("Amanda", "5257688765", "289987", "957 Bay st", "Junction Fizzy");

        // Create 12 new customers.
        Customer customer1 = new Customer("Jack", "6742629786", "1398", 28, "11 Wellesley st W");
        Customer customer2 = new Customer("Lucy", "4287988172", "2208", 31, "832 Bay st");
        Customer customer3 = new Customer("Peter", "358268510", "240211", 75, "70 Forest Manor st");
        Customer customer4 = new Customer("Fiona","6470902148", "77389", 17, "159 Dundas st E");
        Customer customer5 = new Customer("Ashley", "6522780021", "5551555", 13, "28 Wellesley st W");
        Customer customer6 = new Customer("Amir", "3972210864", "1234321", 51, "113 St Joseph st");
        Customer customer7 = new Customer("Charles", "4625319609", "647647", 77, "619 Yonge st");
        Customer customer8 = new Customer("Daniel", "3500708976", "365563", 32, "515 Jarvis st");
        Customer customer9 = new Customer("Matthew", "7465920876", "67802", 40, "Harbour Square");
        Customer customer10 = new Customer("Anthony", "2899830628", "2899", 22, "18 Duncan st");
        Customer customer11 = new Customer("Andrew", "8273904000", "000111", 18, "1537 Avenue Rd");
        Customer customer12 = new Customer("Joshua", "6273802219", "159260", 15, "158 Sterling Rd");

        // Create 26 new drinks.
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
        Drink drink3a = new Drink("Canada Dry", 3.19f, "A drink with refreshing bubbles and the smoothing taste of real ginger flavour", "soda water, syrup, ginger, caramel colour leamon",
                500, new DrinkInputBoundary().getDate("2022-11-15"), new DrinkInputBoundary().getDate("2023-11-15"), 1f);
        Drink drink3b = new Drink("2% Milk", 5.89f, "A white liquid drink produced by the mammary glands of mammals", "partly skimmed milk, vitamin A, vitamin D3",
                2000, new DrinkInputBoundary().getDate("2022-08-01") , new DrinkInputBoundary().getDate("2023-10-01"), 0.8f);
        Drink drink3c = new Drink("Oat Milk", 7.99f, "A milk drink with oat flavour", "soybean, milk, sugar",
                964, new DrinkInputBoundary().getDate("2022-12-01"), new DrinkInputBoundary().getDate("2023-12-01"), 1f);
        Drink drink3d = new Drink("2% Plain Yogurt", 3.99f, "A drink produced by bacterial fermentation of milk", "milk, sweetener, stabilizer",
                750, new DrinkInputBoundary().getDate("2022-09-10"), new DrinkInputBoundary().getDate("2022-12-10"), 0.9f);
        Drink drink3e = new Drink("Caramel Iced Espresso", 6.5f, "An espresso-based drink", "water, milk, sugar, cream, coffee",
                1180, new DrinkInputBoundary().getDate("2022-12-02"), new DrinkInputBoundary().getDate("2023-12-02"), 1f);

        Drink drink4a = new Drink("Peanut Milk", 5.79f, "A milk drink with peanut flavour", "peanut, milk, sugar",
                1540 , new DrinkInputBoundary().getDate("2022-07-01"), new DrinkInputBoundary().getDate("2024-01-01"), 0.7f);
        Drink drink4b = new Drink("Simply Peach", 5.79f, "A juice with peach flavour", "peach, water, sugar",
                1540, new DrinkInputBoundary().getDate("2022-10-18"), new DrinkInputBoundary().getDate("2023-10-18"), 1f);
        Drink drink4c = new Drink("Mango Juice", 3.1f, "A juice with mango flavour", "mango, water, sugar",
                960, new DrinkInputBoundary().getDate("2022-08-08"), new DrinkInputBoundary().getDate("2023-08-08"), 1f);
        Drink drink4d = new Drink("Passion Juice", 2.99f, "A juice with passion fruit flavour", "passion fruit, water, sugar",
                960 , new DrinkInputBoundary().getDate("2022-09-19"), new DrinkInputBoundary().getDate("2023-03-19"), 0.9f);
        Drink drink4e = new Drink("Some Pulp Orange Juice", 5.12f, "A juice with orange falvour and real fruit pulp", "orange, water, sugar",
                1540, new DrinkInputBoundary().getDate("2022-08-18"), new DrinkInputBoundary().getDate("2023-08-18"), 1f);

        Drink drink5a = new Drink("Amber Moon", 9.29f, "An alcoholic cocktail consumed for the purpose of relieving a hangover", "tabasco sauce, wheat, alcohol, egg",
                125 , new DrinkInputBoundary().getDate("2022-12-02"), new DrinkInputBoundary().getDate("2023-02-02"), 1f);
        Drink drink5b = new Drink("Diet Coke", 3.29f, "A drink with perfect balance of crisp and refreshing", "carbonated water, carmel colour, sweeteners",
                2000, new DrinkInputBoundary().getDate("2022-10-11"), new DrinkInputBoundary().getDate("2024-10-11"), 0.7f);
        Drink drink5c = new Drink("Vitamin-water", 1.99f, "A great tasting drink that contains vitamins and minerals to help you get through your day", "water, cane sugar, vitamin C, vitamin E, vitamin B3, vitamin B5",
                591, new DrinkInputBoundary().getDate("2022-12-01"), new DrinkInputBoundary().getDate("2023-12-01"), 1f);
        Drink drink5d = new Drink("Lemonade Juice", 6.00f, "A juice with lemon flavour", "lemon, water, sugar",
                1540, new DrinkInputBoundary().getDate("2022-04-11"), new DrinkInputBoundary().getDate("2023-04-11"), 1f);
        Drink drink5e = new Drink("Iced Tea", 2.88f, "A form of cold tea drink", "water, black tea, sugar",
                960, new DrinkInputBoundary().getDate("2022-04-09"), new DrinkInputBoundary().getDate("2023-04-09"), 1f);

        // For saveToUserDataBase, add the 26 drinks to the corresponding seller.
        ArrayList<Drink> seller1Drinks = new ArrayList<>(
                Arrays.asList(drink1a, drink1b, drink1c, drink1d, drink1e, drink1f)
        );
        ArrayList<Drink> seller2Drinks = new ArrayList<>(
                Arrays.asList(drink2a, drink2b, drink2c, drink2d, drink2e)
        );
        ArrayList<Drink> seller3Drinks = new ArrayList<>(
                Arrays.asList(drink3a, drink3b, drink3c, drink3d, drink3e)
        );
        ArrayList<Drink> seller4Drinks = new ArrayList<>(
                Arrays.asList(drink4a, drink4b, drink4c, drink4d, drink4e)
        );
        ArrayList<Drink> seller5Drinks = new ArrayList<>(
                Arrays.asList(drink5a, drink5b, drink5c, drink5d, drink5e)
        );

        seller1.setItems(seller1Drinks);
        seller2.setItems(seller2Drinks);
        seller3.setItems(seller3Drinks);
        seller4.setItems(seller4Drinks);
        seller5.setItems(seller5Drinks);

        HashMap<String, Seller> sellers = new HashMap<>();
        HashMap<String, Customer> customers = new HashMap<>();
        sellers.put(seller1.getPhoneNumber(), seller1);
        sellers.put(seller2.getPhoneNumber(), seller2);
        sellers.put(seller3.getPhoneNumber(), seller3);
        sellers.put(seller4.getPhoneNumber(), seller4);
        sellers.put(seller5.getPhoneNumber(), seller5);

        customers.put(customer1.getPhoneNumber(), customer1);
        customers.put(customer2.getPhoneNumber(), customer2);
        customers.put(customer3.getPhoneNumber(), customer3);
        customers.put(customer4.getPhoneNumber(), customer4);
        customers.put(customer5.getPhoneNumber(), customer5);
        customers.put(customer6.getPhoneNumber(), customer6);
        customers.put(customer7.getPhoneNumber(), customer7);
        customers.put(customer8.getPhoneNumber(), customer8);
        customers.put(customer9.getPhoneNumber(), customer9);
        customers.put(customer10.getPhoneNumber(), customer10);
        customers.put(customer11.getPhoneNumber(), customer11);
        customers.put(customer12.getPhoneNumber(), customer12);

        // For saveToDrinkDataBase
        HashMap<String, HashMap<String, Drink>> drinkSet = new HashMap<>();
        HashMap<String, Drink> seller1Set = new HashMap<>();
        HashMap<String, Drink> seller2Set = new HashMap<>();
        HashMap<String, Drink> seller3Set = new HashMap<>();
        HashMap<String, Drink> seller4Set = new HashMap<>();
        HashMap<String, Drink> seller5Set = new HashMap<>();

        for(Drink drink : seller1Drinks) {
            seller1Set.put(drink.getName(), drink);
        }
        for(Drink drink : seller2Drinks) {
            seller2Set.put(drink.getName(), drink);
        }
        for(Drink drink : seller3Drinks) {
            seller3Set.put(drink.getName(), drink);
        }
        for(Drink drink : seller4Drinks) {
            seller4Set.put(drink.getName(), drink);
        }
        for(Drink drink : seller5Drinks) {
            seller5Set.put(drink.getName(), drink);
        }

        drinkSet.put(seller1.getStoreName(), seller1Set);
        drinkSet.put(seller2.getStoreName(), seller2Set);
        drinkSet.put(seller3.getStoreName(), seller3Set);
        drinkSet.put(seller4.getStoreName(), seller4Set);
        drinkSet.put(seller5.getStoreName(), seller5Set);

        // Save to RuntimeDB then save to file DB
        UserRuntimeDataBase.setSellers(sellers);
        UserRuntimeDataBase.setCustomers(customers);
        DrinkRuntimeDataBase.setDrinks(drinkSet);

        SaveUserDataBase.saveUserDataBase();
        SaveDrinkDataBase.saveDrinkDataBase();
    }
}
