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
        
        JFrame frame = new JFrame();
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
    

    
    public static void main(String[] args) {
//        ImagePanel canvas = new ImagePanel();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        try {
            URL url = new URL("http://stockcharts.com/c-sc/sc?s=%24TSX&p=W&b=5&g=0&i=t21568592423&r=1480119106271.jpg");
            BufferedImage image = ImageIO.read(url);
            JLabel picLabel = new JLabel(new ImageIcon(image));
            panel.add(picLabel);
        } catch (Exception e){
            
        }
    
        frame.getContentPane().add(panel);
        
//        frame.add(canvas);
//        frame.setSize(400, 400);
        frame.pack();
        frame.setVisible(true);
    }
}
