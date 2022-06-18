package test;

import controller.Controller;
import view.ViewLoginPanel;

public class ViewLoginPanelTest {

	public static void main(String[] args) {

		TestFrame frame= new TestFrame("LoginPanel Test");
		Controller controller = new Controller(null);
		ViewLoginPanel loginPanel = new ViewLoginPanel(controller);
		
		frame.addComp(loginPanel.getLoginPanel());
	}

}
