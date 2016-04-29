package examples;

/**
 * @see NumericTest1 functional interface
 * @author lucieburgess
 *
 */

public class LambdaDemo2 {

	public LambdaDemo2() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// A lambda expression to test is a number is even
		
		NumericTest1 isEven = (n) -> (n % 2) == 0; // NumericTest has only one method which returns a boolean
		// therefore the lambda expression must return a boolean
		// I modified NumericTest to take two arguments which is why this now doesn't work
		
		int n = 10;
		if(isEven.test(n)) {
			System.out.println(n +  " is an even number");
		} else {
			System.out.println(n +  " is an odd number");
		}
		
		n = 9;
		if(isEven.test(n)) {
			System.out.println(n +  " is an even number");
		} else {
			System.out.println(n +  " is an odd number");
		}
		
		// Now use a lambda expression which tests whether a number is positive or negative
		
		NumericTest1 isPositive = (m) -> (m) > 0;
		
		int m = -20;
		if(isPositive.test(m)) {
			 System.out.println(m +  " is greater than zero");
		 } else {
			 System.out.println(m + " is less than zero");
		 }
		
		// a functional interface reference can be used to execute any lambda expression that is compatible with it
	}

	
}
