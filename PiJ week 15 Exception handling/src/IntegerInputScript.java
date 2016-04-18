import java.util.ArrayList;
import java.util.List;

/**
 * Integer input script based on code in Ex 1
 * Look at the following code and write the code flow (use the line numbers to indicate which lines are executed in which order) in the following situations:
 * userInput is 0
 * userInput is 2
 * userInput is 4
 * userInput is 6.
 * @author lucieburgess
 *
 */

public class IntegerInputScript {

	public void launch(int userInput) {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.add(6);
		try {
		intList.remove(0);
		System.out.println(intList.get(userInput));
		intList.remove(0);
		System.out.println(intList.get(userInput));
		intList.remove(0);
		System.out.println(intList.get(userInput));
		intList.remove(0);
		System.out.println(intList.get(userInput));
		intList.remove(0);
		System.out.println(intList.get(userInput));
		intList.remove(0);
		System.out.println(intList.get(userInput));
		intList.remove(0);
		System.out.println(intList.get(userInput));
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		} 
	}		
}

/**
* a. User input is 0
* Main method: runs launch (see IntegerInputMain.java)
* runs method launch on an integer chosen by the user, in this case 0
* moves to IntegerInputScript creates new IntegerInputScrit ie
* runs method launch() on input 0
* runs lines 17-24
* Lines 17-24 Creates a list 1,2,3,4,5,6, in an array
* Enters the try block
* Line 26 Removes index 0 of the array (the number 1)
* Line 27 Prints index 0 of the list, which is now 2
* Line 28 Removes index 0, the number 2
* Line 29 prints the number 3
* line 30 removes 3
* Line 31 prints 4
* Line 32 removes 4
* Line 33 prints 5
* Line 34 removes 5
* Line 35 prints 6
* Line 36 removes 6
* Line 37 tries to remove index 0 but the array list is now empty
* Throws IndexOutofBoundsException
* Moves to line 40
* Catches the exception and prints stack trace
* Reaches end of program.
* 
* b. User input is 2
* Creates the list 1,2,3,4,5,6
* Line 25 enters the try block
* Line 26 removes integer at index 2
* List is now 1,2,4,5,6
* Line 27 prints 4
* Line 28 removes integer at index 2 (the number 4)
* List is now 1,2,5,6
* Line 29 prints 5
* Line 30 removes 5. List is now 1,2,6
* Line 31 prints 6
* Line 32 removes 6. List is now 1,2
* Line 33 tries to remove index 2.
* Throws IndexOutofBoundsException at line 33 
*  
* 
*/