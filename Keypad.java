
// Keypad.java
// Programm nutzt Scanner, um Nutzereingaber zu erfassen
import java.util.Scanner;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Stellt das Eingabefeld des Bankautomaten dar
 * 
 * @author Kerstin Huebner
 * @author Dominik Schuessler
 * 
 */
public class Keypad {

	/** Liest Daten der Kommandozeile */
	private Scanner input;
	private String userinput;

	public static JButton B1;
	public static JButton B2;
	public static JButton B3;
	public static JButton B4;

	/** Button Nummer 5 */
	public static JButton B5;

	public JButton B6;

	public JButton B7;

	public JButton B8;

	public JButton B9;

	public JButton B0;
	public JButton BClear;
	public JButton BEnter;

	/**
	 * Parameterloser Konstruktor instanziiert neues Scanner Objekt. Nutzereingaben
	 * werden in der Instanzvariable {@code input} gespeichert.
	 */
	public Keypad() {
		input = new Scanner(System.in);
	}

	/**
	 * Gibt die vom Benutzer eingegebene Zahl zurueck.
	 * 
	 * Es wird angenommen, dass der Benutzer eine Ganzzahl eingibt.
	 * 
	 * @return die naechste Ganzzahl der Benutzereingabe
	 */
	public int getInput() {
		return input.nextInt();
	} // end method getInput()

	/**
	 * Erstellt die Tasten des Eingabefeldes.
	 * 
	 * Dazu wird fuer jeden Button ein Objekt der Klasse {@code JButton} erzeugt,
	 * das ueber den entsprechenden Konstruktor mit einem Buttontext initialisiert
	 * wird.
	 */
	public void setbuttons() {

		B1 = new JButton("1");

		// ueberfluessig weil Konstruktor Beschriftung schon als Parameter aufnimmt
		B1.setText("1");

		B2 = new JButton("2");
		B3 = new JButton("3");
		B4 = new JButton("4");
		B5 = new JButton("5");
		B6 = new JButton("6");
		B7 = new JButton("7");
		B8 = new JButton("8");
		B9 = new JButton("9");
		B0 = new JButton("0");
		BClear = new JButton("Clear");
		BEnter = new JButton("Enter");

	}

	/**
	 * Erstellt ein neues Eingabefeld mit den Ziffern 0-9, einer Clear und einer
	 * Enter- Taste. Dazu wird ein Container erzeugt, dem die einzelnen Tasten dann
	 * im richtigen Layout hinzugefuegt werden.
	 * 
	 * @return panel Container, dem die Tasten im richtigen Layout hinzugefuegt wurden.
	 */
	public JPanel addkeypad() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 160));
		panel.setBackground(Color.gray);
		panel.setLayout(new FlowLayout());
		panel.add(B1);
		panel.add(B2);
		panel.add(B3);
		panel.add(B4);
		panel.add(B5);
		panel.add(B6);
		panel.add(B7);
		panel.add(B8);
		panel.add(B9);
		panel.add(BClear);
		panel.add(B0);
		panel.add(BEnter);

		return panel;
	}

	/**
	 * @return Methode ruft sich selbst auf.
	 */
	public String userinput() {
		return userinput();
	}

	/**
	 * Setzt die Benutzereingabe auf einen leeren String zurueck.
	 */
	public void resetuserinput() {
		userinput = "";
	}

} // end class Keypad

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