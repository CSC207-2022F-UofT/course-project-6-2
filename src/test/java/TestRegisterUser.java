import entities.users.Seller;
import org.junit.jupiter.api.Test;
import usecases.loginregisterusecases.RegisterUser;
import usecases.userusercases.UserRuntimeDataBase;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegisterUser {
    @Test
    public void testRegisterUser(){
        /*test when password and confirmPass are the same*/
        String register1 = RegisterUser.registerUser("accountName1", "phoneNumber1", "password1", "confirmPass1",
                "address1", 18, "storeName1");
        assertEquals(register1, "Password not match");
        /*test when any parameter is missing*/
        String register2 = RegisterUser.registerUser("", "phoneNumber2", "password2", "password2",
                "address2", 0, "");
        assertEquals(register2, "Text field empty");
        /*test when phone number exists*/
        String register3 = RegisterUser.registerUser("accountName3", "604", "password3", "password3",
                "address3", 38, "storeName3");
        assertEquals(register3, "Phone number exists");
        /*test when store name exists*/
        HashMap<String, Seller> sellers = UserRuntimeDataBase.getSellers();
        ArrayList<Seller> sellers1 = new ArrayList<>(sellers.values());
        String storename1 = sellers1.get(0).getStoreName();
        String register4 = RegisterUser.registerUser("accountName4", "phoneNumber4", "password4", "password4",
                "address4", 48, storename1);
        assertEquals(register4, "Store name exists");
    }
}
