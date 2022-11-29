package screens;

import entities.Drink;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class SearchingTableModel extends DefaultTableModel {

    static Vector<String> headers = new Vector<>();
    static {
        headers.add("Name");
        headers.add("Price");
        headers.add("Description");
        headers.add("Ingredient");
        headers.add("Volume");
        headers.add("Production Date");
        headers.add("Expiration Date");
        headers.add("Discount");
        headers.add("Store Name");
    }
    private SearchingTableModel(){
        super(null,headers);
    }
    private static SearchingTableModel searchingTableModel = new SearchingTableModel();
    public static SearchingTableModel assembleModel(Vector<Vector< Drink >> data){
        searchingTableModel.setDataVector(data,headers);
        return searchingTableModel;
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}


