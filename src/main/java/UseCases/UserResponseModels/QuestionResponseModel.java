package UseCases.UserResponseModels;

import javax.swing.*;

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
    }
}
