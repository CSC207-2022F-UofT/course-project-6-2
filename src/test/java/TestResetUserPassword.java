import org.junit.jupiter.api.Test;
import usecases.loginregisterusecases.ResetUserPassword;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestResetUserPassword {
    @Test
    public void testResetUserPassword() throws IOException, ClassNotFoundException {
        /*reset seller password*/
        /*boolean t1 = ResetUserPassword.resetPassword("778", "234", "234");
        assertTrue(t1);
        String password1 = UserRuntimeDataBase.getSellers().get("778").getPassWord();
        assertEquals(password1, "234");
        ResetUserPassword.resetPassword("778", "123", "123");
        /*reset customer password*/
        /*boolean t2 = ResetUserPassword.resetPassword("604", "234", "234");
        assertTrue(t2);
        String password2 = UserRuntimeDataBase.getCustomers().get("604").getPassWord();
        assertEquals(password2, "234");
        ResetUserPassword.resetPassword("604", "123", "123");
        /*password and confirmpass are different*/
        boolean t3 = ResetUserPassword.resetPassword("604", "234", "123");
        assertFalse(t3);
        /*phonenumber does not exist*/
        boolean t4 = ResetUserPassword.resetPassword("1963873264823", "234", "234");
        assertFalse(t4);
    }
}