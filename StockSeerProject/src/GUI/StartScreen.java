package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StartScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
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
	public StartScreen() {
		initialize();
		createEvent();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnSinglePlayer = new JButton("Single Player");
		
		JButton btnMultiplayer = new JButton("Multiplayer");
		
		JButton btnTutorial = new JButton("Tutorial");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSinglePlayer)
						.addComponent(btnMultiplayer)
						.addComponent(btnTutorial))
					.addContainerGap(323, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSinglePlayer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMultiplayer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTutorial)
					.addContainerGap(159, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	

	private void createEvent() {
		
	}
}
