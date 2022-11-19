package UI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button {
    JButton button;

    public void createButton(JPanel dialogBox, String buttonText, int boundX,
                                     int boundY, int boundWidth, int boundHeight) {
        button = new JButton(buttonText);
        button.setBounds(boundX,boundY,boundWidth,boundHeight);
        dialogBox.add(button);
    }
}
