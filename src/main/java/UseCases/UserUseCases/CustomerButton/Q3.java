package UseCases.UserUseCases.CustomerButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q3 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        JButton sourse = (JButton)e.getSource();
        JOptionPane.showMessageDialog(sourse, "Once you place an order on the website, " +
                "you'll find the record from Get Order Status shortly");
    }
}
