import users.Customer;
import users.Seller;
import users.User;
import users.UserController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    UserController userController;
    public Main() {
        userController = new UserController();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Main mainController = new Main();
        mainController.retrieve();
    }

    public void boot() throws IOException, ClassNotFoundException {
        Seller user1 = new Seller("donna", "77877787", "123456", "bay", "store", new ArrayList<>(), new ArrayList<>());
        Customer user2 = new Customer("kevin", "123123", "604604604", 20, "832", new ArrayList<>());
        userController.registerUser(user1);
        userController.registerUser(user2);
        userController.saveUserDataBase();
    }

    public void retrieve() throws IOException, ClassNotFoundException {
        userController.constructUserDataBase();
    }
}
