package UseCases.UserUseCases.CustomerButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NeedMoreHelp implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        JButton sourse = (JButton)e.getSource();
        JOptionPane.showMessageDialog(sourse, "Further concerns please contact our " +
                "customer support. Phone: 416-978-3384." + " Email: ask.6+2@utoronto.ca");
    }
}
