/**
 * An abstract class representing a plant in a virtual garden.
 */
public abstract class Plant {
    
    /**
     * The number of times the plant has been grown.
     */
    protected int grown;
    
    /**
     * The name of the plant.
     */
    protected String name;
    
    /**
     * The symbol used to represent the plant on the garden map.
     */
    protected char symbol;
    
    /**
     * The type of the plant.
     */
    protected String type = new String("plant");
    
    /**
     * The garden map containing the location of the plant.
     */
    protected char[][] Map = new char[5][5];
    
    /**
     * Grows the plant a specified number of times.
     *
     * @param times the number of times to grow the plant.
     */
    public abstract void grow(int times);
    
    /**
     * Places the plant in the garden map at a specified location.
     */
    public abstract void placePlant();
    
    /**
     * Creates a new plant with the specified name.
     *
     * @param name the name of the plant.
     */
    public Plant(String name) {
        this.grown = 0;
        this.name = name;
        this.symbol = name.charAt(0);
        
        // Initialize the garden map with dots.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Map[i][j] = '.';
            }
        }
    }
    
    /**
     * Prints a specified row of the garden map containing the plant.
     *
     * @param row the row to print.
     */
    public void printRow(int row) {
        for (int i = 0; i < 5; i++) {
            System.out.print(Map[row][i]);
        }
    }
    
    /**
     * Returns the name of the plant.
     *
     * @return the name of the plant.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the type of the plant.
     *
     * @return the type of the plant.
     */
    public String getType() {
        return this.type;
    }
}
