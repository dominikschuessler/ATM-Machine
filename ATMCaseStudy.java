// ATMCaseStudy.java
/**
 * 
 * Die Klasse {@code ATMCaseStudy} ist das Treiber Programm fuer
 * {@code ATMCaseStudy}. Es enthaelt die {@code main} Methode und startet den
 * Bankautomaten.
 * 
 * @author Dominik Schuessler
 */
public class ATMCaseStudy {

	/**
	 * Main Methode erstellt und fuehrt den Bankautomaten aus.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Die einzige Instanz des Bankautomaten, dadurch, dass die Methode getinstance() verwendet wird.
		 */
		ATM theATM = ATM.getinstance();

		theATM.run();
	} // end main
} // end class ATMCaseStudy

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