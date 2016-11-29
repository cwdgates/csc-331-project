package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StockChartPane {
    private String stockSymbol;
    
    private JFrame frame;
    
    /**
     * Launch the application.
     */
    public static void show(String stockSymbol) {
        EventQueue.invokeLater(new Thread() {
            public void run() {
                try {
                    StockChartPane window = new StockChartPane(stockSymbol);
                    window.frame.pack();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the application.
     */
    public StockChartPane(String stockSymbol) {
        this.stockSymbol = stockSymbol;
        initialize();
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame(stockSymbol);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        try {
            URL url = new URL("http://stockcharts.com/c-sc/sc?s=" + stockSymbol +
                    "&p=D&yr=0&mn=3&dy=0&i=t68318560406&.jpg");
            BufferedImage image = ImageIO.read(url);
            JLabel picLabel = new JLabel(new ImageIcon(image));
            panel.add(picLabel);
        } catch (Exception e) {
            
        }
        
        frame.getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
        
        JButton btnClose = new JButton("Close");
        panel_1.add(btnClose);
        btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
    }
}
