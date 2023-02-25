public class Tree extends Plant {
	
	
	public Tree(String name) {
		super(name);
		this.placePlant();
	}
	
	public void grow(int times) {
		this.grown += times;
		for (int i = 0; i < this.grown; i++) {
			this.Map[4][i] = this.symbol;
		}
	}
	
	public void placePlant() {
		this.Map[4][2] = this.symbol;
	}
}
