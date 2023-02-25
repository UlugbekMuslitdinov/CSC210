import java.util.ArrayList;
import java.util.List;

public class Garden {
	private Plant[][] Map;
	private int row;
	private int col;
	private List<String> flowerList = new ArrayList<String>();
	private List<String> treeList = new ArrayList<String>();
	private List<String> vegetableList = new ArrayList<String>();

	/**
	 * Constructor for a Garden object.
	 * @param row the number of rows in the Garden
	 * @param col the number of columns in the Garden
	 */
	public Garden(int row, int col) {
		Map = new Plant[row][col];
		this.addToLists();
		this.row = row;
		this.col = col;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Map[i][j] = null;
			}
		}
	}

	/**
	 * Helper method to add names of flowers, trees, and vegetables to their respective lists.
	 */
	public void addToLists() {
		this.flowerList.add("iris");
		this.flowerList.add("lily");
		this.flowerList.add("rose");
		this.flowerList.add("daisy");
		this.flowerList.add("tulip");
		this.flowerList.add("sunflower");
		this.treeList.add("oak");
		this.treeList.add("willow");
		this.treeList.add("banana");
		this.treeList.add("coconut");
		this.treeList.add("pine");
		this.vegetableList.add("garlic");
		this.vegetableList.add("zucchini");
		this.vegetableList.add("tomato");
		this.vegetableList.add("yam");
		this.vegetableList.add("lettuce");
	}

	/**
	 * Plants a new Plant object in the Garden.
	 * @param name the name of the Plant to be added
	 * @param raw the row in which the Plant will be planted
	 * @param col the column in which the Plant will be planted
	 */
	public void plant(String name, int raw, int col) {
		if (flowerList.contains(name)) {
			Plant p = new Flower(name);
			Map[raw][col] = p;
		} else if (treeList.contains(name)) {
			Plant p = new Tree(name);
			Map[raw][col] = p;
		} else if (vegetableList.contains(name)) {
			Plant p = new Vegetable(name);
			Map[raw][col] = p;
		} else {
			System.out.println("Invalid plant name");
		}
	}

	/**
	 * Prints the Garden's Map 2D array.
	 */
	public void printMap() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < col; k++) {
					if (Map[i][k] == null) {
						System.out.print(".....");
					} else {
						Map[i][k].printRow(j);
					}
				}
				System.out.println();
			}
		}
	}

	/**
	 * Retrieves a Plant object from the Garden's Map 2D array.
	 * @param raw the row in which the Plant is located
	 * @param col the column in which the Plant is located
	 * @return the Plant object at the specified location
	 */
	public Plant getElement(int raw, int col) {
		return Map[raw][col];
	}

	/**
	 * Grows all plants by specific number of times
	 * @param times
	 */
	public void grow(int times) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (Map[i][j] != null) {
					Map[i][j].grow(times);
				}
			}
		}
	}
	
	/**
	 * Grows all plants by specific number of times at specific location
	 * @param times
	 * @param raw
	 * @param col
	 */
	public void grow(int times, int raw, int col) {
		Map[raw][col].grow(times);
	}

	/**
	 * Grows all plants by specific number of times of specific name of plant
	 * @param times
	 * @param name
	 */
	public void grow(int times, String name) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (Map[i][j] != null) {
					if (Map[i][j].getName().equals(name)) {
						Map[i][j].grow(times);
					}
				}
			}
		}
	}

	/**
	 * Remove all vegetables from garden
	 */
	public void harvest() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (Map[i][j] != null) {
					if (Map[i][j].getType().equals("vegetable")) {
						Map[i][j] = null;
					}
				}
			}
		}
	}
	/**
	 * Remove all vegetables from garden at specific location
	 * @param raw
	 * @param col
	 */
	public void harvest(int raw, int col) {
		if (Map[raw][col] != null) {
			if (Map[raw][col].getType().equals("vegetable")) {
				Map[raw][col] = null;
			} else {
				System.out.println("Can't harvest there");
			}
		} else {
			System.out.println("Can't harvest there");
		}
	}

	/**
	 * Remove all vegetables with provided name from garden
	 * @param name
	 */
	public void harvest(String name) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (Map[i][j] != null) {
					if (Map[i][j].getType().equals("vegetable") && Map[i][j].getName().equals(name)) {
						Map[i][j] = null;
					}
				}
			}
		}
	}

	/**
	 * Remove all trees with provided name from garden
	 */
	public void cut() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (Map[i][j] != null) {
					if (Map[i][j].getType().equals("tree")) {
						Map[i][j] = null;
					}
				}
			}
		}
	}

	/**
	 * Remove all trees with provided name from garden at specific location
	 * @param raw
	 * @param col
	 */
	public void cut(int raw, int col) {
		if (Map[raw][col] != null) {
			if (Map[raw][col].getType().equals("tree")) {
				Map[raw][col] = null;
			} else {
				System.out.println("Can't cut there");
			}
		} else {
			System.out.println("Can't cut there");
		}
	}

	/**
	 * Remove all trees with provided name from garden
	 * @param name
	 */
	public void cut(String name) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (Map[i][j] != null) {
					if (Map[i][j].getType().equals("tree") && Map[i][j].getName().equals(name)) {
						Map[i][j] = null;
					}
				}
			}
		}
	}

	/**
	 * Remove all flowers with provided name from garden
	 */
	public void pick() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (Map[i][j] != null) {
					if (Map[i][j].getType().equals("flower")) {
						Map[i][j] = null;
					}
				}
			}
		}
	}

	/**
	 * Remove all flowers with provided name from garden at specific location
	 * @param raw
	 * @param col
	 */
	public void pick(int raw, int col) {
		if (Map[raw][col] != null) {
			if (Map[raw][col].getType().equals("flower")) {
				Map[raw][col] = null;
			} else {
				System.out.println("Can't pick there");
			}
		} else {
			System.out.println("Can't pick there");
		}
	}

	/**
	 * Remove all flowers with provided name from garden
	 * @param name
	 */
	public void pick(String name) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (Map[i][j] != null) {
					if (Map[i][j].getType().equals("flower") && Map[i][j].getName().equals(name)) {
						Map[i][j] = null;
					}
				}
			}
		}
	}
}