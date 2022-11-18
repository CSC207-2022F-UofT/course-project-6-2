package UI;

import javax.swing.*;

public class Button {
    JButton button;

    public void createButton(JPanel dialogBox, String buttonText, int boundX,
                                     int boundY, int boundWidth, int boundHeight) {
        button = new JButton(buttonText);
        button.setBounds(boundX,boundY,boundWidth,boundHeight);
        dialogBox.add(button);
    }
}
