
public class AccountFactory extends Account {

   //Dieser Code wird für die Erstellung zusätzlicher Konten verwendet, die der Datenbank hinzugefügt werden.
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
	}

