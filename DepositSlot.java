
/**
 * Die Klasse {@code Deposit Slot} stellt die Geldeinzahloeffnung dar.
 * 
 * @author Dominik Schuessler
 */
public class DepositSlot {

	/**
	 * Die Methode stellt fest, ob eine Geldeinzahlung vom Automaten angenommen
	 * wurde.
	 * 
	 * Da der Automat nur eine Software Simulation ist, gibt die Methode immer
	 * {@code True} zurück.
	 * 
	 * @return True
	 */
	public boolean isEnvelopeReceived() {
		return true; // Geldbündel wurde erhalten
	}

}
