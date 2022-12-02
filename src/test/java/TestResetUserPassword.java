import org.junit.jupiter.api.Test;
import usecases.loginregisterusecases.ResetUserPassword;
import usecases.databaseusecases.UserRuntimeDataBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class TestResetUserPassword {
    @Test
    public void testResetUserPassword() throws IOException, ClassNotFoundException {
        /*reset seller password*/
        boolean t1 = ResetUserPassword.resetPassword("778", "234", "234");
        assertEquals(t1, true);
        String password1 = UserRuntimeDataBase.getSellers().get("778").getPassWord();
        assertEquals(password1, "234");
        ResetUserPassword.resetPassword("778", "123", "123");
        /*reset customer password*/
        boolean t2 = ResetUserPassword.resetPassword("604", "234", "234");
        assertEquals(t2, true);
        String password2 = UserRuntimeDataBase.getCustomers().get("604").getPassWord();
        assertEquals(password2, "234");
        ResetUserPassword.resetPassword("604", "123", "123");
        /*password and confirmpass are different*/
        boolean t3 = ResetUserPassword.resetPassword("604", "234", "123");
        assertEquals(t3, false);
        /*phonenumber does not exist*/
        boolean t4 = ResetUserPassword.resetPassword("1963873264823", "234", "234");
        assertEquals(t4, false);
    }
}