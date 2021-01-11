//Author: Yazid Escudero
//CS1101
//Array in Java


import java.util.Scanner;

public class MinMaxFinder {
	public static void main(String[] args) {
	
		//TO DO 
		Scanner inUser = new Scanner(System.in);
		System.out.println("Please enter ten numbers...");
		int[] userInput = new int[10];
		for (int i = 0; i < 10; ++i) {
			userInput[i] = inUser.nextInt();
		}
		inUser.nextLine();	//gets rid of any remaining characters in console
		
		System.out.println("The average is: " + getAveg(userInput));
		System.out.println("The Min is: " + getMin(userInput));
		System.out.println("The Max is: " + getMax(userInput));
		
		//read the data from the console
		//calculations
		//print out the result
		
	
	}

	//TO DO
	//Declare a method to return min
	public static int getMin(int[] scores) {
		
		int temp = 100;
		for(int i = 0; i < scores.length; ++i) {
			
			if (scores[i] < temp) {
				temp = scores[i];
			}
		
		}
		
		return temp;
	
	}
	
	//Declare method to return the max
	public static int getMax(int[] scores) {
	
		int temp = scores[0];
		for(int i = 1; i < scores.length; ++i) {
		
			if (scores[i] > temp) {
				temp = scores[i];
			}
		
		}
		
		return temp;
	
	}
	
	//Declare a method to return Average
	public static double getAveg(int[] scores) {
	
		int sum = 0;
		for (int i = 0; i < scores.length; ++i) {
			sum += scores[i];
		}
		
		return ((double)(sum))/(scores.length);
	
	}
}