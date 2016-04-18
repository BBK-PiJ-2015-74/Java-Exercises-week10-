/**
 * Day 10 exercise 1
 * @See Phone.java, OldPhone.java, MobilePhone.java
 * @author lucieburgess
 *
 */

public class SmartPhone extends MobilePhone {

	public SmartPhone() {
	}
	
	private final static int X_ELEMENT = 100;
	private final static int Y_ELEMENT = 100;
	private double[][] GPSarray = new double[X_ELEMENT][Y_ELEMENT];
	// to complete setting up array of doubles with GPS co-ordinates

	public void browseWeb(String webURL) {
		System.out.println("Browsing the web (on SmartPhone) " + webURL);
	}
	
	public double findPosition() {
		double myPosition = 5.6789999;
		System.out.println("Returning your position (from SmartPhone) which is GPS co-ordinate " + myPosition);
		// GPSarray[0,0] = myPosition; need to look up how to fill array again!
		return myPosition;
	}
	
} // end of class
