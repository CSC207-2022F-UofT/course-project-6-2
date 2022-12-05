import entities.users.Customer;
import entities.users.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.loginregisterusecases.ResetUserPassword;
import usecases.databaseusecases.UserRuntimeDataBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class TestResetUserPassword {
    @Test
    @BeforeEach
    public void testLoginUserSetup() {
        Customer customer1 = new Customer("Sara", "1234", "abcd", 18, "Bay");
        Seller seller1 = new Seller("Aras", "4321", "dcba", "Bay", "Super Pig");
        UserRuntimeDataBase.getCustomers().put(customer1.getPhoneNumber(), customer1);
        UserRuntimeDataBase.getSellers().put(seller1.getPhoneNumber(), seller1);
    }
    @Test
    public void testResetUserPassword() throws IOException, ClassNotFoundException {
        /*reset seller password*/
        boolean t1 = ResetUserPassword.resetPassword("4321", "4444", "4444");
        assertEquals(t1, true);
        String password1 = UserRuntimeDataBase.getSellers().get("4321").getPassWord();
        assertEquals(password1, "4444");
        /*reset customer password*/
        boolean t2 = ResetUserPassword.resetPassword("1234", "1111", "1111");
        assertEquals(t2, true);
        String password2 = UserRuntimeDataBase.getCustomers().get("1234").getPassWord();
        assertEquals(password2, "1111");
        ResetUserPassword.resetPassword("604", "123", "123");
        /*password and confirmpass are different*/
        boolean t3 = ResetUserPassword.resetPassword("1234", "234", "123");
        assertEquals(t3, false);
        /*phonenumber does not exist*/
        boolean t4 = ResetUserPassword.resetPassword("1963873264823", "234", "234");
        assertEquals(t4, false);
    }
}