package screens.swingcomponents;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelTextHorizontalPanel extends JPanel {
    public LabelTextHorizontalPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}