/**
 * A priority queue of patients.  Patients with higher priority are
 * dequeued before patients with lower priority.  If two patients have
 * the same priority, they are dequeued in alphabetical order.
 *
 * @author Ulugbek Muslitdinov
 * @class CSC210
 */
public class PatientQueue {
    /**
     * The underlying heap.
     */
    private Heap heap;

    /**
     * PatientQueue constructor.
     * Creates a new empty priority queue.
     */
    public PatientQueue() {
        heap = new Heap();
    }

    /**
     * Adds a patient to the queue.
     *
     * @param value The patient to add.
     */
    public void enqueue(Patient value) {
        heap.enqueue(value);
    }

    /**
     * Adds a patient to the queue.
     *
     * @param name The name of the patient.
     * @param priority The priority of the patient.
     */
    public void enqueue(String name, int priority) {
        Patient p = new Patient(name, priority);
        heap.enqueue(p);
    }

    /**
     * Removes the patient with the highest priority from the queue.
     *
     * @return The patient name with the highest priority.
     * @throws Exception if the queue is empty.
     */
    public String dequeue() throws Exception{
        return heap.dequeue();
    }

    /**
     * Returns the patient name with the highest priority.
     *
     * @return The patient name with the highest priority.
     * @throws Exception if the queue is empty.
     */
    public String peek() throws Exception
    {
        return heap.peek();
    }

    /**
     * Returns the priority of the patient with the highest priority.
     *
     * @return The priority of the patient with the highest priority.
     * @throws Exception if the queue is empty.
     */
    public int peekPriority() throws Exception
    {
        return heap.peekPriority();
    }

    /**
     * Changes the priority of a patient.
     *
     * @param name The name of the patient.
     * @param priority The new priority of the patient.
     */
    public void changePriority(String name, int priority) {
        heap.changePriority(name, priority);
    }

    /**
     * Returns true if the queue is empty.
     *
     * @return boolean True if the queue is empty.
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Returns the number of patients in the queue.
     *
     * @return size The number of patients in the queue.
     */
    public int size() {
        return heap.size();
    }


    /**
     * Removes all patients from the queue.
     */
    public void clear() {
        heap.clear();
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return String A string representation of the queue.
     */
    public String toString() {
        return heap.toString();
    }
}

class Heap
{
    private Patient[] heap;
    private int size;

    /**
     * Heap constructor.
     * Creates a new empty heap.
     */
    public Heap() {
        heap = new Patient[10];
        size = 0;
    }

    /**
     * Compares two patients.
     * @param a The first patient.
     * @param b The second patient.
     * @return boolean True if a has higher priority than b.
     */
    private boolean compare(Patient a, Patient b) {
        if (a.priority < b.priority) {
            return true;
        } else if (a.priority == b.priority) {
            return a.name.compareTo(b.name) < 0;
        } else {
            return false;
        }
    }

    /**
     * Returns the index of the parent of the node at index i.
     * @param i The index of the node.
     * @return int The index of the parent of the node at index i.
     */
    private int parent(int i) {return i/2;}

    /**
     * Returns the index of the left child of the node at index i.
     * @param i The index of the node.
     * @return int The index of the left child of the node at index i.
     */
    private int left(int i) {return 2*i;}

    /**
     * Returns the index of the right child of the node at index i.
     * @param i The index of the node.
     * @return int The index of the right child of the node at index i.
     */
    private int right(int i) {return 2*i+1;}

    /**
     * bubbles up the node at index i.
     * @param i The index of the node.
     */
    private void bubbleUp(int i) {
        if (i > 1) {
            if (compare(heap[i], heap[parent(i)])) {
                Patient temp = heap[parent(i)];
                heap[parent(i)] = heap[i];
                heap[i] = temp;
                bubbleUp(parent(i));
            }
        }
    }

    /**
     * bubbles down the node at index i.
     * @param i The index of the node.
     */
    private void bubbleDown(int i) {
        if (left(i) <= size) {
            int higherPriorityChild = left(i);
            if (right(i) <= size && compare(heap[right(i)], heap[left(i)])) {
                higherPriorityChild = right(i);
            }
            if (compare(heap[higherPriorityChild], heap[i])) {
                Patient temp = heap[higherPriorityChild];
                heap[higherPriorityChild] = heap[i];
                heap[i] = temp;
                bubbleDown(higherPriorityChild);
            }
        }
    }

    /**
     * Adds a patient to the heap.
     *
     * @param value The patient to add.
     */
    public void enqueue(Patient value) {
        if (size == heap.length - 1) {
            Patient[] temp = new Patient[heap.length * 2];
            for (int i = 1; i < heap.length; i++) {
                temp[i] = heap[i];
            }
            heap = temp;
        }
        size++;
        heap[size] = value;
        bubbleUp(size);
    }

    /**
     * Removes the patient with the highest priority from the heap.
     *
     * @return The patient name with the highest priority.
     * @throws Exception if the heap is empty.
     */
    public String dequeue() throws Exception{
        if (size == 0) {
            throw new Exception();
        }
        String result = heap[1].name;
        heap[1] = heap[size];
        size--;
        bubbleDown(1);
        return result;
    }

    /**
     * Returns the patient name with the highest priority.
     *
     * @return String The patient name with the highest priority.
     * @throws Exception if the heap is empty.
     */
    public String peek() throws Exception{
        if (size == 0) {
            throw new Exception();
        }
        return heap[1].name;
    }

    /**
     * Returns the priority of the patient with the highest priority.
     *
     * @return int The priority of the patient with the highest priority.
     * @throws Exception if the heap is empty.
     */
    public int peekPriority() throws Exception{
        if (size == 0) {
            throw new Exception();
        }
        return heap[1].priority;
    }

    /**
     * Changes the priority of the patient with the given name.
     *
     * @param name The name of the patient.
     * @param priority The new priority of the patient.
     */
    public void changePriority(String name, int priority) {
        for (int i = 1; i <= size; i++) {
            if (heap[i].name.equals(name)) {
                heap[i].priority = priority;
                if (i > 1 && compare(heap[i], heap[parent(i)])) {
                    bubbleUp(i);
                } else {
                    bubbleDown(i);
                }
                return;
            }
        }
    }

    /**
     * Returns true if the heap is empty.
     *
     * @return boolean True if the heap is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all patients from the heap.
     */
    public void clear() {
        size = 0;
        heap = new Patient[10];
    }

    /**
     * Returns the number of patients in the heap.
     *
     * @return int The number of patients in the heap.
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of the heap.
     *
     * @return String A string representation of the heap.
     */
    public String toString() {
        String result = "{";
        for (int i = 1; i <= size; i++) {
            result += heap[i].toString();
            if (i < size) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }
}