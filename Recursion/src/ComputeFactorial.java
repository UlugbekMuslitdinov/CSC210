import java.util.Scanner;
import java.util.Stack;

public class ComputeFactorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		System.out.println("Eneter a int: ");
//		int n = input.nextInt();
		
//		System.out.println("Factorial " + n + " is " + factorial(n));
//		System.out.println("Fib for "+n+" is " + fib(n));
		
//		System.out.println("Eneter text");
//		String text = input.next();
//		System.out.println(isPalindrome(text));
//		System.out.println(loopPalindrome(text));
		Stack<Integer> s = new Stack<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		removeEvens(s, 1);
	}
	
	public static long factorial(long n) {
		if (n == 0) return 1;
		else return n * factorial(n-1);
	}
	
	public static long fib(long index) {
		if (index == 0) return 0;
		else if (index == 1) return 1;
		else return fib(index-1) + fib(index - 2);
	}
	
	public static boolean isPalindrome(String s) {
		final int len = s.length();
		if (len == 1) return true;
		else if (len == 2 && s.charAt(0) == s.charAt(len-1)) return true;
		else if (s.charAt(0) == s.charAt(len-1)) return true && isPalindrome(s.substring(1, len-2));
		else return false;
	}
	
	public static boolean loopPalindrome(String s) {
		int front = 0;
		int tail = s.length()-1;
		while (front <= tail) {
			if (s.charAt(front) != s.charAt(tail)) return false;
			front++;
			tail--;
		}
		return true;
	}
	
	public static Stack<Integer> removeEvens(Stack<Integer> s, int k) {
		if (k>0 && !s.empty()) {
			for (int num: s) {
				if (num%2==0) {
					s.remove(0);
					return removeEvens(s, k-1);
				} else {
					int removed = s.remove(0);
					removeEvens(s, k).add(removed);
				}
			}
		}
		return s;
	}
}

