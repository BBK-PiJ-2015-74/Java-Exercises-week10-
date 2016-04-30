package exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A test class to test the methods in ElementUtils
 * @see ElementUtils (which contains the core methods)
 * @see TwoElementPredicate functional interface
 * @author BBK-PiJ-2015-74
 */

public class ElementUtils {

	public ElementUtils() {
	}
	
	/**
	 * This is the generic version of TwoStringPredicate
	 * @param T t1 (an object of type T called t1)
	 * @param T t2 (an object of type T called t2)
	 * @param fn, a predicate function which takes type <T> T and returns true if t1 is "better"
	 * @return the 'best' T according to the definition of function fn
	 */
	public static <T> T betterElement(T t1, T t2, TwoElementPredicate<T> fn) {
		return (fn.isBetter(t1, t2) ? t1 : t2);
	}

	/**
	 * The generic method which takes a List of elements of type T and a Predicate<T> and returns a list of all the values
	 * 	that passed the test
	 * @param myList
	 * @param fn
	 * @return
	 */
	public static <T> List<T> genericMatches(List<T> myList, Predicate<T> fn) {
		List<T> output = new LinkedList<>();
		for (T t:myList) {
			if (fn.test(t)) {
				output.add(t);
			}
		}
		return output;
	}
	
	/**
	 * Exercise 8 day 19, transformedList for generic types
	 * @param inputList
	 * @param transform
	 * @return outputList, the list with the elements transformed according to the function transform
	 */
	public static <T> List<T> transformedList(List<T> inputList, Function<T, T> transform) {
		List<T> outputList = new LinkedList<>();
		for (T t:inputList) {
			T tOut = transform.apply(t);
			outputList.add(tOut);
		}
		return outputList;
	}
	
}