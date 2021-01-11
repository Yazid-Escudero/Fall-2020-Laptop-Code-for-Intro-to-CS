//Author: Yazid Escudero
//CS1101
//Instructor: Dr. Daniel Mejia

import java.util.Scanner;

public class temp {
	
	
	public static void main(String[] args) {
		
		//TODO
		Scanner inUser = new Scanner(System.in);
		System.out.println("Please enter a number greater than 1");
		int temp = inUser.nextInt();
		inUser.nextLine();
		
		
		if (temp > 1) {
			System.out.println(isPrime(temp));
		} else {
			System.out.println("Please enter a number greater than 1");
			temp = inUser.nextInt();
			inUser.nextLine();
		}

		
	}

	public static boolean isPrime(int number) {
	
		boolean flag = true;
		
		for (int i = number - 1; i > 1; --i) {
		
			if (number % i == 0) {
				flag = false;
			}
		
		}
		
		return flag;
	
	
	}
}