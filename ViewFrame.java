package view;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import controller.Controller;

/**
 * Die Klasse {@code ViewFrame} ist fuer die Erzeugung des Fensters zustaendig
 * und verwaltet alle Komponenten, die darauf angezeigt werden.</p>
 * 
 * Außerdem werden alle noetigen Parameter des Fensters gesetzt.
 * 
 * @author Dominik Schuessler
 *
 */
public class ViewFrame extends JFrame {

	private Controller controller;
	private ViewControlButtons controlButtons;
	private ViewNumpad numpad;
	private ViewLoginPanel loginPanel;
	private Container container;
	private Container buttons;

	public ViewFrame(Controller controller) {
		this.controller = controller;
		build();
	}

	public void build() {
		setTitle(controller.getText());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = getContentPane();

		numpad = new ViewNumpad(controller);
		controlButtons = new ViewControlButtons(controller);
		loginPanel = new ViewLoginPanel(controller);

		container = new Container();
		container.setLayout(new GridLayout(2, 1));
		container.add(loginPanel.getLoginPanel());

		buttons = new Container();
		buttons.setLayout(new GridLayout(1, 2));
		buttons.add(numpad.getNumpad());
		buttons.add(controlButtons.getControlButtons());

		container.add(buttons);

	}

	public ViewControlButtons getControlButtons() {
		return controlButtons;
	}

	public ViewLoginPanel getLoginPanel() {
		return loginPanel;
	}

	public ViewNumpad getNumpad() {
		return numpad;
	}

	public void getView() {
		System.out.println("Create View");
		add(container);
	}

}
