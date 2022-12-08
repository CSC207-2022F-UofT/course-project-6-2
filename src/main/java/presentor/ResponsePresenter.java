package presentor;

import javax.swing.*;

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
