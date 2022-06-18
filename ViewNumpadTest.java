package test;

import javax.swing.JFrame;

import controller.Controller;
import view.ViewNumpad;

public class ViewNumpadTest {
	JFrame frame;
	public static void main(String[] args) {
		TestFrame frame = new TestFrame("Numpad Test");
		
		Controller controller = new Controller(null);
		ViewNumpad numpad = new ViewNumpad(controller);
		
		frame.addComp(numpad.getNumpad());
	}

}
