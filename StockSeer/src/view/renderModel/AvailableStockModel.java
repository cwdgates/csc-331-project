package view.renderModel;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import java.util.Arrays;
import java.util.Vector;

public class AvailableStockModel extends FixedTableModel {
    public static String[] columnNames = {"Symbol", "Name", ""};
    private static Vector<String> columnIdentifiers = new Vector<>();
    
    static {
        columnIdentifiers.addAll(Arrays.asList(columnNames));
    }
    
    public AvailableStockModel() {
        this.setColumnIdentifiers(columnIdentifiers);
    }
    
    public void setData(String[] stocks) {
        Vector<Vector<String>> data = new Vector<>();
        for (String stock : stocks) {
            Vector<String> temp = new Vector<>();
            temp.add(stock);
            data.add(temp);
        }
        this.setDataVector(data, columnIdentifiers);
    }
    
}
