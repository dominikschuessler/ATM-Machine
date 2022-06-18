package test;

import controller.Controller;
import view.ViewControlButtons;

public class ControlButtonsTest {

	public static void main(String[] args) {
		TestFrame frame = new TestFrame("Controlbuttons Test");
		Controller controller = new Controller(null);
		ViewControlButtons controlbuttons = new ViewControlButtons(controller);
		
		frame.addComp(controlbuttons.getControlButtons());
	}

}
