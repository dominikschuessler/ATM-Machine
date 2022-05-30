import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//ATM.java

/**
 * Die Klasse {@code ATM} stellt einen Bankautomaten dar.
 * 
 * @author Dominik Schuessler
 */

public class ATM {

	/** Speichert, ob der Nutzer authentifiziert ist */
	private boolean userAuthenticated;

	/** Kontonummer des aktuellen Benutzers */
	private int currentAccountNumber;

	/** Das Display des Bankautomaten */
	private Screen screen;

	/** Das Eingabefeld des Bankautomaten */
	private Keypad keypad;

	/** Der Bargeldausgeber des Bankautomaten */
	private CashDispenser cashDispenser;

	/** Das Bargeldeinzahler des Bankautomaten */
	private DepositSlot depositSlot;

	/** Datenbank mit Account Informationen */
	private BankDatabase bankDatabase;

	/**
	 * Speichert den Adminstatus des Benutzers. Der Wert 0 bedeutet, dass der
	 * Benutzer ueber keine Adminrechte verfuegt.
	 */

	/*
	 * ************************************************ AENDERUNGSVORSCHLAG:
	 * adminCheck klein schreiben + zu adminStatus umbenennen + variable mit 0
	 * initialsieren ***********************************************
	 */

	/**
	 * Speichert, ob ein Nutzer Adminrechte besitzt. Der Wert 0 bedeutet keine
	 * Adminrechte.
	 */
	private int AdminCheck;

	/** Speichert die Nutzereingabe */
	private String userinput = "";

	private int position = 0;

	/**
	 * Speichert die ATM Instanz und verhindert durch Singelton Pattern, dass mehr
	 * als eine Instanz instanziiert wird.
	 */
	private static ATM uniqueinstance;

	/** Sammlung aller zu Programmstart in der Datenbank registrierten Nutzer. */
	Iterator Users = BankDatabase.createIterator();

	/** Konstante zur Abfrage des Kontostands. */
	private static final int BALANCE_INQUIRY = 1;

	/** Konstante zur Auszahlung. */
	private static final int WITHDRAWAL = 2;

	/** Konstante zur Einzahlung. */
	private static final int DEPOSIT = 3;

	/** Konstante zuzum Verlassen des Menues. */
	private static final int EXIT = 4;

	/**
	 * Parameterloser Konstruktor initialisiert jede Instanzvariable.
	 * 
	 * Dazu wird festgelegt, dass der Nutzer standardmaeßig nicht authentifiziert
	 * ist
	 */

	/*
	 * ****************************************************************************
	 * AENDERUNGSVORSCHLAG: Der Konstruktor muesste als private modelliert werden,
	 * wenn zur Erzeugung einer Instanz das Singleton Pattern verwendet werden soll.
	 ******************************************************************************
	 */
	public ATM() {

		// Standardmaessig ist der Benutzer nicht zum Starten authentifiziert
		userAuthenticated = false;

		// Initialwert der Kontonummer auf 0.
		currentAccountNumber = 0;

		screen = new Screen();

		keypad = new Keypad();

		cashDispenser = new CashDispenser();

		depositSlot = new DepositSlot();

		bankDatabase = new BankDatabase();

	} // end no-argument ATM constructor

	/**
	 * Startet den Bankautomaten, begruesst den Benutzer und fuehrt Transaktionen
	 * durch.
	 * 
	 * Solange der Nutzer nicht authentifiziert ist, bleibt er in einer While
	 * Schleife.
	 * 
	 */
	public void run() {
		// While Schleife?

		/** Authentifiziert den Benutzer */
		startlogin();
		// end while

		// else
		// performTransactions(); // user is now authenticated
		// userAuthenticated = false; // reset before next ATM session
		// currentAccountNumber = 0; // reset before next ATM session
		// screen.displayMessageLine("\nThank you! Goodbye!");
		// end while
	}// end method run

	/** Versucht, den Benutzer in der Datenbank zu authentifizieren */
	void startlogin() {

		position = 0;

		// UI fuer Login
		screen.createlogin();
		userinput = "";

		authenticate check = new authenticate();

		screen.Mainframe.revalidate();
		screen.Inputfield2.setText("");
		keypad.setbuttons();
		addkeypadlisteners();

		screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);

		screen.Mainframe.revalidate();
		keypad.BEnter.addActionListener(check);

		screen.Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.Mainframe.setSize(400, 280);
		screen.Mainframe.setVisible(true);
		screen.Mainframe.revalidate();
	}

	/**
	 * Setzt {@code userAthenticated} auf den boolschen Wert, der von der Datenbank
	 * zurueckgegeben wird.
	 * 
	 * Zuerst wird ueberprueft, ob die Authentifizierung erfolgreich war.
	 * 
	 * @param pin
	 */
	public void authenticateuser(int pin) {
		userAuthenticated = bankDatabase.authenticateUser(pin);

		if (userAuthenticated) {
			int accountNumber = bankDatabase.getaccpin(pin);
			/*
			 * *****************************************************************************
			 * AENDERUNGSVORSCHLAG: Die Methode getAdmin ueberprueft nicht nach der PIN
			 * sondern nach der Kontonummer! Parameter PIN ist also falsch! Deswegen wird
			 * auch das Admininterface angezeigt, wenn bei PIN eine 0 eingegeben wird!
			 * ***************************************************************************
			 */
			AdminCheck = bankDatabase.getadmin(pin);
			if (AdminCheck == 0) {
				currentAccountNumber = accountNumber;
				screen.Mainframe.getContentPane().removeAll();
				screen.Mainframe.revalidate();
				createmenu();
				screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
				screen.Mainframe.revalidate();
			}

			else

				createAdminGUI();
			// erstellt den Iterator, damit der Administrator durch die einzelnen Accounts
			// durchschalten kann.
			Iterator UserIterator = BankDatabase.createIterator();

			Addcheck check = new Addcheck();
			Deletecheck check2 = new Deletecheck();

			// Button zum Hinzufuegen eines neuen Nutzers
			screen.button2.addActionListener(check);
			// Button zum Entfernen eines Nutzers
			screen.button3.addActionListener(check2);

			/** Speichert die Kontonummer des aktuellen Benutzers. */
			currentAccountNumber = accountNumber;

		} // end if
		else
			screen.messageJLabel3.setText("Invalid account number or PIN. Please try again.");
	} // end method authenticateUser

	/*
	 * 
	 * *****************************************************************************
	 * ** AENDERUNGSVORSCHLAG: Klasse authenticate groß schreiben + Inputfield 1
	 * wieder akivieren.
	 * *****************************************************************************
	 * 
	 */

	/**
	 * Event Klasse toggelt Nutzerauthentifikation anhand von Kontonummer und PIN.
	 * 
	 * @author Dominik Schuessler
	 */
	private class authenticate implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Erfasst Kontonummer aus Inputfeld 1
			// int accnum = Integer.parseInt( screen.Inputfield1.getText() );

			// Erfasst PIN aus Inputfeld 2
			int PIN = Integer.parseInt(screen.Inputfield2.getText());
			authenticateuser(PIN);
		}
	}

	/**
	 * Event Klasse toggelt das Hinzufuegen eines neuen Benutzers.
	 * 
	 * @author Dominik Schuessler
	 *
	 */
	private class Addcheck implements ActionListener {

		/**
		 * Event Handler zum Hinzufuegen eines neuen Benutzers.
		 */
		public void actionPerformed(ActionEvent e) {

			BankDatabase.Adduser();

		}
	}

	/**
	 * Event Klasse toggelt das Loeschen eines Benutzers.
	 * 
	 * @author Dominik Schuessler
	 */
	private class Deletecheck implements ActionListener {
		/**
		 * Event Handler zum Loeschen eines Benutzers.
		 */
		public void actionPerformed(ActionEvent e) {
			BankDatabase.Deleteuser(position);
			position = position - 1;

		}
	}

	/** Erstellt die GUI des Hauptmenues. */
	public void createmenu() {
		screen.setSize(300, 150);

		balancecheck check1 = new balancecheck();
		Depositcheck check2 = new Depositcheck();
		Withdrawcheck check3 = new Withdrawcheck();
		Exitcheck check4 = new Exitcheck();

		// Bereinigt Fenster
		screen.Mainframe.getContentPane().removeAll();
		screen.Mainframe.revalidate();

		/** Fuegt Tastatur in der Mitte der GUI hinzu */
		screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);

		screen.createmenu();
		Account Account1 = bankDatabase.getAccount(currentAccountNumber);
		screen.messageJLabel.setText("Welcome " + Account1.getUsername()
				+ "                                                                                   ");

		// Buttons fuer Kontostandsabfrage, Einzahlung und Auszahlung
		keypad.B1.addActionListener(check1);
		keypad.B2.addActionListener(check3);
		keypad.B3.addActionListener(check2);
		keypad.B4.addActionListener(check4);

		screen.Mainframe.revalidate();
	}

	/**
	 * Event Klasse initiiert Kontostandsabfrage.
	 * 
	 * @author Dominik Schuessler
	 */
	private class balancecheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userinput = "";
			performTransactions(1);
		}
	}

	/**
	 * Event Klasse initiiert Transaktion 'Einzahlung'.
	 * 
	 * @author Dominik Schuessler
	 */
	private class Depositcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userinput = "";
			performTransactions(3);
		}
	}

	/**
	 * Event Klasse initiiert Transaktion 'Auszahlung'.
	 * 
	 * @author Dominik Schuessler
	 */
	private class Withdrawcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userinput = "";
			performTransactions(2);
		}
	}

	/**
	 * Event Klasse ruft Loginfenster auf.
	 * 
	 * AENDERUNGSVORSCHLAG: Der Nutzer wird nicht abgemeldet bzw. das Fenster
	 * geschlossen!
	 * 
	 * @author Dominik Schuessler
	 */
	private class Exitcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			startlogin();
		}
	}

	/**
	 * 
	 * @param a
	 */
	private void performTransactions(int a) {

		// Speichert die Tansaktion, die gerade durchgefuehrt wird.
		Transaction currentTransaction = null;

		currentTransaction = createTransaction(a);
		keypad.setbuttons();
		addkeypadlisteners();

		userinput = "";
		screen.Inputfield2.setText(userinput);
		currentTransaction.execute();

		Backcheck Back = new Backcheck();
		screen.Exit.addActionListener(Back);
		screen.Mainframe.revalidate();

	}

	/**
	 * Event Klasse bringt den Nutzer zurueck zum Hauptmenue.
	 * 
	 * @author Dominik Schuessler
	 */
	public class Backcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			createmenu();
			screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
			screen.Mainframe.revalidate();
			userinput = "";
			screen.Inputfield2.setText(userinput);
		}
	}

	/**
	 * Erzeugt eine Instanz der drei Transaktionsarten. <br>
	 * <ul>
	 * <li>Kontostandsabfrage ({@codeBalanceInquiry}
	 * <li>Auszahlung ({@code Withdrawal}
	 * <li>Einzahlung ({@code Deposit}
	 * </ul>
	 * 
	 * @param type Ganzzahl im Intervall [1;3] festgelegt durch die deklarierten
	 *             Konstanten
	 * @return temp Das Objekt der aktuellen Transaktion (BalanceInquiry, Deposit,
	 *         Withdrawal)
	 */
	private Transaction createTransaction(int type) {

		// temporaere Variable zur Speicherung der Transaktion
		Transaction temp = null;

		// bereinige Fenster
		screen.getContentPane().removeAll();
		screen.revalidate();

		// stellt fest, um welche Transaktionsart es sich handelt.

		/*
		 * AENDERUNGSVORSCHLAG: statt if eine switch case statement
		 */
		if (type == 1)

			// erzeugt Kontostandsabfrage fuer aktuelle Kontonummer
			temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);

		else if (type == 2)// create new Withdrawal transaction

			// erzeugt neue Auszahlung
			temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);

		else if (type == 3) { // create new Deposit transaction

			// erzeugt neue Einzahlung
			screen.setSize(400, 250);
			temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);

		}
		// end switch

		return temp;
	}
	// end method createTransaction

	/**
	 * Erzeugt die Admin Oberflaeche, wenn die Variable {@code IsAdmin} den Wert 1
	 * hat
	 */
	public void createAdminGUI() {

		// Fenster wird geleert
		screen.Mainframe.getContentPane().removeAll();

		/*
		 * Klassen fuer Adminbuttons werden generiert
		 * 
		 * Ncheck fuer naechsten Benutzer Pcheck fuer vorherigen Benutzer check4 zum
		 * Verlassen des Admininterfaces
		 */
		Nextcheck Ncheck = new Nextcheck();
		Prevcheck Pcheck = new Prevcheck();
		Exitcheck check4 = new Exitcheck();

		screen.Mainframe.revalidate();

		// Adminoberflaeche wird erzeugt
		screen.createAdminpage();

		/*
		 * Event Handler werden mit den Buttons ueber Action Listener verbunden.
		 */
		screen.button1.addActionListener(Ncheck);
		screen.button4.addActionListener(Pcheck);
		screen.Exit.addActionListener(check4);
		screen.Mainframe.revalidate();

	}

	/**
	 * Fuegt den Tasten auf dem Eingabefeld der Klasse {@code Keypad} Action
	 * Listener hinzu, damit diese auch eine Aktion auslösen können.
	 */
	public void addkeypadlisteners() {
		BCheck BC = new BCheck();
		BClear BC1 = new BClear();
		keypad.B1.addActionListener(BC);
		keypad.B2.addActionListener(BC);
		keypad.B3.addActionListener(BC);
		keypad.B4.addActionListener(BC);
		keypad.B5.addActionListener(BC);
		keypad.B6.addActionListener(BC);
		keypad.B7.addActionListener(BC);
		keypad.B8.addActionListener(BC);
		keypad.B9.addActionListener(BC);
		keypad.B0.addActionListener(BC);
		keypad.BClear.addActionListener(BC1);
	}

	/**
	 * Event Klasse ermittelt, welcher Button gerueckt wurde und aktualisiert das
	 * Textfeld entsprechend.
	 * 
	 * @author Dominik Schuessler
	 */
	public class BCheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Speichert Buttonobjekt des gedrueckten Buttons.
			JButton b = (JButton) e.getSource();

			// Speichert Beschriftung des gedrueckten Buttons.
			String label = b.getText();

			// Gedrueckter Button wird in der Variable userinput gespeichert.
			userinput = userinput + label;

			// Aktualisiert das Textfeld mit der Benutzereingabe.
			screen.Inputfield2.setText(userinput);

		}
	}

	/**
	 * Event Klasse bereinigt Textfeld, sobald der "Clear" Button gedrueckt wird.
	 * 
	 * @author Dominik Schuessler
	 *
	 */
	public class BClear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Bereinigt Eingabefeld
			userinput = "";
			screen.Inputfield2.setText(userinput);
		}
	}

	/**
	 * Event Klasse fuer das Weiterruecken zum naechsten Benutzer. Ruft
	 * {@code iterateUser}; diese Methode rueckt dann in der aktuellen ArrayListe
	 * weiter, sofern dies moeglich ist.
	 * 
	 * @author Dominik Schuessler
	 *
	 */
	public class Nextcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			IterateUser(BankDatabase.createIterator());
		}
	}

	/**
	 * Event Klasse fuer das Vorruecken zum vorherigen Benutzer. Ruft
	 * {@code iterateUser}; diese Methode rueckt dann in der aktuellen ArrayListe
	 * zurueck, sofern dies moeglich ist.
	 * 
	 * @author Dominik Schuessler
	 *
	 */
	public class Prevcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			prevIterateUser(BankDatabase.createIterator());
		}
	}

	/*
	 * ******************************* AENDERUNGSVORSCHLAG evtl. irrefuehrender
	 * Name, besser: nextUser() + Bezeichner klein
	 *********************************/
	/*
	 * schreiben!
	 * 
	 */
	/**
	 * {@code IterateUser()} ruft den naechsten Nutzer im aufgenommenen
	 * {@code Iterator} Objekt auf und stellt ihn, sofern dieser Benutzer existiert,
	 * auf der grafischen Benutzeroberflaeche dar.
	 * 
	 * @param Iterator Ein iterierbares Objekt, hier ein Objekt der Klasse
	 *                 {@code AccountIterator} mit Daten aus der Klasse
	 *                 {@code BankDatabase}.
	 */
	public void IterateUser(Iterator Iterator) {
		if (Iterator.hasNext(position) == true) {
			position = position + 1;
			// Display the current user in the GUI message labels.
			Account AccountItem = (Account) Iterator.next(position);
			screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
			screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
			screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());
		}
		// **************************************************************
		// Hier fehlt Error Handling, falls hasNext den Wert 'false' hat
		// **************************************************************

	}

	/**
	 * {@code prevIterateUser()} ruft den vorherigen Nutzer in aufgenommenen
	 * {@code Iterator} Objekt auf und stellt ihn, sofern dieser Benutzer existiert,
	 * auf der grafischen Benutzeroberflaeche dar.
	 * 
	 * @param Iterator Ein iterierbares Objekt, hier ein Objekt der Klasse
	 *                 {@code AccountIterator} mit Daten aus der Klasse
	 *                 {@code BankDatabase}.
	 */
	public void prevIterateUser(Iterator Iterator) {
		if (Iterator.hasPrev(position) == true) {
			position = position - 1;
			Account AccountItem = (Account) Iterator.next(position);
			// *****************************************************************************************
			// Dieser Teil doppelt sich mit IterateUser und sollte ausgelagert werden!
			screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
			screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
			screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());
			// *****************************************************************************************

		}
		// **************************************
		// Selbiges Problem mit Error Handling
		// **************************************

	}

	/**
	 * Singleton Pattern fuer ATM Instanz. Diese Methode verhindert, dass von der
	 * Klasse {@code ATM} mehrere Instanzen erzeugt werden.
	 * 
	 * @return uniqueinstance Die aktuelle Instanz des Automaten
	 */
	public static ATM getinstance() {
		if (uniqueinstance == null) {
			uniqueinstance = new ATM();
		}
		return uniqueinstance;
	}

}

// end method actionPerformed

// end i
// end class ATM
// ...
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