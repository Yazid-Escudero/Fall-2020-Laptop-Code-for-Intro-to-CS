//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description:
	//this program reads from a file that contains multi-entry lines.
	//the lines are stored as rows of an array, and the entires per line
	//are stored as the columns of each row of the array
	//this program's purpose is to compute the average GPA
	//for each category of students, which is masters, bachelors,
	//and doctoral students

import java.io.File;
import java.util.Scanner;

public class GPAPerProgram {
	
	//returns string without spaces
	public static String removeSpaces(String phrase) {
		
		String newPhrase = "";
		
		//add all non-space characters
		for (int i = 0; i < phrase.length(); ++i) {
		
			if (phrase.charAt(i) != ' ') {
				newPhrase += phrase.charAt(i);
			}
		
		}
		
		return newPhrase;
		
	}
	
	//main method
	public static void main(String[] args) {
	
		try {
			//we read from file. First, create a file path variable
			String filePath = "D:/Fresh Start/UTEP/Fall 2020/textFile1.txt";
			
			//now create objecs to be used for this code
			File sourceFile = new File(filePath);
			Scanner inFile = new Scanner(sourceFile);	//will be redeclared later
			
			//declare variables
			int lineCount = 0;	//# of lines will be computed
			
			int numBachelors = 0;		//
			double sumBachelors = 0;	//bachelors
			double averageBachelors;	//
			
			int numMasters = 0;			//
			double sumMasters = 0;		//masters
			double averageMasters;		//
			
			int numDoctorals = 0;		//
			double sumDoctorals = 0;	//doctorals
			double averageDoctorals;	//
			
			
			//count # of lines
			while (inFile.hasNextLine()) {
				//increase lineCount and consume current line
				++lineCount;
				inFile.nextLine();
			}
			
			//create the array to contain file data
			String[][] studentData = new String[lineCount][5];
			
			//redeclare scanner for fresh unused file contents
			inFile = new Scanner(sourceFile);
			
			
			//limit the scope of indexCount variable to these brackets
			{
				int indexCount = 0;
				
				//populate studentData[][] with while loop
				while (inFile.hasNextLine()) {
					
					String temp = removeSpaces(inFile.nextLine());
					studentData[indexCount] = temp.split(",");
					++indexCount;
			
				}
			}
			
			
			/*
			//FIXME: DELETE THIS WHOLE PRINTING SECTION LATER
			System.out.println("######ARRAY CONTENTS########");
			for (int i = 0; i < studentData.length; ++i) {
				System.out.print(studentData[i][0] + " ");
				System.out.print(studentData[i][1] + " ");
				System.out.print(studentData[i][2] + " ");
				System.out.print(studentData[i][3] + " ");
				System.out.println(studentData[i][4]);
			}
			*/
			
			//calculate the number of students in each program and corresponding
			//sum
			for (int i = 0; i < studentData.length; ++i ) {
			
				if(studentData[i][3].equals("Bachelor")) {
					sumBachelors += Double.parseDouble(studentData[i][4]);
					++numBachelors;
				}else if (studentData[i][3].equals("Master")) {
					sumMasters += Double.parseDouble(studentData[i][4]);
					++numMasters;
				}else if (studentData[i][3].equals("Doctoral")) {
					sumDoctorals += Double.parseDouble(studentData[i][4]);
					++numDoctorals;
				}
				
			}
			
			
			/*
			System.out.println("*\n*\n*");
			System.out.println("FIXME: Delete later! Details:");
			System.out.println("sumBachelors is: " + sumBachelors);
			System.out.println("numBachelors is: " + numBachelors);
			System.out.println("sumMasters is: " + sumMasters);
			System.out.println("numMasters is: " + numMasters);
			System.out.println("sumDoctorals is: " + sumDoctorals);
			System.out.println("numDoctorals is: " + numDoctorals);
			System.out.println("*\n*\n*");
			*/
			
			System.out.println("---------------------------------------------------------");
			System.out.println("Average GPA for Bachelor Students: "  + (sumBachelors / numBachelors));
			System.out.println("Average GPA for Master Students: " + (sumMasters / numMasters));
			System.out.println("Average GPA for Doctoral Students: " + (sumDoctorals / numDoctorals));
			System.out.println("---------------------------------------------------------");
			
			
			
		}catch(Exception e) {
			System.out.println("Error ocurred while reading from the file:\n" + e + "\n\n\n");
		}
		
	
	}



}