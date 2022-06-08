import java.awt.Container;
import java.awt.GridLayout;

/**
 * Container fuer alle Teile des Automaten, mit denen interagiert werden kann.
 * 
 * @author Dominik Schuessler
 *
 */
public class InteractionPanel {
	Numpad zahlenfeld;
	Operationspad aktionsfeld;
	
	Container container;

	public InteractionPanel() {
		zahlenfeld = new Numpad();
		aktionsfeld = new Operationspad();
		
		container = new Container();
		
		container.setLayout(new GridLayout(1, 2));

		container.add(zahlenfeld.getNumpad());
		container.add(aktionsfeld.getOperationspad());
	}
	
	public Container getInteractionpanel() {
		return container;
	}
}
