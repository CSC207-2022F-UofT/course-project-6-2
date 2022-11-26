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
        if (CreateUserHashMap.sellers.get(phoneNumber) != null &&
                CreateUserHashMap.sellers.get(phoneNumber).getPassWord().equals(passWord)) {
            return true;
        } else return CreateUserHashMap.customers.get(phoneNumber) != null &&
                CreateUserHashMap.customers.get(phoneNumber).getPassWord().equals(passWord);
    }
}