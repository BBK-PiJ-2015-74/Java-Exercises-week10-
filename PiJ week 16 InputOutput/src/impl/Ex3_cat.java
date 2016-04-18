// this is not finished

package impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.File;
import java.util.Scanner;


public class Ex3_cat {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the directory and file you wish to read: "); // e.g. /Users/lucieburgess/Documents/mytestdir
		String myFile = sc.nextLine(); // this reads the next String input by the user
		
		File file = new File (myFile); 
		
//		if (file.exists() == false) {
//			System.out.println("This file does not exist in the current directory");
			
			try (BufferedReader in = new BufferedReader(new FileReader(file))) { 
			
			String line = file.readLine();
			StringBuilder sb = new StringBuilder();
			sb.append("The file contents starts here:");
			
			while (line != null) {
				sb.append; 
				line = file.readLine();
			}
			System.out.println(sb.toString());
			
			} catch (FileNotFoundException ex) {
				System.out.println("File" + file + " does not exist");
				
			} catch (IOException ex) {
				ex.printStackTrace();
			
			} finally {
				closeReader(in);
			}
			
		private void closeReader(Reader reader) {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		

	}// end of psvm
} // end of class

//... means variable arguments varargs

