//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. DanielMejia
//Description
//	This class is constructed solely to test the outputs and overall functionalities of the methods in CL2_Main.java source code
//	The code will allow for user to choose which functions they want to test
//	The selected method will run and output expected results as well as actual results/output
//
//
//
//LIST OF TESTED METHODS:
//
//	public static double CalculateInterestRate(int creditScore)
//	public static int CalculateDownPayment(int homeValue, int creditScore)
//	public static boolean IsLoanApproved(int grossIncome, int totalSavings, int creditScore, int homeValue, int months)
//	public static double EstimateMonthlyPayment(int totalLoan, double monthlyRate, int months)
//	public static void PrintLoanDecisions(File sourceFile)
//
//END OF LIST OF METHODS


import java.util.Scanner;
import java.io.File;



public class CL2_MethodTesting {
	
	//NEEDED IRRELEVANT FUNCTIONS
	public static void PrintNewLine() {
		System.out.println();
	}
	
	//FUNCTIONS TO BE TESTED:

	//Method calculates interest rate to be applied to loan
	public static double CalculateInterestRate(int creditScore) {		//FIXED IN CL2_MAIN
		
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
	public static int CalculateDownPayment(int homeValue, int creditScore) {		//FIXED IN CL2_MAIN
		
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
	
	//Method returns estimate of Monthly Payment based on user input
	public static double EstimateMonthlyPayment(int totalLoan, double monthlyRate, int months) {	//NO ERRORS IN CL2_MAIN
		
		double monthlyPayment;
		
		monthlyPayment = (totalLoan * (monthlyRate * Math.pow(1 + monthlyRate, months))) / (Math.pow(1 + monthlyRate, months) - 1);
		
		return monthlyPayment;
		
	}
	
	//Method returns true if loan approval is possible, false if not possible based on user input
	public static boolean IsLoanApproved(int grossIncome, int totalSavings, int creditScore, int homeValue, int months) {	//FIXED IN CL2_MAIN
		
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
	
	//Main Method
	public static void main(String[] args) {
		
		Scanner inputC = new Scanner(System.in);
		boolean userQuits = false;					//assume false --> enter loop
		int userChoice = 0;
		String border = "-----------------------------------------------";
		
		while (!userQuits) {
			
			System.out.println("Make a selection:");
			System.out.println("\t1. Test CalculateInterestRate");
			System.out.println("\t2. Test CalculateDownPayment");
			System.out.println("\t3. Test IsLoanApproved");
			System.out.println("\t4. Test EstimateMonthlyPayment");
			System.out.println("\t5. Test PrintLoanDecisions");
			System.out.println("\t6. Exit/Quit Program");
			
			System.out.println();
			System.out.println();
			
			System.out.print(">> ");
			userChoice = inputC.nextInt();
			inputC.nextLine();				//gets rid of newline
			
			System.out.println();
			System.out.println();
			
			if(userChoice == 1) {			//test CalculateInterestRate
				
				System.out.println("Testing CalculateInterestRate Method\n\tTotal Tests = 3");
				System.out.println(border);
				
				//Expected outputs vs actual outputs
				System.out.println("Expecting: 0.028\nGot: " + CalculateInterestRate(839));
				System.out.println();
				System.out.println("Expecting: 0.033\nGot: " + CalculateInterestRate(601));
				System.out.println();
				System.out.println("Expecting: 0.040\nGot: " + CalculateInterestRate(481));
				System.out.println();
				System.out.println();
				
			}
			
			else if(userChoice == 2) {		//test CalculateDownPayment
			
				System.out.println("Testing CalculateDownPayment Method\n\tTotal Tests = 5");
				System.out.println(border);
				
				//Expected outputs vs actual outputs
				System.out.println("Expecting: 31200\nGot: " + CalculateDownPayment(156000, 549));
				System.out.println();
				System.out.println("Expecting: 9800\nGot: " + CalculateDownPayment(98000, 682));
				System.out.println();
				System.out.println("Expecting: 12500\nGot: " + CalculateDownPayment(250000, 845));
				System.out.println();
				System.out.println("Expecting: 3550\nGot: " + CalculateDownPayment(71000, 850));
				System.out.println();
				System.out.println("Expecting: 35380\nGot: " + CalculateDownPayment(176900, 300));
				System.out.println();
				System.out.println();
				
			}
			
			else if(userChoice == 3) {		//IsLoanApproved
			
				System.out.println("Testing IsLoanApproved Method\n\tTotal Tests = 4");
				System.out.println(border);
				
				//Expected outputs vs actual outputs
				System.out.println("Expecting: false\nGot: " + IsLoanApproved(123000, 9000, 805, 200000, 360));
				System.out.println();
				System.out.println("Expecting: true\nGot: " + IsLoanApproved(87900, 15000, 788, 101000, 360));
				System.out.println();
				System.out.println("Expecting: false\nGot: " + IsLoanApproved(60000, 2000, 504, 97500, 180));
				System.out.println();
				System.out.println("Expecting: false\nGot: " + IsLoanApproved(70000, 800, 308, 98000, 360));
				System.out.println();
				System.out.println();
				
			}
			
			else if(userChoice == 4) {		//test EstimateMonthlyPayment
			
				System.out.println("Testing EstimateMonthlyPayment Method\n\tTotal Tests = 4");
				System.out.println(border);
				
				//Expected outputs vs actual outputs
				System.out.println("Expecting: 629.3961\nGot: " + EstimateMonthlyPayment(91140, 0.0025, 180));
				System.out.println();
				System.out.println("Expecting: 1007.276026\nGot: " + EstimateMonthlyPayment(147952, 0.00233, 180));
				System.out.println();
				System.out.println("Expecting: 607.61197\nGot: " + EstimateMonthlyPayment(147952, 0.00233, 360));
				System.out.println();
				System.out.println("Expecting: 386.5512\nGot: " + EstimateMonthlyPayment(81360, 0.0033, 360));
				System.out.println();
				System.out.println();
				
			}
			
			else if(userChoice == 5) {		//test PrintLoanDecisions
			
				//read from CSV File in method tested
				File sourceFile = new File("MethodTestingFile.csv");
			
				System.out.println("Testing PrintLoanDecisions Method\n\tTotal Tests = 4");
				System.out.println(border);
				
				//Expected outputs vs actual outputs
				System.out.println("Expecting following approval decisions:");
				System.out.println("\tNathan Cruz - DENIED");
				System.out.println("\tAlan Renteria - ACCEPTED");
				System.out.println("\tBrandon Evans - DENIED");
				System.out.println("\tYazid Escudero - DENIED");
				
				System.out.println();
				System.out.println();
				
				PrintLoanDecisions(sourceFile);
			}
			
			else if(userChoice == 6) {		//Quit Program
				
				System.out.println("Quitting Program. Have a Great Day!");
				userQuits = true;
				
			}
			
			else {
				
				System.out.println("Incorrect Input. Please, try again");
				System.out.println();
				System.out.println();
				
			}
			
		}
		
	}
	
}