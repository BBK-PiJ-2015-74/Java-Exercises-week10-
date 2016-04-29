package exercises;

/**
 * PiJ day 19 Exercise 3
 * Defines a functional interface which takes two Strings and returns true for whichever string is 'better'
 * @author lucieburgess
 *
 */

@FunctionalInterface
public interface TwoStringPredicate {
	
	/**
	 * Defines a functional interface which can be implemented using a lamda function.
	 * Returns true if the first String str1 is better than the second str2,
     * false otherwise.
     * Lambdas that implement this interface need to define what "better" means.
	 * @param str1
	 * @param str2
	 * @return the 'better' String, with the lambda defining what "better" means.
	 */
	public boolean isBetter (String str1, String str2);

}
