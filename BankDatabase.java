import java.util.ArrayList;

// BankDatabase.java

/**
 * Die Klasse {@code BankDatabase} stellt die Datenbank fuer
 * Bankkontoinformationen dar.
 * 
 * @author Kerstin Huebner
 * @author Annalena Maier
 */

public class BankDatabase

{
	/**
	 * Die Arrayliste {@code accounts} vereinfacht, im Gegensatz zu einem Array, das
	 * Hinzufuegen/Loeschen in der Datenbank.
	 */
	static ArrayList<Account> accounts = new ArrayList<Account>();

	// War hier mal ein Array?

	/**
	 * Der parameterlose Konstruktor initialisiert Bankkonten.
	 */
	public BankDatabase() {
		Account accounts1 = new Account("Customer1", 12345, 11111, 1000.0, 1200.0, 0);
		Account accounts2 = new Account("Customer2", 98765, 22222, 200.0, 200.0, 0);
		Account accounts3 = new Account("Customer3", 19234, 33333, 200.0, 200.0, 0);
		Account accounts4 = new Account("Manager1", 99999, 00000, 0, 0, 1);
		accounts.add(accounts1);
		accounts.add(accounts2);
		accounts.add(accounts3);
		accounts.add(accounts4);
	} // ende no-argument BankDatabase constructor

	/**
	 * Die Methode {@code getAccount} ruft ein bestimmtes Konto ab, indem sie durch
	 * die {@code accounts} geht, um die uebereinstimmende Kontonummer zu finden.
	 * 
	 * @return {@code currentAccount} wenn eine uebereinstimmung gefunden wurde.
	 * 
	 * @param accountnumber Kontonummer
	 */
	public Account getAccount(int accountnumber) {

		for (Account currentAccount : accounts) {
			if (currentAccount.getAccountNumber() == accountnumber)
				return currentAccount;
		} // end for

		return null;
	} // ende methode getAccount

	/**
	 * Die Methode {@code getAccountpin} geht durch die {@code accounts} um die
	 * uebereinstimmende Kontonummer zu finden.
	 * 
	 * @return {@code currentAccount} wenn eine uebereinstimmung gefunden wurde.
	 * @param PIN PIN
	 */
	private Account getAccountpin(int PIN) {

		for (Account currentAccount : accounts) {

			if (currentAccount.GetPin() == PIN)
				return currentAccount;
		} // end for

		return null;
	} // ent method getAccount

	/**
	 * Die Methode {@code authenticateUser} stellt fest, ob ob die vom Benutzer
	 * angegebene Kontonummer und PIN, mit Werten aus der Datenbank,
	 * uebereinstimmen.
	 * 
	 * @return {@code true} bei Uebereinstimmung gefunden wird.
	 * @param userPIN Benutzer PIN
	 */
	public boolean authenticateUser(int userPIN) {
		Account userAccount = getAccountpin(userPIN);

		if (userAccount != null)
			return userAccount.validatePIN(userPIN);
		else
			return false;
	} // ende methode authenticateUser

	/**
	 * Die Methode {@code getAvailableBalance} fragt den Kontostand des Kontos mit
	 * der angegebenen Kontonummer ab.
	 * 
	 * @param userAccountNumber Kontonummer des Benutzers
	 * @return aktuell verfuegbare Geldmittel
	 */
	public double getAvailableBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getAvailableBalance();
	} // ende methode getAvailableBalance

	/**
	 * Die Methode {@code getTotalBalance} fragt das Gesamtsaldo des Kontos Konto
	 * mit der angegebenen Kontonummer ab.
	 * 
	 * @param userAccountNumber Kontonummer des Benutzers
	 * @return verfuegbare Geldmittel + ausstehende Einzahlung
	 */
	public double getTotalBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getTotalBalance();
	} // ende methode getTotalBalance

	/**
	 * Die Methode {@code credit} schreibt einen Betrag auf das Konto mit der
	 * angegebenen Kontonummer gut.
	 * 
	 * @param userAccountNumber
	 * @param amount            Geldbetrag, der gutgeschrieben werden soll
	 */
	public void credit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).credit(amount);
	} // ende methode credit

	/**
	 * Die Methode {@code debit} bucht einen Betrag vom Konto mit der angegebenen
	 * Kontonummer ab.
	 * 
	 * @param userAccountNumber Kontonummer des Benutzers
	 * @param amount
	 */
	public void debit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).debit(amount);
	} // ende methode debit

	/**
	 * Die Methode {@code getadmin} fragt ab, ob das Konto mit der angegebenen
	 * Kontonummer ueber Administratorrechte verfuegt.
	 * 
	 * @param userAccountNumber Kontonummer des Benutzers
	 * @return Adminstatus als Level
	 */
	public int getadmin(int userAccountNumber) {
		return getAccountpin(userAccountNumber).getISadmin();
	}

	/**
	 * Erzeugt ein neues Objekt der Klasse {@code AccountIterator}, das alle
	 * registrierten Accounts enthaelt. Ueber dieses Objekt kann iteriert werden.
	 * 
	 * @see AccountIterator
	 * @see ArrayList
	 * @return {@code AccountIterator} Objekt mit alle zum Programmstart registrierten Accounts.
	 */
	public static Iterator createIterator() {
		return new AccountIterator(accounts);
	}

	/**
	 * Die Methode {@code getaccpin} gibt zu einer beliebigen PIN eine Kontonummer
	 * zurueck.
	 * 
	 * @param PIN PIN
	 * @return {@code currentAccount.getAccountNumber} wenn eine Uebereinstimmung
	 *         gefunden wird
	 */
	public int getaccpin(int PIN) {
		for (Account currentAccount : accounts) {

			if (currentAccount.GetPin() == PIN)
				return currentAccount.getAccountNumber();
			else
				return 1;
		} // ende for
		return PIN; // Wird nicht erreicht
	}

	/**
	 * Die Methode {@code Adduser} fuegt ein neues Benutzerkonto hinzu.
	 */
	public static void Adduser() {
		String name = Screen.Inputfield1.getText();
		int accountnumber = Integer.parseInt(Screen.Inputfield2.getText());
		int pin = Integer.parseInt(Screen.Inputfield4.getText());
		int balance = Integer.parseInt(Screen.Inputfield3.getText());

		Account newaccount = new Account(name, accountnumber, pin, balance, balance, 0);
		accounts.add(newaccount);

		Screen.Inputfield1.setText("");
		Screen.Inputfield2.setText("");
		Screen.Inputfield3.setText("");
		Screen.Inputfield4.setText("");
	}

	/**
	 * Die Methode {@code Deleteuser} loescht ein bestimmtes Benutzerkonto aus der
	 * {@code Accounts} Arrayliste an einem bestimmten Index.
	 * 
	 * @param position Arrayindex
	 */
	public static void Deleteuser(int position) {
		accounts.remove(position);

	}

} // end class BankDatabase

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/