package test;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

/**
 * Tests for Exercise 1, day 19, Lambda expressions
 * @see Outline.java - messy code to clean code!
 * @author BBK-PiJ-2015-74
 */

public class OutlineTest {
		
		String s1 = "The quick brown fox jumped over the lazy dog";
		String s2 = "Somewhere over the rainbow";
		String s3 = "Mary had a little lamb";
		String s4 = "Echo";
		String s5 = "I'm a terrible geek";
		String s6 = "X";
		String s7 = "123456789";
		String s8 = "eeeeeeeee";
		String s9 = "Dude you're killing me";
		String s10 = "Computer science is fun";
		
		String[] stringArray = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
		

	@Test
	public void sortArrayInAlphabeticalOrder() {
		
		System.out.println("Unsorted array :" + Arrays.asList(stringArray));
	
		Collections.sort(Arrays.asList(stringArray), (x, y) -> x.compareTo(y)); // Lambda using natural sort
		
		System.out.println("Array sorted alphabetically :" + Arrays.asList(stringArray) +"\n");
	}

	@Test
	public void sortArrayByWordLength() {
		
		System.out.println("Unsorted array :" + Arrays.asList(stringArray));
		
		Collections.sort(Arrays.asList(stringArray), (x,y) -> x.length() - y.length()); //Lambda comparing length
		
		System.out.println("Array sorted by length of word :" + Arrays.asList(stringArray) +"\n");	
	}
	
	@Test
	public void reverseSortArrayByWordLength() {
		
		System.out.println("Unsorted array :" + Arrays.asList(stringArray));
		
		Collections.sort(Arrays.asList(stringArray), (x,y) -> y.length() - x.length()); //Lambda comparing length
		
		System.out.println("Array reverse sorted by length of word :" + Arrays.asList(stringArray) +"\n");	
	}
	
	@Test
	
	public void sortArrayByWordsContainingE() {
		
		System.out.println("Unsorted array :" + Arrays.asList(stringArray));
		
		Collections.sort(Arrays.asList(stringArray), (x,y) -> {
			int result = 0;
			if(x.contains("e") && !y.contains("e")) {
				result = -1; 
			} else if (y.contains("e") && !x.contains("e")) {
				result = 1;
			}
			return result;
		});
		
		System.out.println("Array sorted by words containing 'e' " + Arrays.asList(stringArray) + "\n");	
	}
}

