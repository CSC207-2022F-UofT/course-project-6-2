package screens.swingcomponents;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelTextVerticalPanel extends JPanel {
    JLabel label;
    JTextField textField;
    public void createLabelTextPanel(JPanel panel, JLabel label, JTextField textField, int boundX,
                                     int boundY, int boundWidth, int boundHeight) {
        this.label = label;
        this.textField = textField;
        label.setBounds(boundX, boundY, boundWidth, boundHeight);
        textField.setBounds(boundX - 5, boundY + 25, boundWidth, boundHeight);
        panel.add(label);
        panel.add(textField);
    }
}