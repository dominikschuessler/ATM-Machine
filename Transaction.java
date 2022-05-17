// Transaction.java
/**
 * Die Klasse {@code Transaction} repraesentiert eine Transaktion des
 * Geldautomaten
 * 
 * @author Dominik Schuessler (Kommentaruebersetzung)
 */
public abstract class Transaction {

	/** Kontonummer des Benutzers. */
	private int accountNumber;

	/** Bildschirm des Bankautomaten. */
	protected Screen screen;

	/** Datenbank mit Accountinformationen. */
	private BankDatabase bankDatabase;

	/**
	 * Kontruktor initialisiert alle Attribute
	 * ({@code accountNumber, screen, bankDatabase}) mit Attributwerten.
	 * 
	 * 
	 * @param userAccountNumber
	 * @param atmScreen
	 * @param atmBankDatabase
	 */
	public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
		accountNumber = userAccountNumber;
		screen = atmScreen;
		bankDatabase = atmBankDatabase;
	}

	/**
	 * Gibt Accountnummer der Instanz zurueck.
	 * 
	 * @return accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Gibt eine Referenz zum Display zurueck.
	 * 
	 * @return screen
	 */
	public Screen getScreen() {
		return screen;
	}

	/**
	 * Gibt Referenz zur Datenbank zurueck.
	 * 
	 * @return bankDatabase
	 */
	public BankDatabase getBankDatabase() {
		return bankDatabase;
	}

	/**
	 * Abstrakte Methode, die die Transaktion durchfuehrt. Implementierung duch
	 * jeweilige Subklasse.
	 * 
	 * @see BalanceInquiry
	 * @see Deposit
	 * @see Withdrawal
	 */
	abstract public void execute();
}

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