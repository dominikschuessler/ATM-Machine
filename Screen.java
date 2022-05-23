
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * Die Klasse {@code Screen.java} stellt den Bildschirm des Bankautomaten dar
 * 
 * @author Mustafa Turhal
 */

public class Screen extends JFrame

{


	public JFrame Mainframe;
	public static JTextField Inputfield1;
	public static JTextField Inputfield2;
	public static JTextField Inputfield3;
	public static JTextField Inputfield4;
	/** Zeigt Textnachrichten an auf dem Bildschirm an */
	public JLabel messageJLabel;
	public JLabel messageJLabel2;
	public JLabel messageJLabel3;
	public JLabel messageJLabel4;
	public JLabel messageJLabel5;
	public JLabel messageJLabel8;
	public JLabel messageJLabel9;
	public JLabel messageJLabel10;
	/** Erzeugt klickbare Knï¿½pfe auf dem Bildschirm */
	public JButton loginbutton;
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JButton button4;
	public JButton button5;
	public JButton Exit;
	public int accnum = 0;
	public int PIN = 0;
	public JLabel messageJLabel6;
	public JLabel messageJLabel7;

	/**
	 * Methode zeig eine Nachricht an ohne Zeilenumbruch
	 * 
	 * @param message
	 */
	public void displayMessage(String message) {
		System.out.print(message);
	}
	// end displayMessage

	/**
	 * Methode zeigt eine Nachricht an ohne Zeilenumbruch
	 * 
	 * @param message
	 */
	public void displayMessageLine(String message) {
		System.out.println(message);
	} // end displayMessageline

	/**
	 * Metode zeigt Dollar/Euro Menge als Double an
	 * 
	 * @param amount
	 */
	public void displayDollarAmount(double amount) {
		System.out.printf("$%,.2f", amount);
	} // end displayDollarAmount

	/** Methode erzeugt Userinterface fï¿½r login */
	public void createlogin() {

		Mainframe = new JFrame("Bankautomat");
		messageJLabel4 = new JLabel("Führen Sie ihre EC-Karte/Kreditkarte ein                             ");
		messageJLabel = new JLabel("  Geben Sie ihre PIN ein:    ");

		Inputfield1 = new JTextField(10);

		messageJLabel2 = new JLabel(" 														                  ");
		Inputfield2 = new JTextField(10);
		loginbutton = new JButton("Login");
		messageJLabel3 = new JLabel("");
		/** Layout wird erstellt mit Layoutmanager */
		Mainframe.setLayout(new FlowLayout());
		Mainframe.add(messageJLabel4);
		/** Erstes Eingabefeld wird erzeugt */
		Mainframe.add(messageJLabel);

		Mainframe.add(Inputfield2);
		Mainframe.add(messageJLabel2);
		// Mainframe.add(loginbutton);
		// Hinzufï¿½gen von Text label
		Mainframe.add(messageJLabel3);
		Inputfield2.setEditable(false);
		Mainframe.repaint();

	}

	/** Methode erzeugt Userinterface fï¿½r Hauptmenï¿½ */
	public void createmenu() {
		Mainframe.getContentPane().removeAll();
		messageJLabel = new JLabel("Wilkommen");
		messageJLabel2 = new JLabel("1 - Kontostand");
		messageJLabel3 = new JLabel("2 - Auszahlen");
		messageJLabel4 = new JLabel("3 - Einzahlen");
		messageJLabel5 = new JLabel("4 - Beenden");
		/** Layout wird erstellt mit Layoutmanager */
		Mainframe.setLayout(new FlowLayout());
		Mainframe.add(messageJLabel);
		/** Erstes Eingabefeld wird erzeugt */
		Mainframe.add(messageJLabel2);
		/** Zweites Eingabefeld wird erzeugt */
		Mainframe.add(messageJLabel3);
		/** hinzufï¿½gen von einem Text label */
		Mainframe.add(messageJLabel4);
		Mainframe.add(messageJLabel5);
		Mainframe.repaint();
	}

	/** Methode erzeugt Userinterface fï¿½r Kontostand */
	public void creatBalanceGUI() {
		Mainframe.getContentPane().removeAll();
		messageJLabel = new JLabel("Kontostand Information:        ");
		messageJLabel2 = new JLabel("Verfügbarer Kontostand:");
		messageJLabel3 = new JLabel("Gesamter Kontostand:");
		Exit = new JButton("Zurück");
		Mainframe.setLayout(new FlowLayout());
		Mainframe.add(messageJLabel);
		Mainframe.add(messageJLabel2);
		Mainframe.add(messageJLabel3);
		Mainframe.add(Exit);
		Mainframe.repaint();
	}

	/** Methode erzeugt Userinterface fuer Auszahlungen */
	public void createWithdrawGUI() {
		Mainframe.getContentPane().removeAll();
		Mainframe.revalidate();
		messageJLabel = new JLabel("Auszahl Menü:                       ");
		messageJLabel2 = new JLabel("1 - 20€ ");
		messageJLabel3 = new JLabel("2 - 40€ ");
		messageJLabel4 = new JLabel("3 - 60€ ");
		messageJLabel5 = new JLabel("4 - 100€ ");
		messageJLabel6 = new JLabel("5 - 200€ ");
		messageJLabel7 = new JLabel("            Wählen Sie einen Betrag zum Auszahlen");
		Exit = new JButton("Abbrechen");
		Mainframe.setLayout(new FlowLayout());
		Mainframe.add(messageJLabel);
		Mainframe.add(messageJLabel2);
		Mainframe.add(messageJLabel3);
		Mainframe.add(messageJLabel4);
		Mainframe.add(messageJLabel5);
		Mainframe.add(messageJLabel6);
		Mainframe.add(Exit);
		Mainframe.add(messageJLabel7);
		Mainframe.repaint();

	}

	/** Methode erzeugt Userinterface fï¿½r Einzahlungen */
	public void CreateDepositGUI() {
		Mainframe.getContentPane().removeAll();
		messageJLabel2 = new JLabel("Bitte geben Sie einen Betrag zum Einzahlen an in CENTS");//Delta: Beträge in Euro
		messageJLabel3 = new JLabel("");
		Inputfield2 = new JTextField(10);
		Inputfield2.setEditable(false);
		button1 = new JButton("Einzahlen");
		Exit = new JButton("Abbrechen");
		Mainframe.add(messageJLabel2);
		Mainframe.add(messageJLabel3);
		Mainframe.add(Inputfield2);
		Mainframe.add(Exit);
		Mainframe.repaint();
	}

	public void setGUI() {
		repaint();
	}

	/** Methode erzeugt das Userinterface fï¿½r den Admin */
	public void createAdminpage() {
		messageJLabel = new JLabel("Nutzer anzeigen:");
		messageJLabel2 = new JLabel("Kontonummer:");
		messageJLabel3 = new JLabel("Verfügbarer Kontostand:");
		messageJLabel4 = new JLabel("Gesamter Kontostand:");
		messageJLabel5 = new JLabel("________________________________________________");
		button1 = new JButton("Nächster");
		button4 = new JButton("Vorheriger");
		Exit = new JButton("Zurück");
		Inputfield1 = new JTextField(10);
		Inputfield2 = new JTextField(10);
		Inputfield3 = new JTextField(10);
		Inputfield4 = new JTextField(10);
		Mainframe.setLayout(new FlowLayout());
		messageJLabel6 = new JLabel("Konto hinzufügen: "+"\n");
		messageJLabel7 = new JLabel("Benutzername: ");
		Mainframe.add(messageJLabel);
		messageJLabel8 = new JLabel("          Kontonummer: ");
		Mainframe.add(messageJLabel2);
		messageJLabel10 = new JLabel("                                       PIN: ");

		messageJLabel9 = new JLabel("              Balance number: ");
		button2 = new JButton("Hinzufügen");
		button3 = new JButton("Löschen");

		Mainframe.add(messageJLabel3);
		Mainframe.add(messageJLabel4);
		Mainframe.add(button4);
		Mainframe.add(button1);
		Mainframe.add(button3);
		Mainframe.add(messageJLabel5);
		Mainframe.add(messageJLabel6);
		Mainframe.add(messageJLabel7);
		Mainframe.add(Inputfield1);
		Mainframe.add(messageJLabel8);
		Mainframe.add(Inputfield2);
		Mainframe.add(messageJLabel10);
		Mainframe.add(Inputfield4);
		Mainframe.add(messageJLabel9);
		Mainframe.add(Inputfield3);

		Mainframe.add(button2);

		Mainframe.add(Exit);
		Mainframe.repaint();
	}

} // Ende der Klasse Screen

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