package examples;
/**
 * @author lucieburgess
 * @see GenericFunc functional interface
 */

public class LambdaDemo6 {

	public static void main(String[] args) {
		// use a String-based version of GenericFunc to reverse the string
		
		GenericFunc<String> reverse = (t) -> { // t is the input string
			
			String result = "";
			int i;
			
			for (i=t.length()-1; i>=0; i--) { // remember the middle parameter is while i is >=0, not until
				result += t.charAt(i);
			}
			
			return result;
		};
		
		String z = "Lambdas add power to Java";
		System.out.println("The string is: " + z);
		System.out.println("The reverse of the string is: " + reverse.genericfunc(z));	
		
		// now use an Integer-based version of GenericFunc to provide a factorial
		
		GenericFunc<Integer> factorial = (k) -> {
			
			int result = 1;
			int i;
			
			for (i=0; i<k; i++) {
				result = result*(k-i);
			}
			return result;
		};
	
		System.out.println("3 factorial is :" + factorial.genericfunc(3));
		System.out.println("5 factorial is :" + factorial.genericfunc(5));
		System.out.println("7 factorial is :" + factorial.genericfunc(7));
		
	}
}
