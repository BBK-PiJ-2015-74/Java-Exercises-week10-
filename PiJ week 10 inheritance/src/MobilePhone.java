/**
 * Create a class MobilePhone that extends OldPhone and adds methods for ringAlarm(String) and playGame(String)
 * @author lucieburgess
 * 
 * Uses the method System.arraycopy(): public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 * The two Object arguments specify the array to copy from and to
 * The three int rguments specify the starting position in the source array, the starting position in the destination array, 
 * and the number of array elements to copy.
 *
 */

public class MobilePhone extends OldPhone {

	public MobilePhone() {
	}

	private final static int LAST_TEN_NUMBERS = 10;
	private String[] lastNumber = new String[LAST_TEN_NUMBERS];
	private int index = 0;
	
	@Override
	public void call(String number) {
		super.call(number);				// this calls the code from the superclass OldPhone, so you don't have to write the method again
		// we only need this because we are extending the method call(String number); hence super.call(number)
		System.out.println("Saving number to recent calls in memory (from MobilePhone)");
		if (index < LAST_TEN_NUMBERS) {
			lastNumber[index++] = new String (number); // fills the array of Strings lastNumber which increases in size
		} else { // throw away the first number and shift the rest down
			System.arraycopy(lastNumber, 1, lastNumber, 0, LAST_TEN_NUMBERS-1);
			lastNumber[LAST_TEN_NUMBERS-1] = number; // puts number into the last position in the array, which is LAST_TEN_NUMBERS-1 - remember arrays start at position 0
		}
		System.out.println("Telephone numbers saved to memory = " + index);
	}

	public void ringAlarm(String alarm) {
		System.out.println("Alarm (from mobilePhone) is ringing" + alarm);
	}

	public void playGame(String game) {
		System.out.println("Playing game (from MobilePhone)" + game);
	}
	
	public void printLastNumbers() {
		System.out.println("== LAST " + index + " NUMBERS (from MobilePhone) ==");
		for (int i = 0; i < index; i++) {
			System.out.println(lastNumber[i]);
		}
	}
}

// this code needs fixing. printLastNumbers is not filling the array correctly
