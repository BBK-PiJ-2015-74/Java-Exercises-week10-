package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class StringUtils {
	
	public StringUtils() {
	}
	
	/**
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
	 * TwoStringPredicate simply is a boolean function that says that returns true if str1 is "better"
	 * Whether str1 is "better" is defined in the lambda function TwoStringPredicate which is implemented below
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
	 * This is the generic version of TwoStringPredicate
	 * @param T t1
	 * @param T t2
	 * @param fn, a predicate function which takes type <T> T and returns true if t1 is "better"
	 * @return the 'best' T according to the definition of function fn
	 */
	public static <T> T betterElement(T t1, T t2, TwoElementPredicate<T> fn) {
		return (fn.isBetter(t1, t2) ? t1 : t2);
	}
	
	/**
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

	public static void main (String[] args) {
		String s1 = "The cheesy ees made me queasy";
		String s2 = "Somewhere over the rainbow";
		String s3 = "yyyyyyyyy";
		String s4 = "echo";
		String s5 = "I'm a terrible geek";
		String s6 = "X";
		String s7 = "123456789";
		String s8 = "eeeeeeeee";
		String s9 = "zzzzz";
		String s10 = "Computer science is fun";
		
		String[] stringArray = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
		System.out.println("Unsorted array list: " + Arrays.asList(stringArray));
		
		// two methods of running StringUtils.eChecker: the first using an explicit lambda, the second passed as a method reference
		
		Collections.sort(Arrays.asList(stringArray), (a, b) -> StringUtils.eChecker(a, b));
		System.out.println("Sorted array list by strings containing the letter e :" + Arrays.asList(stringArray));
		
		Collections.sort(Arrays.asList(stringArray), StringUtils::eChecker);
		System.out.println("Sorted array list by strings containing the letter e :" + Arrays.asList(stringArray));
		
		String test1 = "ee";
		String test2 = "xxxxxxxx";
		
		TwoStringPredicate function1 = (str1, str2) -> (str1.length() > str2.length()); // checks which string is longer
		
		TwoStringPredicate function2 = (str1, str2) -> { // checks which string has the most letter 'e's
			if (str1.contains("e") && !str2.contains("e")) {
				return true;
			} else if (str1.contains("e") && str2.contains("e")) {
				int count1 = 0;
				int count2 = 0;
				for (int i=0; i<str1.length();i++) {
					if (str1.charAt(i) == 'e') {
						count1++;
					}
				}
				for (int j=0; j<str2.length();j++) {
					if (str2.charAt(j) == 'e') {
						count2++;
					}
				}
				return (count1>count2);
			} else {
				return (str1.length() > str2.length());
			}
		};
		
		TwoStringPredicate function3 = (str1, str2) -> true; // always returns str1
		
		System.out.println("Running StringUtils.betterString using TwoStringPredicate functions :" + "\n");
		
		System.out.println(StringUtils.betterString(test1, test2, function1));

		System.out.println(StringUtils.betterString(test1, test2, function2));
		
		System.out.println(StringUtils.betterString(test1, test2, function3));
		
		// Now trying the generic version of TwoElementPredicate with the same logic
		
		TwoElementPredicate<String> genericfn1 = (t1, t2) -> (t1.length() > t2.length());
		
		TwoElementPredicate<String> genericfn2 = (t1, t2) -> { // checks which string has the most letter 'e's
			if (t1.contains("e") && !t2.contains("e")) {
				return true;
			} else if (t1.contains("e") && t2.contains("e")) {
				int count1 = 0;
				int count2 = 0;
				for (int i=0; i<t1.length();i++) {
					if (t1.charAt(i) == 'e') {
						count1++;
					}
				}
				for (int j=0; j<t2.length();j++) {
					if (t2.charAt(j) == 'e') {
						count2++;
					}
				}
				return (count1>count2);
			} else {
				return (t1.length() > t2.length());
			}
		};
		
		TwoElementPredicate<String> genericfn3 = (t1, t2) -> true; // always returns str1
		
		System.out.println("Running StringUtils.betterElement using TwoElementPredicate functions :" + "\n");
		
		System.out.println(StringUtils.betterElement(test1, test2, genericfn1));

		System.out.println(StringUtils.betterElement(test1, test2, genericfn2));
		
		System.out.println(StringUtils.betterElement(test1, test2, genericfn3));
		
		String element1 = "bee";
		String element2 = "ant";
		String element3 = "vole";
		String element4 = "shrew";
		String element5 = "aardvaark";
		String element6 = "kangaroo";
		String element7 = "buzzard";
		String element8 = "elephant";
		String element9 = "dolphin";
		String element10 = "poisonous catfish";
		
		List<String> words = new LinkedList<>();
		words.add(element1);
		words.add(element2);
		words.add(element3);
		words.add(element4);
		words.add(element5);
		words.add(element6);
		words.add(element7);
		words.add(element8);
		words.add(element9);
		words.add(element10);
		
		System.out.println("Running StringUtils.allMatches using Java's built-in Predicate method test() :" + "\n");
		
		List<String> shortWords = StringUtils.allMatches(words, s-> s.length() <= 4);
		System.out.println(shortWords.toString());
		
		List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
		System.out.println(wordsWithB.toString());
		
		List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2 == 0));
		System.out.println(evenLengthWords.toString());
		
		System.out.println("Running StringUtils.genericMatches using Java's built-in Predicate method test() :" + "\n");
		
		List<String> shortGenericWords = StringUtils.genericMatches(words, s -> s.length() <= 4);
		System.out.println(shortGenericWords.toString());
		
		List<String> genericWordsWithB = StringUtils.genericMatches(words, s -> s.contains("b"));
		System.out.println(genericWordsWithB.toString());
		
		List<String> genericEvenWords = StringUtils.genericMatches(words, s -> (s.length() % 2 == 0));
		System.out.println(genericEvenWords.toString());
		
		List<Integer> numbers = new LinkedList<>();
		numbers.add(123);
		numbers.add(456);
		numbers.add(11111);
		numbers.add(300000);
		numbers.add(55555);
		numbers.add(267589403);
		numbers.add(0);
		
		System.out.println("Running StringUtils.genericMatches on a list of integers using Predicate method test() :" + "\n");
		
		List<Integer> shortNumbers = StringUtils.genericMatches(numbers, i-> i <=1000);
		Collections.sort(shortNumbers);
		System.out.println(shortNumbers.toString());
		
		List<Integer> numbersWith5 = StringUtils.genericMatches(numbers, i -> {
			String str = i.toString();
			return (str.contains("5")? true : false);
		});
		Collections.sort(numbersWith5);
		System.out.println(numbersWith5.toString());
		
		List<Integer> evenNumbers = StringUtils.genericMatches(numbers, i-> i % 2 == 0);
		Collections.sort(evenNumbers);
		System.out.println(evenNumbers.toString());
	}
	
}
