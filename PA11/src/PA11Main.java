/**
 * PA11Main.java
 * @author: Ulugbek Muslitdinov
 * @class: CSC210 Spring 2023
 */

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class is the main class that reads the file and calls the heuristic and
 * backtracking methods from DGraph.java
 * It accepts two command line arguments: the name of the file and the command
 * (HEURISTIC or BACKTRACK)
 */
public class PA11Main {

    public static void main(String[] args) {
        int nodes;
        List<Integer> path = new ArrayList<>();
        String fileName = args[0];
        String command = args[1];
        DGraph dg = new DGraph(); // create a new DGraph object

        // read the file
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            boolean firstLine = false;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.charAt(0) != '%') {
                    if (firstLine == false) { // read the first line
                        String[] items = line.split("\\s+");
                        if (items.length == 3) {
                            nodes = Integer.parseInt(items[1]);
                            for (int i = 1; i <= nodes; i++) {
                                path.add(i);
                            }
                            firstLine = true;
                        }
                    } else {
                        String[] items = line.split("\\s+");
                        if (items.length == 3) {
                            int u = Integer.parseInt(items[0]);
                            int v = Integer.parseInt(items[1]);
                            double w = Double.parseDouble(items[2]);
                            dg.addEdge(u, v, w);
                        }
                    }
                }
            }
            fileReader.close();

            // call the heuristic or backtracking method
            if (command.equals("HEURISTIC")) {
                dg.heuristic(1);
            }
            if (command.equals("BACKTRACK")) {
                dg.backtracking(1);
            }
            if (command.equals("OWN")) {
                dg.own_method(1);
            }
            if (command.equals("TIME")) {
                dg.timing(1);
            }

            // if file not found, print "File not found"
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
