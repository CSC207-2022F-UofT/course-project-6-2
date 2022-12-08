package screens.customerscreens;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * The searching table model is used to set up the headers and data in the jtable for the searched drink.
 */
public class SearchingTableModel extends DefaultTableModel {
    private static final Vector<String> headers = new Vector<>();
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
    public static SearchingTableModel assembleModel(Vector<Vector<String>> data){
        searchingTableModel.setDataVector(data, headers);
        return searchingTableModel;
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}


