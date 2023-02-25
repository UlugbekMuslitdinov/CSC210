/**
 * 
 * This class is a subclass of Plant. It is used to create a tree object.
 *
 */
public class Tree extends Plant {

	/**
	 * Constructor for Tree object
	 * @param name
	 */
	public Tree(String name) {
		super(name);
		this.placePlant();
		this.type = "tree";
	}

	/**
	 * Grows the tree a specified number of times.
	 * @param times
	 */
	public void grow(int times) {
		this.grown += times;
		for (int i = 4; i > 3-this.grown; i--) {
			this.Map[i][2] = this.symbol;
		}
	}

	/**
	 * Places the tree in the garden map at a specified location.
	 */
	public void placePlant() {
		this.Map[4][2] = this.symbol;
	}
}
