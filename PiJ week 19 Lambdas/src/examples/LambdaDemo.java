package examples;
import examples.MyNumber;

public class LambdaDemo {
	
	public static void main (String [] args) {
		MyNumber myNum; // declare a reference to an interface
		
		// myNum is not a fixed number: it allow us to execute the block of code getValue() using a 
		// lambda function to define the value of myNum
		
		myNum = () -> 123.45;
		System.out.println("My number is " + myNum.getValue());
		
		myNum = () -> Math.random() *100;
		System.out.println("My number is " + myNum.getValue());
		
		myNum = () -> Math.random() *100;
		System.out.println("My number is " + myNum.getValue());
		
	}

}
