import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.users.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCustomer {
    @Test
    @DisplayName("Customer test")
    void testCustomer(){
        Customer customer1 = new Customer("Amy", "7780000000", "abcd", 20, "College St.");
        assertEquals(customer1.getAge(), 20);
    }
}
