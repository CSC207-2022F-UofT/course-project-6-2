package usecases.userusercases;

import entities.users.Customer;
import entities.users.Seller;

import java.util.HashMap;

// Use Cases Layer

public class UserRuntimeDataBase {
    protected static HashMap<String, Seller> sellers = new HashMap<>();
    protected static HashMap<String, Customer> customers = new HashMap<>();

    protected static Seller currentSeller;

    protected static Customer currentCustomer;

    public static void constructCurrentSeller(String phoneNum){
        currentSeller = (Seller) sellers.get(phoneNum);
    }

    public static void constructCurrentCustomer(String phoneNum){
        currentCustomer = customers.get(phoneNum);
    }
    public static HashMap<String, Seller> getSellers() {
        return sellers;
    }

    public static HashMap<String, Customer> getCustomers() {
        return customers;
    }

    public static Seller getCurrentSeller() {
        return currentSeller;
    }

    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }
}
