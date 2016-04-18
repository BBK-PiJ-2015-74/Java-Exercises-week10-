/**
 * Exercise 1b week 14 Recursion II
 * @author lucieburgess
 *
 */

public class McCarthy91 {

	public McCarthy91() {
	}
	
	public int function_mcCarthy91 (int n) {
		if (n > 100) {
			return n - 10;
		} else {
			return function_mcCarthy91 (function_mcCarthy91(n+11));
		}
	}

}
