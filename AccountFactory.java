
/*
 * Die Klasse kann eventuell durch vorgeschlagenen Kommentar ersetzt werden, da sie
 * lediglich den Konstruktor der Klasse Account implementiert.
 */

/**
 * Die Klasse {@code AccountFactory} erzeugt neue Instanzen ihrer Superklasse
 * {@code Account}
 * 
 * @author Dominik Schuessler
 */

public class AccountFactory extends Account {

	public AccountFactory(String Username, int theAccountNumber, int thePIN, double theAvailableBalance,
			double theTotalBalance, int isadmin) {
		super(Username, theAccountNumber, thePIN, theAvailableBalance, theTotalBalance, isadmin);
		setUsername(Username);
		setAccountNumber(theAccountNumber);
		setPin(thePIN);
		setAvailableBalance(theAvailableBalance);
		setTotalBalance(theTotalBalance);
		setAdmin(isadmin);
	}

//	public AccountFactory(String username, int accountNumber, int PIN, double availabeBalance, double totalBalance,
//			int admin) {
//		super(username, accountNumber, PIN, availabeBalance, totalBalance, admin);
//	}

}
