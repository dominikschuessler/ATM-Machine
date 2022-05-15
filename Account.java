
// Account.java
// Repraesentiert einen bank account

/**
 * Die Klasse {@code Account} stellt ein Bankkonto dar.
 * 
 * <p>
 * <b> Methoden neu sortieren! </b>
 * </p>
 * 
 * @author Kerstin Huebner
 * @author Dominik Schuessler
 * 
 */
public class Account {

	/** Kontonummer */
	private int accountNumber;

	/** Persoenliche Identifikationsnummer (PIN) */
	private int pin;

	/** aktuell veruegbare Geldmittel */
	private double availableBalance;

	/** verfuegbare Geldmittel + ausstehende Einzahlungen */
	private double totalBalance;

	/**
	 * Speichert, ob der Benutzer Administratorrechte hat.
	 * 
	 * besser als boolsche Variable?
	 */
	private int admin;

	/** Bentzername */
	private String username;

	// Der Kontokonstruktor initialisiert die Attribute
	public Account(String Username, int theAccountNumber, int thePIN, double theAvailableBalance,
			double theTotalBalance, int isadmin) {

		setUsername(Username);
		setAccountNumber(theAccountNumber);
		setPin(thePIN);
		setAvailableBalance(theAvailableBalance);
		setTotalBalance(theTotalBalance);
		setAdmin(isadmin);
	} // ende Account Konstruktor

	/**
	 * Ueberprueft, ob die angegebene PIN die des Kontos ist.
	 * 
	 * @return {@code true} wenn die angegebe PIN mit der des Kontos übereinstimmt.
	 */
	public boolean validatePIN(int userPIN) {
		if (userPIN == getPin())
			return true;
		else
			return false;
	} // ende Methode validatePIN

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
	 * Schreibt dem Konto einen bestimmten Betrag gut.
	 * 
	 * @param amount Betrag, der dem Konto gutgeschrieben werden soll
	 */
	public void credit(double amount) {
		setTotalBalance(getTotalBalance() + amount); // zum Gesamtguthaben hinzufügen
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

	/**
	 * Getter fuer {@code accountNumber}.
	 * 
	 * @return accountNumber Kontonummer
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Gibt zurueck, ob der Bentzer Administratorrechte besitzt.
	 * 
	 * @return admin ist der Benutzer Administrator
	 */
	public int getISadmin() {
		return getAdmin();
	}

	/**
	 * Getter fuer {@code pin}.
	 * 
	 * @return PIN Persoenliche Identifikationsnummer
	 */
	public int GetPin() {
		return getPin();
	}

	/**
	 * Getter fuer {@code userName}.
	 * 
	 * @return userName Benutzername
	 */
	public String getUsername() {
		return username;
	}

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
	 * Getter fuer {@code pin}.
	 * 
	 * @return pin Persoenliche Identifikationsnummer
	 */
	public int getPin() {
		return pin;
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
	 * @param availableBalance
	 */
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * Setter fuer {@code totalBalance}.
	 * 
	 * @param totalBalance
	 */
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	/**
	 * Getter fuer {@code admin}.
	 * 
	 * @return admin
	 */
	public int getAdmin() {
		return admin;
	}

	/**
	 * setter fuer {@code admin}.
	 * 
	 * @param admin Hat der Benutzer Administratorrechte.
	 */
	public void setAdmin(int admin) {
		this.admin = admin;
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