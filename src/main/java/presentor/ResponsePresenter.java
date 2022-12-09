package presentor;

import javax.swing.*;

/**
 * The presenter to present the corresponding message when the corresponding action is done by user.
 */
public class ResponsePresenter {
    String message;
    public ResponsePresenter(String message) {
        this.message = message;
    }
    public void messagePresenter() {
        JOptionPane.showMessageDialog(null, message);
    }

    public void drinkMessagePresenter(String drink) {
        JOptionPane.showMessageDialog(null, drink + message);
    }
}
