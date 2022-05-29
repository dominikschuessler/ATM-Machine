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
 * @author Mustafa Turhal
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
	 * Fuehrt die Transaktion durch. ueberprueft, ob das Konto des Nutzers ausreichend
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
		 * ueberprueft, ob der Nutzer einen Auszahlbetrag gewaehlt oder abgebrochen hat.
		 */
		// if?? weiter unten steht ein end if ohne, dass eins begonnen wurde

		/** Speichert den verfuegbaren Kontostand */
		availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

		/** Ueberprueft, ob der Benutzeraccount ausreichend gedeckt ist. */
		if (amount <= availableBalance) {

			/** Ueberprueft, ob der Geldausgabeschacht ueber ausreichende Geld verfuegt. */
			if (cashDispenser.isSufficientCashAvailable(amount)) {

				/** Aktualisiert den beteiligten Account mit Auszahlung. */
				bankDatabase.debit(getAccountNumber(), amount);

				cashDispenser.dispenseCash(amount); // dispense cash
				cashDispensed = true; // cash was dispensed

				/** Aufforderung an den Benutzer, das Geld zu entnehmen. */
				screen.messageJLabel7.setText("\nIhr Bargeld wurde" + " Ausgezahlt. Bitte entnehmen Sie ihr Bargeld jetzt.");
			} // end if

			/**
			 * Im Fall, dass der Geldausgeber nicht ueber eine ausreichende Geldmenge
			 * verfuegt.
			 */
			else
				screen.messageJLabel7
						.setText("\nUnzureichender Betrag an Bargeld im Geldautomaten. " + "\n\nBitte geben Sie einen kleineren Betrag an.");
		} // end if

		/**
		 * Im Fall, dass der Benutzeraccount nicht ausreichend gedeckt ist.
		 */
		else {
			screen.messageJLabel7
					.setText("\nUnzureichende Geldmittel auf ihrem Konto." + "\n\nBitte geben Sie einen kleineren Betrag an.");
		} // end else
	} // end if
		// end else

	// end method execute

	/**
	 * Stellt ein Menue mit unteschiedlichen Auszahlbetraegen und der Option zum
	 * Abbruch dar. Gibt den ausgewaehlten Betrag zurueck; Bricht der Benutzer den
	 * Vorgang ab, wird 0 zurueckgegeben.
	 * 
	 */
	private void displayMenuOfAmounts() {

		/** Speichert den Betrag, der zurueckgegeben werden soll. */
		int userChoice = 0;

		/** Screen Referenz */
		Screen screen = getScreen();
		/**Auszahlmenue wird Erzeugt**/
		screen.createWithdrawGUI();
		screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
		/**Erzeugt neue Instanz von withdraw1**/
		withdraw1 check1 = new withdraw1();
		/**Erzeugt neue Instanz von withdraw2**/
		withdraw2 check2 = new withdraw2();
		/**Erzeugt neue Instanz von withdraw3**/
		withdraw3 check3 = new withdraw3();
		/**Erzeugt neue Instanz von withdraw4**/
		withdraw4 check4 = new withdraw4();
		/**Erzeugt neue Instanz von withdraw5**/
		withdraw5 check5 = new withdraw5();
		/**Prueft in {@link Keypad} ob B1 gedrueckt wurde und fuehrt somit check1 aus**/
		Keypad.B1.addActionListener(check1);
		/**Prueft in {@link Keypad} ob B2 gedrueckt wurde und fuehrt somit check2 aus**/
		Keypad.B2.addActionListener(check2);
		/**Prueft in {@link Keypad} ob B3 gedrueckt wurde und fuehrt somit check3 aus**/
		Keypad.B3.addActionListener(check3);
		/**Prueft in {@link Keypad} ob B4 gedrueckt wurde und fuehrt somit check4 aus**/
		Keypad.B4.addActionListener(check4);
		/**Prueft in {@link Keypad} ob B5 gedrueckt wurde und fuehrt somit check5 aus**/
		Keypad.B5.addActionListener(check5);
		/**Setzt {@link Screen#Mainframe} zurueck basierend auf den neuen Geldbetraegen**/
		screen.Mainframe.revalidate();
	}
	/**Fuehrt die Transaktion für die erste Auszahlungsmöglichkeit durch **/
	public class withdraw1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(20);
		}
	}
	/**Fuehrt die Transaktion für die zweite Auszahlungsmöglichkeit durch **/
	public class withdraw2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(40);
		}
	}
	/**Fuehrt die Transaktion für die dritte Auszahlungsmöglichkeit durch **/
	public class withdraw3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(60);
		}
	}
	/**Fuehrt die Transaktion für die vierte Auszahlungsmöglichkeit durch **/
	public class withdraw4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transaction(100);
		}
	}
	/**Fuehrt die Transaktion für die fünfte Auszahlungsmöglichkeit durch **/
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