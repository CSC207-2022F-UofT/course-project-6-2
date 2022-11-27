package UseCases.UserUseCases;

import Entities.Users.Seller;
import Entities.Users.User;

import java.util.HashMap;

// Use Cases Layer

public class UserRuntimeDataBase {
    protected static HashMap<String, User> sellers = new HashMap<>();
    protected static HashMap<String, User> customers = new HashMap<>();

    protected static Seller currentSeller;

    protected static Seller currentCustomer;
}
