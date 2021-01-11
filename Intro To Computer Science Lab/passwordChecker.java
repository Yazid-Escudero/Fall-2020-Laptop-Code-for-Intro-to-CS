//AUTHOR: YAZID ARAM ESCUDERO
//COURSE: CS1101 FROM CS1301
//INSTRUCTOR: DR. DANIEL MEJIA
//DESCRIPTION: THIS PROGRAM TAKES IN A "PASSWORD" FROM USER INPUT AND IS THOROUGHLY SCANNED TO VERIFY THAT IT MEETS ALL CRITERIA AS DESCRIBED IN LAB ASSIGNMENT DESCRIPTION. 
			   //Create a method to check the number of characters. It must be more than 8;
			   //Create a method to check the pasword to have at elast one uppercase letter
			   //Create a method to check the password to have at least one lowercase letter
			   //Create a method to heck the password to have at least on digit.
			   //create a method to check the password to have at least one special characters
//END OF DESCRIPTION

import java.util.Scanner;

public class passwordChecker {
	
	//this method simply prints a newline
	public static void PrintNewLine() {
		System.out.println();
	}
	
	//this method prints the password criteria that the user MUST meet for his/her password to be valid
	public static void PrintPasswordCriteria() {
	
		System.out.println("User entered password must meet the following criteria to be valid:");
		System.out.println("\t*Password must have at least 8 characters");
		System.out.println("\t*Passsword must have at least one uppercase letter");
		System.out.println("\t*Password must have at least one lowercase letter");
		System.out.println("\t*Password must have at least one digit");
		System.out.println("\t*Password must have at least one special character (!, 2, #, %, &, *, (,), etc.)");
		PrintNewLine();
		PrintNewLine();
		
	
	}
	
	//this method returns true if phrase contains eight characters
	public static boolean ContainsEightCharacters(String phrase) {
		
		//holds true at end if phase contains eight characters
		boolean hasEightLetters = false;			//assume false at first until proven true
		
		if (phrase.length() >= 8) {
			hasEightLetters = true;
		}
		
		return hasEightLetters;
	}
	
	//this method returns true if phrase contains uppercase letter
	public static boolean ContainsUpperCase(String phrase) {
		
		//holds true at end if phase contains uppercase letter
		boolean hasUpperCaseLetter = false;			//assume false until proven true
		
		for(int i = 0; i < phrase.length(); ++i) {
		
			if (Character.isUpperCase(phrase.charAt(i))) {
				//if uppercae found, update hasUpperCaseLetter to true
				hasUpperCaseLetter = true;
				break;								//no more need to iterate since criteria is met
			}
		
		}
		
		return hasUpperCaseLetter;
	}
	
	//this method returns true if phrase contains lowercase letter
	public static boolean ContainsLowerCaes(String phrase) {
		
		//holds true at end if phase contains lowercase letter
		boolean hasLowerCaseLetter = false;			//assume false until proven true
		
		for(int i = 0; i < phrase.length(); ++i) {
		
			if (Character.isLowerCase(phrase.charAt(i))) {
				//if lowercase found, update hasLowerCaseLetter to true
				hasLowerCaseLetter = true;
				break;								//no more need to iterate since criteria is met
			}
		
		}
		
		return hasLowerCaseLetter;
	}
	
	//this method returns true if phrase contains digit character
	public static boolean ContainsDigit(String phrase) {
		
		//holds true at end if phase contains digit character
		boolean hasDigitCharacter = false;			//assume false until proven true
		
		for(int i = 0; i < phrase.length(); ++i) {
			
			if (Character.isDigit(phrase.charAt(i))) {
				//if digit found, update hasDigitCharacter to true
				hasDigitCharacter = true;
				break;								//no more need to iterate since criteria is met
			}
		}
		
		return hasDigitCharacter;
	}
	
	//ths method returns true if phrase contains a special character
	public static boolean ContainsSpecialCharater(String phrase) {
		
		/*
			Characters considered special characters:
				!
				#
				%
				&
				*
				,
				@
				$
		*/
		
		//holds true at end if phase contains special character
		boolean hasSpecialCharacter = false;				//assume false until proven true
		
		for(int i = 0; i < phrase.length(); ++i) {
			
			//IF ANY OF THE FOLLOWING IF STATEMENTS IS ENTERED
			//hasSpecialCharacter IS UPDATED TO TRUE AND
			//THE FOR LOOP IS EXITED DUE TO NO NEED 
			//FOR ANY MORE ITERATIONS SINCE WE ALREADY KNOW THERE
			//IS AT LEAST ONE SEPCIAL CHARACTER
			if (phrase.charAt(i) == '!') {
				hasSpecialCharacter = true;
				break;
			}
			
			if (phrase.charAt(i) == '#') {
				hasSpecialCharacter = true;
				break;
			}
			
			if (phrase.charAt(i) == '%') {
				hasSpecialCharacter = true;
				break;
			}
			
			if (phrase.charAt(i) == '&') {
				hasSpecialCharacter = true;
				break;
			}
			
			if (phrase.charAt(i) == '*') {
				hasSpecialCharacter = true;
				break;
			}
			
			if (phrase.charAt(i) == ',') {
				hasSpecialCharacter = true;
				break;
			}
			
			if (phrase.charAt(i) == '@') {
				hasSpecialCharacter = true;
				break;
			}
			if (phrase.charAt(i) == '$') {
				hasSpecialCharacter = true;
				break;
			}
			
		}
		
		return hasSpecialCharacter;
	}
	
	
	//this method checks if the password is valid. calls other methods to checck different criteria
	public static boolean isValid(String password) {
		
		//decclare boolean variables corresponding to all criteria plus another for final evaluation
		boolean criteriaPassed;						//holds final evaluation of wether the password is valid
		boolean hasEightCharacters;					//true if password contains eight characters
		boolean hasUpperCase;						//true if password contains uppercase letter
		boolean hasLowerCase;						//true if password contains lowercase letter
		boolean hasDigit;							//true if password contains a digit
		boolean hasSpecialCharacter;				//true if password contains special character
		
		//call each criteria related method. assign result to corresponding boolean variables
		hasEightCharacters = ContainsEightCharacters(password);
		hasUpperCase = ContainsUpperCase(password);
		hasLowerCase = ContainsLowerCaes(password);
		hasDigit = ContainsDigit(password);
		hasSpecialCharacter = ContainsSpecialCharater(password);
		
		
	
		
		//now determine if password has met ALL CRITERIA. If YES, then it IS valid
		//if NO, then password is NOT valid (so criteriaPassed is FALSE
		if (hasEightCharacters && hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter) {
			criteriaPassed = true;
		} else {
			criteriaPassed = false;
			
			//if criteriaPassed == false, then print out error messages
			//error messages tell user why their password is not valid
			
			System.out.println("-----------------------------------------------");
			if (!hasEightCharacters) {
				System.out.println("ERROR: DOES NOT CONTAIN 8 CHARACTERS");
			}
			if (!hasUpperCase) {
				System.out.println("ERROR: DOES NOT CONTAIN UPPERCASE LETTER");
			}
			if (!hasLowerCase) {
				System.out.println("ERROR: DOES  NOT CONTAIN LOWERCASE LETTER");
			}
			if (!hasDigit) {
				System.out.println("ERROR: DOES NOT CONTAIN DIGIT");
			}
			if (!hasSpecialCharacter) {
				System.out.println("ERROR: DOES NOT CONTAIN SPECIAL CHARACTER");
			}
			System.out.println("-----------------------------------------------");
			PrintNewLine();
			PrintNewLine();
			PrintNewLine();
		}
		
		//return final evaluation
		return criteriaPassed;
	
	}
	
	//MAIN FUNCTION
	public static void main(String[] args) {
		//declare necessary variables and scanners
		boolean validPassword;						//will be true if password is valid, else, will be false
		String userPassword = null;					//hold user password. it points to nothign		
		Scanner inUser = new Scanner(System.in);	//read from user in console

		
		//print password criteria, get user password
		PrintPasswordCriteria();
		System.out.print("Enter password:\n>> ");
		userPassword = inUser.nextLine();			//read password from user input
		PrintNewLine();								//print 3 newlines to create vertical space
		PrintNewLine();								//
		PrintNewLine();								//
		
		//call function to evaluate if entered password is valid or invalid. assign return value to validPassword
		validPassword = isValid(userPassword);
		
		if (validPassword) {
			System.out.println("Password meets criteria");
		} else {
			System.out.println("Password does not meet criteria");
		}
		
		
	}


}