//Author: Yazid Aram Escudero
//Date Created: November the 2nd, 2020
//Course: CS1301 - "Introduction to Computer Science"
//Instructor: Dr. Daniel Mejia
//The TAs and IAs:
//	TA Alireza P. Nouri
//	IA Paola Terrazas
//	IA Cynthia Sustaita
//
//	
//
//Project Description:
//This project is a banking mortgage user interface. The Program will allow the user to choose from a menu containing options "a. Loan Approval Calculator", "b. Monthly Payment
//Calculator", "c. Loan Approval Reader", "d. Exit Mortgage Banking Interface". Choice "a" allows user to enter their information to check if they can get approved for a loan.
//Option "b" allows user to enter information about their finances to get an estimate of a monthly payment - should they, of course, get the loan. Option "c" reads a CSV file,
//and this file contains applicant information for all applicatinos held by the system. This method will print out each and every applicatoin decision - if they're approved, an "approved"
//message will print and the estimated monthly payment will print as well. If they're denied, then a "denied" message will be printed along. Each one of these print statements will 
//address each applicant by name! The Program will continuously take the user back to the Main Menu until the user chooses the fourth option "d" - in which case the program will terminate
//with a "goodbye" message.


//Work Log:

	//November 2nd, 2020:
		//Begin Coding Project. Import necessary classes. Create a working "Menu Engine" that loops around continuously
		//The "Menu Engine" keeps going after each option chosen, except for option "d", in which case, program quits.
		//Define Method Stubs for all methods to be written. Print out statement to show that method calls work in general
		//Methods aside from main will only print something out to assure functionality in method calls
		
		//The three methods highlighed with star borders are the methods that essentially execute the functionalities of the program:
			//IsLoanApproved
			//EstimateMonthlyPayment
			//PrintLoanDecisions
			
		//The other supporting methods that are not part of the three methods avobe are the following
			//PrintNewLine
			//PrintMenu
			//CalculateInterestRate
			//CalculateDownPayment
		
		//In Main Method, File Object for use of program that reads from CSV File has been created
		//Scanner object to read user input created
		
	//November 3rd, 2020 (PRESIDENTIAL ELECTION DAY!)
		//Implemented full functionality to IsLoanApproved Method
		//Implemented full functionality to CalculateInterestRate Method
		//Implemented full functionality to CalculateDownPayment
		//Implemented full functionality to EstimateMonthlyPayment
		
		//Add functionality to if branch corresponding to user choosing Menu option "a"
		//Add functionality to if-else branch corresponding to user choosing Menu option "b"
		//Add functionality to if-else branch corresponding to user choosing Menu option "c"
		
		//Implemented full functionality to PrintLoanDecisions
		
		//Program Completed
		
		
	




//END OF Work Log



//import classes
import java.util.Scanner;
import java.io.File;	
		
public class CL2_Main {
	
//Method prints out newline!
	public static void PrintNewLine() {
		System.out.println();
	}
	
//Method prints out menu options for main!
	public static void PrintMenu() {
		
		System.out.println("-----------------------------------------------------");
		System.out.println("Please choose an option from the following menu!");
		System.out.println("\ta. Loan Approval Calculator");
		System.out.println("\tb. Monthly Payment Calculator");
		System.out.println("\tc. Loan Approval Reader");
		System.out.println("\td. Exit Interface");
		PrintNewLine();
		PrintNewLine();
		
		
	}
	
	//Method calculates interest rate to be applied to loan
	public static double CalculateInterestRate(int creditScore) {
		
		//determine interest rate according to score with if-elseif-else statements
		double interestRate = 0.0;

			if ((creditScore >= 800) && (creditScore <= 850)) {
				interestRate = 0.028;		
			}
			else if ((creditScore >= 740) && (creditScore <= 799)) {
				interestRate = 0.03;
			}
			else if ((creditScore >= 670) && (creditScore <= 739)) {
				interestRate = 0.032;
			}
			else if ((creditScore >= 580) && (creditScore <= 669)) {	//BUGFIXED: Range added after method testing
				interestRate = 0.033;
			}
			else if ((creditScore >= 560) && (creditScore <= 579)) {	//BUGFIXED: Incorrect ranges now fixed
				interestRate = 0.035;
			}
			else if ((creditScore >= 300) && (creditScore <= 559)) {	//BUGFIXED: Incorrect ranges now fixed
				interestRate = 0.040;
			}
		
			return interestRate;

	}
	
	//Method calculates downpayment amount required for loan
	public static int CalculateDownPayment(int homeValue, int creditScore) {
		
		//determine the downpayment to nearest dolllar. FIrst, find percentage of downpayment
		
			double downPaymentRatio = 0.0;	//ratio refers to ratio of house cost that should be paid as downpayment
			int downPayment;			//holds downpayment users should give!
			
			if ((creditScore >= 800) && (creditScore <= 850)) {
				downPaymentRatio = 0.05;		
			}
			else if ((creditScore >= 740) && (creditScore <= 799)) {
				downPaymentRatio = 0.07;
			}
			else if ((creditScore >= 670) && (creditScore <= 739)) {
				downPaymentRatio = 0.10;
			}
			else if ((creditScore >= 580) && (creditScore <= 669)) {	//BUGFIXED: Range added after method testing
				downPaymentRatio = 0.13;
			}
			else if ((creditScore >= 560) && (creditScore <= 579)) {	//BUGFIXED: Incorerct reanges now fixed
				downPaymentRatio = 0.15;
			}
			else if ((creditScore >= 300) && (creditScore <= 559)) {	//BUGFIXED: Incorrect ranges now fixed
				downPaymentRatio = 0.20;
			}		

			downPayment = (int) (homeValue * downPaymentRatio);	//nearest dollar!
			
			return downPayment;
		
		//System.out.println("FIXME: CalculateDownPayment Method Caleld!");
		//return 0;
	}
	
	
/*THREE FUNCTIONALITIES OF THE PROGRAM*/
/**********************************************************************************************************************/	
//Method returns true if loan approval is possible, false if not possible based on user input
	public static boolean IsLoanApproved(int grossIncome, int totalSavings, int creditScore, int homeValue, int months) {
		
		//Create Necessary Variables
			boolean satisfactoryMonthlyNetIncome = false;	//
			boolean satisfactoryHomeValue = false;			//assume false at first...
			boolean satisfactorySavings = false;			//
			boolean status = false;							//
			
			double netMonthlyToPaymentRatio;	// determines decimal ratio of (monthly payments) / (net monthly income)
			double netMonthlyIncome;
			int requiredSavings = 0;
			double interestRate;
			double monthlyPayment;
			int maxHomePrice;
			int totalLoan;
			
			
		//calculate quantities needed for calculating true or false for status
			
			maxHomePrice = (int)(3.5 * grossIncome);	//max house value allowed
														//nearest dollar
														
			double monthlyRate = CalculateInterestRate(creditScore) / 12;	//returns interest rate as decimal
			
			totalLoan = homeValue - CalculateDownPayment(homeValue, creditScore);	//nearest dollar
			
			
		
			if ((creditScore >= 800) && (creditScore <= 850)) {		//determine (if-elseif-else) requiredSavings amount
				requiredSavings = (int) (0.05 * homeValue);			//nearest dollar determined
			}
			else if ((creditScore >= 740) && (creditScore <= 799)) {
				requiredSavings = (int) (0.07 * homeValue);
			}
			else if ((creditScore >= 670) && (creditScore <= 739)) {
				requiredSavings = (int) (0.10 * homeValue);
			}
			else if ((creditScore >= 580) && (creditScore <= 669)) {	//BUGFIXED: Added missing range
					requiredSavings = (int) (0.13 * homeValue);	
			}
			else if ((creditScore >= 560) && (creditScore <= 579)) {	//BUGFIXED: Fixed incorrect ranges
				requiredSavings = (int) (0.15 * homeValue);
			}
			else if ((creditScore >= 300) && (creditScore <= 559)) {	//BUGFIXED: Fixed incorrect ranges
				requiredSavings = (int) (0.20 * homeValue);
			}
			
			monthlyPayment = EstimateMonthlyPayment(totalLoan, monthlyRate, months);
			
		//Net Monthly Income is assummed to be 68% of gross incomeWitholdings divided into 12 months
			netMonthlyIncome = (grossIncome * 0.68) / 12;	//stored as double value
			netMonthlyToPaymentRatio = monthlyPayment / netMonthlyIncome;
			
		//Check conditions and assign status with final evaluation
			
			//conditions for loan approval:
				//Desired home value must NOT be more than 3.5 times greater than grossIncome
				//Certain amount of savings should be available - determined according to credit score in if-elseif statements
				//Estimated monthly payment should be 42% or less of Net monthly income

		//check for satisfactory conditions through declared boolean variables
			
			if (homeValue <= maxHomePrice) {				//satisfactory home value	//BUGFIXED: Incorrect operator fixed - replaced with correct logical operator
				satisfactoryHomeValue = true;
			}
			
			if (totalSavings >= requiredSavings) {	//satisfactory amount saved
				satisfactorySavings = true;
			}
			
			if ((netMonthlyToPaymentRatio - 0.42 < 0.0001) || (netMonthlyToPaymentRatio < 0.42)) {
				satisfactoryMonthlyNetIncome = true;
			}
			
		//check if all conditions are satisfactory. If true, then status = true!
			
			if (satisfactoryHomeValue && satisfactorySavings && satisfactoryMonthlyNetIncome) {
				status = true; //approved!
			}
			
			
			return status;
			
	}
	
//Method returns estimate of Monthly Payment based on user input
	public static double EstimateMonthlyPayment(int totalLoan, double monthlyRate, int months) {
		
		double monthlyPayment;
		
		monthlyPayment = (totalLoan * (monthlyRate * Math.pow(1 + monthlyRate, months))) / (Math.pow(1 + monthlyRate, months) - 1);
		
		return monthlyPayment;
		
	}
	
//Method reads and prints approval/monthlypayments or denail decisions on applications stored in CSV File
	public static void PrintLoanDecisions(File sourceFile) {
	
		try {
		
		//Create a scanner reference variable
			Scanner inputF = null;
		
		//Create necessary variables and arrays
			int[] countDecisions = {0, 0};	//countDecisions[0] (#of accepted applications) and countDecisions[1] (# of denied applicatoins)
		
		
		//Create object and assign reference to created scanner reference variable
			inputF = new Scanner(sourceFile);
		
		//Use while loop to iterate through the CSV File
			inputF.nextLine();	//gets rid of header line in file for accurate counting
		
			while (inputF.hasNextLine()) {
			
				String temp = inputF.nextLine();
				String[] currentApplicationInfo = temp.split(",");
				boolean veredict = false;	//assume false. determines if person is approved
			
				//MAP OF THE INDEXES AND THEIR CORRESPONDING DATA
					//[0] - FIRSTNAME
					//[1] - LASTNAME
					//[2] - ANNUALGROSSINCOME
					//[3] - TOTALSAVINGS
					//[4] - CREDITSCORE
					//[5] - MONTHS
					//[6] - DESIREDHOMEVALUE
				
		//Parse array and convert number strings to integers
			int annualGrossIncome = Integer.parseInt(currentApplicationInfo[2]);
			int totalSavings = Integer.parseInt(currentApplicationInfo[3]);
			int creditScore = Integer.parseInt(currentApplicationInfo[4]);
			int desiredHomeValue = Integer.parseInt(currentApplicationInfo[6]);
			int months = Integer.parseInt(currentApplicationInfo[5]);
			
		//returns true if approved
			veredict = IsLoanApproved(annualGrossIncome, totalSavings, creditScore, desiredHomeValue, months);
			
		//Update - counts # approved and # denied
			if (veredict) {
				++countDecisions[0];	
			}
			else {
				++countDecisions[1];
			}
			
		//Print out the result!
			if (veredict) {

				int totalLoan = desiredHomeValue - CalculateDownPayment(desiredHomeValue, creditScore);	//nearest dollar
				double monthlyRate = CalculateInterestRate(creditScore) / 12;
					
				System.out.println("Congratulations, " + currentApplicationInfo[0] + " " + currentApplicationInfo[1] + "! You have been APPROVED for a mortgage loan!");
				System.out.println("The estimated monthly payment (before Taxes/Insurance) is $" + EstimateMonthlyPayment(totalLoan, monthlyRate, months));
				PrintNewLine();
				
			}
			else {
				
				System.out.println("Sorry, " + currentApplicationInfo[0] + " " + currentApplicationInfo[1] + "! You have been DENIED for a mortgage loan!");
				PrintNewLine();
				
			}
			
			PrintNewLine();
			PrintNewLine();
		
		}
		
		System.out.println("Number of Accepted Appllications: " + countDecisions[0]);
		System.out.println("Number of Denied Applications: " + countDecisions[1]);
		
		}catch (Exception e) {
			System.out.println("File Not Found:\n" + e);
		}
		
	}
/**********************************************************************************************************************/




	
//MAIN METHOD
	public static void main(String[] args) {
		
		//handles errors in reaching corressopnding CSV File
		try {
			
		//create objects
			Scanner inputC = new Scanner(System.in);
			File csvFile = new File("D:/Fresh Start/UTEP/Fall 2020/Intro To Computer Science Lab/Comprehensive Lab 2/MortgageApplications.csv");
			
		//Create general variables
			char userSelection = '\0';	//will hold user menu choice
			boolean userQuits = false;	//so loop iterates at least once
			
			
		//Create Menu Engine!
			while (!userQuits) {
		
			//Print Menu and read user choice!
				PrintMenu();
				System.out.print(">> ");
				userSelection = inputC.nextLine().charAt(0);
				PrintNewLine();
			
			//Process user input in case user enteres uppercase
				userSelection = Character.toLowerCase(userSelection);
			
			//if-elseif-else statements depending on user inputC
			
				if(userSelection == 'a') { //Loan Approval Calculator
				
				//create variables for user information and to check user input
					String firstName = null;
					String lastName = null;
					int annualGrossIncome = 0;	//nearest dollar
					int totalSavings = 0;		//nearest dollar
					int creditScore = 0;
					int desiredHomeValue = 0;	//nearest dollar
					int totalYears = 0;
					int totalMonths = 0;
					
					//assume all inputs are valid (true) until proven false!
					boolean validUserInput = true;
					boolean validGrossIncome = true;
					boolean validSavings = true;
					boolean validCreditScore = true;
					boolean validTotalYears = true;
					boolean validHomeValue = true;
					
					//final decision on loan!
					boolean loanApproved = false;	//assume false at first
				
				//ask for required user information
					System.out.println("Please enter required information!");
					System.out.print("First Name >> ");
					firstName = inputC.nextLine();
					System.out.print("Last Name >> ");
					lastName = inputC.nextLine();
					System.out.print("Annual Gross Income (Pre-Tax Income, and nearest dollar) >> ");
					annualGrossIncome = inputC.nextInt();
					inputC.nextLine();	//get rid of leftover newline character
					System.out.print("Total Savings (nearest dollar) >> ");
					totalSavings = inputC.nextInt();
					inputC.nextLine();	//get rid of leftover newline character
					System.out.print("Credit Score (range 300 to 850) >> ");
					creditScore = inputC.nextInt();
					inputC.nextLine();	//get rid of leftovr newline character
					System.out.print("Desired Home Value (nearest dollar) >> ");
					desiredHomeValue = inputC.nextInt();
					inputC.nextLine();	//get rid of leftover newline character
					System.out.print("Please enter number of years for loan (15 or 30 years) >> ");
					totalYears = inputC.nextInt();
					inputC.nextLine();	//get rid of leftover newline characcter
					
				//convert years to months
					totalMonths = totalYears * 12;
					
				//check for valid user input
					
					//check each boolean variable
					if (annualGrossIncome < 0) {
						validGrossIncome = false;
					}
					if (totalSavings < 0) {
						validSavings = false;
					}
					if ( !((creditScore >= 300) && (creditScore <= 850))) {
						validCreditScore = true;
					}
					if ( !((totalYears == 15) || (totalYears == 30))) {
						validTotalYears = false;
					}
					if (desiredHomeValue <= 0) {
						validHomeValue = false;
					}
					
					
					
					//check that all user input is valid...
					if (validGrossIncome && validSavings && validCreditScore && validTotalYears && validHomeValue) {
						validUserInput = true;
					}
					else {
						validUserInput = false;
					}
					
				//check if user entered any invalid input. If so, print out the invalid entries
					if (!validUserInput) {
						
						System.out.println("You entered invalid information for the following:");
						
						if ( !validGrossIncome) {
							System.out.println("Invalid Gross Income Entered");
						}
						if( !validSavings) {
							System.out.println("Invalid Total Savings Entered");
						}
						if ( !validCreditScore) {
							System.out.println("Invalid Credit Score Entered");
						}
						if ( !validTotalYears) {
							System.out.println("Invalid Amount of Years Entered");
						}
						if ( !validHomeValue) {
							System.out.println("Invalid Desired Home Value Entered");
						}
						
					}
				//but if user DID entere valid input... else...
					else {
						
						loanApproved = IsLoanApproved(annualGrossIncome, totalSavings, creditScore, desiredHomeValue, totalMonths);
						
						if (loanApproved) {
							System.out.println("Congratulations " + firstName + " " + lastName + "! You have been APPROVED for a mortgage loan!");
						}
						else {
							System.out.println("Sorry " + firstName + " " + lastName + "! You have been DENIED for a mortgage loan!");
						}
						
					}
					
					PrintNewLine();
				}
				
				else if (userSelection == 'b') { //Monthly Payment Calculator
				
				//Create variables to hold user input and also boolean variables that check for valid user input
					int creditScore = 0;
					int desiredHomeValue = 0;	//nearset dollar
					int totalYears = 0;
					int totalMonths = 0;
					int totalLoan = 0;			//nearest dollar
					
					double estimatedMonthlyPayment = 0.0;
					double monthlyRate = 0.0;
					
					//assume all inputs are true until proven false!
					boolean validCreditScore = true;
					boolean validHomeValue = true;
					boolean validTotalYears = true;
					
					boolean validUserInput = true;	//shows if all user input is valid (determined true or false...)
					
				//Ask user for required information
					System.out.println("Please enter required information!");
					System.out.print("Credit Score (range 300 to 850) >> ");
					creditScore = inputC.nextInt();
					inputC.nextLine();	//get rid of leftovr newline character
					System.out.print("Desired Home Value (nearest dollar) >> ");
					desiredHomeValue = inputC.nextInt();
					inputC.nextLine();	//get rid of leftover newline character
					System.out.print("Please enter number of years for loan (15 or 30 years) >> ");
					totalYears = inputC.nextInt();
					inputC.nextLine();	//get rid of leftover newline characcter
					
				//Convert years to months
					totalMonths = totalYears * 12;
				//Calculate totaLoal and monthlyRate
					totalLoan = desiredHomeValue - CalculateDownPayment(desiredHomeValue, creditScore);	//nearest dollar
					monthlyRate = CalculateInterestRate(creditScore) / 12;								//returns interest rate as decimal
					
				//check for valid user input
					
					//check each boolean variable
					if ( !((creditScore >= 300) && (creditScore <= 850))) {
						validCreditScore = true;
					}
					if ( !((totalYears == 15) || (totalYears == 30))) {
						validTotalYears = false;
					}
					if (desiredHomeValue <= 0) {
						validHomeValue = false;
					}
					
					
				//check that all user input is valid...
					if (validCreditScore && validTotalYears && validHomeValue) {
						validUserInput = true;
					}
					else {
						validUserInput = false;
					}	
					
				//check if user entered any invalid input. If so, print out the invalid entries
					if ( !validUserInput) {
						
						System.out.println("You entered invalid information for the following:");
						
						if ( !validCreditScore) {
							System.out.println("Inavlid Credit Score Entered");
						}
						if ( !validTotalYears) {
							System.out.println("Invaid Amount of Years Entered");
						}
						if ( !validHomeValue) {
							System.out.println("Invalid DesiredHome Value Entered");
						}
					}
				//if user did NOT enter any invalid information...else....
					else {

						estimatedMonthlyPayment = EstimateMonthlyPayment(totalLoan, monthlyRate, totalMonths);
						System.out.println("The estimated monthly payment (before Taxes/Insurance) is: $" + estimatedMonthlyPayment);
					}
					
					PrintNewLine();
				}
				
				else if (userSelection == 'c') { //Loan Approval Reader - Prints Decisions on Applications from CSV Files
					PrintLoanDecisions(csvFile);	//function call only requires csvFile reference variable to file to be passed
					
					PrintNewLine();
				}
				
				else if (userSelection == 'd') {
					System.out.println("Please come back again!");
					userQuits = true;
				}
				
				else {
				//default case if user enters ivalid choice!
					System.out.println("Invalid selection. Please try again!");
					PrintNewLine();
					PrintNewLine();
				}
			
			}

			
		}catch (Exception e) {
			System.out.println("Error happened while reading from file:\n" + e + "\n");
		}
		
		
		
		
	}
	
}