import org.junit.jupiter.api.Test;
import usecases.loginregisterusecases.LoginUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginUser {
    @Test
    public void testLoginUser(){
        /*test customer login*/
        assertEquals(LoginUser.login("604", "123"), "Customer");
        /*test seller login*/
        assertEquals(LoginUser.login("778", "123"), "Seller");
        /*test other login*/
        assertEquals(LoginUser.login("9327486349", "123"), "No user");
    }
}
