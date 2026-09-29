package taxCalculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		tax();
	}
	
	static void tax() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("NOTE: This calculator doesn't deduct National Insurance. This exclusively shows your income after income tax");
		System.out.println("How much do you earn annually?");
		double annualEarnings = input.nextDouble();
		
		
		//values for each tax bracket:
		double personalAllowance = 12570; //all earnings under this amount are not taxed
		int lowestTaxBracket = 50270; //everything between this and personalAllowance is taxed by 20%
		int midTaxBracket = 125140; //everything between this and lowestTaxBracket is taxed by 40%
		//everything above midTaxBracket is taxed by 45%
		
		
		if (annualEarnings <= personalAllowance) {
			System.out.println("Your yearly salary is £" + annualEarnings);
			System.out.println("You earn £" + (annualEarnings/12) + " per month");
		}
		
		else if (annualEarnings > personalAllowance && annualEarnings < lowestTaxBracket) {
			
			//calculation for the amount to be taxed
			double taxedAmount = annualEarnings - personalAllowance;
			
			//calculations for the percentage
			taxedAmount = taxedAmount * 0.2;
			
			//deducting the taxed amount from the total salary
			annualEarnings = annualEarnings - taxedAmount;
			
			
			System.out.println("Your yearly salary is £" + (annualEarnings));
			System.out.println("You earn £" + (annualEarnings / 12) + " per month");
		}
		
		else if (annualEarnings >= lowestTaxBracket && annualEarnings < midTaxBracket) {
			
			//calculates the personal allowance for between £100,000 and £125,140
			double newPersonalAllowance = 0;
			if (annualEarnings >= 100000) { 
				//Your personal allowance goes down by £1 for every £2 that your adjusted net income is above £100,000. This means your allowance is zero if your income is £125,140 or above.
				double personalAllowanceCalculation = annualEarnings - 100000;
				personalAllowanceCalculation = personalAllowanceCalculation / 2;
				newPersonalAllowance = personalAllowance - personalAllowanceCalculation;
			}
			System.out.println("Personal Allowance: " + newPersonalAllowance);
			annualEarnings = annualEarnings - newPersonalAllowance;
			
			
			//calculating the amount to be taxed for each bracket
			double lowTaxed = lowestTaxBracket - personalAllowance;
			System.out.println("low amount: " + lowTaxed);
			
			double highTaxed = annualEarnings - lowTaxed; 
			System.out.println("top amount to be taxed: " + highTaxed);
			
			
			System.out.println(); //creates a blank line
			
			
			//calculating the percentages for each tax bracket
			highTaxed = highTaxed * 0.4;
			System.out.println("top tax: " + highTaxed);
			
			lowTaxed = lowTaxed * 0.2;
			System.out.println("low tax: " + lowTaxed);
			
			
			//deducting the taxed amount from the total salary
			annualEarnings = annualEarnings - (highTaxed + lowTaxed);
			
			
			System.out.println("Your yearly salary is £" + (annualEarnings + newPersonalAllowance));
			System.out.println("You earn £" + (annualEarnings / 12) + " per month");
			
		}
		else if (annualEarnings >= midTaxBracket) {
			
			//calculating how much is to be taxed for each tax bracket
			double lowTaxed = lowestTaxBracket - personalAllowance;
			System.out.println("low amount: " + lowTaxed);
			
			double midTaxed = midTaxBracket - lowTaxed;
			System.out.println("mid amount to be taxed: " + midTaxed);
			
			double highTaxed = annualEarnings - midTaxBracket;
			System.out.println("top amount to be taxed: " + highTaxed);
			
			
			System.out.println(); //creates a blank line
			
			
			//calculating percentages for each tax bracket
			highTaxed = highTaxed * 0.45;
			System.out.println("top tax: " + highTaxed);
			
			midTaxed = midTaxed * 0.4;
			System.out.println("mid tax: " + midTaxed);
			
			lowTaxed = lowTaxed * 0.2;
			System.out.println("low tax: " + lowTaxed);
			
			
			//deducting the taxed amount from the total salary
			annualEarnings = annualEarnings - (highTaxed + midTaxed + lowTaxed);
			
			System.out.println("Your yearly salary is £" + (annualEarnings));
			System.out.println("You earn £" + (annualEarnings / 12) + " per month");
			
		}
		input.close();
	}

}
