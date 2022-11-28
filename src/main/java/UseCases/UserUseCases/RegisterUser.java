package UseCases.UserUseCases;

import Entities.Users.*;

import java.util.ArrayList;
import java.util.Objects;

// Use Case Layer

public class RegisterUser {
    /**
     * registerUser: Store user instance to corresponding database
     * @param accountName A String of user account name
     * @param phoneNumber A String of user phone number
     * @param password A String of user password
     * @param confirmPass A String of confirmed user password
     * @param address A String of user address
     * @param age An int of user age
     * @param storeName A String of store name
     */
    public static boolean registerUser(String accountName, String phoneNumber, String password, String confirmPass,
                                       String address, int age, String storeName) {
        // determine if password and confirmPass are the same
        if (!Objects.equals(password, confirmPass)){
            return false;
        }

        // if user is a customer
        if (storeName == null) {
            Customer newCustomer = new Customer(accountName, phoneNumber, password, age, address, new ArrayList<>());
            UserRuntimeDataBase.customers.put(phoneNumber, newCustomer);
        }

        // if user is a seller
        else {
            Seller newSeller = new Seller(accountName, phoneNumber, password, address, storeName, new ArrayList<>(), new ArrayList<>());
            UserRuntimeDataBase.sellers.put(phoneNumber, newSeller);
        }
        return true;
    }
}
