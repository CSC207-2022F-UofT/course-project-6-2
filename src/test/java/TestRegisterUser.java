import entities.users.Customer;
import entities.users.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.loginregisterusecases.RegisterUser;
import usecases.databaseusecases.UserRuntimeDataBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegisterUser {
    @Test
    @BeforeEach
    public void testRegisterUserSetup() {
        Customer customer1 = new Customer("Sara", "1234", "abcd", 18, "Bay");
        Seller seller1 = new Seller("Aras", "4321", "dcba", "Bay", "Super Pig");
        UserRuntimeDataBase.getCustomers().put(customer1.getPhoneNumber(), customer1);
        UserRuntimeDataBase.getSellers().put(seller1.getPhoneNumber(), seller1);
    }
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
        String register3 = RegisterUser.registerUser("accountName3", "1234", "password3", "password3",
                "address3", 38, "storeName3");
        assertEquals(register3, "Phone number exists");
        /*test when store name exists*/

        String register4 = RegisterUser.registerUser("accountName4", "phoneNumber4", "password4", "password4",
                "address4", 48, "Super Pig");
        assertEquals(register4, "Store name exists");
        /*test customer register*/
        String register5 = RegisterUser.registerUser("accountName5", "phoneNumber5", "password5", "password5",
                "address5", 58, null);
        assertEquals(register5, "Successfully registered");
        assertEquals(UserRuntimeDataBase.getCustomers().get("phoneNumber5").getAge(), 58);
        /*test seller register*/

        String register6 = RegisterUser.registerUser("accountName6", "phoneNumber6", "password6", "password6",

                "address6", 68, "storeName6");
        assertEquals(register6, "Successfully registered");
        assertEquals(UserRuntimeDataBase.getSellers().get("phoneNumber6").getStoreName(), "storeName6");
        /*test age not int*/
        String register7 = RegisterUser.registerUser("accountName7", "phoneNumber7", "password7", "password7",
                "address7", -2, "storeName7");
        assertEquals(register7, "Age not integer");

    }
}