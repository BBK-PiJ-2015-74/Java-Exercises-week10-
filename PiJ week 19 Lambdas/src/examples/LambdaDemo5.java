package examples;

/**
 * @see StringFunc functional interface
 * @author lucieburgess
 */

public class LambdaDemo5 {

	public static void main(String[] args) {
		
		// this block lambda reverses the characters in a string
		// the lambda expression infers the type String of s
		
		StringFunc reverseString = (s) -> {
			
			String result = "";
			int i;
			
			for (i = s.length()-1; i >= 0; i--) {
				result = result + s.charAt(i);
				//result += s.charAt(i); // C += A is equivalent to C = C + A
			}
			return result;
		};
		
		String z = "The quick brown fox jumped over the lazy dog";
		System.out.println("The string is: " + z);
		System.out.println("The reverse of the string is: " + reverseString.function(z));
	}

}
