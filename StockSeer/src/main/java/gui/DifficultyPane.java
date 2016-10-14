package gui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Choose difficulty before going to Create League Pane
 * 
 * @author anvu
 *
 */
public class DifficultyPane extends JPanel {
	private final ButtonGroup btnGrpDifficulty = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public DifficultyPane() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblChooseDifficultyLevel = new JLabel("Choose difficulty level for your league");
		panel.add(lblChooseDifficultyLevel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
				JRadioButton rdbtnEasy = new JRadioButton("Easy");
				panel_2.add(rdbtnEasy);
				btnGrpDifficulty.add(rdbtnEasy);
				
						JRadioButton rdbtnMedium = new JRadioButton("Medium");
						panel_2.add(rdbtnMedium);
						btnGrpDifficulty.add(rdbtnMedium);
						
								JRadioButton rdbtnHard = new JRadioButton("Hard");
								panel_2.add(rdbtnHard);
								btnGrpDifficulty.add(rdbtnHard);
								
										JRadioButton rdbtnAreYouNut = new JRadioButton("Are you nut?");
										panel_2.add(rdbtnAreYouNut);
										btnGrpDifficulty.add(rdbtnAreYouNut);

		JPanel panel_1 = new JPanel();
		add(panel_1);

		JButton btnChoose = new JButton("Choose");
		panel_1.add(btnChoose);
		
	}
}
