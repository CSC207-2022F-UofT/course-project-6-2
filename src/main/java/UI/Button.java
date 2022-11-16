package UI;

import javax.swing.*;

public class Button {
    JButton button;

    public JButton getButton() {
        return button;
    }

    public void createButton(JFrame dialogBox, String buttonText, int boundX,
                                     int boundY, int boundWidth, int boundHeight) {
        button = new JButton(buttonText);
        button.setBounds(boundX,boundY,boundWidth,boundHeight);
        dialogBox.add(button);
    }

    public void changeShape(Button button){

    }
}
