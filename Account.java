
// Account.java
// Repraesentiert einen bank account

public class Account 
{
   private int accountNumber; // account number
   private int pin; // PIN fuer Authentifikation
   private double availableBalance; // Verfügbare Mittel zur Entnahme
   private double totalBalance; // Verfügbare Mittel + ausstehende Einlagen
   private int admin;
   private String username;

   // Der Kontokonstruktor initialisiert die Attribute
   public Account(String Username, int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance, int isadmin)
   {
	   setUsername(Username);
      setAccountNumber(theAccountNumber);
      setPin(thePIN);
      setAvailableBalance(theAvailableBalance);
      setTotalBalance(theTotalBalance);
      setAdmin(isadmin);
   } // ende Account Konstruktor

   // ermittelt, ob eine vom Benutzer angegebene PIN mit der PIN im Konto übereinstimmt
   public boolean validatePIN(int userPIN)
   {
      if (userPIN == getPin())
         return true;
      else
         return false;
   } // ende Methode validatePIN
   
   // gibt available balance zurueck
   public double getAvailableBalance()
   {
      return availableBalance;
   } // ende getAvailableBalance

   // Gibt die total balance zurueck
   public double getTotalBalance()
   {
      return totalBalance;
   } // ende methode getTotalBalance

   // schreibt einen Betrag auf dem Konto gut
   public void credit(double amount)
   {
      setTotalBalance(getTotalBalance() + amount); // add to total balance
   } // ende methode credit

   // bucht einen Betrag vom Konto ab
   public void debit(double amount)
   {
      setAvailableBalance(getAvailableBalance() - amount); // subtract from available balance
      setTotalBalance(getTotalBalance() - amount); // subtract from total balance
   } // ende methode debit

   // Gibt account number zurueck
   public int getAccountNumber()
   {
      return accountNumber;  
   } // ende methode getAccountNumber
   
   public int getISadmin()
   {
	   return getAdmin();  
   }
   
   public int GetPin(){
	   return getPin();
   }

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}

public int getPin() {
	return pin;
}

public void setPin(int pin) {
	this.pin = pin;
}

public void setAvailableBalance(double availableBalance) {
	this.availableBalance = availableBalance;
}

public void setTotalBalance(double totalBalance) {
	this.totalBalance = totalBalance;
}

public int getAdmin() {
	return admin;
}

public void setAdmin(int admin) {
	this.admin = admin;
}
   
  
   
} // ende Klasse Account


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/