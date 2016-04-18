/**
 * a) Write a program that reads 10 numbers from the user and then prints the mean average. 
 * If the user inputs something that is not a number, the program should complain and ask for a number again until 10 numbers have been introduced.
 * b) Modify the program so that it first asks how many numbers the user wants to enter, and then asks for the numbers. 
 * The computer should complain if the user enters something that is not a number in both cases. Use methods to prevent code repetitions.
 * @author lucieburgess
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Average {


	public Average() {
		// auto generated method stub
	}
	
	public double Average(ArrayList<Integer> userInput) {
		
		List<Integer> userList = new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a number until you have entered 10 numbers: ");
			i = sc.nextInt(); // this reads the next int input by the user
			userList.add(i);
		}
		
		int result = 0;
		for (int k=0; k<10; k++) {
			int sum = userList.get(k);
			result = sum + result;	
		}
		
		double average = result/10;
		return average;
	}
}
