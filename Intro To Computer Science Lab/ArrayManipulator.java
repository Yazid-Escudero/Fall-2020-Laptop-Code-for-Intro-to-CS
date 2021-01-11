//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description: This program deals with arrays and implements the following functionalities
	//Remove a particular element from an array
	//Add a new element to an array
	//Change an element with the new one
	//Search for a particular element in the array
	
//Notes:
	//NOT ALLOWED TO USE ANY JAVA PRE-DEFINED FUNCTIONS
	//We may use String or int data type for an array.
	//Code must be separated into four separate methods for each task:
		//public static int[] deleteElement(int[] userArray, int ele);							DONE!
		//pubilc static int[] addElement(int[] userArray, int ele);								DONE!
		//public static int[] changeElement(int[] userArray, int oldEle, int newEle);			DONE!
		//public static boolean findElement(int[] userArray,int ele);							DONE!
		
//START TIME: 5:10PM
		
import java.util.Scanner;
import java.util.Arrays;
		
public class ArrayManipulator {
	
	//METHOD
	//method prints a new line just for visual organization
	public static void PrintNewLine() {
		System.out.println();
	}
	
	//METHOD
	//this method deletes a certain element completely from the given array
	public static int[] DeleteElement(int[] userArray, int elementToDelete) {
		
		int newSize = 0;	//will contain size of newArray
		
		//count number of elements to copy to new array
		for(int i = 0; i < userArray.length; ++i) {
			
			if (userArray[i] != elementToDelete) {
				++newSize;
			}
			
		}
		
		//now create the new array with newSize
		int[] newArray = new int[newSize];
		
		//now copy over the elements that are NOT the elementToDelete equivalent
		int oldIndex = 0; 	//indexes the userArray
		int newIndex = 0;	//indexes the newArray
		
		while(oldIndex < userArray.length) {
			if (userArray[oldIndex] != elementToDelete) {
				newArray[newIndex] = userArray[oldIndex];
				++oldIndex;
				++newIndex;
			}
			else {
				++oldIndex;
			}
		}
		
		return newArray;
	}
	
	//METHOD
	//this method adds an element to the end of the given array by passing back a newly constructed array
	public static int[] AddElement(int[] userArray, int elementToAdd) {
		//make a new array with userArray.length + 1 in size
		int[] newArray = new int[(userArray.length) + 1];
		
		//copy all the elements of userArray into the last.. (the last element in newArray will be empty..
		//we will fill the last element after copying the original values)...
		for(int i = 0; i < userArray.length; ++i) {
			newArray[i] = userArray[i];
		}
		
		//now add the elementToAdd to the last element which is still empty
		newArray[(newArray.length) - 1] = elementToAdd;
		
		return newArray;
	}
	
	//METHOD
	//this method changes each element that matches with 'element to change' to the element 'newElement'
	public static void ChangeElement(int[] userArray, int elementToChange, int newElement) {
		
		//iterate through array. If an element matches elementToChange, then 
		//replace with newElement
		for (int i = 0; i < userArray.length; ++i) {
			if (userArray[i] == elementToChange) {
				userArray[i] = newElement;
			}
		}
		
		//this element does not need to return a new array
	}
	
	//METHOD
	//this method simply checks if 'elementToFind' exists in an array. true as soon as ONE is confirmed to exist
	public static boolean FindElement(int[] userArray, int elementToFind) {
		
		//create a flag
		boolean flag = false;		//assume false
		
		for(int i = 0; i < userArray.length; ++i) {
			
			if (userArray[i] == elementToFind) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	//METHOD
	//main method
	public static void main(String[] args) {
		
		//declare general variables and objects
		int userChoice;								//stores the menu choice from user
		Scanner inUser = new Scanner(System.in);	//read from user
		
		//declare arraySize and get size from input. Prompt user to enter answers
		System.out.print("Please enter the number of values to store:\n>> ");
		int arraySize = inUser.nextInt();			//stores size of array from the user.
		
		//declare array with user sepcified size
		int[] userValues = new int[arraySize];
		
		//grab user values from the user in console
		System.out.println("Enter your " + arraySize + " values");
		for(int i = 0; i < arraySize; ++i) {
			System.out.print("Value " + (i + 1) + " >> ");
			userValues[i] = inUser.nextInt();
		}
		PrintNewLine();
		PrintNewLine();
		
		System.out.println("ENTERED ARRAY: " + Arrays.toString(userValues));
		PrintNewLine();
		PrintNewLine();
		
		//HERE WE GIVE USER OPTION TO CHOOSE WHAT TO DO WITH ARRAY.
		//WILL ONLY RUN ONCE, IT WILL NOT ITERATE OVER AND OVER
		//UNTIL THE USER QUITS
		
		System.out.println("Please choose from the menu below:");
		System.out.println("\t1. Delete element form the array");
		System.out.println("\t2. Add element to the end of the array");
		System.out.println("\t3. Change element inside the array");
		System.out.println("\t4. Find element inside the array");
		PrintNewLine();
		
		//grab user choice:
		System.out.print(">> ");
		userChoice = inUser.nextInt();
		
		//make vertical space... format the console output
		PrintNewLine();
		PrintNewLine();
		PrintNewLine();
		
		//switch statement that handles user choice
		switch(userChoice) {
			case 1:
				System.out.print("Please enter the value to delete from the array\n>> ");
				int elementToDelete = inUser.nextInt();
				
				userValues = DeleteElement(userValues, elementToDelete);
				
				//print out the new array
				System.out.println("NEW ARRAY: " + Arrays.toString(userValues));
				break;
			case 2:
				System.out.print("Plese enter the value to add to end of the array\n>> ");
				int elementToAdd = inUser.nextInt();
				
				userValues = AddElement(userValues, elementToAdd);
				
				//print out the new array
				System.out.println("NEW ARRAY: " + Arrays.toString(userValues));
				break;
			case 3:
				System.out.print("Please enter the value to change inside array\n>> ");
				int elementToChange = inUser.nextInt();
				System.out.print("Please enter the value to replace the element you wish to change\n>> ");
				int newElement = inUser.nextInt();
				
				//method does not actually return anything. simply modifies the passed array
				ChangeElement(userValues, elementToChange, newElement);
				
				//print out the new array
				System.out.println("NEW ARRAY: " + Arrays.toString(userValues));
				break;
			case 4:
				System.out.print("Please enter the value to find inside the array\n>> ");
				int elementToFind = inUser.nextInt();
				
				if(FindElement(userValues, elementToFind)) {
					System.out.println(elementToFind + " was found inside the array!");
				}
				else {
					System.out.println(elementToFind + " was not found...");
				}
				break;
			default:
				System.out.println("Invalid Choice. Exiting Program");
				break;
		}
		
		
		
	
	}


}