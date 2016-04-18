/**
 * Exercise 3 Hailstone
 * 
 * @author lucieburgess
 * There is an error in this code which needs fixing!
 *
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;

public class Hailstone {
	
	public Hailstone() {
	}
	
	static List<Integer> hailStoneList;
	
	private static Map<Integer,Integer> memo = new ConcurrentHashMap<>(); 

	public static int getHailStone(int n) {
		int result = 0;
		if (memo.containsKey(n)) {
			System.out.println("Using hash map to memoize Hailstone numbers");
			memo.get(n);
		} else {
			int hail = 0;
			if (n%2 == 0 ) {
				 hail = (n/2);
			} else {
				hail = (3*n+1);
			}
			hailStoneList.add(hail);
			if (hail == 1) {
				return 1;
			} else {
				result = getHailStone(hail);
				memo.put(n, hail);
				System.out.println(memo);
				return result;
			}
		}
		return result;
	}   
    
} // end of class

