/**
 * This is the main class for the Garden project. It reads the input file and
 * calls the appropriate methods in the Garden class.
 *
 * @author Ulugbek Muslitdinov
 * @class CSC 210
 * @date 02/24/2023
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PA3Main {
	/**
	 * Scanner object for reading input from console.
	 */
	static Scanner input = new Scanner(System.in);

	/**
	 * The main method of the program. It reads the input file and calls the appropriate
	 * methods in the Garden class.
	 *
	 * @param args command line arguments passed to the program (not used in this program).
	 */
	public static void main(String[] args) {
	    try {
	        // Read the name of the input file from the console
	        String filename = input.nextLine();

	        // Create a Scanner object to read the input file
	        Scanner file = new Scanner(new File(filename));

	        // Line 1 is the number of rows and line 2 is the number of columns
	        int rows = Integer.parseInt(file.nextLine().split(" ")[1]);
	        int cols = Integer.parseInt(file.nextLine().split(" ")[1]);

	        // Check if there are too many columns
	        if (cols > 16) {
	            System.out.println("Too many columns");
	            return;
	        }

	        // Create a new Garden object
	        Garden garden = new Garden(rows, cols);

	        // Read the input file line by line
	        while (file.hasNextLine()) {
	            String line = file.nextLine();
	            String command = line.split(" ")[0].toLowerCase();

	            // Plant command
	            if (command.equals("plant")) {
	                String position = line.split(" ")[1];
	                String name = line.split(" ")[2].toLowerCase();

	                // Parse the row and column from the position string
	                int row = Character.getNumericValue(position.split(",")[0].charAt(1));
	                int col = Character.getNumericValue(position.split(",")[1].charAt(0));
	                
	                if (row >= rows || col >= cols) {
	                    System.out.println("Can't plant there");
	                    continue;
	                } else if (garden.getElement(row, col) != null) {
	                    System.out.println("Can't plant there");
	                    continue;
	                } else {
	                    // Plant the given plant at the specified position
	                    garden.plant(name, row, col);
	                }
	            }

	            // Grow command
	            else if (command.equals("grow")) {
	                int times = Integer.parseInt(line.split(" ")[1]);

	                if (line.split(" ").length == 3) {
	                    // Third element can be either a plant name or a position
	                    String nameOrPosition = line.split(" ")[2].toLowerCase();

	                    if (nameOrPosition.contains(",")) {
	                        // It's a position
	                        int row = Character.getNumericValue(nameOrPosition.split(",")[0].charAt(1));
	                        int col = Character.getNumericValue(nameOrPosition.split(",")[1].charAt(0));

	                        // Check if the position is outside of the garden or there is no plant at the position
	                        if (row >= rows || col >= cols || garden.getElement(row, col) == null) {
	                            System.out.println("Can't grow there");
	                            continue;
	                        } else {
	                            // Grow the plant at the specified position
	                            garden.grow(times, row, col);
	                        }
	                    } else {
	                        // It's a plant name
	                        garden.grow(times, nameOrPosition);
	                    }
	                } else {
	                    // Grow all plants in the garden
	                    garden.grow(times);
	                }
	            }

	            // Print command
	            else if (command.equals("print")) {
	                // Print the current state of the garden
	                garden.printMap();
	            } else if (command.equals("harvest") || command.equals("cut") || command.equals("pick")) {
                    if (line.split(" ").length == 1) {
                        if (command.equals("cut"))
                            garden.cut();
                        else if (command.equals("pick"))
                            garden.pick();
                        else if (command.equals("harvest")) {
                            garden.harvest();
                        }
                    } else {
                        String nameOrPosition = line.split(" ")[1].toLowerCase();
                        if (nameOrPosition.contains(",")) {
                            // It's a position
                            int row = Character.getNumericValue(nameOrPosition.split(",")[0].charAt(1));
                            int col = Character.getNumericValue(nameOrPosition.split(",")[1].charAt(0));
                            // if outside of the garden
                            if (row >= rows || col >= cols) {
                                System.out.println("Can't harvest there");
                                continue;
                            } else if (garden.getElement(row, col) == null) {
                                System.out.println("Can't harvest there");
                                continue;
                            } else {
                                if (command.equals("cut"))
                                    garden.cut(row, col);
                                else if (command.equals("pick"))
                                    garden.pick(row, col);
                                else if (command.equals("harvest")) {
                                    garden.harvest(row, col);
                                }
                            }
                        } else {
                            // It's a plant name
                            if (command.equals("cut"))
                                garden.cut(nameOrPosition);
                            else if (command.equals("pick"))
                                garden.pick(nameOrPosition);
                            else if (command.equals("harvest")) {
                                garden.harvest(nameOrPosition);
                            }
                        }
                    }
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
