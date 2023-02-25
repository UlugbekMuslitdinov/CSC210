
public abstract class Plant {
	protected int grown;
	protected String name;
	protected char symbol;
	protected char[][] Map = new char[5][5];
	
	public abstract void grow(int times);
	public abstract void placePlant();
	
	public Plant(String name) {
		this.grown = 0;
		this.name = name;
		this.symbol = name.charAt(0);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Map[i][j] = '.';
			}
		}
	}

	public void printMap() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(Map[i][j]);
			}
		}
	}

	public void printRow(int row) {
		for (int i = 0; i < 5; i++) {
			System.out.print(Map[row][i]);
		}
	}
}
