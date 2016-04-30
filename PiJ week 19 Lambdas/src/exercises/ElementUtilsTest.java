package exercises;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ElementUtilsTest {
	
	private String test1 = "ee";
	private String test2 = "xxxxxxxx";
	
	private Double d1 = 1234567.567;
	private Double d2 = 567483910000.2;
	
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
	
	public List<Integer> setUpNumbers() {
		List<Integer> numbers = new LinkedList<>(); 
		numbers.add((Integer)123);
		numbers.add((Integer)456);
		numbers.add((Integer)11111);
		numbers.add((Integer)3000);
		numbers.add((Integer)55555);
		numbers.add((Integer)26708);
		numbers.add((Integer)0);
		return numbers;
	}
			
	/**
	 * Exercise 4, day 19
	 * @see ElementUtils.betterElement()
	 */
	@Test
	public void betterElementReturnsLongestString() {
		
		System.out.println("Checking betterElement returns longest string: ");
		TwoElementPredicate<String> genericfn1 = (t1, t2) -> t1.length() > t2.length(); //lambda gives longest string
		System.out.println(ElementUtils.betterElement(test1, test2, genericfn1));
	}
	
	
	@Test
	public void betterElementReturnsFirstString() {
		
		System.out.println("Checking betterElement returns the first string: ");
		TwoElementPredicate<String> genericfn2 = (t1, t2) -> true; // always returns str1
		System.out.println(ElementUtils.betterElement(test1, test2, genericfn2));
				
	}
	
	@Test 
	public void betterElementReturnsStringWithMostEs() {
		
		System.out.println("Checking betterElement returns string containing the most e's: ");
		TwoElementPredicate<String> genericfn3 = (t1, t2) -> { // checks which string has the most letter 'e's
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
	
		System.out.println(ElementUtils.betterElement(test1, test2, genericfn3) + "\n");
	}
	
	
	@Test
	public void betterElementReturnsLargestDouble() {
		
		System.out.println("Checking better element returns the largest double"); 
		TwoElementPredicate<Double> genericfn4 = (x, y) -> x > y;
		System.out.println(ElementUtils.betterElement(d1, d2, genericfn4) + "\n");
	}
	
		
	@Test 
	public void betterElementReturnsEvenDouble() {
		
		System.out.println("Checking better element returns double divisible by 0.2");
		TwoElementPredicate<Double> genericfn5 = (x, y) -> {
			if ((x % 0.2 == 0) && (y % 0.2 == 0)) {
				return true;
			}
			else if ((x % 0.2 == 0) && !(y % 0.2 == 0)) {
				return true;
			} else {
				return false;
			}
		};
		System.out.println(ElementUtils.betterElement(d1, d2, genericfn5) + "\n");
	}
	
	
	/**
	 * Exercise 6, day 19
	 * @see ElementUtils.genericMatches()
	 */
	@Test
	public void genericMatchesFindsShortWords() {
		List<String> words = setUpWords();
		List<String> shortGenericWords = ElementUtils.genericMatches(words, s -> s.length() <= 4);
		System.out.println("Finding short words using genericMatches :");
		System.out.println(shortGenericWords.toString() + "\n");
	}
	
	@Test
	public void genericMatchesFindsWordsWithB() {
		List<String> words = setUpWords();
		List<String> genericWordsWithB = ElementUtils.genericMatches(words, s -> s.contains("b"));
		System.out.println("Finding words containing B using genericMatches :");
		System.out.println(genericWordsWithB.toString() +"\n");
	}
	
	@Test
	public void genericMatchesFindsEvenWords() {
		List<String> words = setUpWords();
		List<String> genericEvenWords = ElementUtils.genericMatches(words, s -> (s.length() % 2 == 0));
		System.out.println("Finding even-length words using genericMatches :");
		System.out.println(genericEvenWords.toString() +"\n");	
	}
	
	@Test
	public void genericMatchesFindsSmallNumbers() {
		List<Integer> numbers = setUpNumbers();
		List<Integer> shortNumbers = ElementUtils.genericMatches(numbers, i-> i <=1000);
		Collections.sort(shortNumbers);
		System.out.println("Finding numbers < 1000 using genericMatches :");
		System.out.println(shortNumbers.toString() +"\n");
	}
	
	@Test
	public void genericMatchesFindsNumbersWith5() {
		List<Integer> numbers = setUpNumbers();
		List<Integer> numbersWith5 = ElementUtils.genericMatches(numbers, i -> {
			String str = i.toString();
			return (str.contains("5")? true : false);
		});
		Collections.sort(numbersWith5);
		System.out.println("Finding numbers containing 5 using genericMatches :");
		System.out.println(numbersWith5.toString() +"\n");
	}
	
	@Test
	public void genericMatchesFindsEvenNumbers() {
		List<Integer> numbers = setUpNumbers();
		List<Integer> evenNumbers = ElementUtils.genericMatches(numbers, i-> i % 2 == 0);
		Collections.sort(evenNumbers);
		System.out.println("Finding even numbers using genericMatches :");
		System.out.println(evenNumbers.toString());
	}
	
	/**
	 * Exercise 8
	 * transformedList with generic types
	 * @see ElementUtils.transformedList()
	 */
	@Test
	public void transformedListProducesExcitingWords() {
		List<String> words = setUpWords();
		List<String> excitingWords = ElementUtils.transformedList(words, s -> (s + "!"));
		System.out.println("Making exciting words using generic transformedList");
		System.out.println(excitingWords);
	}
	
	@Test
	public void transformedListProducesEyeWords() {
		List<String> words = setUpWords();
		List<String> eyeWords = ElementUtils.transformedList(words, s -> s.replace("i", "eye"));
		System.out.println("Creating eye words using generic transformedList");
		System.out.println(eyeWords);
	}
	
	@Test
	public void transformedListProducesUpperCaseWords() {
		List<String> words = setUpWords();
		List<String> upperCaseWords = ElementUtils.transformedList(words, s -> s.toUpperCase());
		System.out.println("Creating upper case words using generic transformedList");
		System.out.println(upperCaseWords);
	}
	
	@Test
	public void transformedListMultipliesIntegersBy1Million() {
		List<Integer> numbers = setUpNumbers();
		List<Integer> hundredNumbers = ElementUtils.transformedList(numbers, i -> i*100);
		System.out.println("Multiplying numbers by 100 using generic transformedList");
		System.out.println(hundredNumbers);
	}
	
	@Test
	public void transformedListOmitsZeros() {
		List<Integer> numbers = setUpNumbers();
		List<Integer> nonZeroNumbers = ElementUtils.transformedList(numbers, i -> {
			String str = String.valueOf(i);
			str = str.replaceAll("0","");
			i = Integer.parseInt(str);
			return i;
		});
		System.out.println("Stripping out zeros using generic transformedList");
		System.out.println(nonZeroNumbers);
	}
	
}
