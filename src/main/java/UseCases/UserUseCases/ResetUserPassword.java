package UseCases.UserUseCases;

import java.io.IOException;

// User Case Layer

public class ResetUserPassword {
    /**
     * resetPassword: Receive newPassword and check if the new password is different from previous password,
     * a user can only reset the password if and only if the phone number exists and newPass and confirmPass match
     * @param phoneNumber User's phone number
     * @param newPass A String of new password the user wants to reset to
     * @param confirmPass A String of confirmed new password the user wants to reset to
     * @return Reset unsuccessful (false) happens when phone number is incorrect or newPass and confirmPass doesn't match
     */
    public static Boolean resetPassword(String phoneNumber, String newPass, String confirmPass) throws IOException, ClassNotFoundException {
        if (UserRuntimeDataBase.sellers.get(phoneNumber) != null) {
            if (newPass.equals(confirmPass)) {
                UserRuntimeDataBase.sellers.get(phoneNumber).setPassWord(newPass);
                return true;
            }
        }
        else if (UserRuntimeDataBase.customers.get(phoneNumber) != null) {
            if (newPass.equals(confirmPass)) {
                UserRuntimeDataBase.customers.get(phoneNumber).setPassWord(newPass);
                return true;
            }
        }
        return false;
    }
}
