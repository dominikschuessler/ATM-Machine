package view;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.Controller;

/**
 * Die Klasse modelliert das Login Fenster und stellt entsprechende Methoden zur
 * Manipulation der eingegeben Texte bereit.
 * 
 * @author Dominik Schuessler
 *
 */
public class ViewLoginPanel {
	private Controller controller;
	private JTextField inputfieldAccountNumber;
	private JPasswordField inputfieldPIN;

	private JLabel userInstructionAccountnumer;
	private JLabel userInstructionPIN;

	private Container loginPanel;

	public ViewLoginPanel(Controller controller) {
		this.controller = controller;
		build();
	}

	public void build() {
		inputfieldAccountNumber = new JTextField();
		inputfieldAccountNumber.setFocusable(true);
		inputfieldAccountNumber.requestFocus();
		inputfieldPIN = new JPasswordField();

		userInstructionAccountnumer = new JLabel("Kontonummer");
		userInstructionPIN = new JLabel("PIN");

		loginPanel = new Container();
		loginPanel.setLayout(new GridLayout(4, 1));

		loginPanel.add(userInstructionAccountnumer);
		loginPanel.add(inputfieldAccountNumber);
		loginPanel.add(userInstructionPIN);
		loginPanel.add(inputfieldPIN);
	}

	public Container getLoginPanel() {
		return this.loginPanel;
	}

	public String getInputfieldAccountNumber() {
		return inputfieldAccountNumber.getText();
	}

	public void setInputfieldAccountNumber(String input) {
		this.inputfieldAccountNumber.setText(input);
	}

	public String getInputfieldPIN() {
		return String.valueOf(inputfieldPIN.getPassword());
	}

	public void setInputfieldPIN(String input) {
		this.inputfieldPIN.setText(input);
	}

	public void clearAll() {
		clearAccountnumber();
		clearPIN();
	}

	public void clearAccountnumber() {
		setInputfieldAccountNumber("");
	}

	public void clearPIN() {
		setInputfieldPIN("");
	}
}
