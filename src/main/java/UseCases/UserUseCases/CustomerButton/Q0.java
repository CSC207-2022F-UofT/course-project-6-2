package UseCases.UserUseCases.CustomerButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q0 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        JButton source = (JButton)e.getSource();
        JOptionPane.showMessageDialog(source, "Register on our app for the flexibility to sell one item or thousands.\n" +
                "Fulfill orders quickly when customers make a purchase.");
    }
}
