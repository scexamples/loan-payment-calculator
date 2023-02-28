package com.example.loanpaymentcalculator.schemes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.loanpaymentcalculator.models.PaybackPlanItem;
import com.example.loanpaymentcalculator.models.PaybackSchemeParameters;

/*
 * In the balloon payment scheme, a portion of the principal (and interest) is paid periodically. At the end of the period the remainder
 * of the loan is paid as a single balloon payment.
 * 
 * EXAMPLE:
 * $24,000 loan with $12000 balloon after 12 months
 * Periodic payment schedule: Every month over 12 months
 ^ Each month make a fixed principal payment of $1000 and interest on the remaining portion of the non-balloon portion
 */
@Component(value="BalloonLoanScheme")
public class BalloonLoanScheme implements PaybackScheme {

	private static final int SIMPLE_INTEREST_CONSTANT = 1;
	private static final int MONTHS_IN_A_YEAR = 12;
	
	public BalloonLoanScheme() {}

	@Override
	public List<PaybackPlanItem> calculateMonthlyPayment(PaybackSchemeParameters paybackSchemeParameters) {
		
			List<PaybackPlanItem> paybackPlanItems = new ArrayList<>();
			double loanAmountDuePerMonth = (paybackSchemeParameters.getLoanAmount()-paybackSchemeParameters.getBalloonAmount())/(double)paybackSchemeParameters.getTermInMonths();
			
			for(int i = 0; i<paybackSchemeParameters.getTermInMonths(); i++){
				
				int remainingMonths = paybackSchemeParameters.getTermInMonths()-i;

				// total outstanding loanAmount to be paid in installments
				double unpaidPrincipal = (paybackSchemeParameters.getLoanAmount() - paybackSchemeParameters.getBalloonAmount())- (loanAmountDuePerMonth*i);			
				
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
