package UseCases;

import Entities.Users.User;
import UseCases.UserUseCases.CreateUserHashMap;

import java.io.IOException;



public class ExtractUserFromPhoneNum{

    public User extractUser(String phoneNum) throws IOException, ClassNotFoundException {
        if (CreateUserHashMap.getSellers().get(phoneNum) != null) {
            return CreateUserHashMap.getSellers().get(phoneNum);
        } else {
            return CreateUserHashMap.getCustomers().get(phoneNum);
        }
    }
}
