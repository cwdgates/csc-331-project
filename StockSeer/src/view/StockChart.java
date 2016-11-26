package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StockChart {
    
    private static class ImagePanel extends JPanel {
        public void paint(Graphics g) {
            try {
                URL url = new URL("http://chart.finance.yahoo.com/z?s=AAPL&t=7d&q=l&l=on&z=s&p=m50,m200.jpg");
                BufferedImage image = ImageIO.read(url);
                Toolkit t = Toolkit.getDefaultToolkit();
                g.drawImage(image, 0, 0, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
    private JFrame frame;
    
    /**
     * Launch the application.
     */
    public static void show() {
        EventQueue.invokeLater(new Thread() {
            public void run() {
                try {
                    StockChart window = new StockChart();
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
    public StockChart() {
        initialize();
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        try {
            URL url = new URL("http://stockcharts.com/c-sc/sc?s=%24TSX&p=W&b=5&g=0&i=t21568592423&r=1480119106271.jpg");
            BufferedImage image = ImageIO.read(url);
            JLabel picLabel = new JLabel(new ImageIcon(image));
            panel.add(picLabel);
        } catch (Exception e) {
            
        }
        
        frame.getContentPane().add(panel);
    }
    
}
