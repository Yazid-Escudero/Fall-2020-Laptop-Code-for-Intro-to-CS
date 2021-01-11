//Author: Yazid Escudero
//Description: Test error that pops when creating scanner object to read from File object and then passing it to another function

import java.io.File;
import java.util.Scanner;

public class ScannerErrorExample {
	
//PrintFile simply prints out CSV file content line by line, with spaces instead of commas
	public static void PrintFile(Scanner fileInput /*could have been called "inputF"*/) {
		
	//Print newlines (3)
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	//While loop prints out CSV flie (commas --> spaces) line by line
		while (fileInput.hasNextLine()) {
			
			String temp = fileInput.nextLine().replace(',', ' ');	//next line in CSV file with all commas turned as spaces
			System.out.println(temp);
			
		}
		
		System.out.println("\n\n\nFile Reading Complete!");
		
	}
	
//Main Method
	public static void main(String[] args) {
		
	try {
		
		//Scanner and File objects to read from file	
			File sourceFile = new File("D:/Fresh Start/UTEP/Fall 2020/Intro To Computer Science Lab/Comprehensive Lab 2/MortgageApplications.csv");
			Scanner inputF = new Scanner(sourceFile);
		
		//Call method - prints out every line in file
			PrintFile(inputF);
		
		
		} catch(Exception e) {
			System.out.println("Error while reading file:\n" + e);
		}
	}
	
}