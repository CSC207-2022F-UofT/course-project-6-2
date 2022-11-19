package UI;

import javax.swing.*;
import java.awt.*;

    public class Label {
        JLabel label;

        public JLabel getLabel() {
            return label;
        }

        public void setLabel(String s){
            label.setText(s);
        }

        public void createLabel(JPanel dialogBox, String labelText, Color foregroundColor, int boundX, int boundY,
                                int boundWidth, int boundHeight) {
            label = new JLabel(labelText);
            label.setBounds(boundX, boundY, boundWidth, boundHeight);
            label.setForeground(foregroundColor);
            if (dialogBox != null) {
                dialogBox.add(label);
            }
        }

}
