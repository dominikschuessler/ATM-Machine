import javax.swing.text.Position;

/**
 * 
 * Dieses Interface definiert Methoden zum Umgang mit Objekten, ueber die iteriert werden kann.
 * 
 * @see AccountIterator
 * @author Annalena Maier
 * @author Dominik Schuessler
 * */
public interface Iterator {
	
	/**
	 * Ueberprueft, ob ein Index eines iterrierbaren Objektes einen Nachfolger hat.
	 * @param position Indexwert, der auf einen Nachfolger ueberprueft werden soll
	 * @return {@code true}, wenn es einen Nachfolger gibt.
	 */
	boolean hasNext(int position);

	/**
	 * Gibt das Objekt an einer bestimmten Stelle zurueck.
	 * @param position bestimmte Stelle
	 * @return Objekt an Stelle {@code position}
	 */
	Object next(int position);

	/**
	 * Ueberprueft, ob ein Index eines iterrierbaren Objektes einen Vorgaenger hat.
	 * @param position Indexwert, der auf ein Vorgaenger ueberprueft werden soll.
	 * @return {@code true}, wenn es einen Vorgaenger gibt.
	 */
	boolean hasPrev(int position);

}
