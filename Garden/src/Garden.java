import java.util.ArrayList;
import java.util.List;

public class Garden {
	private Plant[][] Map;
	private int row;
	private int col;
	private List<String> flowerList = new ArrayList<String>();
	private List<String> treeList = new ArrayList<String>();
	private List<String> vegetableList = new ArrayList<String>();

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

	public void addToLists() {
		this.flowerList.add("Iris");
		this.flowerList.add("Lily");
		this.flowerList.add("Rose");
		this.flowerList.add("Daisy");
		this.flowerList.add("Tulip");
		this.flowerList.add("Sunflower");
		this.treeList.add("Oak");
		this.treeList.add("Willow");
		this.treeList.add("Banana");
		this.treeList.add("Coconut");
		this.treeList.add("Pine");
		this.vegetableList.add("Garlic");
		this.vegetableList.add("Zucchini");
		this.vegetableList.add("Tomato");
		this.vegetableList.add("Yam");
		this.vegetableList.add("Lettuce");
	}

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
}