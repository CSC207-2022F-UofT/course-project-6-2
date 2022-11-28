package UseCases;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Use case layer

/**
 * Detects when the close window button is clicked
 */
public class DetectWindowClose {
    public DetectWindowClose(JFrame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosed");
                System.exit(0);
            }
        });
    }
}
