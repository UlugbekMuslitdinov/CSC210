public class LinkedList {

    private Node head;
    private Node tail;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

//    public static void main(String[] args) {
//    	Queue<Integer> queue = new LinkedList<Integer>();
//    	for (int i = 1; i <= 6; i++) {
//    	queue.add(i);
//    	}
//    	for (int i = 0; i < queue.size(); i++) {
//    	System.out.print(queue.remove() + " ");
//    	}
//    	System.out.print(queue);
//    	System.out.println(“ size “ + queue.size());
//    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeTail() {
        if (head == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
    }
}