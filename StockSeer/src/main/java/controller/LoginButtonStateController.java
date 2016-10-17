package controller;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginButtonStateController implements DocumentListener {
	JButton button;

	public LoginButtonStateController(JButton button) {
		this.button = button;
	}

	/**
	 * enable the button if the document length is positive
	 * 
	 * @param event
	 */
	public void disableIfEmpty(DocumentEvent event) {
		button.setEnabled(event.getDocument().getLength() > 0);
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		disableIfEmpty(arg0);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		disableIfEmpty(arg0);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		disableIfEmpty(arg0);
	}
}
