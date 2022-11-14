package users;

import helpers.Deserializer;
import helpers.Serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UserController {
    protected static HashMap<String, User> sellers = new HashMap<>();
    protected static HashMap<String, User> customers = new HashMap<>();
    private static final Serializer userSerializer = new Serializer();
    private static final Deserializer userDeserializer = new Deserializer();

    /**
     * constructUserDataBase: Extract data from database and store to users HashMap
     */
    public static void constructUserDataBase() throws IOException, ClassNotFoundException {
        userDeserializer.deserialize("./data/users");
        ArrayList<HashMap> data = (ArrayList<HashMap>) userDeserializer.getObject();
        if (data != null) {
            sellers = data.get(0);
            customers = data.get(1);
        }
    }

    /**
     * saveUserDataBase: Store users HashMap data to database
     */
    public static void saveUserDataBase() throws IOException {
        ArrayList<HashMap> users = new ArrayList<HashMap>(
                Arrays.asList(sellers, customers)
        );
        userSerializer.serialize("./data/users", users);
    }

    /**
     * registerUser: Store user instance to corresponding database
     * @param user A User instance to be stored in the database
     */
    public static void registerUser(User user) {
        if (user instanceof Seller) {
            sellers.put(user.getPhoneNumber(), user);
        } else {
            customers.put(user.getPhoneNumber(), user);
        }
    }

    /**
     * login: Receive login info and check if user should be authenticated
     * @param phoneNumber A String of user's phone number
     * @param passWord A String of user's password
     * @return A boolean indicating whether the login is successful
     */
    public static boolean login(String phoneNumber, String passWord) {
        if (sellers.get(phoneNumber) != null && sellers.get(phoneNumber).getPassWord().equals(passWord)) {
            return true;
        } else if (customers.get(phoneNumber) != null && customers.get(phoneNumber).getPassWord().equals(passWord)) {
            return true;
        }
        return false;
    }

    /**
     * resetPassword: Receive newPassword and check if the new password is different from previous password,
     * a user can only reset the password if and only if the new password is different from their previous password
     * @param newPassword A String of new password the user wants to reset to
     * @param user A User instance
     * @return A boolean indicating whether reset successfully
     */
    public Boolean resetPassword(User user, String newPassword){
        if (user instanceof Seller){
            if (sellers.get(user.getPhoneNumber()).getPassWord().equals(newPassword)){
                return false;
            }
            return true;
        } else if(customers.get(user.getPhoneNumber()).getPassWord().equals(newPassword)){
            return false;
        }
        return true;
    }
}
