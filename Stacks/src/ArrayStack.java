public class ArrayStack implements StackInterface {
    private int[] stack;
    private int top;
    private int bottom;
    private int capacity;
    private int size;

    /*
        * Constructor
     */
    public ArrayStack() {
        this.capacity = 10;
        this.stack = new int[this.capacity];
        this.size = 0;
        this.top = 0;
        this.bottom = 0;
    }

    /**
     * Adds a value to the top of the stack
     * @param value the value to add
     * @return void
     * @complexity O(1)
     */
    public void push(int value) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.stack[this.top] = value;
        this.top = (this.top + 1) % this.capacity;
        this.size++;
    }

    /**
     * Removes a value from the top of the stack
     * @return the value removed
     * @complexity O(1)
     */
    public int pop() {
        if (this.size == 0) {
            return -1;
        }
        int value = this.stack[this.top];
        this.top = (this.top - 1) % this.capacity;
        this.size--;
        return value;
    }

    /**
     * Returns the value at the top of the stack
     * @return the value at the top of the stack
     * @complexity O(1)
     */
    public int peek() {
        if (this.size == 0) {
            return -1;
        }
        return this.stack[this.top];
    }

    /**
     * Returns true if the stack has no elements.
     * @return true if the stack has no elements
     * @complexity O(1)
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     * @complexity O(1)
     */
    public int size() {
        return this.size;
    }

    /**
     * Removes all elements from the stack.
     * @return void
     * @complexity O(1)
     */
    public void clear() {
        this.top = 0;
        this.bottom = 0;
        this.size = 0;
    }

    /**
     * Returns a string representation of the stack.
     * @return a string representation of the stack
     * @complexity O(n)
     */
    private void resize() {
        int[] newStack = new int[this.capacity * 2];
        int index = 0;
        for (int i = this.bottom; i < this.size; i++) {
            newStack[index] = this.stack[i];
            index++;
        }
        for (int i = 0; i < this.bottom; i++) {
            newStack[index] = this.stack[i];
            index++;
        }
        this.stack = newStack;
        this.bottom = 0;
    }

    /**
     * Returns a string representation of the stack.
     * @return a string representation of the stack
     * @complexity O(n)
     */
    public String toString() {
        String result = "{";
        for (int i = this.bottom; i < this.size; i++) {
            result += this.stack[i];
            if (i != this.size - 1) {
                result += ",";
            }
        }
        result += "}";
        return result;
    }

    /**
     * Returns true if the stack has no elements.
     * @param obj the object to compare
     * @return true if the stack has no elements
     * @complexity O(n)
     */
    public boolean equals(Object obj) {
        ArrayStack other = (ArrayStack) obj;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.stack[i] != other.stack[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a copy of the stack.
     * @param other the stack to copy
     * @return a copy of the stack
     * @complexity O(n)
     */
    public ArrayStack(ArrayStack other){
        this.capacity = other.capacity;
        this.stack = new int[this.capacity];
        this.size = other.size;
        this.top = other.top;
        this.bottom = other.bottom;
        for (int i = 0; i < this.size; i++) {
            this.stack[i] = other.stack[i];
        }
    }
}
