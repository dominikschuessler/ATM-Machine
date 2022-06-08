import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;

public class Numpad {
	JButton tasteNummer1;
	JButton tasteNummer2;
	JButton tasteNummer3;
	JButton tasteNummer4;
	JButton tasteNummer5;
	JButton tasteNummer6;
	JButton tasteNummer7;
	JButton tasteNummer8;
	JButton tasteNummer9;
	JButton tasteNummer0;

	JButton downTaste;
	JButton upTaste;

	JButton[] alleTasten = { tasteNummer1, tasteNummer2, tasteNummer3, tasteNummer4, tasteNummer5, tasteNummer6,
			tasteNummer7, tasteNummer8, tasteNummer9, downTaste, tasteNummer0, upTaste };

	Container alleTastenContainer;

	public Numpad() {
		tasteNummer0 = new JButton("0");
		tasteNummer1 = new JButton("1");
		tasteNummer2 = new JButton("2");
		tasteNummer3 = new JButton("3");
		tasteNummer4 = new JButton("4");
		tasteNummer5 = new JButton("5");
		tasteNummer6 = new JButton("6");
		tasteNummer7 = new JButton("7");
		tasteNummer8 = new JButton("8");
		tasteNummer9 = new JButton("9");
		downTaste = new JButton("down");
		tasteNummer0 = new JButton("0");
		upTaste = new JButton("up");

		alleTastenContainer = new Container();

		alleTastenContainer.setLayout(new GridLayout(4, 3));

		alleTastenContainer.add(tasteNummer1);
		alleTastenContainer.add(tasteNummer2);
		alleTastenContainer.add(tasteNummer3);
		alleTastenContainer.add(tasteNummer4);
		alleTastenContainer.add(tasteNummer5);
		alleTastenContainer.add(tasteNummer6);
		alleTastenContainer.add(tasteNummer7);
		alleTastenContainer.add(tasteNummer8);
		alleTastenContainer.add(tasteNummer9);
		alleTastenContainer.add(downTaste);
		alleTastenContainer.add(tasteNummer0);
		alleTastenContainer.add(upTaste);
	}

	/**
	 * Gibt ein Numpad als Container in der richtigen Anordnung aus.
	 * 
	 * @return alleTastenContainer als Container
	 */
	public Container getNumpad() {
		return alleTastenContainer;
	}
}
