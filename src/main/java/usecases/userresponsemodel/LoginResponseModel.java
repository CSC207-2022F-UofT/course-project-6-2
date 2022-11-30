package usecases.userresponsemodel;

import javax.swing.*;
import java.util.Objects;

// Use case layer

public class LoginResponseModel{
    public LoginResponseModel(String loginResult) {
        String message;
        if(Objects.equals(loginResult, "Seller") || Objects.equals(loginResult, "Customer")){
            message = "You have successfully logged in!";
        } else {
            message = "Incorrect phone number or password!";
        }
        JOptionPane.showMessageDialog(null, message);

    }
}
