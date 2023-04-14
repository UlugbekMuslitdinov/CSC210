import java.util.*;

public class PriorityQueueDemo {

	public static void main(String args[]) {
//		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
//		
//		pQueue.add(10);
//		pQueue.add(20);
//		pQueue.add(15);
//		
//		System.out.println(pQueue.peek());
//		System.out.println(pQueue.poll());
//		System.out.println(pQueue.peek());
		
		Comparator<String> stringLengthComparator = new Comparator<>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};
		
		PriorityQueue<String> namePriorityQueue = new PriorityQueue<>((s1, s2) -> {return s1.length() - s2.length();});
		
		namePriorityQueue.add("Liz");
		namePriorityQueue.add("Robert");
		namePriorityQueue.add("John");
		
		while(!namePriorityQueue.isEmpty()) {
			System.out.println(namePriorityQueue.remove());
		}
	}
}
