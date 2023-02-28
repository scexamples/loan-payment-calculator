package com.example.loanpaymentcalculator.displaymodels;

import org.springframework.stereotype.Component;

@Component
public class DisplayPaybackPlanItem {

	private int id;
	private String payment;
	private String interest;
	private String principalComponent;
	private String amountOutstanding;
	
	
	public DisplayPaybackPlanItem() {
		super();
	}
	
	public DisplayPaybackPlanItem(int id, String payment, String interest, String principalComponent, String amountOutstanding) {
		super();
		this.id = id;
		this.payment = payment;
		this.interest = interest;
		this.principalComponent = principalComponent;
		this.amountOutstanding = amountOutstanding;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getPrincipalComponent() {
		return principalComponent;
	}
	public void setPrincipalComponent(String principalComponent) {
		this.principalComponent = principalComponent;
	}
	public String getAmountOutstanding() {
		return amountOutstanding;
	}
	public void setAmountOutstanding(String amountOutstanding) {
		this.amountOutstanding = amountOutstanding;
	}	
}
