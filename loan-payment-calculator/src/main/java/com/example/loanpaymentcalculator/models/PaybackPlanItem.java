package com.example.loanpaymentcalculator.models;

import org.springframework.stereotype.Component;

@Component
public class PaybackPlanItem {
	
	private double payment;
	private double interest;
	
	public PaybackPlanItem() {}
	
	public PaybackPlanItem(double payment, double interest) {
		super();
		this.payment = payment;
		this.interest = interest;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	public double getPrincipalComponent() {
		return payment-interest;
	}

}
