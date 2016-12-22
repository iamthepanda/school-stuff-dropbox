// use Java Swing package
import javax.swing.JOptionPane;

public class SimpleIO {
	public static void main(String [] args) {

		// Display an input Dialog box and read input to readStr
		String readStr = JOptionPane.showInputDialog("Enter something");

		// Display msg box
		JOptionPane.showMessageDialog(null,readStr);
	}
}
