package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import view.renderModel.AvailableStockModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ChooseStockPane extends JPanel {
    static public final String BTN_REROLL = "Reroll";
    static public final String BTN_ACCEPT = "Accept";
    static public final String BTN_STOCK_INFO = "Stock info...";
    private AvailableStockModel availStockModel;
    private DefaultListModel addedStockModel;
    private JTable table;
    private JButton btnReroll;
    private JButton btnAccept;
    private JButton btnStockInfo;
    
    /**
     * Create the panel.
     */
    private ChooseStockPane() {
        setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable(new AvailableStockModel());
        scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false);
        
        JPanel panelControl = new JPanel();
        add(panelControl, BorderLayout.SOUTH);
        panelControl.setLayout(new BoxLayout(panelControl, BoxLayout.X_AXIS));
        
        btnStockInfo = new JButton(BTN_STOCK_INFO);
        panelControl.add(btnStockInfo);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        panelControl.add(horizontalGlue);
        
        btnReroll = new JButton("Reroll");
        panelControl.add(btnReroll);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        panelControl.add(horizontalStrut);
        
        btnAccept = new JButton("Accept");
        panelControl.add(btnAccept);
        btnAccept.setEnabled(false);
        
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
        btnStockInfo.addActionListener(controller);
    }
    
    public void registerContainer(JFrame frame) {
        btnAccept.addActionListener(e -> frame.setVisible(false));
    }
    
    /**
     * @return ChooseStockPane
     */
    public static ChooseStockPane showChooseStockPane() {
        ChooseStockPane pane = new ChooseStockPane();
        
        JFrame frame = new JFrame("Choose Stocks");
        frame.getContentPane().add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pane.registerContainer(frame);
        frame.setVisible(true);
        return pane;
    }
    
    public void setBtnAcceptEnabled(boolean isEnabled) {
        btnAccept.setEnabled(isEnabled);
    }
    
    public String getSelectedStock(){
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            return (String) table.getValueAt(selectedRow, 0);
        }
        return null;
    }
}
