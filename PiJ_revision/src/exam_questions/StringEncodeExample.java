package exam_questions;

public class StringEncodeExample {

	public StringEncodeExample() {
		
	}

	public static String encode(String source, String from, String to) {
		
		for (int k = 0; k < from.length(); k++) {
            source = substitute(source, from.charAt(k), to.charAt(k));
		}
        return source;
		
	}
	
	private static String substitute(String input, char f, char t) {
		
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            sb.append((ch == f) ? t : ch);
        }
        return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(encode("Amy loved her dog","dle", "gdx"));
	}

	
}
