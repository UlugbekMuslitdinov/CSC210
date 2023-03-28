public class ListQueue implements QueueInterface {
    private Node front;
    private Node back;
    private int size;

    /**
     * Constructor
     */
    public ListQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    /**
     * This method adds a new node to the back of the queue
     * @param value the value of the new node
     * @return void
     * @complexity O(1)
     */
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (this.size == 0) {
            this.front = newNode;
            this.back = newNode;
        } else {
            this.back.setNextNode(newNode);
            this.back = newNode;
        }
        this.size++;
    }

    /**
     * This method removes the front node from the queue
     * @param none
     * @return the value of the removed node
     * @complexity O(1)
     */
    public int dequeue() {
        if (this.size == 0) {
            return -1;
        }
        int value = this.front.getValue();
        this.front = this.front.getNextNode();
        this.size--;
        return value;
    }

    /**
     * This method returns the value of the front node
     * @param none
     * @return the value of the front node
     * @complexity O(1)
     */
    public int peek() {
        if (this.size == 0) {
            return -1;
        }
        return this.front.getValue();
    }

    /**
     * This method returns true if the queue is empty
     * @param none
     * @return true if the queue is empty, false otherwise
     * @complexity O(1)
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * This method returns the size of the queue
     * @param none
     * @return the size of the queue
     * @complexity O(1)
     */
    public int size() {
        return this.size;
    }

    /**
     * This method clears the queue
     * @param none
     * @return void
     * @complexity O(1)
     */
    public void clear() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    /**
     * This method returns a string representation of the queue
     * @param none
     * @return a string representation of the queue
     * @complexity O(n)
     */
    public String toString() {
        String result = "{";
        Node currentNode = this.front;
        while (currentNode != null) {
            result += currentNode.getValue();
            if (currentNode.getNextNode() != null) {
                result += ",";
            }
            currentNode = currentNode.getNextNode();
        }
        result += "}";
        return result;
    }

    /**
     * This method returns a hash code for the queue
     * @param none
     * @return true if the queue is equal to the other queue, false otherwise
     * @complexity O(n)
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ListQueue otherQueue = (ListQueue) other;
        if (this.size != otherQueue.size) {
            return false;
        }
        Node currentNode = this.front;
        Node otherCurrentNode = otherQueue.front;
        while (currentNode != null) {
            if (currentNode.getValue() != otherCurrentNode.getValue()) {
                return false;
            }
            currentNode = currentNode.getNextNode();
            otherCurrentNode = otherCurrentNode.getNextNode();
        }
        return true;
    }

    /**
     * This method returns a hash code for the queue
     * @param none
     * @complexity O(n)
     */
    public ListQueue(ListQueue other) {
        if (other == null) {
            return;
        }
        if (other.size == 0) {
            this.front = null;
            this.back = null;
            this.size = 0;
        } else {
            Node currentNode = other.front;
            while (currentNode != null) {
                this.enqueue(currentNode.getValue());
                currentNode = currentNode.getNextNode();
            }
        }
    }
}
