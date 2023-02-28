package com.example.loanpaymentcalculator.loans;

import org.springframework.stereotype.Component;

import com.example.loanpaymentcalculator.schemes.PaybackScheme;

@Component
public class CarLoan extends Loan {

	public CarLoan() {
		
	}
	
	public CarLoan(int loanAmount, int termInMonths, double interestRate, PaybackScheme ps) {		
		super(loanAmount, termInMonths, interestRate, ps);		
	}

}
