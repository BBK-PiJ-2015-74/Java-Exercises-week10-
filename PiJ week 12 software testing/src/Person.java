/**
 * Ex 3 day 12 - practice 'find bugs once'
 * @author lucieburgess
 *
 */

public class Person {
	
	private String fullName;
	private int age;
	private String address;

	public Person() {
		this.fullName = fullName;
		this.age = age;
		this.address = address;
	}

	public String getInitials(String fullName) { 
		String result = "";
		String[] words = fullName.split(" "); 
			for (int i = 0; i < words.length; i++) {
				String nextInitial = "" + words[i].charAt(0);
				result = result + nextInitial.toUpperCase(); 
			}
	   return result;
	}
	
} // end of class
