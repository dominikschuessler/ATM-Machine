
// Account.java

/**
 * Die Klasse {@code Account} stellt ein Bankkonto dar.
 * 
 * @author Kerstin Huebner
 * @author Dominik Schuessler
 * 
 */
public class Account {

	/** Benutzername */
	private String username;

	/** Kontonummer */
	private int accountNumber;

	/** Persoenliche Identifikationsnummer (PIN) */
	private int pin;

	/** aktuell veruegbare Geldmittel */
	private double availableBalance;

	/** verfuegbare Geldmittel + ausstehende Einzahlungen */
	private double totalBalance;

	/** Speichert, ob der Benutzer Administratorrechte hat. 
	 *  0 = kein Admin
	 *  >0 = Admin
	 * */
	private int adminStatus;

	/**
	 * Der Kontokonstruktor initialisiert die Attribute der Klasse.
	 * 
	 * @param Username            Benutzername
	 * @param theAccountNumber    Kontonummer
	 * @param thePIN              PIN
	 * @param theAvailableBalance verfuegbarer Geldmittel
	 * @param theTotalBalance     verfuegbare Geldmittel mit ausstehenden Einzahlungen
	 * @param isadmin             speichert, ob der Nutzer ueber Adminrecht verfuegt
	 */
	public Account(String Username, int theAccountNumber, int thePIN, double theAvailableBalance,
			double theTotalBalance, int isadmin) {

		setUsername(Username);
		setAccountNumber(theAccountNumber);
		setPin(thePIN);
		setAvailableBalance(theAvailableBalance);
		setTotalBalance(theTotalBalance);
		setAdmin(isadmin);
	}

	/**
	 * Ueberprueft, ob die angegebene PIN die PIN des Kontos ist.
	 * 
	 * @param userPIN soll mit der des Kontos verglichen werden
	 * @return {@code true} wenn die angegebe PIN mit der des Kontos uebereinstimmt.
	 */
	public boolean validatePIN(int PIN) {
		if (this.pin == PIN)
			return true;
		else
			return false;
	}

	/**
	 * Schreibt dem Konto einen bestimmten Betrag gut.
	 * 
	 * @param amount Betrag, der dem Konto gutgeschrieben werden soll
	 */
	public void credit(double amount) {
		setTotalBalance(getTotalBalance() + amount); // zum Gesamtguthaben hinzufuegen
	}

	/**
	 * Bucht vom Konto einen bestimmten Betrag ab.
	 * 
	 * Dazu wird der Betrag von {@code availableBalance} und {@code totalBalance}
	 * abgezogen.
	 * 
	 * @param amount Betrag, der vom Konto abgebucht werden soll.
	 */
	public void debit(double amount) {
		setAvailableBalance(getAvailableBalance() - amount);
		setTotalBalance(getTotalBalance() - amount);
	}

	// ##### GETTER #####

	/**
	 * Getter fuer {@code userName}.
	 * 
	 * @return userName Benutzername
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Getter fuer {@code accountNumber}.
	 * 
	 * @return accountNumber Kontonummer
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Getter fuer {@code pin}.
	 * 
	 * @return pin Persoenliche Identifikationsnummer
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * Getter fuer {@code availableBalance}
	 * 
	 * @return availableBalance aktuell veruegbare Geldmittel
	 */
	public double getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * Getter fuer {@code totalBalance}
	 * 
	 * @return totalBalance verfuegbare Geldmittel + ausstehende Einzahlungen
	 */
	public double getTotalBalance() {
		return totalBalance;
	}

	/**
	 * Ersetzt durch {@code getAdminStatus()}
	 */
	@Deprecated
	public int getAdmin() {
		return getAdminStatus();
	}

	/**
	 * Gibt zurueck, ob der Bentzer Administratorrechte besitzt.
	 * Impliziert die Rueckgabe eines boolschen Wertes, was nicht der Fall ist.
	 * 
	 * @return adminStatus ist der Benutzer Administrator
	 */
	@Deprecated
	public int getISadmin() {
		return getAdminStatus();
	}


	@Deprecated
	public int GetPin() {
		return getPin();
	}

	// ##### SETTER #####

	/**
	 * Setter fuer {@code userName}.
	 * 
	 * @param username Neuer Benutzername
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Setter fuer {@code accountNumber}.
	 * 
	 * @param accountNumber Neue Kontonummer
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Setter fuer {@code pin}.
	 * 
	 * @param pin Neue persoenliche Identifikationsnummer
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}

	/**
	 * Setter fuer {@code availableBalance}.
	 * 
	 * @param availableBalance verfuegbare Geldmenge
	 */
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * Setter fuer {@code totalBalance}.
	 * 
	 * @param totalBalance verfuegbare Geldmenge + ausstehende Einzahlungen
	 */
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	/**
	 * setter fuer {@code adminStatus}.
	 * 
	 * @param adminStatus Hat der Benutzer Administratorrechte.
	 */
	public void setAdmin(int adminStatus) {
		this.adminStatus = adminStatus;
	}

	public int getAdminStatus() {
		return adminStatus;
	}

} // ende Klasse Account

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