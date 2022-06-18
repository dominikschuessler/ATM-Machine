package main;

import controller.Controller;
import model.Model;
import view.ViewFrame;

/**
 * Die Klasse {@code Main} ist das Treiber Programm des Automaten. Innerhalb der
 * {@code main} Methode wird jeweils eine Instanz der Klassen {@code Model},
 * {@code ViewFrame} und {@code Controller} erzeugt, die entsprechend mit den
 * Bezeichnern model, view, contoller versehen sind.
 * </p>
 * 
 * Der Controller wird als final deklariert, damit er von Klassen, die ihn
 * verwenden nicht veraendert werden kann. Sonst wuerde er seine Funktionalitaet
 * verlieren.
 * 
 * @author Dominik Schuessler
 *
 */
public class Main {
	public static void main(String[] args) {
		Model model = new Model();
		final Controller controller = new Controller(model);
		ViewFrame view = new ViewFrame(controller);

		controller.setFrame(view);
		controller.load();

		view.setSize(400, 400);
		view.getView();
		view.setVisible(true);

		/**
		 * Beendet den Automaten.
		 */
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				controller.exit();
			}
		});
	}
}
