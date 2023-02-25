
public class Vegetable extends Plant{	
	public Vegetable(String name) {
		super(name);
		this.placePlant();
		this.type = "vegetable";
	}
	
	public void grow(int times) {
		this.grown += times;
		// Grow from top to bottom
		for (int i = 0; i < this.grown; i++) {
			this.Map[i][2] = this.symbol;
		}
	}
	
	public void placePlant() {
		this.Map[0][2] = this.symbol;
	}
}
