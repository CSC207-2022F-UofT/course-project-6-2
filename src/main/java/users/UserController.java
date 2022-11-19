package users;

import helpers.Deserializer;
import helpers.Serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class UserController {
    protected static HashMap<String, User> sellers = new HashMap<>();
    protected static HashMap<String, User> customers = new HashMap<>();
    private static final Serializer userSerializer = new Serializer();
    private static final Deserializer userDeserializer = new Deserializer();

    /**
     * constructUserDataBase: Extract data from database and store to users HashMap
     */
    @SuppressWarnings("unchecked")
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
            customers.put(phoneNumber, newCustomer);
        }

        // if user is a seller
        else {
            Seller newSeller = new Seller(accountName, phoneNumber, password, address, storeName, new ArrayList<>(), new ArrayList<>());
            sellers.put(phoneNumber, newSeller);
        }
        return true;
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
     * a user can only reset the password if and only if the phone number exists and newPass and confirmPass match
     * @param phoneNumber User's phone number
     * @param newPass A String of new password the user wants to reset to
     * @param confirmPass A String of confirmed new password the user wants to reset to
     * @return Reset unsuccessful (false) happens when phone number is incorrect or newPass and confirmPass doesn't match
     */
    public static Boolean resetPassword(String phoneNumber, String newPass, String confirmPass) throws IOException, ClassNotFoundException {
        if (sellers.get(phoneNumber) != null) {
            if (newPass.equals(confirmPass)) {
                sellers.get(phoneNumber).setPassWord(newPass);
                return true;
            }
        }
        else if (customers.get(phoneNumber) != null) {
            if (newPass.equals(confirmPass)) {
                customers.get(phoneNumber).setPassWord(newPass);
                return true;
            }
        }
        return false;
    }
}
