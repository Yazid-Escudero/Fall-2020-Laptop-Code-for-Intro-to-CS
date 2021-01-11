//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description: reads multi-line text document. each line contains first name,
				//last name, department and GPA


import java.io.File;		//to read something from a file
import java.util.Scanner;	//read stream from file


public class ReadDB {
	public static void main(String[] args) {
		
		try {
			
			File sourceFile = new File("textFile1.txt");
			Scanner inFile = new Scanner(sourceFile);
			
			int rows = 7;
			int columns = 5;
			
			String[][] studentsDB = new String[rows][columns];
			
			int count = 0;
			
			//now go inside file and read the stuff
			//read from the file and fill the 2-D Array
			while (inFile.hasNextLine()) {
				
				String temp = inFile.nextLine();
				studentsDB[count] = temp.split(",");
				
				++count;
				
			}
			
			//find the master students
			for (int i = 0; i < rows; ++i) {
			
				if (studentsDB[i][3].trim().equals("Master")) {
					System.out.println(studentsDB[i][0]+studentsDB[i][1]);
				}
			
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println("Error while reading from the file" + e);
		}
		
	}

}