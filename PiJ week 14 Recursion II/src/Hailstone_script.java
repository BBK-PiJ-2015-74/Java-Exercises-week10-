import java.util.Scanner;


public class Hailstone_script {

	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a number n and this script will calculate Hailstone(n): ");
	int z = sc.nextInt(); // this reads the next int input by the user

	System.out.println("The iterative Hailstone sequence for n=" + z + " is");
	System.out.println(Hailstone.getHailStone(10));

	if (sc != null) {
		sc.close();
	}

	}

}
