import java.util.Scanner;

public class ComputeFactorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Eneter a int: ");
		int n = input.nextInt();
		
		System.out.println("Factorial " + n + " is " + factorial(n));
//		System.out.println("Fib for "+n+" is " + fib(n));
		
//		System.out.println("Eneter text");
//		String text = input.next();
//		System.out.println(isPalindrome(text));
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
}

