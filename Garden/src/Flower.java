/*
 * This class is a subclass of Plant. It is used to create a flower object.
 */
public class Flower extends Plant {

	/**
	 * Constructor for Flower object
	 * @param name
	 */
	public Flower(String name) {
		super(name);
		this.placePlant();
		this.type = "flower";
	}

	/**
	 * Grows the flower a specified number of times.
	 * @param times
	 */
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

	/**
	 * Places the flower in the garden map at a specified location.
	 */
	public void placePlant() {
		this.Map[2][2] = this.symbol;
	}
}
