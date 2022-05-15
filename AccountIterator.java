import java.util.ArrayList;

//Diese Klasse ist verantwortlich für das Iterator-Entwurfsmuster

public class AccountIterator implements Iterator {
    ArrayList<Account> accounts;
    
    public AccountIterator(ArrayList<Account> accounts2) {
		this.accounts = accounts2;
	} //Damit wird eine bereits vorhandene ArrayList zur Verwendung in dieser Klasse abgerufen.
    
    
    //Diese Funktion gibt true zurück, wenn die ArrayList ein Leerzeichen neben dem aktuellen enthält
	public boolean hasNext(int position) {
		if (position >= accounts.size()) {
			return false;
		} else {
			return true;
		}
	}
	

	@Override //Diese Funktion iteriert zur nächsten Position in der ArrayList.
	public Object next(int position) {
		Account AccountItem = accounts.get(position);
		return AccountItem;
	}


	@Override
	//Diese Funktion prüft, ob die Position bei 0 liegt, und verhindert, dass der Benutzer noch weiter zurückgehen kann. 
	public boolean hasPrev(int position) {
		if(position == 0)
		return false;
		else
			return true;
	}
	



	

}
