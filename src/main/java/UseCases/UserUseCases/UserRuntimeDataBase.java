package UseCases.UserUseCases;

import Entities.Users.*;

import java.util.HashMap;

// Use Cases Layer

public class UserRuntimeDataBase {
    protected static HashMap<String, User> sellers = new HashMap<>();
    protected static HashMap<String, User> customers = new HashMap<>();

    protected static Seller currentSeller;

    protected static Customer currentCustomer;

    public static void constructCurrentSeller(String phoneNum){
        currentSeller = (Seller) sellers.get(phoneNum);
    }

    public static void constructCurrentCustomer(String phoneNum){
        currentCustomer = (Customer) customers.get(phoneNum);
    }

    public static HashMap<String, User> getSellers() {
        return sellers;
    }

    public static HashMap<String, User> getCustomers() {
        return customers;
    }

    public static Seller getCurrentSeller() {
        return currentSeller;
    }

    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }
}
