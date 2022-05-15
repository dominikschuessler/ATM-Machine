import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/** @author Annalena Maier */

// Deposit.java
/** Die Klasse "Deposit" repraesentiert eine Einzahlung. */

public class Deposit extends Transaction
{
   private double amount; /** Die Menge an Geld, welche Eingezahlt werden soll. */
   private Keypad keypad; /** Eine Referenz zur Klasse "Keypad" */
   private DepositSlot depositSlot; /** Eine Referenz zur Klasse "depositSlot" */
   private final static int CANCELED = 0; /** Die Konstante für die Abbruch Option */

   /** Der Konstruktor von Deposit */
   public Deposit(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot)
   {
      /** Die Superklassen Variablen werden initialisiert. */ 
      super(userAccountNumber, atmScreen, atmBankDatabase);

      /** Die Referenzen zu "Keypad" und "depositSlot" werden initialisiert. */ 
      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   } // end Deposit constructor

   /** Die Transaktion wird ausgefuehrt. */
   @Override
   public void execute()
   {
	   promptForDepositAmount();
   }
   public void makedeposit(double amount){
      BankDatabase bankDatabase = getBankDatabase(); // get reference
      Screen screen = getScreen(); // get reference
       /** Die Menge, die der Nutzer Einzahlen will. */

      /** Es wird ueberprueft, ob ein Einzahlungsbetrag eingegeben wurde oder ob der Vorgang abgebrochen wurde. */
      if (amount != CANCELED)
      {
         /** Die Aufforderung, das Geld einzulegen */
         screen.messageJLabel2.setText( "\nPlease insert a deposit envelope containing " + amount);

         /** Es wird ueberprueft ob das Geld erhalten wurde */
         boolean envelopeReceived = depositSlot.isEnvelopeReceived();

         // check whether deposit envelope was received
         if (envelopeReceived)
         {  
        	 screen.messageJLabel2.setText("\nYour envelope has been " + 
               "received.\nNOTE: The money just deposited will not ");
              screen.messageJLabel3.setText("be available until we verify the amount of any " +
               "enclosed cash and your checks clear.");
            
            /** Der Kontostand wird angezeigt, um die Einzahlung nach zu vollziehen. */
            bankDatabase.credit(getAccountNumber(), amount); 
         } // end if
         else /** Wenn kein Geld eingezahlt wurde */
         {
        	 screen.messageJLabel2.setText("\nYou did not insert an " +
               "envelope, so the ATM has canceled your transaction.");
         } // end else
      } // end if 
      else /** Falls der Nutzer den Vorgang abbricht. */
      {
    	  screen.messageJLabel2.setText("\nCanceling transaction...");
      } // end else
   } // end method execute

   /** Der Nutzer wird aufgefordert, einen Betrag in Cent einzugeben. */
   private void promptForDepositAmount()
   {
      Screen screen = getScreen(); // get reference to screen

      /** Zeigt die Eingabeaufforderung an */
      screen.CreateDepositGUI(); // receive input of deposit amount
      screen.Mainframe.add( keypad.addkeypad(), BorderLayout.CENTER);
      Depositcheck check1 = new Depositcheck();  
      keypad.BEnter.addActionListener( check1 );
      screen.Mainframe.revalidate();
      /** Es wir ueberprueft ob der Nutzer den Vorgang abgebrochen hat oder einen gueueltigen Betrag eingegeben hat. */
      
          /**Die Menge an Geld wird ausgegeben */
      } // end else
   // end method promptForDepositAmount

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