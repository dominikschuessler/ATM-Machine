// CashDispenser.java

/** @author Annalena Maier  */
/** Die Klasse (@code CashDispenser) stellt die Geldausgabe des Automaten dar. */

public class CashDispenser 
{
   /** Die voreingestellte Menge an Scheinen in der Geldausgabe. */
   private final static int INITIAL_COUNT = 500;
   private int count; /** Die Anzahl der verbleibenden $20 Scheine. */
   
   // no-argument CashDispenser constructor initializes count to default
   public CashDispenser()
   {
      count = INITIAL_COUNT; // set count attribute to default
   } // end CashDispenser constructor

   // simulates dispensing of specified amount of cash
   public void dispenseCash(int amount)
   {
      int billsRequired = amount / 20; /** Die Menge an erforderten $20 Scheinen. */
      count -= billsRequired; // /** Die aktualisierte Anzahl an Scheinen */
   } // end method dispenseCash

   // indicates whether cash dispenser can dispense desired amount
   public boolean isSufficientCashAvailable(int amount)
   {
      int billsRequired = amount / 20; /** Die Menge an erforderten $20 Scheinen. */

      if (count >= billsRequired )
         return true; // enough bills available
      else 
         return false; // not enough bills available
   } // end method isSufficientCashAvailable
} // end class CashDispenser



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