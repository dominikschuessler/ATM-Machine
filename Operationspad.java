import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;

public class Operationspad {
	JButton bestaetigung;
	JButton korrektur;
	JButton hilfe;
	JButton abbruch;
	
	Container alleTasten;
	
	public Operationspad() {
		bestaetigung = new JButton("Bestaetigung");
		korrektur = new JButton("Korrektur");
		hilfe = new JButton("Hilfe");
		abbruch = new JButton("Abbruch");
		alleTasten = new Container();
				
		alleTasten.setLayout(new GridLayout(4,1));
		
		addToContainer();
		setFarben();
	}
	
	public Container getOperationspad() {
		return alleTasten;
	}
	
	private void addToContainer() {
		alleTasten.add(bestaetigung);
		alleTasten.add(korrektur);
		alleTasten.add(hilfe);
		alleTasten.add(abbruch);
	}
	
	private void setFarben() {
		bestaetigung.setBackground(Color.GREEN);
		korrektur.setBackground(Color.yellow);
		hilfe.setBackground(Color.BLUE);
		abbruch.setBackground(Color.RED);
		
		hilfe.setForeground(Color.WHITE);
		abbruch.setForeground(Color.WHITE);
	}
}
