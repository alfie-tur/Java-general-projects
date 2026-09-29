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
		
		int personalAllowance = 12570; //all earnings under this amount are not taxed
		int lowestTaxBracket = 50270; //everything between this and personalAllowance is taxed by 20%
		int midTaxBracket = 125140; //everything between this and lowestTaxBracket is taxed by 40%
		//everything above midTaxBracket is taxed by 45%
		
		if (annualEarnings <= personalAllowance) {
			System.out.println("Your yearly salary is £" + annualEarnings);
			System.out.println("You earn £" + (annualEarnings/12) + " per month");
		}
		else if (annualEarnings > personalAllowance && annualEarnings < lowestTaxBracket) {
			double taxedAmount = annualEarnings - personalAllowance;
			
			taxedAmount = taxedAmount * 0.2;
			
			annualEarnings = annualEarnings - taxedAmount;
			
			System.out.println("Your yearly salary is £" + (annualEarnings));
			System.out.println("You earn £" + (annualEarnings / 12) + " per month");
		}
		else if (annualEarnings >= lowestTaxBracket && annualEarnings < midTaxBracket) {
			double highTaxed = annualEarnings - (lowestTaxBracket);		
			
			highTaxed = highTaxed * 0.4;
			
			double lowTaxed = lowestTaxBracket - personalAllowance;
			
			lowTaxed = lowTaxed * 0.2;
			
			annualEarnings = annualEarnings - highTaxed - lowTaxed;
			
			System.out.println("Your yearly salary is £" + (annualEarnings));
			System.out.println("You earn £" + (annualEarnings / 12) + " per month");
			
		}
		else if (annualEarnings >= midTaxBracket) {
			double highTaxed = annualEarnings - midTaxBracket;
			
			highTaxed = highTaxed * 0.45;
			
			double midTaxed = midTaxBracket - lowestTaxBracket;
			
			midTaxed = midTaxed * 0.4;
			
			double lowTaxed = lowestTaxBracket - personalAllowance;
			
			lowTaxed = lowTaxed * 0.2;

			annualEarnings = annualEarnings - (highTaxed + midTaxed + lowTaxed);
			
			System.out.println("Your yearly salary is £" + (annualEarnings));
			System.out.println("You earn £" + (annualEarnings / 12) + " per month");
			
		}
		
	}

}
