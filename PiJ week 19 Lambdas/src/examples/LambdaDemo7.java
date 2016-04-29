package examples;

/**
 * @ see StringFunc interface
 * @author lucieburgess
 */

public class LambdaDemo7 {
	
	// the method stringOp has a functional interface as the type of its first parameter
	// i.e. StringFunc is passed as an argument to the method
	// the second parameter s specifies the string to operate on

	public static String stringOp(StringFunc sf, String s) {
		return sf.function(s);
	}

	public static void main(String [] args) {
		String inStr = "Lambdas add power to Java";
		String outStr;
		
	// a simple lambda expression that uppercases a string is passed to stringOp
	outStr = stringOp(str -> str.toUpperCase(), inStr);	
		
	// the next few lines pass a block lambda that remove spaces
	outStr = stringOp( (str) -> {
		String result = "";
		for (int i = 0; i<str.length(); i++) {
			if (str.charAt(i) != ' ') {
				result += str.charAt(i);
			}
		}
		return result;
	}, inStr); // close the method body of stringOp
	
	System.out.println("The string with spaces removed: " + outStr);
	
	}
}
