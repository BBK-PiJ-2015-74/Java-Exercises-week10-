// Example shown in class

public class Wee {

	public Wee() {
		// TODO Auto-generated constructor stub
	}
	
	static void bar() throws Throwable {
		throw new Throwable("Wee!");
	}
	
	static void foo() throws Throwable {
		bar();
		System.out.println("Foo!");
	}
	
	public static void main(String[] args) {
		try {
			foo();
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		System.err.println("I'm still running");
	}

}

// class is loaded in
// No variables loaded, no static initialisation or variables
// calls main method
// calls line 9
// calls 

// Output stream is non-deterministic
// System.out.println is buffered
// System.err.println is not buffered, so both responses run
// what will the output be?
// Wee!
// I'm still running
