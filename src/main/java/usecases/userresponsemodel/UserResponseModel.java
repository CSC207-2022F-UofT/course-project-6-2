package usecases.userresponsemodel;

import usecases.customerusecases.SearchForSeller;

import javax.swing.*;
import java.util.Objects;

public class UserResponseModel {
    private String message;
    public String loginResponse(String loginResult) {
        if(Objects.equals(loginResult, "Seller") || Objects.equals(loginResult, "Customer")){
            message = "You have successfully logged in!";
        } else {
            message = "Incorrect phone number or password!";
        }
        return message;
    }

    public String registerResponse(String registerResult) {
        if (Objects.equals(registerResult, "Password not match")) {
            message = "Password does not match!";
        } else if (Objects.equals(registerResult, "Text field empty")) {
            message = "One or more information is missing!";
        } else if (Objects.equals(registerResult, "Phone number not integer")) {
            message = "Phone number must be integers!";
        } else if (Objects.equals(registerResult, "Phone number not valid length")) {
            message = "Phone number is not valid length!";
        } else if (Objects.equals(registerResult, "Phone number exists")){
            message = "Phone number already exists!";
        } else if (Objects.equals(registerResult, "Store name exists")) {
            message = "Store name already exists!";
        } else if (Objects.equals(registerResult, "Age not integer")) {
            message = "Age must be an integer!";
        } else {
            message = "You have successfully registered, please log in !";
        }
        return message;
    }

    public String resetResponse(boolean resetResult) {
        String message;
        if (resetResult) {
            message = "You have reset your password!";
        } else {
            message = "Phone number incorrect or password doesn't match!";
        }
        return message;
    }

    public String addModifyDrinkResponse(String addModifyResult) {
        if (Objects.equals(addModifyResult, "Price not float")) {
            message = "Price must be a float!";
        } else if (Objects.equals(addModifyResult, "Volume not integer")) {
            message = "Volume must be an integer!";
        } else if (Objects.equals(addModifyResult, "Production not Date")) {
            message = "Production date is not in the correct format!";
        } else if (Objects.equals(addModifyResult, "Expiration not Date")) {
            message = "Expiration date is not in the correct format!";
        } else if (Objects.equals(addModifyResult, "Discount not float")) {
            message = "Discount must be a float!";
        } else if (Objects.equals(addModifyResult, "Success")){
            message = "Drink added successfully!";
        }
        return message;
    }

    public String questionResponse(int questionNumber) {
        if (questionNumber == 1) {
            message = "Register on our app for the flexibility to sell one item or thousands. " +
                    "Fulfill orders quickly when customers make a purchase.";
        }
        if (questionNumber == 2) {
            message = "Sorry, currently we do not offer any reward points";
        }
        if (questionNumber == 3) {
            message = "Sorry, currently we do not offer any birthday special or reward programs.";
        }
        if (questionNumber == 4) {
            message = "Once you place an order on the website, " +
                    "you'll find the record from Get Order Status shortly";
        }
        if (questionNumber == 5) {
            message = "Shipping fees depend on whether you plan to fulfill orders yourself. " +
                    "Generally speaking: Air express > Air freight > sea freight ";
        }
        if (questionNumber == 6) {
            JOptionPane.showMessageDialog(null, "Some products may not be listed as a matter of " +
                    "compliance with legal or regulatory restrictions (for example, prescription drugs). ");
        }
        if (questionNumber == 7) {
            JOptionPane.showMessageDialog(null, "Further concerns please contact our " +
                    "customer support. Phone: 416-978-3384." + " Email: ask.6+2@utoronto.ca");
        }

        if (questionNumber == 0) {
            String storeName = JOptionPane.showInputDialog(null, "Enter seller's store name to search for:");
            if (SearchForSeller.sellerExists(storeName)) {
                message = "The phone number for store " + storeName + " is " + SearchForSeller.getPhoneNumber();
            } else {
                message = "Could not find the Seller " + storeName;
            }
        }

        return message;
    }
}
