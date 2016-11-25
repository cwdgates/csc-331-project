package view;

import javax.swing.*;

import view.renderModel.AvailableStockModel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class ChooseStockPane extends JPanel {
    static public final String BTN_REROLL = "Reroll";
    static public final String BTN_ACCEPT = "Accept";
    private AvailableStockModel availStockModel;
    private DefaultListModel addedStockModel;
    private JTable table;
    private JButton btnReroll;
    private JButton btnAccept;
    
    /**
     * Create the panel.
     */
    private ChooseStockPane() {
        setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable(new AvailableStockModel());
        scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false); // disable column reordering
        
        JPanel panelControl = new JPanel();
        add(panelControl, BorderLayout.SOUTH);
        
        btnReroll = new JButton("Reroll");
        panelControl.add(btnReroll);
        
        btnAccept = new JButton("Accept");
        panelControl.add(btnAccept);
        
        JScrollPane scrollPaneDirection = new JScrollPane();
        add(scrollPaneDirection, BorderLayout.NORTH);
        
        JTextPane txtpnDirection = new JTextPane();
        txtpnDirection.setText("Click reroll to choose different stocks");
        txtpnDirection.setToolTipText("");
        txtpnDirection.setEditable(false);
        scrollPaneDirection.setViewportView(txtpnDirection);
        
    }
    
    public void setAvailStockModel(AvailableStockModel availStockModel) {
        table.setModel(availStockModel);
    }
    
    public void registerController(ActionListener controller) {
        btnAccept.addActionListener(controller);
        btnReroll.addActionListener(controller);
    }
    
    public void registerContainer(JFrame frame) {
        btnAccept.addActionListener(e -> frame.setVisible(false));
    }
    
    /**
     * @return ChooseStockPane
     */
    public static ChooseStockPane showChooseStockPane() {
        ChooseStockPane pane = new ChooseStockPane();
        
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pane.registerContainer(frame);
        frame.setVisible(true);
        return pane;
    }
}
