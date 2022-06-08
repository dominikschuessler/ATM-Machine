import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * @author Dominik Schuessler
 *
 */
public class GUIBuilder {
	InteractionPanel interactionPanel;
	LoginGUI loginGUI;

	JFrame gui;
	Container container;

	public GUIBuilder() {
		interactionPanel = new InteractionPanel();
		loginGUI = new LoginGUI();
	}
	
	public void initFrame() {
		gui = new JFrame();
		
		container = gui.getContentPane();
		container.setLayout(new GridLayout(2, 1, 1, 10));

		gui.setSize(400, 400);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
		
		gui.add(loginGUI.getLoginGUI());
		gui.add(interactionPanel.getInteractionpanel());
	}

}
