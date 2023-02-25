/**
 * This class is a subclass of Plant
 */
public class Vegetable extends Plant{
	/**
	 * Constructor for Vegetable object
	 * @param name
	 */
	public Vegetable(String name) {
		super(name);
		this.placePlant();
		this.type = "vegetable";
	}

	/**
	 * Grows the vegetable a specified number of times.
	 * @param times
	 */
	public void grow(int times) {
		this.grown += times;
		// Grow from top to bottom
		for (int i = 0; i < this.grown; i++) {
			this.Map[i][2] = this.symbol;
		}
	}

	/**
	 * Places the vegetable in the garden map at a specified location.
	 */
	public void placePlant() {
		this.Map[0][2] = this.symbol;
	}
}
