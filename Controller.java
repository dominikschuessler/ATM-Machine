package controller;

import model.Model;
import view.ViewControlButtons;
import view.ViewFrame;
import view.ViewLoginPanel;

/**
 * Nach dem MVC Prinzip ist der Controller der Mittler zwischen der
 * Datenbasis(model) und der Präsentationsschicht(view). Im konkreten Fall
 * uebernimmt der Controller sowohl diese Aufgabe als auch die Verbindung der
 * unterschiedlichen View Klassen. So wird ermoeglicht, eine Aktion in der einen
 * View Klasse zu triggern und ueber den Controller in der anderen View Klasse
 * auszuloesen.
 * </p>
 * 
 * Ein Beispiel hierfuer ist der Korrektur Button (Klasse
 * {@code ViewControlButtons}), der mittels Controller, das Loeschen der
 * Nutzereingabe und die Bereinigung der Eingabefelder (Klasse
 * {@code ViewLoginPanel} triggert.
 * </p>
 * 
 * @author Dominik Schuessler
 * @see ViewControlButtons
 * @see ViewLoginPanel
 * @see Model
 */
public class Controller {
	private Model model;
	private ViewFrame view;
	private String userinput = "";

	public Controller(Model model) {
		this.model = model;
	}

	public void setFrame(ViewFrame view) {
		this.view = view;
	}

	/**
	 * Initiiert die Verbindung der Datanbasis zum Model.
	 */
	public void load() {
		System.out.println("-Loading-");
	}

	public void doSubmit() {
		System.out.println("-Submit-");
		System.out.println("Login failed.");
		view.getLoginPanel().clearAll();
	}

	public void doCorrect() {
		userinput = "";
		view.getLoginPanel().clearAll();
		System.out.println("-Correct.-");
		System.out.println("Userinput geleert.");
	}

	public void doHelp() {
		System.out.println("-Help-");
		System.out.println("Userinput: " + userinput);
	}

	public void doCancel() {
		System.out.println("-Cancel-");
	}

	public void exit() {
		System.out.println("-Exit-");
	}

	public String getText() {
		return null;
	}

	public void modifyUserInput(String input) {
		userinput += input;
	}

}
