import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Withdrawal.java
/**
 * Stellt die Transaktion 'Geld abheben' des Bankautomaten dar. Erbt von der
 * Klasse {@code Transaction}. Erbt von der Klasse {@code Transaction}.
 * 
 * @see Transaction
 * @author Dominik Schüßler (Kommentarübersetzung und Kommentarergänzung)
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

	/**
	 * Fuehrt Transaktion durch.
	 * 
	 * Fehlender Code!
	 * <ul>
	 * <li>Fuer Auszahlung verfuegbarer Betrag,
	 * <li>Referenz zur Datenbank und zum Display,
	 * <li>Wiederholung bis das Geld ausgezahlt wurde oder der Benutzer den Vorgang
	 * abbricht.
	 * </ul>
	 * 
	 * @see Transaction
	 */
	@Override
	public void execute() {
		// Hier! fehlender Code aus Beschreibung
		displayMenuOfAmounts();
	}

	/**
	 * Führt die Transaktion durch. Überprüft, ob das Konto des Nutzers ausreichend
	 * gedeckt ist, der Automat ueber ausreichend Geld verfuegt und ueberwacht, ob
	 * der Nutzer den Vorgang abbricht. 
	 * <p><b>Fehlender Code!</b>
	 * 
	 * @param amount Der Betrag, der ausgegeben werden soll.
	 */
	public void transaction(int amount) {

		BankDatabase bankDatabase = getBankDatabase();

		Screen screen = getScreen();

		/** Der Geldbetrag wurde noch nicht ausgegeben. */
		boolean cashDispensed = false;

		double availableBalance;
		/**
		 * Überprüft, ob der Nutzer einen Auszahlbetrag gewählt oder abgebrochen hat.
		 */
		// if?? weiter unten steht ein end if ohne, dass eins begonnen wurde

		/** Speichert den verfügbaren Kontostand */
		availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

		/** Ueberprueft, ob der Benutzeraccount ausreichend gedeckt ist. */
		if (amount <= availableBalance) {

			/** Ueberprueft, ob der Geldausgabeschacht über ausreichende Geld verfuegt. */
			if (cashDispenser.isSufficientCashAvailable(amount)) {

				/** Aktualisiert den beteiligten Account mit Auszahlung. */
				bankDatabase.debit(getAccountNumber(), amount);

				cashDispenser.dispenseCash(amount); // dispense cash
				cashDispensed = true; // cash was dispensed

				/** Aufforderung an den Benutzer, das Geld zu entnehmen. */
				screen.messageJLabel7.setText("\nYour cash has been" + " dispensed. Please take your cash now.");
			} // end if

			/**
			 * Im Fall, dass der Geldausgeber nicht ueber eine ausreichende Geldmenge
			 * verfuegt.
			 */
			else
				screen.messageJLabel7
						.setText("\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller amount.");
		} // end if

		/**
		 * Im Fall, dass der Benutzeraccount nicht ausreichend gedeckt ist.
		 */
		else {
			screen.messageJLabel7
					.setText("\nInsufficient funds in your account." + "\n\nPlease choose a smaller amount.");
		} // end else
	} // end if
		// end else

	// end method execute

	/**
	 * Stellt ein Menue mit unteschiedlichen Auszahlbetraegen und der Option zum
	 * Abbruch dar. Gibt den ausgewaehlten Betrag zurück; Bricht der Benutzer den
	 * Vorgang ab, wird 0 zurückgegeben.
	 * 
	 * @return userChoice ausgewaehlter Betrag oder 0
	 */
	private void displayMenuOfAmounts() {

		/** Speichert den Betrag, der zurückgegeben werden soll. */
		int userChoice = 0;

		/** Screen Referenz */
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

	public class withdraw1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(20);
		}
	}

	public class withdraw2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(40);
		}
	}

	public class withdraw3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(60);
		}
	}

	public class withdraw4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(100);
		}
	}

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