package lambdahol;

/*
 * For each exercise, develop a solution using Java SE 8 Lambda/Streams
 * and remove the @Ignore tag.
 */

import org.junit.Test;

import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Exercises {

    @Before
    public void setUpBufferedReader() throws IOException {
    	Path path = FileSystems.getDefault().getPath("SonnetI.txt");
        reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
    }

    
    @After
    public void closeBufferedReader() throws IOException {
        reader.close();
    }


    static final String REGEXP = "\\W+"; // for splitting into words

    static List<String> wordList = Arrays.asList("every", "problem", "in", "computer", "science", "can", "be", "solved", 
    		"by", "adding", "another","level", "of", "indirection");

    private BufferedReader reader;

    //EXERCISE 1
    /** 
     * Print out all the words in wordList, which is a static List<String> 
     */
    @Test
    public void printAllWords() {
        wordList.forEach(System.out::println);
        System.out.println("\n");
    }

    
    // EXERCISE 2
    /**
     * Convert all words in wordList to upper case, and gather the result into an output list.
     * @param inputList
     * @param transform
     * @return
     */
    private List<String> transformedList(List<String> inputList, Function<String, String> transform) {
		List<String> outputList = new LinkedList<>();
		for (String str:inputList) {
			String outStr = transform.apply(str);
			outputList.add(outStr);
		}
		return outputList;
	}
       
    @Test
    public void upperCaseWords() {
    	
    	List<String> output = transformedList(wordList, s -> s.toUpperCase());
        assertEquals(
                Arrays.asList(
                        "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                        "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                        "LEVEL", "OF", "INDIRECTION"),
                output);
    }

    //EXERCISE 3
    /**
     * Find all the words in wordList that have even length and put them into an output list
     */
    
    public static List<String> allMatches(List<String> myList, Predicate<String> fn ) {		
		List<String> output = new LinkedList<>();
		for (String str:myList) {
			if (fn.test(str)) {
				output.add(str);
			}
		}
		return output;
	}
    
	@Test
    public void findEvenLengthWords() {
        List<String> output = allMatches(wordList, s -> s.length() % 2 == 0);

        assertEquals(
                Arrays.asList(
                        "in", "computer", "be", "solved", "by", "adding", "of"),
                output);
    }

	//EXERCISE 4
   /**
    * Count the number of lines in a file. The field *reader*
    * @throws IOException
    * is a BufferedReader which will be opened for you on the text file.
    * See the JUnit @Before and @After methods at the bottom of this file.
    * The text file is "SonnetI.txt" (Shakespeare's first sonnet) which is
    * located at the root of this NetBeans project.
    */

    @Test
    public void countLinesInFile() throws IOException {
        long count = 0L; 
        count = reader.lines().count();
        assertEquals(14, count);
    }


    // EXERCISE 5
    /**
     * Join lines 3-4 from the text file into a single string.
     * @throws IOException
     */
    @Test
    public void joinLineRange() throws IOException {
        String output = "";
        Stream<String> lines = reader.lines();
        List<String> lineList = lines.collect(Collectors.toList());
        String line3 = lineList.get(2);
        String line4 = lineList.get(3);
        output = line3 + line4;

        assertEquals(
                "But as the riper should by time decease," +
                        "His tender heir might bear his memory:",
                output);
    }

    // EXERCISE 6 
    /**
     * Find the length of the longest line in the file.
     * @throws IOException
     * ?? Could do this with an Optional<T> .max() according to specified Comparator?
     */
    @Test
    public void lengthOfLongestLine() throws IOException {
        int longest = 0; 
        Stream<String> lines = reader.lines();
        List<String> lineList = lines.collect(Collectors.toList());
        Collections.sort(lineList, (x,y) -> x.length() - y.length());
        longest = lineList.get(lineList.size()-1).length();
        assertEquals(longest, 53);
    }

   // EXERCISE 7 
    /**
     * Collect all the words from the text file into a list.
     * @throws IOException
     * Hint: use String.split(REGEXP) to split a string into words
     * Splitting this way results in "words" that are the empty string,
     * which should be discarded. REGEXP is defined at the bottom of this file.
     * NB My solution: could have also done the following:
     * //List<String> linesjoined = new LinkedList<>();
     * //linesjoined = reader.lines().sequential().collect(Collectors.toList());
     * //StringBuilder sb = new StringBuilder();
     * //for (String str:linesjoined) {
     * //	sb.append(str);
     * //}   
     */
    @Test
    public void listOfAllWords() throws IOException {
    	
        String linesjoined = reader.lines().collect(Collectors.joining(","));
        String[] intermediateoutput = linesjoined.split(REGEXP);
        List<String> output = new ArrayList<>();
        for (String s:intermediateoutput) {
        	if (!s.equals(REGEXP)) {
        		output.add(s);
        	}
        }
        
        assertEquals(
                Arrays.asList(
                        "From", "fairest", "creatures", "we", "desire", "increase",
                        "That", "thereby", "beauty", "s", "rose", "might", "never", "die",
                        "But", "as", "the", "riper", "should", "by", "time", "decease",
                        "His", "tender", "heir", "might", "bear", "his", "memory", "But",
                        "thou", "contracted", "to", "thine", "own", "bright", "eyes",
                        "Feed", "st", "thy", "light", "s", "flame", "with", "self",
                        "substantial", "fuel", "Making", "a", "famine", "where",
                        "abundance", "lies", "Thy", "self", "thy", "foe", "to", "thy",
                        "sweet", "self", "too", "cruel", "Thou", "that", "art", "now",
                        "the", "world", "s", "fresh", "ornament", "And", "only", "herald",
                        "to", "the", "gaudy", "spring", "Within", "thine", "own", "bud",
                        "buriest", "thy", "content", "And", "tender", "churl", "mak",
                        "st", "waste", "in", "niggarding", "Pity", "the", "world", "or",
                        "else", "this", "glutton", "be", "To", "eat", "the", "world", "s",
                        "due", "by", "the", "grave", "and", "thee"),
                output);
    }

    // EXERCISE 8 
    /**
     * Create a list containing the words, lowercased, in alphabetical order.
     * @throws IOException
     */

    @Test
    public void sortedLowerCase() throws IOException {
    	String linesjoined = reader.lines().sequential().collect(Collectors.joining(","));
        String[] intermediateoutput = linesjoined.split(REGEXP);
        
        List<String> output = new ArrayList<>();
        for (String s:intermediateoutput) {
        	if (!s.equals(REGEXP)) {
        		output.add(s);
        	}
        }
        
        output = output.stream().map(s -> s.toLowerCase()).collect(Collectors.toList()); //map words to LowerCase, needs to be assigned to output
        output.sort((s1, s2) -> s1.compareTo(s2)); // doesn't need to be assigned to output because .sort() returns void
        System.out.println("Exercise 8: printing output of all words after sort:" + output);

        assertEquals(
                Arrays.asList(
                        "a", "abundance", "and", "and", "and", "art", "as", "be",
                        "bear", "beauty", "bright", "bud", "buriest", "but", "but",
                        "by", "by", "churl", "content", "contracted", "creatures",
                        "cruel", "decease", "desire", "die", "due", "eat", "else",
                        "eyes", "fairest", "famine", "feed", "flame", "foe", "fresh",
                        "from", "fuel", "gaudy", "glutton", "grave", "heir", "herald",
                        "his", "his", "in", "increase", "lies", "light", "mak",
                        "making", "memory", "might", "might", "never", "niggarding",
                        "now", "only", "or", "ornament", "own", "own", "pity",
                        "riper", "rose", "s", "s", "s", "s", "self", "self", "self",
                        "should", "spring", "st", "st", "substantial", "sweet",
                        "tender", "tender", "that", "that", "the", "the", "the",
                        "the", "the", "the", "thee", "thereby", "thine", "thine",
                        "this", "thou", "thou", "thy", "thy", "thy", "thy", "thy",
                        "time", "to", "to", "to", "to", "too", "waste", "we", "where",
                        "with", "within", "world", "world", "world"),
                output);
    }


    // EXERCISE 9 
    /**
     * Sort unique, lower-cased words by length, then alphabetically
     * within length, and place the result into an output list.
     */
    @Test
    public void sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
        
    	Function<String, String> omitspaces = s -> {
    		if (!s.equals(REGEXP)) return s;
    		else return "";
    	};
    	
        String linesjoined = reader.lines().collect(Collectors.joining(","));
        String[] intermediateoutput = linesjoined.split(REGEXP);
        
        List<String> output = new ArrayList<>();
        for (String s:intermediateoutput) {
        		output.add(s);
        	}
        
        output = output.stream()
        		.map(omitspaces) //NB. .map(mapper) where mapper is a Function
        		.map(s -> s.toLowerCase())
        		.distinct()
        		.sorted((s1, s2) -> s1.compareTo(s2))
        		.sorted((s1, s2) -> (s1.length()-s2.length()))
        		.collect(Collectors.toList());
       
        System.out.println("Exercise 9: mapped to lower case, distinct and sorted by length" + output);
        
        assertEquals(
                Arrays.asList(
                        "a", "s", "as", "be", "by", "in", "or", "st", "to", "we",
                        "and", "art", "bud", "but", "die", "due", "eat", "foe", "his",
                        "mak", "now", "own", "the", "thy", "too", "bear", "else",
                        "eyes", "feed", "from", "fuel", "heir", "lies", "only",
                        "pity", "rose", "self", "that", "thee", "this", "thou",
                        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
                        "grave", "light", "might", "never", "riper", "sweet", "thine",
                        "waste", "where", "world", "beauty", "bright", "desire",
                        "famine", "herald", "making", "memory", "should", "spring",
                        "tender", "within", "buriest", "content", "decease",
                        "fairest", "glutton", "thereby", "increase", "ornament",
                        "abundance", "creatures", "contracted", "niggarding",
                        "substantial"),
                output);
    }

    // EXERCISE 10: 
    /**
     * Categorize the words into a map, where the map's key is
     * the length of each word, and the value corresponding to a key is a
     * list of words of that length. Don't bother with uniqueness or lower-casing the words.
     * public V put (K key, V value)
     * @throws IOException
     */
    @Test
    public void mapLengthToWordList() throws IOException {
  
    	//Integer is the length of each word
    	//List<String> is the list of words of length Integer
    	//No need to sort alphabetically within the word length in this exercise
    	//Converting Optional<T> to <T> - just use .get()
    	
        Map<Integer, List<String>> map = new HashMap<>();
        
        String linesjoined = reader.lines().collect(Collectors.joining(","));
        String[] intermediateoutput = linesjoined.split(REGEXP);
        
        List<String> output = new ArrayList<>();
        for (String s:intermediateoutput) {
        		output.add(s);
        	}
        
        output = output.stream()
        		.sorted((s1, s2) -> (s1.length()-s2.length()))
        		.collect(Collectors.toList());
        
        Integer maxK = output.stream().max((s1, s2) -> (s1.length()-s2.length())).get().length();  
        
        System.out.println("The length of the longest word is :" + maxK);
        
        for (Integer K=0; K<=maxK; K++) { // for loop by length of word K
        	List<String> V = new ArrayList<>();
        	for (String str:output) {
        		if (str.length() == K) V.add(str); 
        		map.put(K,V);
        	}
        }        

        assertEquals(6, map.get(7).size());
        assertEquals(Arrays.asList("increase", "ornament"), map.get(8));
        assertEquals(Arrays.asList("creatures", "abundance"), map.get(9));
        assertEquals(Arrays.asList("contracted", "niggarding"), map.get(10));
        assertEquals(Arrays.asList("substantial"), map.get(11));
        assertFalse(map.containsKey(12));
    }
    
    // EXERCISE 11: 
    /**
     * Gather the words into a map, accumulating a count of the
     * number of occurrences of each word. Don't worry about upper case and lower case.
     * String is the key K, the values are the word frequency
     * @throws IOException
     */
    @Test
    public void wordFrequencies() throws IOException {
        
    	Map<String, Long> map = new HashMap<>();
        
        String linesjoined = reader.lines().collect(Collectors.joining(","));
        String[] intermediateoutput = linesjoined.split(REGEXP);
        
        List<String> output = new ArrayList<>();
        for (String s:intermediateoutput) {
        		output.add(s);
        	}

        //output is a list of all the words that occur
        
        Long V = (long) 0;
        String K = "";
        for (String str:output) {
        	V = output.stream().filter(s -> s.equals(str)).count();
        	K = output.stream().filter(s -> s.equals(str)).findFirst().get();
        	map.put(K, V);
        }
        
        assertEquals(2L, (long) map.get("tender"));
        assertEquals(6L, (long) map.get("the"));
        assertEquals(1L, (long) map.get("churl"));
        assertEquals(2L, (long) map.get("thine"));
        assertEquals(3L, (long) map.get("world"));
        assertFalse(map.containsKey("java8"));
    }

    // Exercise 12: Create a nested grouping, where the outer map is a map
// from the first letter of the word to a submap. (Use a string of length
// one as the key.) The submap, in turn, is a mapping from the length of the
// word to a list of words with that length. Don't bother with any downcasing
// or uniquifying of the words.
//
// For example, given the words "foo bar baz bazz" the top level map would have
// a keys of "f" and "b". The value corresponding to "b" would be a map with
// a key of 3 with a value of [bar baz] (a list of Strings) and a key of 4
// with a value of [bazz] (a one-element list of String).

    @Test
    @Ignore
    public void nestedGrouping() throws IOException {
        Map<String, Map<Integer, List<String>>> map = null; /* TODO */

        assertEquals("[From, Feed]", map.get("F").get(4).toString());
        assertEquals("[by, be, by]", map.get("b").get(2).toString());
        assertEquals("[the, thy, thy, thy, too, the, the, thy, the, the, the]",
                map.get("t").get(3).toString());
        assertEquals("[beauty, bright]", map.get("b").get(6).toString());
    }
}
