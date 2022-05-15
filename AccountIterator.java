import java.util.ArrayList;

import javax.swing.undo.CannotRedoException;

//Diese Klasse ist verantwortlich für das Iterator-Entwurfsmuster



/**
 * 
 * Die Klasse {@code AccountIterator} implementiert Methoden, die den Index einer gegebenen {@code ArrayListe} betreffen.
 * 
 * @author Annalena Maier
 * @author Dominik Schuessler
 * @see Iterator
 */

public class AccountIterator implements Iterator {
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
	 * Gibt zurueck, ob die {@code ArrayList accounts} einen bestimmen Index hat.
	 * 
	 * @param Der Index, von dem erfragt werden soll, ob er existiert.
	 * @return {@code true} wenn der Indexplatz existiert.
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
