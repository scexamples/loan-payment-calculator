package com.example.loanpaymentcalculator.loans;

import java.util.List;

import com.example.loanpaymentcalculator.models.PaybackPlanItem;
import com.example.loanpaymentcalculator.models.PaybackSchemeParameters;
import com.example.loanpaymentcalculator.schemes.PaybackScheme;

// Abstract class to not allow instantiation
public abstract class Loan {
	
	private int loanAmount;
	private int termInMonths;
	private double interestRate;
	private PaybackScheme paybackScheme; 
	
	protected Loan() {
		
	}
	
	protected Loan(int loanAmount, int termInMonths, double interestRate, PaybackScheme paybackScheme) {
		super();
		this.loanAmount = loanAmount;
		this.termInMonths = termInMonths;
		this.interestRate = interestRate;
		this.paybackScheme = paybackScheme;
	}
	
	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTermInMonths() {
		return termInMonths;
	}

	public void setTermInMonths(int termInMonths) {
		this.termInMonths = termInMonths;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public PaybackScheme getPaybackScheme() {
		return paybackScheme;
	}

	public void setPs(PaybackScheme paybackScheme) {
		this.paybackScheme = paybackScheme;
	}

	public List<PaybackPlanItem> generatePaymentPlan(PaybackSchemeParameters paybackSchemeParameters){
		return paybackScheme.calculateMonthlyPayment(paybackSchemeParameters);
	}

}
