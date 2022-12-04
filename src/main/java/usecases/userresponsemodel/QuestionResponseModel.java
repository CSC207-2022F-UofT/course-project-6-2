package usecases.userresponsemodel;

import entities.users.Seller;
import usecases.databaseusecases.UserRuntimeDataBase;

import javax.swing.*;
import java.util.*;


public class QuestionResponseModel {

    public QuestionResponseModel(int questionNumber) {

        if (questionNumber == 1) {
            JOptionPane.showMessageDialog(null, "Register on our app for the flexibility to sell one item or thousands.\n" +
                    "Fulfill orders quickly when customers make a purchase.");
        }
        if (questionNumber == 2) {
            JOptionPane.showMessageDialog(null, "Sorry, currently we do not offer any reward points");
        }
        if (questionNumber == 3) {
            JOptionPane.showMessageDialog(null, "Sorry, currently we do not offer " +
                    "any birthday special or reward programs.");
        }
        if (questionNumber == 4) {
            JOptionPane.showMessageDialog(null, "Once you place an order on the website, " +
                    "you'll find the record from Get Order Status shortly");
        }
        if (questionNumber == 5) {
            JOptionPane.showMessageDialog(null, "Shipping fees depend on whether you plan to fulfill orders yourself." +
                    " Generally speaking: Air express > Air freight > sea freight ");
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
            String personName = JOptionPane.showInputDialog(null, "Enter seller's store name to search for:");

            // value whose key is to be searched
            HashMap<String, Seller> SearchField = UserRuntimeDataBase.getSellers();
            HashMap<String, String> SearchField2 = new HashMap<>();

            // iterate each entry of hashmap
            for (Map.Entry<String, Seller> entry : SearchField.entrySet()) {

                SearchField2.put(entry.getValue().getStoreName(), entry.getKey());
            }
            if (SearchField2.containsKey(personName)){
                JOptionPane.showMessageDialog(null,
                        "The phone number for store " +
                                personName + " is " + SearchField2.get(personName));
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Could not find the Seller " + personName);
            }
            }
        }
    }

