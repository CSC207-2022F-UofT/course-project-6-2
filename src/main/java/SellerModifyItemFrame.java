import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SellerModifyItemFrame extends JFrame{
    private JTextField MFDrinkName;
    private JTextField MFStoreName;
    private JTextField MFPrice;
    private JTextField MFDescription;
    private JPanel ModifyFrame;
    private JTextField MFIngredient;
    private JTextField MFVolume;
    private JTextField MFProductionDateYear;
    private JTextField MFExpirationDateYear;
    private JTextField MFDiscount;
    private JButton saveButton;
    private JTextField MFProductionDateDay;
    private JTextField MFExpirationDateMonth;
    private JTextField MFExpirationDateDay;
    private JButton cancelButton;
    private JTextField MFProductionDateMonth;

    public SellerModifyItemFrame(){
        setContentPane(ModifyFrame);
        setTitle("Modify the Information of Drink");
        setSize(400, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String StoreName = MFStoreName.getText();
                String DrinkName = MFDrinkName.getText();
                float price = Float.parseFloat(MFPrice.getText());
                String description = MFDescription.getText();
                String ingredient = MFIngredient.getText();
                int volume = Integer.parseInt(MFVolume.getText());



            }
        });
    }

    public static void main(String[] args) {
        SellerModifyItemFrame newFrame = new SellerModifyItemFrame();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
