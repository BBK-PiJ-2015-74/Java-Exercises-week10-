/**
 * Testfile using JUnit for the Person class
 * @author BBK-PiJ-2015-74
 *
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest { 
	
	@Test
	public void testsNormalName() {
		Person p = new Person();
		String input = "Dereck Robert Yssirt"; 
		String output = p.getInitials(input); 
		String expected = "DRY"; 
		assertEquals(output, expected);
	} 

}

