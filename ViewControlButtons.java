package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import controller.Controller;

/**
 * Diese Klasse stellt die ControlButtons bereit. Diese umfassen folgende
 * Buttons:
 * <ul>
 * <li>Bestaetigung
 * <li>Korrektur
 * <li>Hilfe
 * <li>Abbruch
 * </ul>
 * 
 * Die Buttons sind farblich voneinander unterschieden. Durch einer Verbindung
 * zum {@code Controller} kann fuer jeden Button dort eine spezifische
 * Funktionalitaet implementiert werden.<br>
 * Zur Einbindung des Views in das anzuzeigende Fenster, kann dieser als
 * Container mittels {@code getControlButtons()} uebergeben werden.
 * 
 * @author Dominik Schuessler
 *
 */
public class ViewControlButtons {
	private Controller controller;
	private Container controlButtons;

	private JButton submitButton;
	private JButton correctButton;
	private JButton helpButton;
	private JButton cancelButton;

	private static final Color COLOR_BESTAETIGUNG = Color.GREEN;
	private static final Color COLOR_KORREKTUR = Color.YELLOW;
	private static final Color COLOR_HILFE = Color.BLUE;
	private static final Color COLOR_ABBRUCH = Color.RED;
	private static final Color COLOR_FONT_WHITE = Color.WHITE;

	public ViewControlButtons(Controller controller) {
		this.controller = controller;
		build();
	}

	private void build() {
		submitButton = new JButton("Bestaetigung");
		submitButton.setBackground(COLOR_BESTAETIGUNG);
		submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.doSubmit();
			}
		});

		correctButton = new JButton("Korrektur");
		correctButton.setBackground(COLOR_KORREKTUR);
		correctButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.doCorrect();
			}
		});

		helpButton = new JButton("Hilfe");
		helpButton.setBackground(COLOR_HILFE);
		helpButton.setForeground(COLOR_FONT_WHITE);
		helpButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.doHelp();
			}
		});

		cancelButton = new JButton("Abbruch");
		cancelButton.setBackground(COLOR_ABBRUCH);
		cancelButton.setForeground(COLOR_FONT_WHITE);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.doCancel();
			}
		});

		controlButtons = new Container();

		controlButtons.setLayout(new GridLayout(4, 1));

		controlButtons.add(submitButton);
		controlButtons.add(correctButton);
		controlButtons.add(helpButton);
		controlButtons.add(cancelButton);

	}

	public Container getControlButtons() {
		return controlButtons;
	}

}
