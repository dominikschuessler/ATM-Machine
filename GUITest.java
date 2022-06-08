import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class GUITest {

	public static void main(String[] args) {
		LoginGUI login = new LoginGUI();
		GUIBuilder tasten = new GUIBuilder();
		JFrame meineGUI = new JFrame();
		
		Container container = meineGUI.getContentPane();
		
		meineGUI.getContentPane().setLayout(new GridLayout(2,1, 10, 10));

		meineGUI.setSize(400, 400);
		meineGUI.setLocationRelativeTo(null);
		meineGUI.setVisible(true);
		
		container.add(login.getLoginGUI());
		container.add(tasten.);
	
	}

}
