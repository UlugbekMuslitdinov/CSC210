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

    public Plant getElement(int raw, int col) {
        return Map[raw][col];
    }

    public void grow(int times) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (Map[i][j] != null) {
                    Map[i][j].grow(times);
                }
            }
        }
    }

    public void grow(int times, int raw, int col) {
        Map[raw][col].grow(times);
    }

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

    public void harvest(int raw, int col) {
        if (Map[raw][col] != null) {
            if (Map[raw][col].getType().equals("vegetable")) {
                Map[raw][col] = null;
            }
        }
    }

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
}