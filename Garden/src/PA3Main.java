import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PA3Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            String filename = input.nextLine();
            Scanner file = new Scanner(new File(filename));
            // Line 1 is the number of rows and line 2 is the number of columns
            int rows = Integer.parseInt(file.nextLine().split(" ")[1]);
            int cols = Integer.parseInt(file.nextLine().split(" ")[1]);
            if (cols > 16) {
                System.out.println("Too many columns");
                return;
            }
            Garden garden = new Garden(rows, cols);
            System.out.println(rows + " " + cols);


            while (file.hasNextLine()) {
                String line = file.nextLine();
                String command = line.split(" ")[0].toLowerCase();

                if (command.equals("plant")) {
                    String position = line.split(" ")[1];
                    String name = line.split(" ")[2].toLowerCase();
                    int row = Character.getNumericValue(position.split(",")[0].charAt(1));
                    int col = Character.getNumericValue(position.split(",")[1].charAt(0));
                    System.out.println("Planting " + name + " at (" + row + ", " + col + ")");
                    garden.plant(name, row, col);
                } else if (command.equals("grow")) {
                    int times = Integer.parseInt(line.split(" ")[1]);
                    if (line.split(" ").length == 3) {
                        // Third element can be either a plant name or a position
                        String nameOrPosition = line.split(" ")[2].toLowerCase();
                        if (nameOrPosition.contains(",")) {
                            // It's a position
                            int row = Character.getNumericValue(nameOrPosition.split(",")[0].charAt(1));
                            int col = Character.getNumericValue(nameOrPosition.split(",")[1].charAt(0));
                            // if outside of the garden
                            if (row >= rows || col >= cols) {
                                System.out.println("Can't grow there");
                                continue;
                            } else if (garden.getElement(row, col) == null) {
                                System.out.println("Can't grow there");
                                continue;
                            } else {
                                System.out.println("Growing " + times + " times at (" + row + ", " + col + ")");
                                garden.grow(times, row, col);
                            }
                        } else {
                            // It's a plant name
                            System.out.println("Growing " + times + " times " + nameOrPosition);
                            garden.grow(times, nameOrPosition);
                        }
                    } else {
                        System.out.println("Growing " + times + " times");
                        garden.grow(times);
                    }
                } else if (command.equals("print")) {
                    garden.printMap();
                } else if (command.equals("harvest")) {
                    if (line.split(" ").length == 1) {
                        System.out.println("Harvesting all plants");
                        garden.harvest();
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
                                System.out.println("Harvesting at (" + row + ", " + col + ")");
                                garden.harvest(row, col);
                            }
                        } else {
                            // It's a plant name
                            System.out.println("Harvesting " + nameOrPosition);
                            garden.harvest(nameOrPosition);
                        }
                    }
                }
            }
            file.close();
            garden.printMap();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
