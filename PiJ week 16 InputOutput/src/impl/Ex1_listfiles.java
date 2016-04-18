package impl;

import java.io.File;

public class Ex1_listfiles {

	public static void main(String[] args) {
	
		File file = new File("/Users/lucieburgess/Documents"); // "." just means a pointer to the current directory
		
//		if (file.isDirectory() == false) {
//			System.out.println("This directory does not exist");
//		}
		
		try{
			String[] myFileList = file.list();
		
			for (int i=0; i<myFileList.length; i++) {
				System.out.println(myFileList[i]);
			}
		} catch (NullPointerException npe){
			System.out.println("This directory does not exist");
		}
		
	}

}
