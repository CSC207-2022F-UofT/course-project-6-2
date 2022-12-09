package screens.swingcomponents;

import javax.swing.*;

// Frameworks/Drivers layer

/**
 * Create the constructor for the label to the horizontal panel to use this button class more convenient in the interface.
 */
public class LabelTextHorizontalPanel extends JPanel {
    public LabelTextHorizontalPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}