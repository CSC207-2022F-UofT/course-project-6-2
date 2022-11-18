package UI;

import javax.swing.*;
import java.awt.*;

public class NumberLabel {
    JLabel label;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(String s){
        label.setText(s);
    }
    public void createLabel(JPanel dialogBox, int labelText, Color foregroundColor, int boundX, int boundY,
                            int boundWidth, int boundHeight) {
        label = new JLabel(String.valueOf(labelText));
        label.setBounds(boundX, boundY, boundWidth, boundHeight);
        label.setForeground(foregroundColor);
        if (dialogBox != null) {
            dialogBox.add(label);
        }
    }
}
