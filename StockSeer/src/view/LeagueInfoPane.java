package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aqv on 11/25/2016.
 */
public class LeagueInfoPane {
    private JFrame frame;
    private String leagueName;
    
    /**
     * @param leagueName
     */
    public static void show(String leagueName) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LeagueInfoPane window = new LeagueInfoPane(leagueName);
                    window.frame.pack();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private LeagueInfoPane(String leagueName) {
        this.leagueName = leagueName;
        initialize();
    }
    
    private void initialize() {
        frame = new JFrame(leagueName);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.getContentPane().add(textArea, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> frame.dispose());
        panel.add(btnClose);
    }
}
