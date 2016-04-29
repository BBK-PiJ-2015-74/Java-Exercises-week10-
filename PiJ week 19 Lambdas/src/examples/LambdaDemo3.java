package examples;

/**
 * @see NumericTest2
 * @author lucieburgess
 *
 */

public class LambdaDemo3 {

	public static void main (String[] args) {
		// this lambda expression determines if one number is a factor of another
		NumericTest2 isFactor = (n,f) -> (n % f) == 0;
		
		int j = 10;
		int k = 2;
		if(isFactor.test(j,k))
			System.out.println(k + " is a factor of " + j);
		
		int l = 10;
		int m = 3;
		if(!isFactor.test(l,m))
			System.out.println(m + " is not a factor of " + l);
	}
}
