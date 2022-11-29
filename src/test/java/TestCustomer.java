import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.users.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This test is testing Customer constructor and some inherited properties like accountname, phonenumber etc.
 * further properties like getShoppingCart will be tested in UsecaseTest.
 */
public class TestCustomer {
    @Test
    @DisplayName("Customer test")
    void testCustomer(){
        Customer customer1 = new Customer("Amy", "7780000000",
                "abcd", 20, "College St.");
        assertEquals(customer1.getAge(), 20);
        assertEquals(customer1.getPassWord(), "abcd");
        assertEquals(customer1.getPhoneNumber(), "7780000000");
        assertEquals(customer1.getAccountName(), "Amy");
        assertEquals(customer1.getAddress(), "College St.");
    }
}
