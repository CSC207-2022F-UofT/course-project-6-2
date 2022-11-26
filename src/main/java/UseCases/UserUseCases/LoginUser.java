package UseCases.UserUseCases;

// Use Cases Layer

public class LoginUser {
    /**
     * login: Receive login info and check if user should be authenticated
     * @param phoneNumber A String of user's phone number
     * @param passWord A String of user's password
     * @return A boolean indicating whether the login is successful
     */

    public static boolean login(String phoneNumber, String passWord) {
        if (UserRuntimeDataBase.sellers.get(phoneNumber) != null &&
                UserRuntimeDataBase.sellers.get(phoneNumber).getPassWord().equals(passWord)) {
            return true;
        } else return UserRuntimeDataBase.customers.get(phoneNumber) != null &&
                UserRuntimeDataBase.customers.get(phoneNumber).getPassWord().equals(passWord);
    }
}
