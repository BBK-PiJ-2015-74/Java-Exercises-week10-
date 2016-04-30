package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import exercises.StringUtils;
import exercises.TwoStringPredicate;

/**
 * A test class to test the methods in StringUtils and associated functional interfaces
 * @see StringUtils
 * @see TwoStringPredicate
 * @author BBK-PiJ-2015-74
 *
 */

public class StringUtilsTest {
	
	private String s1 = "The cheesy ees made me queasy";
	private String s2 = "Somewhere over the rainbow";
	private String s3 = "yyyyyyyyy";
	private String s4 = "echo";
	private String s5 = "I'm a terrible geek";
	private String s6 = "X";
	private String s7 = "123456789";
	private String s8 = "eeeeeeeee";
	private String s9 = "zzzzz";
	private String s10 = "Computer science is fun";
	
	private String[] stringArray = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
	
	private String test1 = "ee";
	private String test2 = "xxxxxxxx";
	
	private String element1 = "bee";
	private String element2 = "ant";
	private String element3 = "vole";
	private String element4 = "shrew";
	private String element5 = "aardvaark";
	private String element6 = "kangaroo";
	private String element7 = "buzzard";
	private String element8 = "elephant";
	private String element9 = "dolphin";
	private String element10 = "poisonous catfish";
	
	public List<String> setUpWords() {
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
		return words;
	}

	/**
	 * Test method for Exercise 2, eChecker
	 * @see StringUtils.eChecker()
	 */
	@Test
	public void eCheckerWorks() {
		
		Collections.sort(Arrays.asList(stringArray), (a, b) -> StringUtils.eChecker(a, b));
		System.out.println("Sorted array list by strings containing e using a method reference in a lambda" + Arrays.asList(stringArray));
		
		Collections.sort(Arrays.asList(stringArray), StringUtils::eChecker);
		System.out.println("Sorted array list by strings containing e using a method reference to a static method :" + Arrays.asList(stringArray));
	}
	
	/**
	 * Test method for Exercise 3, betterString
	 * @see StringUtils.betterString()
	 */
	@Test
	public void betterStringProducesLongestString() {
		
		TwoStringPredicate function1 = (str1, str2) -> str1.length() > str2.length(); // checks which string is longer
		System.out.println("Checking which string is the longest using fuctional interface TwoStringPredicate");
		System.out.println(StringUtils.betterString(test1, test2, function1));
	}
	
	@Test
	public void betterStringProducesFirstString() {
		
		TwoStringPredicate function2 = (str1, str2) -> true; // always returns str1
		System.out.println("This function will always return the first string");
		System.out.println(StringUtils.betterString(test1, test2, function2));
	}
	
	@Test
	public void betterStringChecksWhichContainsMostEs() {

		TwoStringPredicate function3 = (str1, str2) -> { // checks which string has the most letter 'e's
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
		
		System.out.println("This function returns the string with the most e's: ");
		System.out.println(StringUtils.betterString(test1, test2, function3));
	}
	
	/**
	 * Exercise 5 day 19
	 * @see StringUtils.allMatches()
	 */
	@Test
	public void allMatchesFindsShortWords() {
		List<String> words = setUpWords();
		List<String> shortWords = StringUtils.allMatches(words, s-> s.length() <= 4);
		System.out.println(shortWords.toString());
	}
	
	@Test
	public void allMatchesFindsWordsWithB() {
		List<String> words = setUpWords();
		List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
		System.out.println(wordsWithB.toString());
	}	

	@Test
	public void allMatchesFindsEvenLengthWords() {
		List<String> words = setUpWords();
		List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2 == 0));
		System.out.println(evenLengthWords.toString());
	}
	
	
	/**
	 * Exercise 7, day 19
	 * @see StringUtils.transformedList()
	 */
	@Test
	public void transformedListProducesExcitingWords() {
		List<String> words = setUpWords();
		List<String> excitingWords = StringUtils.transformedList(words, s -> (s + "!"));
		System.out.println(excitingWords);
	}
	
	@Test
	public void transformedListProducesEyeWords() {
		List<String> words = setUpWords();
		List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("e", "zing"));
		System.out.println(eyeWords);
	}
	
	@Test
	public void transformedListProducesUpperCaseWords() {
		List<String> words = setUpWords();
		List<String> upperCaseWords = StringUtils.transformedList(words, s -> s.toUpperCase());
		System.out.println(upperCaseWords);
	}
	
}
