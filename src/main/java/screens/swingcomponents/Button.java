package screens.swingcomponents;

import javax.swing.*;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer
/**
 * Create the methods for the button to use this button class more convenient in the interface.
 */
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