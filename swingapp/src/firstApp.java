import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class firstApp {
	public static void createAndShowGUI() {
		JFrame mainFrame = new JFrame("Swing Example");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(400, 400);
		
		JPanel mainPanel = new JPanel(null);
		JPanel widgetsPanel = new JPanel();
		widgetsPanel.setLocation(400,0);
		widgetsPanel.setSize(200,400);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ok Button clicked");
			}
		});
		
		widgetsPanel.add(okButton);
		mainPanel.add(widgetsPanel);
		JPanel graphicsPanel = new GPanel();
		graphicsPanel.setLocation(0,0);
		graphicsPanel.setSize(400,400);
		graphicsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(graphicsPanel);
		
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		createAndShowGUI();
	}
	
	private static class GPanel extends JPanel {
		public GPanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					System.out.println(e.getX() + " " + e.getY());
					Graphics g = getGraphics();
					g.setColor(Color.yellow);
					g.fillOval(e.getX(), e.getY(), 20, 20);
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			int width = getSize().width;
			int height = getSize().height;
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.WHITE);
			g.drawString("hello", 10, 200);
		}
	}
}
