package com.example.loanpaymentcalculator.schemes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.loanpaymentcalculator.models.PaybackPlanItem;
import com.example.loanpaymentcalculator.models.PaybackSchemeParameters;

/*
 * In the series loan scheme, periodic monthly payments include a fixed equal amount of the principal and 
 * the interest assessed on the remaining unpaid portion of the principal (the interest portion decreases with each
 * periodic payment)
 * 
 * EXAMPLE:
 * $12,000 loan over 12 months at 5% interest rate
 * Periodic payment schedule: $1000 every month over 12 months
 ^ Each month make a payment of $1000 and 5% interest on the unpaid portion
 */
@Component(value="SeriesLoanScheme")
public class SeriesLoanScheme implements PaybackScheme {
	
	private static final int SIMPLE_INTEREST_CONSTANT = 1;
	private static final int MONTHS_IN_A_YEAR = 12;

	
	public SeriesLoanScheme() {
		
	}
	
	public List<PaybackPlanItem> calculateMonthlyPayment(PaybackSchemeParameters paybackSchemeParameters) {
		
		List<PaybackPlanItem> paybackPlanItems = new ArrayList<>();
		double loanAmountDuePerMonth = paybackSchemeParameters.getLoanAmount()/(double)paybackSchemeParameters.getTermInMonths();
		
		for(int i = 0; i<paybackSchemeParameters.getTermInMonths(); i++){
			
			int remainingMonths = paybackSchemeParameters.getTermInMonths()-i;

			// total outstanding loanAmount as of this month
			double unpaidPrincipal = paybackSchemeParameters.getLoanAmount() - (loanAmountDuePerMonth*i);			
			
			// total outstanding amount (loan+interest)
			double unpaidBalance =  unpaidPrincipal*(SIMPLE_INTEREST_CONSTANT + (paybackSchemeParameters.getInterestRate()*(remainingMonths/(double)MONTHS_IN_A_YEAR)));			
			
			// interest for this term
			double interest = unpaidBalance - unpaidPrincipal;
			
			// payment for this term (loan installment plus interest)
			double payment = loanAmountDuePerMonth + interest;
			
			paybackPlanItems.add(new PaybackPlanItem(payment, interest));
						
		}
				
		return paybackPlanItems;
	}
	
}
