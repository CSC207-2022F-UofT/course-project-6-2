package screen;
import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JFrame{

    public void createScrollPane(JFrame frame, JPanel panel) {

        // set flow layout for the frame
        frame.getContentPane().setLayout(new FlowLayout());

        JScrollPane scrollablePanel = new JScrollPane(panel);

        scrollablePanel.setPreferredSize(new Dimension(780,580));
        scrollablePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel.setPreferredSize(new Dimension(800,600));

        frame.getContentPane().add(scrollablePanel);
    }
}
