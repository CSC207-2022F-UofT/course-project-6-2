package usecases.loginregisterusecases;

import entities.users.Customer;
import entities.users.Seller;
import usecases.drinkusecases.DrinkRuntimeDataBase;
import usecases.userusercases.UserRuntimeDataBase;

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
     * @return A String indicating whether the user inputs are valid or not.
     */
    public static String registerUser(String accountName, String phoneNumber, String password, String confirmPass,
                                      String address, int age, String storeName) {
        // determine if password and confirmPass are the same
        if (!Objects.equals(password, confirmPass)){
            return "Password not match";
        }

        // determine if any parameter is missing
        if (Objects.equals(accountName, "") || Objects.equals(phoneNumber, "") || Objects.equals(password, "")
                || Objects.equals(confirmPass, "") || Objects.equals(address, "") || age == 0 || Objects.equals(storeName, "")) {
            return "Text field empty";
        }

        // determine if phone number exists
        if (UserRuntimeDataBase.getSellers().get(phoneNumber) != null || UserRuntimeDataBase.getCustomers().get(phoneNumber) != null) {
            return "Phone number exists";
        }

        // determine if store name exists
        if (UserRuntimeDataBase.getSellers().get(storeName) != null) {
            return "Store name exists";
        }

        // if user is a customer
        if (storeName == null) {
            Customer newCustomer = new Customer(accountName, phoneNumber, password, age, address);
            UserRuntimeDataBase.getCustomers().put(phoneNumber, newCustomer);
        }

        // if user is a seller
        else {
            Seller newSeller = new Seller(accountName, phoneNumber, password, address, storeName);
            UserRuntimeDataBase.getSellers().put(phoneNumber, newSeller);
            DrinkRuntimeDataBase.addStore(storeName);
        }
        return "Successfully registered";
    }
}
