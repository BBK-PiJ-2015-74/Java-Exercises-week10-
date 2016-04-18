package impl;

import java.io.File;
import java.util.Scanner;


public class Ex2_mkdir {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the directory you wish to create: "); // e.g. /Users/lucieburgess/Documents/mytestdir
		String myDir = sc.nextLine(); // this reads the next String input by the user
		
		File file = new File(myDir); 

		file.mkdir();

		if (sc != null) {
			sc.close();
		
		try {
			String[] myFileList = file.list();
		
			for (int i=0; i<myFileList.length; i++) {
				System.out.println(myFileList[i]);
			}
		} catch (NullPointerException ex){
			System.out.println("This directory does not exist");
		}
	
		}
	} // end of psvm
} // end of class

