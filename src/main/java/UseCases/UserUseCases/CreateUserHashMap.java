package UseCases.UserUseCases;

import Entities.Users.User;

import java.util.HashMap;

// Use Cases Layer

public class CreateUserHashMap {
    protected static HashMap<String, User> sellers = new HashMap<>();
    protected static HashMap<String, User> customers = new HashMap<>();

    public static HashMap<String, User> getSellers() {return sellers;}

    public static HashMap<String, User> getCustomers() {
        return customers;
    }
}
