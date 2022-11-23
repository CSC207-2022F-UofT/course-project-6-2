package UseCases.UserUseCases.CustomerButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q4 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        JButton source = (JButton)e.getSource();
        JOptionPane.showMessageDialog(source, "Shipping fees depend on whether you plan to fulfill orders yourself." +
                " Generally speaking: Air express > Air freight > sea freight ");
    }
}

