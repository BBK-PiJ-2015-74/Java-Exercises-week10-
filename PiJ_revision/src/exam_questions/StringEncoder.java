package exam_questions;
/**
 * Q8 from the 2015 PiJ exam paper
 * @author lucieburgess
 *
 */
public class StringEncoder {

	public StringEncoder() {
	}

	public static String encode(String source, String from, String to) {
	
		
		for (int k=0; k<from.length(); k++) { 
			
			StringBuilder sb = new StringBuilder(); // have to bring the new StringBuilder inside the loop for the replacement to start again
			
			for (int i=0; i< source.length(); i++) { // i = 0. In the first loop we want to replace l with d
				char sourcechar = source.charAt(i);
				char fromchar = from.charAt(k);
				char tochar = to.charAt(k);
				if (sourcechar == fromchar) {
					sourcechar = tochar;
				}		
				sb.append(sourcechar);
				System.out.println(sb.toString());
			}
			source = sb.toString(); // after we have been through the source string once (k = 0), we need to replace it
									// with the output of the first loop 
		}
		return source;
	}
	
	public static void main(String[] args) {
		System.out.println(encode("Amy loved her dog","dle", "gdx"));
	}
	
}
