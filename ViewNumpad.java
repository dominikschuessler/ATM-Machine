package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.Controller;

/**
 * Die Klasse modelliert das Nummernfeld und sieht vor, dass entsprechende
 * buttonspezifische Funktionen im Controller getriggert werden koennen. Dafuer
 * ist fuer jeden Button ein {@code ActionListener} implementiert. 
 * 
 * @author Dominik Schuessler
 * @see Controller
 */
public class ViewNumpad {
	private Controller controller;

	private JButton tasteNummer1;
	private JButton tasteNummer2;
	private JButton tasteNummer3;
	private JButton tasteNummer4;
	private JButton tasteNummer5;
	private JButton tasteNummer6;
	private JButton tasteNummer7;
	private JButton tasteNummer8;
	private JButton tasteNummer9;
	private JButton tasteNummer0;

	private JButton downButton;
	private JButton upButton;

	private Container numpad;

	public ViewNumpad(Controller controller) {
		this.controller = controller;
		build();
	}

	public void build() {

		tasteNummer1 = new JButton("1");
		tasteNummer1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("1");
				System.out.println("-1-");
			}
		});

		tasteNummer2 = new JButton("2");
		tasteNummer2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("2");
				System.out.println("-2-");
			}
		});

		tasteNummer3 = new JButton("3");
		tasteNummer3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("3");
				System.out.println("-3-");
			}
		});

		tasteNummer4 = new JButton("4");
		tasteNummer4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("4");
				System.out.println("-4-");
			}
		});

		tasteNummer5 = new JButton("5");
		tasteNummer5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("5");
				System.out.println("-5-");
			}
		});

		tasteNummer6 = new JButton("6");
		tasteNummer6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("6");
				System.out.println("-6-");
			}
		});

		tasteNummer7 = new JButton("7");
		tasteNummer7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("7");
				System.out.println("-7-");
			}
		});

		tasteNummer8 = new JButton("8");
		tasteNummer8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("8");
				System.out.println("-8-");
			}
		});

		tasteNummer9 = new JButton("9");
		tasteNummer9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("9");
				System.out.println("-9-");
			}
		});

		downButton = new JButton("down");
		downButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("-down-");
			}
		});

		tasteNummer0 = new JButton("0");
		tasteNummer0.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.modifyUserInput("0");
				System.out.println("-0-");
			}
		});

		upButton = new JButton("up");
		upButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("-up-");
			}
		});

		numpad = new Container();
		numpad.setLayout(new GridLayout(4, 3));

		numpad.add(tasteNummer1);
		numpad.add(tasteNummer2);
		numpad.add(tasteNummer3);
		numpad.add(tasteNummer4);
		numpad.add(tasteNummer5);
		numpad.add(tasteNummer6);
		numpad.add(tasteNummer7);
		numpad.add(tasteNummer8);
		numpad.add(tasteNummer9);
		numpad.add(downButton);
		numpad.add(tasteNummer0);
		numpad.add(upButton);
	}

	public Container getNumpad() {
		return this.numpad;
	}

}
