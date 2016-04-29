package examples;

/**
 * @see MyStringOps class which defines method strReverse
 * @author lucieburgess
 *
 */

public class LambdaDemo10 {

	// This method has a functional interface as the type of its first parameter
	// Thus it can be passed by any instance of that interface, including a method reference
	
	private static String stringOp(StringFunc sf, String s) {
		return sf.function(s);
	}

	public static void main (String[] args) {
		String inStr = "Lambdas add power to java";
		String outStr;
		
		// Here a method reference to the method strReverse in class MyStringOps is passed to stringOp()
		// outStr = stringOp(MyStringOps::strReverse, inStr);
		
		// Alternatively create a new MyStringOps object and pass that to the instance method strReverse
		MyStringOps strOps = new MyStringOps();
		
		outStr = stringOp(strOps::strReverse, inStr);
		
		System.out.println("Original string: " + inStr);
		System.out.println("String reversed: " + outStr);
		
	}
}
