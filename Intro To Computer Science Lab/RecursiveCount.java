//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description:
	//recursive method finds number of times that a specified character occurs inside a string
	//example: recursie method returns 2 in the case of character = 'e' and string = "Welcome"
	
import java.util.Scanner;

public class RecursiveCount {
	
//count method counts number of occurrences of character in a passed string
	public static int count(String phrase, char character, int currentIndex) {
		
	//Base Case: currentIndex is last accessible index...
		if (currentIndex == (phrase.length()) - 1) {
			
		//if last character is the specified character...
			if (phrase.charAt(currentIndex) == character) {
			
				return 1;
			
			}
		//if not... 
			else {
				
				return 0;
				
			}
		}
		
	//If NOT Base Case... 
		else {
		
		//if phrase.charAt(currentIndex) is the specified characcter
			if (phrase.charAt(currentIndex) == character) {
				
				return 1 + count(phrase, character, currentIndex + 1);
				
			}
		//if not...
			else {
				
				return count(phrase, character, currentIndex + 1);
				
			}
		
		}
		
		//end of count() function
	}
	
//PrintUserNotice() simply tells the user that this program is Case SENSITIVE!
	public static void PrintUserNotice() {
		
	//Before anything else, tell user that this program is case sensitive...
	//example: y and Y are NOT the same!		
		System.out.println("***************************************************");
		System.out.println("NOTICE: This program is Case Sensitive!");
		System.out.println("\tExample: Y and y are NOT the same!");
		System.out.println("***************************************************");
		System.out.println("\n\n");
	}
	
	
//MAIN METHOD
	public static void main(String[] args) {
		
	//Create Scanner Object
		Scanner input = new Scanner(System.in);
	//Create Necessary and non-temporary variables
		int charCount = 0;
		char userChar = '\0';
		String userPhrase = null;
		
	//Before anything else, tell user that this program is case sensitive...
	//example: y and Y are NOT the same!
		PrintUserNotice();
		
		
	//Grab user input and save to corresonding varialbes
		System.out.print("Please enter a string. Any String\n>> ");
		userPhrase = input.nextLine();
		System.out.print("Choose a character!\n>> ");
		userChar = input.nextLine().charAt(0);
		
	//Call function and assign return value to charCount
		charCount = count(userPhrase, userChar, 0);
	//Now output the result!
		String result = "Number of occurrences of character " + userChar + " in entered phrase:\n";
		System.out.println(result + charCount);
		
	}
	
	
}