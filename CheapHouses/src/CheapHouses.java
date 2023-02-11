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
 */
public class CheapHouses {
    private JButton btnSubmit;
    private String fname;
    private int priceInt;
    private static JTextField fileField;
    private static JTextField priceField;
    private GPanel graphicsPanel;
    private double maxLat;
    private double minLat;
    private double maxLong;
    private double minLong;

    public void createAndShowGUI() {
        JFrame mainFrame = new JFrame("Cheap houses");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 600);

        JPanel mainPanel = new JPanel(null);
        JPanel controlPanel = new JPanel();
        controlPanel.setLocation(0, 520);
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

        graphicsPanel = new GPanel();
        graphicsPanel.setSize(586, 500);
        graphicsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fname = fileField.getText();
                graphicsPanel.clear();
                setMinMax();
                try {
                    priceInt = Integer.parseInt(priceField.getText());
                } catch (NumberFormatException ex) {
                    System.out.println("Price must be an integer");
                    System.exit(0);
                }
                openReadFile();
            }
        });
        controlPanel.add(buttonSubmit);


        mainPanel.add(graphicsPanel);
        mainPanel.add(controlPanel);
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);
    }

    public void openReadFile() {
        File fileCont = new File(this.fname);
        try {
            Scanner fileScan = new Scanner(fileCont);
            while (fileScan.hasNextLine()) {
                System.out.println(fileScan.nextLine());
                String[] line = fileScan.nextLine().split(",");
                int price = Integer.parseInt(line[9]);
                if (price < this.priceInt) {
                    System.out.println("Price: " + price);
//                    double x = (Double.parseDouble(line[10]) - 38) * 500;
//                    double y = (Double.parseDouble(line[11]) + 122) * 500;
                    double x = (Double.parseDouble(line[10]) - minLat) * 586 / (maxLat - minLat);
                    double y = (Double.parseDouble(line[11]) - minLong) *500 / (maxLong - minLong);
                    System.out.println("X-file: " + line[10] + " Y-file: " + line[11]);
                    System.out.println("X: " + x + " Y: " + y);
                    System.out.println("MaxLat: " + maxLat + " MinLat: " + minLat + " MaxLong: " + maxLong + " MinLong: " + minLong);

                    // Draw a circle on GPanel with given x and y coordinates
                    graphicsPanel.pointHouse(x, y);
                }
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setMinMax() {
        File fileCont = new File(this.fname);
        try {
            Scanner fileScan = new Scanner(fileCont);
            // Skip first line
            fileScan.nextLine();
            minLat = Double.parseDouble(fileScan.nextLine().split(",")[10]);
            maxLat = minLat;
            minLong = Double.parseDouble(fileScan.nextLine().split(",")[11]);
            maxLong = minLong;
            while (fileScan.hasNextLine()) {
                String[] line = fileScan.nextLine().split(",");
                double lat = Double.parseDouble(line[10]);
                double lon = Double.parseDouble(line[11]);
                if (lat > maxLat) {
                    maxLat = lat;
                }
                if (lat < minLat) {
                    minLat = lat;
                }
                if (lon > maxLong) {
                    maxLong = lon;
                }
                if (lon < minLong) {
                    minLong = lon;
                }
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {
        CheapHouses houses = new CheapHouses();
        houses.createAndShowGUI();
    }

    private class GPanel extends JPanel {
        public void pointHouse(double x, double y) {
            Graphics g = getGraphics();
            g.setColor(Color.BLACK);
            System.out.println("X: " + x + " Y: " + y);
            g.fillOval((int) x, (int) y, 5, 5);
        }

        public void clear() {
            Graphics g = getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 586, 500);
        }
    }
}


