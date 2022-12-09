package TestUseCases;

import entities.users.Customer;
import entities.users.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.loginregisterusecases.LoginUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginUser {
    @Test
    @BeforeEach
    public void testLoginUserSetup() {
        Customer customer1 = new Customer("Sara", "1234", "abcd", 18, "Bay");
        Seller seller1 = new Seller("Aras", "4321", "dcba", "Bay", "Super Pig");
        UserRuntimeDataBase.getCustomers().put(customer1.getPhoneNumber(), customer1);
        UserRuntimeDataBase.getSellers().put(seller1.getPhoneNumber(), seller1);
        UserRuntimeDataBase.constructCurrentCustomer("1234");
        UserRuntimeDataBase.constructCurrentSeller("4321");
    }
    @Test
    public void testLoginUser(){
        /*test customer login*/
        assertEquals(LoginUser.login("1234", "abcd"), "Customer");
        /*test seller login*/
        assertEquals(LoginUser.login("4321", "dcba"), "Seller");
        /*test other login*/
        assertEquals(LoginUser.login("9327486349", "123"), "No user");
    }
}