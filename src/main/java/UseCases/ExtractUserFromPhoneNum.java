package UseCases;

import Controller.LoginController;
import Entities.Users.User;
import UseCases.UserUseCases.CreateUserHashMap;

public class ExtractUserFromPhoneNum{

    public User extractUser(LoginController loginController) {
        if (CreateUserHashMap.getSellers().get(loginController.getPhoneNumber()) != null) {
            return CreateUserHashMap.getSellers().get(loginController.getPhoneNumber());
        } else {
            return CreateUserHashMap.getCustomers().get(loginController.getPhoneNumber());
        }
    }
}
