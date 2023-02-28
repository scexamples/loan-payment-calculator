package com.example.loanpaymentcalculator.models;

import org.springframework.stereotype.Component;

@Component
public class PaybackSchemeParameters {
	
	private int loanAmount;
	private int termInMonths;
	private double interestRate;
	private double balloonAmount;
	
	public PaybackSchemeParameters() {
		
	}

	public PaybackSchemeParameters(int loanAmount, int termInMonths, double interestRate) {
		super();
		this.loanAmount = loanAmount;
		this.termInMonths = termInMonths;
		this.interestRate = interestRate;
	}

	public PaybackSchemeParameters(int loanAmount, int termInMonths, double interestRate, double balloonAmount) {
		this(loanAmount, termInMonths, interestRate);
		this.balloonAmount = balloonAmount;
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

	public double getBalloonAmount() {
		return balloonAmount;
	}

	public void setBalloonAmount(double balloonAmount) {
		this.balloonAmount = balloonAmount;
	}

}
