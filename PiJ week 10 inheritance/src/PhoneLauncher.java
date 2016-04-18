/** 
 * This class launches the SmartPhone and MobilePhone classes and runs the code
 * We could also use it to run the code from OldPhone, but this is implemented (and extended) by MobilePhone
 * @author lucieburgess
 *
 */

public class PhoneLauncher {

	public static void main(String[] args) {
		
		PhoneLauncher launcher = new PhoneLauncher();
		launcher.launch();	
	}

	public void launch() {
		
		MobilePhone myNokia = new MobilePhone();
		
		String number1 = "01865 277183";
		String number2 = "0207 546 1234";
		String number3 = "123";
		String number4 = "567";
		String number5 = "8910";
		String number6 = "111213";
		String number7 = "141516";
		String number8 = "171819";
		String number9 = "202122";
		String number10 = "232425";
		String number11 = "262728";
		String number12 = "293031";
		String number13 = "323334";
		
		System.out.println("Calling phone numbers on MobilePhone myNokia");
		myNokia.call(number1);
		myNokia.call(number2);
		myNokia.call(number3);
		myNokia.call(number4);
		
		myNokia.printLastNumbers();
		
		myNokia.call(number5);
		myNokia.call(number6);
		myNokia.call(number7);
		myNokia.call(number8);
		myNokia.call(number9);
		myNokia.call(number10);
		myNokia.call(number11);
		myNokia.call(number12);
		myNokia.call(number13);
		
		myNokia.printLastNumbers();
		
		String alarm1 = "BEEP BEEP";
		String alarm2 = "RING RING";
		String alarm3 = "Switching on the radio";
		
		System.out.println("Time to go to Java class - ringing alarm on MobilePhone my Nokia");
		myNokia.ringAlarm(alarm1);
		
		String game1 = "Tetris";
		String game2 = "Minecraft";
		String game3 = "Sudoku";
		
		System.out.println("Time to have some fun - playing a game on MobilePhone my Nokia");
		myNokia.playGame(game1);
		
		SmartPhone myiPhone = new SmartPhone();
		
		String webURL1 = "http://bl.uk";
		String webURL2 = "https://bodleian.ox.ac.uk";
		String webURL3 = "https://moodle.bbk.ac.uk";
		System.out.println("Making a call on SmartPhone iPhone to this number: " + number12);
		
		myiPhone.browseWeb(webURL1);
		
		
	}
}
