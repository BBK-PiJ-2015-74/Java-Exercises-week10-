/**
 * A class which implements interface Phone
 * @author lucieburgess
 *
 */

public class OldPhone implements Phone {

	/** constructor of class OldPhone
	 * 
	 */
	public OldPhone() {
	}
	
	@Override
	public void call(String number) {

		System.out.println("Please enter the number you wish to call (from OldPhone");
		System.out.println("Calling " + number);

	}

}
