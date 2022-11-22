package Screens;
import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JFrame{

    public void createScrollPane(JFrame frame, JPanel panel) {

        JScrollPane scrollablePanel = new JScrollPane(panel);

        scrollablePanel.setPreferredSize(new Dimension(780,560));
        scrollablePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollablePanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panel.setPreferredSize(new Dimension(800,600));

        frame.getContentPane().add(scrollablePanel);
    }
}
