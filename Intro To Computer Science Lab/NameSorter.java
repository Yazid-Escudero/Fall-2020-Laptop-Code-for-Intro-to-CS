//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description: This program takes a list of ten strings, which are stored in array
			 //Then sort the array into ascending order and deccending order
			 //then print out array in both ascending and decending order
			 
			 
import java.util.Scanner;

public class NameSorter {
	
	//prints a newline to create vertical space in console
	public static void PrintVerticalSpace() {
		System.out.println();
	}
	
	//replaces all strings in string[] array with trimmed versions of themselves
	public static void TrimArrayStrings(String[] array) {
		
		for (int i = 0; i < array.length; ++i) {
			array[i] = array[i].trim();
		}
		
	}
	
	//replaces all strings in string[] array with lowercase versions of themselves
	public static void LowerCaseArrayStrings(String[] array) {
	
		for (int i = 0; i < array.length; ++i) {
			array[i] = array[i].toLowerCase();
		}
	
	}
	
	//compares two strings. Explanation inside the method
	public static int CompareTwoStrings(String stringOne, String stringTwo) {
		
		
		//ASCII COMPARISON:
			// zero if two compared elements are equal (size and characters)
			//positive if second is "larger" than the first element
			//negative if first is "larger" than the second element
		
		int evaluation = 0;					 //assume two strings are equal at first
		
		//determine smallest string length
		int smallestLength = 0;
		
		if (stringOne.length() == stringTwo.length()) {
			smallestLength = stringOne.length();
		}
		else if (stringOne.length() < stringTwo.length()) {
			smallestLength = stringOne.length();
		}
		else if (stringOne.length() > stringTwo.length()) {
			smallestLength = stringTwo.length();
		}
		
		//we must assume that if one string is larger than the other, then THAT string will be
		//"greater" than the second string, unless for loop below determines otherwise
		if (stringOne.length() > stringTwo.length()) {
			evaluation = -1;
		}
		else if (stringOne.length() < stringTwo.length()) {
			evaluation = 1;
		}
		else { //if string lengths are equal, assume total equality
			evaluation = 0;
		}
		
		
		//now compare character by character
			//if inequality is found, assig corresponding evaluation to "evaluation"
			//and set evaluationCompleted to true, then break from the loop
			//we assume equality. If not equal, the loop will assign correspoding inteeger evaluation
		for (int i = 0; i < smallestLength; ++i) {
			
			//if a character comparison shows second string should go after first string...
			if (stringOne.charAt(i) < stringTwo.charAt(i)) {
				evaluation = 1;
				break;	//evaluation found. NO more need to iterate. 
			}
			//else if character comparison shows first string should go after the second...
			else if (stringOne.charAt(i) > stringTwo.charAt(i)) {
				evaluation = -1;
				break;	//evaluation found. NO more need to iterate.
			}
		}
		
		//if no inequality found at all, then assumed evaluation will be passed.
		return evaluation;
	}
	
	//sorts array passed into alphabeticall ascending array
	public static void SortArrayAscending(String[] array) {
	
		boolean flag = true; //assume the pairs are intially unordered
		
		while (flag) {
			
			//if flag was set to true, then it will be reset to false
			//and raised again if another unordered pair is found
			flag = false;
			
			for (int i = 0; i < (array.length) - 1; ++i) {
				
				//ASCII COMPARISON:
				// zero if two compared elements are equal (size and characters)
				//positive if second is "larger" than the first element
				//negative if first is "larger" than the second element
				int ascendingOrderEvaluation = CompareTwoStrings(array[i], array[i + 1]);
				
				//if strings are unordered alphabetically ascending...(negative evaluation)
				if (ascendingOrderEvaluation < 0) {
					
					flag = true;	//unordered pair found! will make the for loop iterate again
				
					String temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				//if strings are equal or ordered alphabetically ascending (zero or positive evaluation),
				//then do nothing. nothing is necessary
		
			}
		
		}
	
	}
	
	//sorts array that is ALREADY in ascending alphabetical order into descending alphabetical order
	public static void SortArrayDescending(String[] array) {
	
		//array should already be in ascending order
		//now, simply reverse the array
		
		int halfway = (array.length) / 2;
		
		for (int i = 0; i < halfway; ++i) {
			
			String temp = array[i];
			array[i] = array[(array.length) - 1 - i];
			array[(array.length) - 1 - i] = temp;
			
		}
		
		//done sorting intt alphabetically descending order!!
	
	}
	
	//prints out a perfect sized array
	public static void PrintPerfectSizeStringArray(String[] array) {
	
		//use enhanced for loop!
		for (String currentName : array) {
			System.out.println(currentName);
		}
		
		//Print two vertical spaces
		PrintVerticalSpace();
		PrintVerticalSpace();
		
		
	
	}
	
	//the MAIN METHOD
	public static void main(String[] args) {
	
		Scanner inUser = new Scanner(System.in);
		boolean userInsight = false;	//true with correct CMD arguments
		String[] names = new String[10];
		
		//check if String[] args contains arguments from CMD
		if (args.length > 0) {
			//check if user offered "userInsight-TRUE" as CMD argument
			if (args[0].equals("userInsight-TRUE")) {
				userInsight = true;
			}
		}
		
		PrintVerticalSpace();
		PrintVerticalSpace();
		System.out.println("--------------------------------------------------------------");
		
		//populate array with single word names
		System.out.println("Please enter single word names");
		System.out.println("Enter 10 names:");
		for (int i = 0; i < names.length; ++i) {
			System.out.print("Enter Name " + (i + 1) + " >> ");
			names[i] = inUser.nextLine();
		}
		
		PrintVerticalSpace();	//print newline
		PrintVerticalSpace();	//print newline
		
		//Process contents of the array (perfect sized arrays)
		TrimArrayStrings(names);		//trims all strings in array
		LowerCaseArrayStrings(names);	//makes all strings lowercase in array
		
		//optional code - activate with user CMD argument "userInsight-TRUE"
		if (userInsight) {
			System.out.println("USER INSIGHT: NAMES AFTER TRIMMING AND CONVERTING TO LOWERCASE");
			//enchanced for loop to print names array contents!
			for(String currentName : names) {
				System.out.println(currentName);
			}
			
			PrintVerticalSpace();
			PrintVerticalSpace();
			
		}
		
		
		SortArrayAscending(names);	//sorts into alphabetically ascending order
		System.out.println("Names ordered alphabetically:");
		PrintPerfectSizeStringArray(names);		//print name array contents;
		
		SortArrayDescending(names);	//sorts alphabetically ascending array INTO descending array
		System.out.println("Names ordered alphabetically backwards:");
		PrintPerfectSizeStringArray(names);		//print array contents
		
		
		
		
		
		
		
		
		
		
	
	}

}