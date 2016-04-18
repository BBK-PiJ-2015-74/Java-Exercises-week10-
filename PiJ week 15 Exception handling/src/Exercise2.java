/**
 * Exercise 2 Exception Handling day 15
 * @author lucieburgess
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {

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
			} catch (NullPointerException ex) { // this would be an unreachable catch block, if below catch (Exception ex). It already handled by the catch block Exception
				ex.printStackTrace();
			} catch (Exception ex) { 
				ex.printStackTrace();
			} 
		}		
	}


