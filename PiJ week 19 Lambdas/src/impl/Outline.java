package impl;


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
	
		System.out.println("Sorting array using a lambda function");
		Collections.sort(Arrays.asList(stringArray), (x, y) -> x.compareTo(y));
		System.out.println(Arrays.asList(stringArray));
		
		System.out.println("Sorting array by length of string using a lambda function");
		Collections.sort(Arrays.asList(stringArray), (x,y) -> x.length()-y.length());
		System.out.println(Arrays.asList(stringArray));
		
		// this needs to be a reverse sort
		//System.out.println("Sorting array in reverse order using a lambda function");
		//Collections.sort(Arrays.asList(stringArray), (x, y) -> x.substring(0)="e" y.substring(0)!="e" );
		//System.out.println(Arrays.asList(stringArray));
		
		// sorting all those that contain the letter 'e'
		//System.out.println("Sorting array in reverse order using a lambda function");
		//Collections.sort(Arrays.asList(stringArray), (x, y) -> x.substring(0)="e" y.substring(0)!="e" );
		//System.out.println(Arrays.asList(stringArray));
		
	}
}

