import java.util.Scanner;

// Exercise 4

public class ResponsiveUI implements Runnable {
	
	private int taskID;
	private static final int TASK_NUMBER = 10;
	
	public ResponsiveUI(int taskID) {
		this.taskID = taskID;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		for (int i =0; i<=10; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Task " + i+ ":");
			System.out.print("Enter the task length in seconds ");
			if (sc != null) {
				sc.close();
			}
		}
	}
}


	
