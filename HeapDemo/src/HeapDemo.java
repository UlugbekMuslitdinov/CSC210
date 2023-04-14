
public class HeapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Heap<E extends Comparable<E>>
{
	private java.util.ArrayList<E> heap;
	private int size;
	
	public Heap()
	{
		heap = new java.util.ArrayList<>();
		heap.add(null);
		size = 0;
	}
	
	private boolean compare(E a, E b) {return ((Comparable<E>a).compareTo(b) < 0);}
	
	private int parent(int i) {return i/2;}
	private int left(int i) {return 2*i;}
	private int right(int i) {return 2*i + 1;}
	
	private void bubbleUp(int i) {
		if (i > 1) {
			if (compare(heap.get(i), heap.get(parent(i)))) {
				E e = heap.get(parent(i));
				heap.set(parent(i), heap.get(i));
				heap.set(i, e);
				bubbleUp(parent(i));
			}
		}
	}
}
