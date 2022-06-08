import javax.swing.JFrame;

public class NumpadTest {

	public static void main(String[] args) {
		Numpad eingabefeld = new Numpad();

		JFrame meinNumpadAlsFenster = new JFrame();
		
		meinNumpadAlsFenster.setSize(400, 400);
		meinNumpadAlsFenster.setLocationRelativeTo(null);
		meinNumpadAlsFenster.setVisible(true);
		
		meinNumpadAlsFenster.add(eingabefeld.getNumpad());
	}

}
