public class Tree extends Plant {
	
	
	public Tree(String name) {
		super(name);
		this.placePlant();
		this.type = "tree";
	}
	
	public void grow(int times) {
		this.grown += times;
		for (int i = 4; i > 3-this.grown; i--) {
			this.Map[i][2] = this.symbol;
		}
	}
	
	public void placePlant() {
		this.Map[4][2] = this.symbol;
	}
}
