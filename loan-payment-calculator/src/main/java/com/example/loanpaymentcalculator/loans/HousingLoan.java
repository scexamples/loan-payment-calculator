package com.example.loanpaymentcalculator.loans;

import org.springframework.stereotype.Component;

import com.example.loanpaymentcalculator.schemes.PaybackScheme;

@Component
public class HousingLoan extends Loan {

	
	public HousingLoan() {
		
	}
	
	public HousingLoan(int loanAmount, int termInMonths, double interestRate, PaybackScheme ps) {		
		super(loanAmount, termInMonths, interestRate, ps);		
	}

}
