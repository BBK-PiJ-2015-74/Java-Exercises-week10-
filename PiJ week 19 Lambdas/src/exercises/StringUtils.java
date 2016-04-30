package exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringUtils {
	
	public StringUtils() {
	}
	
	/**
	 * Exercise 2, day 19
	 * A method using lambda functions to check whether strings contain an e. Can be passed as a method reference
	 * to a lambda function
	 * @param x a String which may contain an e
	 * @param y a String which may contain an e
	 * @return -1 if x contains e and y doesn't, or 1 if y contains e and x doesn't
	 */
	public static int eChecker (String x, String y) {
		int result = 0;
		if(x.contains("e") && !y.contains("e")) {
			result = -1; 
		} else if (y.contains("e") && !x.contains("e")) {
			result = 1;
		}
		return result;
	}
	
	/**
	 * Exercise 3, day 19
	 * TwoStringPredicate simply is a boolean function that says that returns true if str1 is "better"
	 * Whether str1 is "better" is defined in the lambda function TwoStringPredicate which is implemented below
	 * @see TwoStringPredicate functional interface
	 * @param str1
	 * @param str2
	 * @param ts, a predicate function defined in functional interface TwoStringPredicate
	 * @return the 'best' String according to the definition of function ts
	 */	
	public static String betterString(String str1, String str2, TwoStringPredicate ts) {		
		if (ts.isBetter(str1, str2)) {
			return str1;
		} else {
			return str2;
		}
	}
	
	/**
	 * Exercise 5, day 19
	 * A method which takes a List of Strings and a Predicate<String> and returns a list of
	 * 	all the values that passed the test
	 * @param myList, the input list
	 * @param fn a boolean function defined in Predicate<T> - fn is implemented below. Predicate standard functional Java 8 interface
	 * @return List<String> of all strings which pass the test
	 */
	public static List<String> allMatches(List<String> myList, Predicate<String> fn ) {		
		List<String> output = new LinkedList<>();
		for (String str:myList) {
			if (fn.test(str)) {
				output.add(str);
			}
		}
		return output;
	}
	
	
	/**
	 * Exercise 7, day 19 
	 * creates a static method called transformedList which takes a list of strings and a Function<String, String>
	 * 	and returns a new list that contains the results of applying the function to each element of the original list
	 * @param boringList, the input list
	 * @param transform, a function using the functional interface Function<T,R> which applies an operation to an object of
	 * type T and returns the result as an object of type R. Its method is called apply()
	 * @return differentList, the list with the function applied to each element
	 */
	public static List<String> transformedList(List<String> boringList, Function<String, String> transform) {
		List<String> differentList = new LinkedList<>();
		for (String str:boringList) {
			String outStr = transform.apply(str);
			differentList.add(outStr);
		}
		return differentList;
	}

	
}
