import javax.swing.*;

public class SellerModifyItemFrame extends JFrame{
    private JTextField MFDrinkName;
    private JTextField MFStoreName;
    private JTextField MFPrice;
    private JTextField MFDescription;
    private JPanel ModifyFrame;
    private JTextField MFIngredient;
    private JTextField MFVolume;
    private JTextField MFProductionDate;
    private JTextField MFExpirationDate;
    private JTextField MFDiscount;
    private JButton saveButton;
    private JButton cancelButton;

    public SellerModifyItemFrame(){
        setContentPane(ModifyFrame);
        setTitle("Modify the Information of Drink");
        setSize(400, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SellerModifyItemFrame newFrame = new SellerModifyItemFrame();
    }
}
