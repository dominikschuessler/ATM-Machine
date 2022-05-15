import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Dominik Schüßler (Kommentarübersetzung)
 * */

// BalanceInquiry.java
/**
 * Die Klasse {@code BalanceInquiry} stellt die Transaktionsart "Saldenanfrage"
 * des Bankautomaten dar.
 */
public class BalanceInquiry extends Transaction {

	/**
	 * Im Konstruktor wird der Superkonstruktor der Klasse {@code Transaction}
	 * aufgerufen.
	 * 
	 * @see Transaction
	 * 
	 */
	public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
		super(userAccountNumber, atmScreen, atmBankDatabase);
	} // end BalanceInquiry constructor

	/** Führt die Transaktion durch */
	@Override
	public void execute() {
		
		/**Referenz zur Bankdatenbank*/
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();

		/**Erfragt den verfügbaren Saldo des beteiligten Accounts.*/
		double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

		/**Erfragt den vollständigen Saldo des beteiligten Accounts*/
		double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

		/**Stellt den Saldo auf dem Bildschirm dar.*/
		screen.creatBalanceGUI();
		screen.messageJLabel2.setText("Avaliable Balance: " + availableBalance);
		screen.messageJLabel3.setText("Total Balance: " + totalBalance);
		screen.Mainframe.revalidate();

	} // end method execute

} // end class BalanceInquiry

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