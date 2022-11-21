package Screens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button {
    public JButton button;

    public JButton getButton() {
        return button;
    }

    public void createButton(JPanel panel, String buttonText, int boundX,
                             int boundY, int boundWidth, int boundHeight) {
        button = new JButton(buttonText);
        button.setBounds(boundX,boundY,boundWidth,boundHeight);
        panel.add(button);
    }

    public void addActionListener(ActionListener l) {
        button.addActionListener(l);
    }

}