/**
 * 
 * @author Ulugbek Muslitdinov
 * class CSC210 SP23
 *
 */
public class ListStack implements StackInterface {
    private Node top;
    private int size;

    /*
     * Constructor
     */
    public ListStack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * This method adds a new node to the top of the stack
     * @param value the value of the new node
     * @return void
     * @complexity O(1)
     **/
    public void push(int value) {
        Node newNode = new Node(value);
        if (this.size == 0) {
            this.top = newNode;
        } else {
            newNode.setNextNode(this.top);
            this.top = newNode;
        }
        this.size++;
    }

    /**
     * This method removes the top node from the stack
     * @param none
     * @return the value of the removed node
     * @complexity O(1)
     **/
    public int pop() {
        if (this.size == 0) {
            return -1;
        }
        int value = this.top.getValue();
        this.top = this.top.getNextNode();
        this.size--;
        return value;
    }

    /**
     * This method returns the value of the top node
     * @param none
     * @return the value of the top node
     * @complexity O(1)
     **/
    public int peek() {
        if (this.size == 0) {
            return -1;
        }
        return this.top.getValue();
    }

    /**
    * This method checks if the stack is empty
    * @param none
    * @return true if the stack is empty, false otherwise
    * @complexity O(1)
     **/
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * This method returns the size of the stack
     * @param none
     * @return the size of the stack
     * @complexity O(1)
     **/
    public int size() {
        return this.size;
    }

    /**
     * This method removes all the nodes from the stack
     * @param none
     * @return void
     * @complexity O(1)
     **/
    public void clear() {
        this.top = null;
        this.size = 0;
    }

    /**
     * This method returns a string representation of the stack
     * @param none
     * @return a string representation of the stack
     * @complexity O(n)
     **/
    public String toString() {
        String result = "{";
        Node currentNode = this.top;
        while (currentNode != null) {
            result += currentNode.getValue();
            if (currentNode.getNextNode() != null) {
                result += ", ";
            }
            currentNode = currentNode.getNextNode();
        }
        result += "}";
        return result;
    }

    /**
     * This method checks if the stack is equal to another stack
     * @param obj the other stack
     * @return true if the stacks are equal, false otherwise
     * @complexity O(n)
     **/
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ListStack otherStack = (ListStack) obj;
        if (this.size != otherStack.size) {
            return false;
        }
        Node currentNode = this.top;
        Node otherCurrentNode = otherStack.top;
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
     * This method returns a copy of the stack
     * @param none
     * @return a copy of the stack
     * @complexity O(n)
     **/
    public ListStack(ListStack other) {
        if (other.size == 0) {
            this.top = null;
            this.size = 0;
        } else {
            Node currentNode = other.top;
            Node newTop = new Node(currentNode.getValue());
            this.top = newTop;
            this.size = 1;
            currentNode = currentNode.getNextNode();
            while (currentNode != null) {
                Node newNode = new Node(currentNode.getValue());
                newNode.setNextNode(this.top);
                this.top = newNode;
                this.size++;
                currentNode = currentNode.getNextNode();
            }
        }
    }
}
