import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Deposit.java
/** 
 * Die Klasse {@code Deposit} repraesentiert eine Einzahlung.
 * Die Klasse {@code Deposit} erbt von der Klasse {@code Transaction}.
 *
 * @see Transaction
 * @author Annalena Maier
 */

public class Deposit extends Transaction
{
	/** Die Menge an Geld, welche Eingezahlt werden soll. */
   private double amount; 
   
   /** Eine Referenz zur Klasse "Keypad" */
   private Keypad keypad; 
   
   /** Eine Referenz zur Klasse "depositSlot" */
   private DepositSlot depositSlot; 
   
   /** Die Konstante für die Abbruch Option */
   private final static int CANCELED = 0; 

   /** Konstruktor initialisiert alle Attribute der Superklasse {@code Transaction}
	 * und der Klasse selbst.
	 * 
	 * @param userAccountNumber Kontonummer des Benutzers
	 * @param atmScreen         Das Display des Bankautomaten
	 * @param atmBankDatabase   Die Datenbank mit Accountinformationen
	 * @param atmKeypad         Das Eingabefeld
	 * @param atmDepositSlot	Der Geldfach
	 */
   public Deposit(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot)
   { 
      super(userAccountNumber, atmScreen, atmBankDatabase);

      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   } // end Deposit constructor

   /** Die Transaktion wird ausgefuehrt. */
   @Override
   public void execute()
   {
	   promptForDepositAmount();
   }
   
   /**
    * Die Methode {@code makedeposit} ueberprueft zuerst, ob ein Einzahlungsbetrag eingegeben wurde oder ob der Vorgang abgebrochen wurde.<br><br>
    * 
    * Wenn ein Betrag eingegeben wurde, wird der Benutzer aufgefordert, das Geld einzulegen.<br>
    * 
    * Wenn das Geld eingelegt wurde, wird der Kontostand angezeigt um die Einzahlung nachzuvollziehen. <br> <br>
    * 
    * Wenn kein Geld eingelegt wurde, wird dem Nutzer dies auf dem Bildschirm angezeigt. <br><br>
    * 
    * Wenn der Nutzer den Vorgang abbricht, wird ihm diese Aktion auf dem Bildschirm bestätigt.
    * 
    * @param amount
    */
   public void makedeposit(double amount){
      BankDatabase bankDatabase = getBankDatabase(); // get reference
      Screen screen = getScreen(); // get reference

      if (amount != CANCELED)
      {
         screen.messageJLabel2.setText( "\nPlease insert a deposit envelope containing " + amount);

  
         boolean envelopeReceived = depositSlot.isEnvelopeReceived();

         
         if (envelopeReceived)
         {  
        	 screen.messageJLabel2.setText("\nYour envelope has been " + 
               "received.\nNOTE: The money just deposited will not ");
              screen.messageJLabel3.setText("be available until we verify the amount of any " +
               "enclosed cash and your checks clear.");
            
            
            bankDatabase.credit(getAccountNumber(), amount); 
         } // end if
         else 
         {
        	 screen.messageJLabel2.setText("\nYou did not insert an " +
               "envelope, so the ATM has canceled your transaction.");
         } // end else
      } // end if 
      else 
      {
    	  screen.messageJLabel2.setText("\nCanceling transaction...");
      } // end else
   } // end method execute

   
   /** 
    * Der Nutzer wird aufgefordert, einen Betrag in Cent einzugeben. 
    */
   private void promptForDepositAmount()
   {
      Screen screen = getScreen(); // get reference to screen
      screen.CreateDepositGUI(); // receive input of deposit amount
      screen.Mainframe.add( keypad.addkeypad(), BorderLayout.CENTER);
      Depositcheck check1 = new Depositcheck();  
      keypad.BEnter.addActionListener( check1 );
      screen.Mainframe.revalidate();
      
      // if fehlt?
      
      /** 
       * Es wir ueberprueft ob der Nutzer den Vorgang abgebrochen hat oder einen gueueltigen Betrag eingegeben hat.
       * Die Menge an Geld wird ausgegeben.
       */
      
      } // end else?? welches else?
   // end method promptForDepositAmount
   
   
   /**
    * Die Klasse {@code Depositcheck} implementiert die Schnittstelle {@code ActionListener}
    * */
   private class Depositcheck implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
   	   
         double input = Integer.parseInt( screen.Inputfield2.getText() );
         double amount = input / 100;
        
         makedeposit(amount);
       
      }
   }
}
 // end class Deposit



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