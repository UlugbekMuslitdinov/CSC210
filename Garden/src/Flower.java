public class Flower extends Plant {
	
	
	public Flower(String name) {
		super(name);
		this.placePlant();
	}
	
	public void grow(int times) {
		this.grown += times;
		int vBottom = 2 - this.grown;
		int vTop = 2 + this.grown;
		int hLeft = 2 - this.grown;
		int hRight = 2 + this.grown;
		if (vBottom < 0) {
			vBottom = 0;
			vTop = 4;
			hLeft = 0;
			hRight = 4;
		}
		for (int i = vBottom; i <= vTop; i++) {
			this.Map[i][2] = this.symbol;
		}
		for (int i = hLeft; i <= hRight; i++) {
			this.Map[2][i] = this.symbol;
		}
	}
	
	public void placePlant() {
		this.Map[2][2] = this.symbol;
	}
}
