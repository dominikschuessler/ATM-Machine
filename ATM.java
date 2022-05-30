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

	private int AdminCheck;

	private String userinput = "";

	private int position = 0;

	/**Speichert die ATM Instanz und verhindert durch Singelton Pattern, dass mehr als eine Instanz instanziiert wird.	 */
	private static ATM uniqueinstance;

	Iterator Users = BankDatabase.createIterator();

	// Die Konstanten beziehen sich auf Einstellungen des Hauptmenues
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;

	/**
	 * Parameterloser Konstruktor initialisiert jede Instanz.
	 * 
	 * Dazu wird festgelegt, dass der Nutzer standardmaeßig nicht authentifiziert ist
	 */
	
	//AENDERUNGSVORSCHLAG: Der Konstruktor muesste als private modelliert werden, wenn zur Erzeugung einer Instanz das Singleton Pattern verwendet werden soll.
	public ATM() {

		// Standardmaessig ist der Benutzer nicht zum Starten authentifiziert
		userAuthenticated = false;

		// Initialwert der Kontonummer auf 0.
		currentAccountNumber = 0;

		// Display wird erzeugt
		screen = new Screen();

		// Tastatur wird erzeugt.
		keypad = new Keypad();

		// Bargeldausgeber wird erzeugt
		cashDispenser = new CashDispenser();

		// Bargeldeinzahler wird erzeugt
		depositSlot = new DepositSlot();

		// Datenbank ueber Accountinformationen wird erzeugt
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
		/** Setzt die Groesse des Rahmens */
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
			Iterator UserIterator = BankDatabase.createIterator();
			Addcheck check = new Addcheck();
			Deletecheck check2 = new Deletecheck();
			screen.button2.addActionListener(check);
			screen.button3.addActionListener(check2);

			/** Speichert die Kontonummer des aktuellen Benutzers. */
			currentAccountNumber = accountNumber;

		} // end if
		else
			screen.messageJLabel3.setText("Invalid account number or PIN. Please try again.");
	} // end method authenticateUser

	// AENDERUNGSVORSCHLAG: Klasse authenticate groß schreiben!
	private class authenticate implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// int accnum = Integer.parseInt( screen.Inputfield1.getText() );
			int PIN = Integer.parseInt(screen.Inputfield2.getText());
			// Get the PIN from the GUI text field.
			authenticateuser(PIN);
		}
	}

	private class Addcheck implements ActionListener {
		/**
		 * Action Listener zum Hinzufuegen eines Bentuzers.
		 * 
		 * @param e Objekt vom Typ {@code ActionEvent}
		 */

		public void actionPerformed(ActionEvent e) {

			BankDatabase.Adduser();

		}
	}

	private class Deletecheck implements ActionListener {

		/**
		 * Action Listener zum Entfernen eines Bentuzers.
		 * 
		 * @param e Objekt vom Typ {@code ActionEvent}
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
		screen.Mainframe.getContentPane().removeAll();
		screen.Mainframe.revalidate();
		/** Fuegt Tastatur zur GUI hinzu */
		screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
		screen.createmenu();
		Account Account1 = bankDatabase.getAccount(currentAccountNumber);
		screen.messageJLabel.setText("Welcome " + Account1.getUsername()
				+ "                                                                                   ");

		keypad.B1.addActionListener(check1);
		keypad.B2.addActionListener(check3);
		keypad.B3.addActionListener(check2);
		keypad.B4.addActionListener(check4);
		screen.Mainframe.revalidate();
	}

	/** Stellt das Hauptmenue dar und fuehrt Transaktionen durch. */
	private class balancecheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userinput = "";
			performTransactions(1);
		}
	}

	/**
	 * Option im Hauptmenue.
	 */
	private class Depositcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userinput = "";
			performTransactions(3);
		}
	}

	/**
	 * Option im Hauptmenue.
	 */
	private class Withdrawcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userinput = "";
			performTransactions(2);
		}
	}

	/**
	 * Option im Hauptmenue.
	 */
	private class Exitcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			startlogin();
		}
	}

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

	public class Backcheck implements ActionListener {
		/** Bring den Nutzer zurueck zum Hauptmenue. */
		public void actionPerformed(ActionEvent e) {
			createmenu();
			screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
			screen.Mainframe.revalidate();
			userinput = "";
			screen.Inputfield2.setText(userinput);
		}
	}

	private Transaction createTransaction(int type) {
		/** temporaere Variable zur Speicherung der Transaktion */
		Transaction temp = null;
		screen.getContentPane().removeAll();
		screen.revalidate();

		// determine which type of Transaction to create

		if (type == 1) // create new BalanceInquiry transaction
			temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
		else if (type == 2)// create new Withdrawal transaction
			temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
		else if (type == 3) { // create new Deposit transaction
			screen.setSize(400, 250);
			temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
		}
		// end switch

		return temp; // return the newly created object
	}
	// end method createTransaction

	/**
	 * Erzeugt die Admin Oberflaeche, wenn die Variable {@code IsAdmin} den Wert 1
	 * hat
	 */
	public void createAdminGUI() {

		// AENDERUNG: Hier findet keine Ueberpruefung statt, ob die Variable IsAdmin
		// einen bestimmten Wert besitzt

		screen.Mainframe.getContentPane().removeAll();
		Nextcheck Ncheck = new Nextcheck();
		Prevcheck Pcheck = new Prevcheck();
		Exitcheck check4 = new Exitcheck();

		screen.Mainframe.revalidate();

		// Adminoberflaeche wird erzeugt
		screen.createAdminpage();

		screen.button1.addActionListener(Ncheck);
		screen.button4.addActionListener(Pcheck);
		screen.Exit.addActionListener(check4);
		screen.Mainframe.revalidate();

	}

	// This code adds action listeners to the keypad.
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

	// This code checks what button was pressed on the keypad.
	public class BCheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			String label = b.getLabel();
			userinput = userinput + label;
			// update the text field using the user's input.
			screen.Inputfield2.setText(userinput);

		}
	}

	public class BClear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Clear the input field.
			userinput = "";
			screen.Inputfield2.setText(userinput);
		}
	}

	// Action listener used for the literator pattern
	public class Nextcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			IterateUser(BankDatabase.createIterator());
		}
	}

	// Action listener used for the literator pattern
	public class Prevcheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			prevIterateUser(BankDatabase.createIterator());
		}
	}

	// Action listener used for the literator pattern
	public void IterateUser(Iterator Iterator) {
		if (Iterator.hasNext(position) == true) {
			position = position + 1;
			// Display the current user in the GUI message labels.
			Account AccountItem = (Account) Iterator.next(position);
			screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
			screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
			screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());
		}

	}

	// Action listener used for the literator pattern
	public void prevIterateUser(Iterator Iterator) {
		if (Iterator.hasPrev(position) == true) {
			position = position - 1;
			Account AccountItem = (Account) Iterator.next(position);
			screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
			screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
			screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());

		}

	}
	/**
	 * Singleton Pattern fuer ATM Instanz. Diese Methode verhindert, dass von der Klasse {@code ATM} mehrere Instanzen erzeugt werden.
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