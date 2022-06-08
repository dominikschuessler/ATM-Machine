import javax.swing.JFrame;
import javax.swing.JPanel;

public class OperationspadTest {

	
	public static void main(String[] args) {
		JFrame meinOperationspanel = new JFrame();
		
		meinOperationspanel.setSize(400, 400);
		meinOperationspanel.setLocationRelativeTo(null);
		meinOperationspanel.setVisible(true);
		
		Operationspad einFeldKlickMich = new Operationspad();
		
		meinOperationspanel.add(einFeldKlickMich.getOperationspad());
	}
}
