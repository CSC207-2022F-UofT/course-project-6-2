package UseCases.UserUseCases;

import Entities.Users.Customer;
import Entities.Users.Seller;
import Entities.Users.User;

import java.util.HashMap;

// Use Cases Layer

public class UserRuntimeDataBase {
    protected static HashMap<String, User> sellers = new HashMap<>();
    protected static HashMap<String, User> customers = new HashMap<>();

    public static Seller currentSeller;

    public static Customer currentCustomer;
}
