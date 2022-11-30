package usecases.userresponsemodel;

import javax.swing.*;
import java.util.Objects;

// Use case layer

public class RegisterResponseModel {
    public RegisterResponseModel(String registerResult) {
        String message;
        if (Objects.equals(registerResult, "Password not match")) {
            message = "Password does not match!";
        } else if (Objects.equals(registerResult, "Text field empty")) {
            message = "One or more information is missing!";
        } else if (Objects.equals(registerResult, "Phone number exists")){
            message = "Phone number already exists!";
        } else if (Objects.equals(registerResult, "Store name exists")) {
            message = "Store name already exists!";
        } else if (Objects.equals(registerResult, "Age not integer")) {
            message = "Age must be an integer!";
        } else {
            message = "You have successfully registered, please log in !";
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
