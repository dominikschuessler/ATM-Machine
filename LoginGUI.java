import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI {
	
	private JTextField inputfieldAccountNumber;
	private JPasswordField inputfieldPIN;
	
	private JLabel userInstructionAccountnumer;
	private JLabel userInstructionPIN;
	
	private Container container;
	
	public LoginGUI() {
		
		inputfieldAccountNumber = new JTextField();
		inputfieldPIN = new JPasswordField();
		
		userInstructionAccountnumer = new JLabel("Kontonummer");
		userInstructionPIN = new JLabel("PIN");
		
		container = new Container();
		
		container.setLayout(new GridLayout(4,1, 1, 10));
		
		container.add(userInstructionAccountnumer);
		container.add(inputfieldAccountNumber);
		container.add(userInstructionPIN);
		container.add(inputfieldPIN);
		
	}

	public Container getLoginGUI() {
		return container;
	}
	
}
