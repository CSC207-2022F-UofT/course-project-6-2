package usecases.loginregisterusecases;

// Use Cases Layer

import usecases.userusercases.UserRuntimeDataBase;

public class LoginUser {
    /**
     * login: Receive login info and check if user should be authenticated
     * @param phoneNumber A String of user's phone number
     * @param passWord A String of user's password
     * @return A boolean indicating whether the login is successful
     */


    public static String login(String phoneNumber, String passWord) {
        if (UserRuntimeDataBase.getSellers().get(phoneNumber) != null &&
                UserRuntimeDataBase.getSellers().get(phoneNumber).getPassWord().equals(passWord)) {
            return "Seller";
        } else if (UserRuntimeDataBase.getCustomers().get(phoneNumber) != null &&
                UserRuntimeDataBase.getCustomers().get(phoneNumber).getPassWord().equals(passWord)) {
            return "Customer";
        }
        return "No user";
    }
}
