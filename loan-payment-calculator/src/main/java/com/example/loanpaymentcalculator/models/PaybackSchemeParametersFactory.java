package com.example.loanpaymentcalculator.models;

import org.springframework.stereotype.Component;

@Component
public class PaybackSchemeParametersFactory {
	
	private PaybackSchemeParametersFactory() {}
	
	public static PaybackSchemeParameters getParameters(PaybackSchemeType type, int loanAmount, int termInMonths, double interestRate) {
		
		if(type == PaybackSchemeType.SERIES) {
			return new PaybackSchemeParameters(loanAmount, termInMonths, interestRate);
		} 
		return null;
		
	}
	
	public static PaybackSchemeParameters getParameters(PaybackSchemeType type, int loanAmount, int termInMonths, double interestRate, double balloonAmount) {
		
		if(type == PaybackSchemeType.BALLOON) {
			return new PaybackSchemeParameters(loanAmount, termInMonths, interestRate, balloonAmount);
		} 
		return null;
		
	}	
		
}
