import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class MemoizedFibonacci {

	public MemoizedFibonacci() {
	}
	
	private static Map<Integer, Integer> memo = new ConcurrentHashMap<>(); // note use of genericised type Map (interface) of which ConcurrentHashMap is an implementation

	public static int getFib(int n) {
		if ((n == 1) || (n == 2)) {
			return 1;
		}
		if (memo.containsKey(n)) {
			System.out.println("Using hash map to memoize Fibonacci numbers");
			return memo.get(n);
		} else {
			int result = 0;
	    	result = getFib(n-1) + getFib(n-2);
	    	memo.put(n, result);
	    	System.out.println(memo);
	        return result;
		}
	}   

}