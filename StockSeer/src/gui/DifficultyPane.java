package gui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;

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

		Component verticalGlue = Box.createVerticalGlue();
		add(verticalGlue);

		JPanel panel = new JPanel();
		add(panel);

		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		btnGrpDifficulty.add(rdbtnEasy);
		panel.add(rdbtnEasy);

		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		btnGrpDifficulty.add(rdbtnMedium);
		panel.add(rdbtnMedium);

		JRadioButton rdbtnHard = new JRadioButton("Hard");
		btnGrpDifficulty.add(rdbtnHard);
		panel.add(rdbtnHard);

		JRadioButton rdbtnAreYouNut = new JRadioButton("Are you nut?");
		btnGrpDifficulty.add(rdbtnAreYouNut);
		panel.add(rdbtnAreYouNut);

		JPanel panel_1 = new JPanel();
		add(panel_1);

		JButton btnChoose = new JButton("Choose");
		panel_1.add(btnChoose);

	}

}
