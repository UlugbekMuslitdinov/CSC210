public class ArrayQueue implements QueueInterface{
    private int[] queue;
    private int front;
    private int back;
    private int size;
    private int capacity;

    /*
        * Constructor
     */
    public ArrayQueue() {
        this.capacity = 10;
        this.queue = new int[this.capacity];
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }

    /*
        * Adds a value to the back of the queue
        * @param value the value to add
        * @return void
        * @complexity O(1)
     */
    public void enqueue(int value) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.queue[this.back] = value;
        this.back = (this.back + 1) % this.capacity;
        this.size++;
    }

    /*
        * Removes a value from the front of the queue
        * @return the value removed
        * @complexity O(1)
     */
    public int dequeue() {
        if (this.size == 0) {
            return -1;
        }
        int value = this.queue[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return value;
    }

    /*
        * Returns the value at the front of the queue
        * @return the value at the front of the queue
        * @complexity O(1)
     */
    public int peek() {
        if (this.size == 0) {
            return -1;
        }
        return this.queue[this.front];
    }

    /*
        * Returns true if the queue is empty
        * @return true if the queue is empty
        * @complexity O(1)
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /*
        * Returns the size of the queue
        * @return the size of the queue
        * @complexity O(1)
     */
    public int size() {
        return this.size;
    }

    /*
        * Clears the queue
        * @return void
        * @complexity O(1)
     */
    public void clear() {
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }

    /*
        * Resizes the queue
        * @return void
        * @complexity O(n)
     */
    private void resize() {
        int[] newQueue = new int[this.capacity * 2];
        int index = 0;
        for (int i = this.front; i < this.size; i++) {
            newQueue[index] = this.queue[i];
            index++;
        }
        for (int i = 0; i < this.front; i++) {
            newQueue[index] = this.queue[i];
            index++;
        }
        this.queue = newQueue;
        this.front = 0;
        this.back = this.size;
        this.capacity *= 2;
    }

    /*
        * Returns a string representation of the queue
        * @return a string representation of the queue
        * @complexity O(n)
     */
    public String toString() {
        String result = "{";
        for (int i = this.front; i < this.size; i++) {
            result += this.queue[i];
            if (i != this.size - 1) {
                result += ",";
            }
        }
        for (int i = 0; i < this.front; i++) {
            result += this.queue[i];
            if (i != this.front - 1) {
                result += ",";
            }
        }
        result += "}";
        return result;
    }

    /*
        * Returns true if the queue is equal to the other queue
        * @param obj the other queue
        * @return true if the queue is equal to the other queue
        * @complexity O(n)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ArrayQueue other = (ArrayQueue) obj;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.queue[i] != other.queue[i]) {
                return false;
            }
        }
        return true;
    }

    /*
        * Returns a copy of the queue
        * @return a copy of the queue
        * @complexity O(n)
     */
    public ArrayQueue(ArrayQueue other) {
        this.capacity = other.capacity;
        this.queue = new int[this.capacity];
        this.front = other.front;
        this.back = other.back;
        this.size = other.size;
        for (int i = 0; i < this.size; i++) {
            this.queue[i] = other.queue[i];
        }
    }
}
