package TestUseCases;

import entities.users.Customer;
import entities.users.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.loginregisterusecases.ResetUserPassword;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the reset user password use case, when the user reset the password, the different cases would be distinguished
 * and reset the password successfully or unsuccessfully for different cases.
 */
public class TestResetUserPassword {
    @Test
    @BeforeEach
    public void testResetUserPasswordSetup() {
        Customer customer1 = new Customer("Sara", "1234", "abcd", 18, "Bay");
        Seller seller1 = new Seller("Aras", "4321", "dcba", "Bay", "Super Pig");
        UserRuntimeDataBase.getCustomers().put(customer1.getPhoneNumber(), customer1);
        UserRuntimeDataBase.getSellers().put(seller1.getPhoneNumber(), seller1);
    }
    @Test
    public void testResetUserPassword() throws IOException, ClassNotFoundException {
        /*reset seller password*/
        boolean t1 = ResetUserPassword.resetPassword("4321", "4444", "4444");
        assertTrue(t1);
        String password1 = UserRuntimeDataBase.getSellers().get("4321").getPassWord();
        assertEquals(password1, "4444");
        /*reset customer password*/
        boolean t2 = ResetUserPassword.resetPassword("1234", "1111", "1111");
        assertTrue(t2);
        String password2 = UserRuntimeDataBase.getCustomers().get("1234").getPassWord();
        assertEquals(password2, "1111");
        ResetUserPassword.resetPassword("604", "123", "123");
        /*password and confirmpass are different*/
        boolean t3 = ResetUserPassword.resetPassword("1234", "234", "123");
        assertFalse(t3);
        /*phonenumber does not exist*/
        boolean t4 = ResetUserPassword.resetPassword("1963873264823", "234", "234");
        assertFalse(t4);
    }
}