package examples;

/**
 * @see functional interface NumericFunc
 * @author lucieburgess
 * This provides an example of a block lambda which allows multiple statements, uses curly brackets
 *  and must have a return value
 */

public class LambdaDemo4 {

	public static void main(String[] args) {
		
		// block lambda computes the factorial of an integer value
		
		NumericFunc factorial = (n) -> {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result = i*result;
			}
			return result;
		}; // notice the closing bracket of the lambda must have a semicolon
		
		System.out.println("3 factorial is " + factorial.function(3)); // factorial is the name of the type NumericFunc
		System.out.println("5 factorial is " + factorial.function(5)); // function is the method specified by the functional interface
		System.out.println("7 factorial is " + factorial.function(7));
		
	}
}
