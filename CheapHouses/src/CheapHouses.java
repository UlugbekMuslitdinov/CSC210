import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

import java.util.Scanner;

/**
 * 
 */

/**
 * @author User
 *
 */
public class CheapHouses{
	private JButton btnSubmit;
	private String fname;
	private int priceInt;
	private static JTextField fileField;
	private static JTextField priceField;
	
	public void createAndShowGUI() {
		JFrame mainFrame = new JFrame("Cheap houses");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(600, 600);
		
		JPanel mainPanel = new JPanel(null);
		JPanel controlPanel = new JPanel();
		controlPanel.setLocation(0,520);
		controlPanel.setSize(586, 43);
		controlPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel fileLabel = new JLabel("File:");
		controlPanel.add(fileLabel);
		
		fileField = new JTextField();
		controlPanel.add(fileField);
		fileField.setColumns(10);
		
		JLabel priceLabel = new JLabel("Price:");
		controlPanel.add(priceLabel);
		
		priceField = new JTextField();
		controlPanel.add(priceField);
		priceField.setColumns(10);
		
		GPanel graphicsPanel = new GPanel();
		graphicsPanel.setSize(586, 500);
		graphicsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fname = fileField.getText();
				priceInt = Integer.parseInt(priceField.getText());
				openReadFile();
			}
		});
		controlPanel.add(buttonSubmit);

		
		mainPanel.add(graphicsPanel);
		mainPanel.add(controlPanel);
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.setVisible(true);
	}
	
	public void openReadFile () {
		File fileCont = new File(this.fname);
		try {
			Scanner fileScan = new Scanner(fileCont);
			while (fileScan.hasNextLine()) {
				System.out.println(fileScan.nextLine());
				String[] line = fileScan.nextLine().split(",");
				int price = Integer.parseInt(line[9]);
				if (price < this.priceInt) {
					System.out.println("Price: " + price);
					double x = Double.parseDouble(line[10]);
					double y = Double.parseDouble(line[11]);
					System.out.println("X: " + x + " Y: " + y);
				}
			}
			fileScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CheapHouses houses = new CheapHouses();
		houses.createAndShowGUI();
	}
	
	private class GPanel extends JPanel {
		// Draw a circle on GPanel with given x and y coordinates
		public void paintComponent(Graphics g, int x, int y) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillOval(x, y, 10, 10);
		}
	}
}


