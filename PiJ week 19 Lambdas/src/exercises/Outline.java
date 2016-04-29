package exercises;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class Outline {
	public static void main(String... args) { // varargs alternative to String[]
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
		
		String[] stringArray = {s1,s2,s3,s4,s5,s6, s7, s8, s9, s10};
		System.out.println(Arrays.asList(stringArray));
		
		// sort with anonymous inner class
		System.out.println("Sorting array using an anonymous inner class");
		Collections.sort(Arrays.asList(stringArray), new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		System.out.println(Arrays.asList(stringArray));
	
		// Ex 1a sort array by alphabetical order (first character)
		System.out.println("Sorting array in alphabetical order");
		Collections.sort(Arrays.asList(stringArray), (x, y) -> x.compareTo(y));
		System.out.println(Arrays.asList(stringArray) + "\n");
		
		// Ex 1b sort array by length, shortest to longest
		System.out.println("Sorting array by length of string, shortest to longest");
		Collections.sort(Arrays.asList(stringArray), (x,y) -> x.length() - y.length());
		System.out.println(Arrays.asList(stringArray) + "\n");
		
		// Ex 1c sort array by length, longest to shortest
		System.out.println("Sorting array by length of string, longest to shortest");
		Collections.sort(Arrays.asList(stringArray), (x,y) -> y.length() - x.length());
		System.out.println(Arrays.asList(stringArray) + "\n");
		
		// Ex 1d, all those that contain the letter 'e' first, everything else second
		// Uses Collection.sort where the sort method is:
		// public static <T> void sort(List<T> list, Comparator<? super T> c)
		// in this case the Comparator is compare - but in the background
		// int compare (T o1, T o2) where o1 and o2 are the objects to be compared
		
		System.out.println("Sorting array by strings containing the letter 'e' :");
		Collections.sort(Arrays.asList(stringArray), (x,y) -> {
			int result = 0;
			if(x.contains("e") && !y.contains("e")) {
				result = -1; 
			} else if (y.contains("e") && !x.contains("e")) {
				result = 1;
			}
			return result;
		});
		System.out.println(Arrays.asList(stringArray) + "\n");
		
	}
}

