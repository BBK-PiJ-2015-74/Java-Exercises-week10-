package examples;

public class MyStringOps {

	// was public static String strReverse(String str)
	String strReverse(String str){
		
		String result = "";
		
		for (int i=str.length()-1; i>0; i--) {
			result += result.charAt(i);
		}
		return result;
	}
}
