package UI;
import javax.swing.*;

public class ScrollPane {

    public void createScrollPane(JFrame frame) {

        JScrollPane scrollableArea = new JScrollPane(frame);
        scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollableArea);
    }
}
