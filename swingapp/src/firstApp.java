import javax.swing.JFrame;
import javax.swing.JLabel;

public class firstApp {
	public static void createAndShowGUI() {
		JFrame mainFrame = new JFrame("Swing Example");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(400, 400);
		
		JLabel topLabel = new JLabel("", JLabel.CENTER);
		topLabel.setText("Hello Swing World!");
		mainFrame.getContentPane().add(topLabel);
		
		mainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		createAndShowGUI();
	}
}
