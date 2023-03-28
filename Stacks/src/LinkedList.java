public class LinkedList {
	private Node head;

	/**
	 * This method inserts a new node at the head of the list
	 *
	 * @param value the value of the new node
	 * @return void
	 * @complexity O(1)
	 */
	public void insert(int value) {
		Node newNode = new Node(value);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	/**
	 * This method removes the head node from the list
	 *
	 * @param none
	 * @return void
	 * @complexity O(1)
	 */
	public void delete() {
		if (this.head == null) {
			return;
		}
		this.head = this.head.getNextNode();
	}

	/**
	 * This method returns the value of the head node
	 *
	 * @param none
	 * @return the value of the head node
	 * @complexity O(1)
	 */
	public String toString() {
		String result = "{";
		Node current = this.head;
		while (current != null) {
			result += current.getValue();
			if (current.getNextNode() != null) {
				result += ",";
			}
			current = current.getNextNode();
		}
		result += "}";
		return result;
	}

	/**
	 * This method returns the value of the head node
	 *
	 * @param none
	 * @return the value of the head node
	 * @complexity O(1)
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof LinkedList)) {
			return false;
		}
		LinkedList other = (LinkedList) obj;
		Node current = this.head;
		Node otherCurrent = other.head;
		while (current != null && otherCurrent != null) {
			if (current.getValue() != otherCurrent.getValue()) {
				return false;
			}
			current = current.getNextNode();
			otherCurrent = otherCurrent.getNextNode();
		}
		if (current != null || otherCurrent != null) {
			return false;
		}
		return true;
	}

	/**
	 * This method returns the value of the head node
	 *
	 * @param none
	 * @return the value of the head node
	 * @complexity O(1)
	 */
	public LinkedList() {
		this.head = null;
	};

	/**
	 * This method returns the value of the head node
	 *
	 * @param none
	 * @return the value of the head node
	 * @complexity O(1)
	 */
	public LinkedList(LinkedList other) {
		if (other == null) {
			return;
		}
		Node current = other.head;
		while (current != null) {
			this.insert(current.getValue());
			current = current.getNextNode();
		}
	}
}

class Node {
	private int value;
	private Node nextNode;

	/**
	 * This method creates a new node with the given value
	 *
	 * @param value the value of the new node
	 * @return void
	 * @complexity O(1)
	 */
	public Node(int value) {
		this.value = value;
	}

	/**
	 * This method returns the value of the node
	 *
	 * @param none
	 * @return the value of the node
	 * @complexity O(1)
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * This method sets the value of the node
	 *
	 * @param value the new value of the node
	 * @return void
	 * @complexity O(1)
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * This method returns the next node in the list
	 *
	 * @param none
	 * @return the next node in the list
	 * @complexity O(1)
	 */
	public Node getNextNode() {
		return this.nextNode;
	}

	/**
	 * This method sets the next node in the list
	 *
	 * @param nextNode the next node in the list
	 * @return void
	 * @complexity O(1)
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	/**
	 * This method creates a new node with the same value as the given node
	 *
	 * @param other the node to copy
	 * @return void
	 * @complexity O(1)
	 */
	public Node(Node other) {
		this.value = other.value;
		this.nextNode = other.nextNode;
	}

	/**
	 * This method returns the value of the node as a string
	 *
	 * @param none
	 * @return the value of the node as a string
	 * @complexity O(1)
	 */
	public String toString() {
		return String.valueOf(this.value);
	}
}
