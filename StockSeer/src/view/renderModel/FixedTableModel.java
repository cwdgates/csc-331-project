package view.renderModel;

import javax.swing.table.DefaultTableModel;

/**
 * prevent columns from being dragged
 */
public abstract class FixedTableModel extends DefaultTableModel {
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
