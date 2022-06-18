package model;

/**
 * Die Klasse {@code Account} stellt die Vorlage zur Speicherung von Nutzern
 * dar. Dafuer werden Attribute abgefragt, die fuer den Betrieb des Automaten
 * noetig sind. Damit ein Administrator auch ohne einen Kontostand angelegt
 * werden kann, wurde der Konstruktor entsprechend ueberladen.
 * </p>
 * 
 * Die Klasse stellt entsprechende getter und setter Methoden bereit. <br>
 * Der getter zur PIN wurde bewusst nicht implementiert, stattdessen findet die
 * Ueberpruefung der PIN innerhalb der Klasse {@code Account} durch die Methode
 * {@code isPin} statt.
 * 
 * @author Dominik Schuessler
 *
 */
public class Account {

	private String username;
	private int accountNumber;
	private int pin;
	private double availableBalance;
	private double totalBalance;
	private int adminStatus;

	/**
	 * Konstruktor zum Anlegen eines neuen Kontos.
	 */
	public Account(String username, int accountNumber, int adminStatus, int pin, double availableBalance,
			double totalBalance) {
		setUsername(username);
		setAccountNumber(accountNumber);
		setAdminStatus(adminStatus);
		setPin(pin);
		setAvailableBalance(availableBalance);
		setTotalBalance(totalBalance);
	}

	/**
	 * Konstruktor zum Anlegen eines neues Admin Kontos.
	 */
	public Account(String username, int accountNumber, int adminStatus, int pin) {
		setUsername(username);
		setAccountNumber(accountNumber);
		setAdminStatus(adminStatus);
		setPin(pin);
		setAvailableBalance(0);
		setTotalBalance(0);
	}

	public boolean isPin(int pin) {
		return this.pin == pin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public int getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(int adminStatus) {
		this.adminStatus = adminStatus;
	}
}
