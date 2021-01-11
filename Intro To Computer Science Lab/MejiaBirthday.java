//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description: This Java File contains the work from the Lab of October 26th, 2020. The work was done in lab by 
	//the professor Dr. Daniel Mejia and these are his code statements
	
	
public class MejiaBirthday {
	
	public static void main(String[] args) {
		
		System.out.println("HELLO WORLD");
		
	//declare variables
		int factValue = fact(6);
		int factRegVal = factReg(6);
		
		System.out.println(factValue);
		System.out.println(factRegValue);
		
		int[] nums = {10, 26, 43, 21, -25, 73, 28, 32, 31, 10, -90};
		
		int[] numsTwo = {10, 20, 30};
		
	//declare more variables
		int numsMax = max(nums);
		int numsSum = sumArray(nums);
		int numsSumRec = sumArrayRec(nums, 0);
		
		System.out.println(numsMax);
		System.out.println(numsSum);
		System.out.println(numsSumRec);
		
		String stringDOB = getSomeoneAge(1, 1, 2020, 1935);
		System.out.println(stringDOB);
		
		
	}
	
	public static String getSomeoneAge(int monthBirth, int dateBirth, int currentYear, int yob) {
	
		String month = getMonth(monthBirth);
		int age = getAge(currentYear, yob);
		
		return month + " " + dateBirth + ", " + yob + " - " + age + " years old";
		
	}
	
	public static int getAge(int currentYear, int yob) {
	
		return currentYear - yob;
	
	}
	
	public static String getMonth(int month) {
		
		switch(month) {
			case 1:
				monthString = "January";
				break;
			case 2:
				monthString = "February";
				break;
			case 3:
				monthString = "March";
				break;
			case 4:
				monthString = "April";
				break;
			case 5:
				monthString = "May";
				break;
			case 6:
				monthString = "June";
				break;
			case 7:
				monthString = "July";
				break;
			case 8:
				monthString = "August";
				break;
			case 9:
				monthString = "September";
				break;
			case 10:
				monthString = "October";
				break;
			case 11:
				monthString = "November";
				break;
			case 12:
				monthString = "December";
				break;
			default:
				monthString = "Lame!!";
				break;
			
		}
		return monthString;
		
	}
	
	public static int sumArrayRec(int[] arr, int index) {
	
		if (arr.length == index) {
			return 0;
		}
		
		return arr[index] + sumArray(arr, index + 1);
	
	}
	
	public static int sumArray(int arr) {
	
		int sum = 0;
		
		for (int i = 0; i < arr.length; ++i) {
			sum += arr[i];
		}

	}
	
	public static int max(int[] nums) {
	
		in (nums.length == 0) {
			return -100000;
		}
		
		int max = nums[0];
		
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		
	}
	
	public static int fact(int number) {
		//base case
		if (number == 0) {
			return 1;
		}
		
		//recursive call
		return number * fact(number - 1);
	}
	
	public static int factReg(int number) {
	
		int fact = 1;
		
		for (int i = number; i >= 1; --i) {
			fact = fact * i;
		}
		
		return fact;
	
	}
	
	
}