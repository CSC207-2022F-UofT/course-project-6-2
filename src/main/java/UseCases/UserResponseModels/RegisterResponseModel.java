package UseCases.UserResponseModels;

import javax.swing.*;
import java.util.Objects;

// Use case layer

public class RegisterResponseModel {
    public RegisterResponseModel(String registerResult) {
        if (Objects.equals(registerResult, "Password not match")) {
            JOptionPane.showMessageDialog(null, "Password does not match!");
        } else if (Objects.equals(registerResult, "Text field empty")) {
            JOptionPane.showMessageDialog(null, "One or more information is missing!");
        } else if (Objects.equals(registerResult, "Phone number exists")){
            JOptionPane.showMessageDialog(null, "Phone number already exists!");
        } else if (Objects.equals(registerResult, "Store name exists")) {
            JOptionPane.showMessageDialog(null, "Store name already exists!");
        } else {
            JOptionPane.showMessageDialog(null, "You have successfully registered, please log in !");
        }
    }
}
