package UseCases.UserUseCases.CustomerButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q5 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        JButton source = (JButton)e.getSource();
        JOptionPane.showMessageDialog(source, "Some products may not be listed as a matter of " +
                "compliance with legal or regulatory restrictions (for example, prescription drugs). ");
    }
}
