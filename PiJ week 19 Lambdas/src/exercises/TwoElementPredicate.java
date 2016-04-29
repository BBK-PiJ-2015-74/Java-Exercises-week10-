package exercises;

/**
 * PiJ day 19 Exercise 4
 * Defines a functional interface which takes two generic elements and returns true for whichever element is 'better'
 * @author lucieburgess
 *
 */

@FunctionalInterface
public interface TwoElementPredicate<T> {
	
	/**
	 * Defines a functional interface which can be implemented using a lamda function.
	 * Returns true if the first element t1 of type T is better than the second element t2 of type T,
     * false otherwise.
     * Lambdas that implement this interface need to define what "better" means.
	 * @param <T> t1
	 * @param <T> t2
	 * @return the 'better' String, with the lambda defining what "better" means.
	 */
	public boolean isBetter(T t1, T t2);

}