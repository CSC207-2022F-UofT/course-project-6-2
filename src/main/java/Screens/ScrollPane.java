package Screens;
import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JFrame{

    JScrollPane scrollPane;

    public JScrollPane getScrollPane(){
        return scrollPane;
    }
    public void createScrollPane(JFrame frame, JPanel panel) {

        scrollPane.setPreferredSize(new Dimension(780,560));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panel.setPreferredSize(new Dimension(800,600));

        frame.getContentPane().add(scrollPane);
    }
}
