package test;

import controller.Controller;
import view.ViewFrame;

public class FrameTest {

	public static void main(String[] args) {
		Controller controller = new Controller(null);
		ViewFrame frame = new ViewFrame(controller);
		
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.getView();
	}

}
