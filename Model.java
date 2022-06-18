package model;

import java.util.ArrayList;


/**
 * Das {@code Model} stellt nach dem MVC Prinzip die Verbindung zur Datenbasis
 * (also der Datenbank) her. In diesem Fall repaesentiert das {@code Model} die
 * Datenbasis selbst, indem es Instanzen der Klasse {@code Account} speichert.
 * Dies dient Gruenden der Einfachheit.
 * </p>
 * 
 * Die Accounts werden in einer ArrayList iterrierbar gespeichert. Darueber
 * hinaus wird eine Methode zur Authetifizierung bereitgestellt.</p>
 * 
 * @author Dominik Schuessler
 * @see Controller
 * @see Account
 */
public class Model {
	private ArrayList<Account> accountList = new ArrayList<Account>();

	private Account account1;
	private Account account2;
	private Account account3;
	private Account account4;
	private Account account5;
	private Account account6;

	public Model() {
		account1 = new Account("Hans", 101010, 0, 1234, 1000, 1500);
		account2 = new Account("Joseph", 202020, 0, 5678, 2000, 2000);
		account3 = new Account("Helga", 303030, 0, 1859, 15000, 1500);
		account4 = new Account("Luise", 404040, 0, 1944, 1000, 1500);
		account5 = new Account("Frank", 808080, 1, 4902);
		account6 = new Account("Nadine", 909090, 1, 9085);

		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
		accountList.add(account4);
		accountList.add(account5);
		accountList.add(account6);

	}

	public Account getAccount(int accountNumber) {
		for (Account currentAccount : accountList) {

			if (currentAccount.getAccountNumber() == accountNumber) {
				return currentAccount;
			}
		}
		return null;
	}

	public boolean authenticateUser(int accountNumber, int userPIN) {

		Account userAccount = getAccount(accountNumber);

		if (userAccount != null) {
			if (userAccount.isPin(userPIN)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}


}
