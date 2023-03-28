public class DynamicArray {
	
	private Integer[] array;
	private int size;
	private int cap;

	/**
	 * Constructor
	 */
	public DynamicArray() {
		this.cap = 5;
		this.size = 0;
		this.array = new Integer[this.cap];
	}

	/**
	 * Resizes the array
	 * @return void
	 * @complexity O(n)
	 */
	public void resize() {
		this.cap = this.cap + 5;
		Integer[] newArr = new Integer[this.cap];
		for (int i=0; i<this.size; i++) {
			newArr[i] = this.array[i];
		}
		this.array = newArr;
	}

	/**
	 * Adds an element to the array
	 * @param element
	 * @return void
	 * @complexity O(1)
	 */
	public void add(int element) {
		if (this.size == this.cap) {
			this.resize();
		}
		int place = this.size;
		this.array[place] = element;
	}

	/**
	 * Returns the size of the array
	 * @param index
	 * @return the size of the array
	 * @complexity O(1)
	 */
	public int get(int index) {
		int item = (int)this.array[index];
		return item;
	}

	/**
	 * Returns the size of the array
	 * @param index
	 * @return the size of the array
	 * @complexity O(1)
	 */
	public void remove(int index) {
		for (int i=index; i<this.size-1; i++) {
			this.array[i] = this.array[i+1];
		}
		this.array[this.size-1] = null;
	}

	/**
	 * Returns the size of the array
	 * @return the size of the array
	 * @complexity O(1)
	 */
	public String toString() {
		String result = "{";
		for (int i=0; i<this.size; i++) {
			result += this.array[i];
			if (i != this.size-1) {
				result += ",";
			}
		}
		result += "}";
		return result;
	}

	/**
	 * Returns true if the array is equal to the other array
	 * @param obj the other array
	 * @return true if the array is equal to the other array
	 * @complexity O(n)
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		DynamicArray other = (DynamicArray)obj;
		if (this.size != other.size) {
			return false;
		}
		for (int i=0; i<this.size; i++) {
			if (this.array[i] != other.array[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns a copy of the array
	 * @param other the other array
	 * @return a copy of the array
	 * @complexity O(n)
	 */
	public DynamicArray(DynamicArray other) {
		this.size = other.size;
		this.cap = other.cap;
		this.array = new Integer[this.cap];
		for (int i=0; i<this.size; i++) {
			this.array[i] = other.array[i];
		}
	}
}
