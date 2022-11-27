package UseCases.UserResponseModels;

import javax.swing.*;
import java.util.Objects;

// Use case layer

public class LoginResponseModel{
    public LoginResponseModel(String loginResult) {
        if(Objects.equals(loginResult, "Seller") || Objects.equals(loginResult, "Customer")){
            JOptionPane.showMessageDialog(null, "You have successfully logged in!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect phone number or password!");
        }
    }
}
