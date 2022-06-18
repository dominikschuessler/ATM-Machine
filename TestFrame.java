package test;

import java.awt.Container;

import javax.swing.JFrame;

public class TestFrame {
	JFrame frame;
	
	public TestFrame(String testname) {
		frame = new JFrame(testname);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	
	public void addComp(Container c) {
		frame.add(c);
		frame.setVisible(true);

	}
}
