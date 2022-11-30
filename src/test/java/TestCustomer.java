import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.users.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This test is testing Customer constructor and some inherited properties like accountname, phonenumber etc.
 * further properties like getShoppingCart will be tested in UsecaseTest.
 */
public class TestCustomer {
    Customer customer1 = new Customer("Amy", "7780000000",
            "abcd", 20, "College St.");

    @Test
    @DisplayName("Get age test")
    void getAgeTest(){
        assertEquals(customer1.getAge(), 20);
    }

    @Test
    @DisplayName("Get phone number test")
    void getPhoneNumTest(){
        assertEquals(customer1.getPhoneNumber(), "7780000000");
    }

    @Test
    @DisplayName("Get age test")
    void getPasswordTest() {
        assertEquals(customer1.getPassWord(), "abcd");
    }

    @Test
    @DisplayName("Get account number test")
    void getAccountNameTest(){
        assertEquals(customer1.getAccountName(), "Amy");
    }

    @Test
    @DisplayName("Get address test")
    void name() {
        assertEquals(customer1.getAddress(), "College St.");
    }
}
