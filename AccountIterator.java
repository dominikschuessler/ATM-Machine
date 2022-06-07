import java.util.ArrayList;
import java.util.List;

import javax.swing.undo.CannotRedoException;

/**
 * Die Klasse {@code AccountIterator} speichert Accountobjekte dynamisch in
 * einer ArrayListe, welche durch diverse Methoden manipulierbar waere. Die
 * ArrayListe ist im Gegensatz zu einem Array dynamisch erweiterbar und
 * verkuerzbar; Die ArrayList ist eine veraenderbare Implementierung des
 * {@code List} Interfaces, dieses definiert lediglich abfragende Methoden, die
 * Existenz eines Objektes zurueckgeben bzw. das Objekt selbst.
 * 
 * @author Annalena Maier
 * @author Dominik Schuessler
 * @see Iterator
 * @see List
 */
public class AccountIterator implements Iterator {
	/**
	 * Die Arrayliste {@code accounts} speichert dynamisch keinen, einen oder
	 * mehrere Accounts.
	 */
	ArrayList<Account> accounts;

	/**
	 * Der Konstruktor initalisiert die Instanzvariable {@code accounts}
	 * 
	 * @param accounts2 Eine bereits vorhandene Arrayliste
	 */
	public AccountIterator(ArrayList<Account> accounts2) {
		this.accounts = accounts2;
	}

	/**
	 * 
	 * Gibt zu einer gegebenen Position zurueck, ob es einen Nachfolger gibt.
	 * 
	 * @param position Index, der auf Nachfolger ueberprueft werden soll
	 * @return {@code true} wenn ein Nachfolger im Array exisitiert.
	 * 
	 */
	@Override
	public boolean hasNext(int position) {
		if (position >= accounts.size()) {
			return false;
		} else {
			return true;
		}
	}

	// AENDERUNGSVORSCHLAG: Die Methode next() gibt das Objekt an der gegebenen Stelle
	// zurueck; irrefuehrender Bezeichner!
	/**
	 * Gibt ein Objekt der Klasse {@code Account} an einer bestimmten Stelle
	 * zurueck.
	 * 
	 * @param position Ein bestimmter {@code ArrayList}-Index
	 * @return {@code Account} Objekt an der Stelle {@code position}
	 */
	@Override
	public Object next(int position) {
		Account AccountItem = accounts.get(position);
		return AccountItem;
		// evtl.: return accounts.get(position)
	}

	/**
	 * Gibt zurueck, ob es vor einem bestimmten Indexwert in der {@code ArrayList}
	 * noch einen weiteren Eintrag gibt.
	 * 
	 * @param position Indexwert, vor dem geprueft werden soll
	 * @return {@code true}, wenn es vor dem Eintrag noch einen weiteren Eintrag
	 *         gibt.
	 */
	@Override
	public boolean hasPrev(int position) {
		if (position == 0)
			return false;
		else
			return true;
	}

}
