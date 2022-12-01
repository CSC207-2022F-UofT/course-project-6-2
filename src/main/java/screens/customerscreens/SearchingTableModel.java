package screens.customerscreens;

import entities.Drink;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class SearchingTableModel extends DefaultTableModel {
    private Vector<Vector<Drink>> data;
    static Vector<String> headers = new Vector<>();
    static {
        headers.add("Drink Name");
        headers.add("Store Name");
        headers.add("Price");
        headers.add("Volume");
    }
    private SearchingTableModel(){
        super(null,headers);
    }
    private static final SearchingTableModel searchingTableModel = new SearchingTableModel();
    public static SearchingTableModel assembleModel(Vector<Vector<Drink>> data){
        searchingTableModel.setDataVector(data, headers);
        return searchingTableModel;
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}


