package model;

import javax.swing.table.DefaultTableModel;

public abstract class FixedTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
