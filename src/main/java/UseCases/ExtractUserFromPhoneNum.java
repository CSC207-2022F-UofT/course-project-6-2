package UseCases;

import Entities.Users.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExtractUserFromPhoneNum{

    Helpers.Deserializer userDeserializer = new Helpers.Deserializer();
    HashMap<String, User> sellers = new HashMap<>();
    HashMap<String, User> customers = new HashMap<String, User>();

    public User extractUser(String phoneNum) throws IOException, ClassNotFoundException {
        userDeserializer.deserialize("./data/users");
        ArrayList<HashMap> data = (ArrayList<HashMap>) userDeserializer.getObject();
        if (data != null) {
            sellers = data.get(0);
            customers = data.get(1);
        }

        if (sellers.get(phoneNum).getPhoneNumber().equals(phoneNum)) {
            return sellers.get(phoneNum);
        } else {
            return customers.get(phoneNum);
        }
    }
}
