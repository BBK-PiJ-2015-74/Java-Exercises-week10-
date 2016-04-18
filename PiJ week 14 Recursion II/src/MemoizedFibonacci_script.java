import java.util.Scanner;

public class MemoizedFibonacci_script {

	public MemoizedFibonacci_script() {
	}

	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a number n and this script will calculate Fibonacci(n): ");
	int z = sc.nextInt(); // this reads the next int input by the user

	System.out.println("The iterative Fibonacci sequence for n=" + z + " is");
	System.out.println(MemoizedFibonacci.getFib(z));

	if (sc != null) {
		sc.close();
	}

	}

}
