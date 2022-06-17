import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Withdrawal.java
/**
 * Stellt die Transaktion 'Geld abheben' des Bankautomaten dar. Erbt von der
 * Klasse {@code Transaction}.
 * 
 * @see Transaction
 * @author Dominik Schuessler
 */

public class Withdrawal extends Transaction {

	/** Abzuhebender Betrag. */
	private int amount;

	/** Referenz zur Tastatur. */
	private Keypad keypad;

	/** Referenz zum Bargeldausgeber. */
	private CashDispenser cashDispenser;

	/** Konstante zur Menue Option 'abbrechen'. */
	private final static int CANCELED = 6;

	/**
	 * Konstruktor initialisiert alle Attribute der Superklasse {@code Transaction}
	 * und der Klasse selbst.
	 * 
	 * @param userAccountNumber Kontonummer des Benutzers
	 * @param atmScreen         Das Display des Bankautomaten
	 * @param atmBankDatabase   Die Datenbank mit Accountinformationen
	 * @param atmKeypad         Das Eingabefeld
	 * @param atmCashDispenser  Der Geldausgabeschacht
	 */
	public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad,
			CashDispenser atmCashDispenser) {

		super(userAccountNumber, atmScreen, atmBankDatabase);
		keypad = atmKeypad;
		cashDispenser = atmCashDispenser;
	} // end Withdrawal constructor

	/*
	 * 
	 * Fehlender Code! <ul> <li>Fuer Auszahlung verfuegbarer Betrag, <li>Referenz
	 * zur Datenbank und zum Display, <li>Wiederholung bis das Geld ausgezahlt wurde
	 * oder der Benutzer den Vorgang abbricht. </ul>
	 */

	/**
	 * Fuehrt Transaktion durch.
	 * 
	 * @see Transaction
	 */
	@Override
	public void execute() {
		// Hier! fehlender Code aus Beschreibung
		displayMenuOfAmounts();
	}

	/**
	 * Fuehrt die Transaktion durch. ueberprueft, ob das Konto des Nutzers
	 * ausreichend gedeckt ist, der Automat ueber ausreichend Geld verfuegt und
	 * ueberwacht, ob der Nutzer den Vorgang abbricht.
	 * <p>
	 * <b>Fehlender Code!</b>
	 * 
	 * @param amount Der Betrag, der ausgegeben werden soll.
	 */
	public void transaction(int amount) {

		BankDatabase bankDatabase = getBankDatabase();

		Screen screen = getScreen();

		boolean cashDispensed = false;

		double availableBalance;
		/*
		 * ueberprueft, ob der Nutzer einen Auszahlbetrag gewaehlt oder abgebrochen hat.
		 */
		// if?? weiter unten steht ein end if ohne, dass eins begonnen wurde

		availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

		if (amount <= availableBalance) {

			if (cashDispenser.isSufficientCashAvailable(amount)) {

				bankDatabase.debit(getAccountNumber(), amount);

				cashDispenser.dispenseCash(amount);
				cashDispensed = true;

				screen.messageJLabel7
						.setText("\nIhr Bargeld wurde" + " ausgezahlt. Bitte entnehmen Sie ihr Bargeld jetzt.");
			}

			else
				screen.messageJLabel7.setText("\nUnzureichender Betrag an Bargeld im Geldautomaten. "
						+ "\n\nBitte geben Sie einen kleineren Betrag an.");
		}

		else {
			screen.messageJLabel7.setText(
					"\nUnzureichende Geldmittel auf ihrem Konto." + "\n\nBitte geben Sie einen kleineren Betrag an.");
		}
	}

	/**
	 * Stellt ein Menue mit unteschiedlichen Auszahlbetraegen und der Option zum
	 * Abbruch dar. Gibt den ausgewaehlten Betrag zurueck; Bricht der Benutzer den
	 * Vorgang ab, wird 0 zurueckgegeben.
	 * 
	 */
	private void displayMenuOfAmounts() {

		int userChoice = 0;

		Screen screen = getScreen();

		screen.createWithdrawGUI();
		screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);

		withdraw1 check1 = new withdraw1();

		withdraw2 check2 = new withdraw2();

		withdraw3 check3 = new withdraw3();

		withdraw4 check4 = new withdraw4();

		withdraw5 check5 = new withdraw5();

		Keypad.B1.addActionListener(check1);

		Keypad.B2.addActionListener(check2);

		Keypad.B3.addActionListener(check3);

		Keypad.B4.addActionListener(check4);

		Keypad.B5.addActionListener(check5);

		screen.Mainframe.revalidate();
	}

	/**
	 * Eventklasse, die bei einem ActionEvent die Methode {@code transaction} mit
	 * dem Betrag von 20 Euro ausführt.
	 *
	 */
	public class withdraw1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(20);
		}
	}

	/**
	 * Eventklasse, die bei einem ActionEvent die Methode {@code transaction} mit
	 * dem Betrag von 40 Euro ausführt.
	 *
	 */
	public class withdraw2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(40);
		}
	}

	/**
	 * Eventklasse, die bei einem ActionEvent die Methode {@code transaction} mit
	 * dem Betrag von 60 Euro ausführt.
	 *
	 */
	public class withdraw3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(60);
		}
	}

	/**
	 * Eventklasse, die bei einem ActionEvent die Methode {@code transaction} mit
	 * dem Betrag von 100 Euro ausführt.
	 *
	 */
	public class withdraw4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(100);
		}
	}

	/**
	 * Eventklasse, die bei einem ActionEvent die Methode {@code transaction} mit
	 * dem Betrag von 200 Euro ausführt.
	 *
	 */
	public class withdraw5 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(200);
		}
	}
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