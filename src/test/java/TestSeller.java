import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.users.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This test is testing Seller constructor attributes and some inherited properties.
 * more properties will be tested in UsecaseTest.
 */
public class TestSeller {
    @Test
    @DisplayName("Seller test")
    void testCustomer(){
        Seller Seller1 = new Seller("May", "4165552704",
                "abcd", "200Elm", "Teashop168");
        assertEquals(Seller1.getStoreName(), "Teashop168");
        assertEquals(Seller1.getPhoneNumber(), "4165552704");
        assertEquals(Seller1.getAddress(), "200Elm");
        assertEquals(Seller1.getPassWord(), "abcd");
        assertEquals(Seller1.getAccountName(), "May");
    }
}