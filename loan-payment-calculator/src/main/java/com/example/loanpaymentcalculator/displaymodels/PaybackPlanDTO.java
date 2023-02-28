package com.example.loanpaymentcalculator.displaymodels;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.loanpaymentcalculator.models.PaybackPlanItem;

/* Utility class for use in the UI 
 * includes data and methods to derive values and format numbers for UI display 
 * Class must be extended for instantiation
*/
public abstract class PaybackPlanDTO {

	private int loanAmount;
	private int termInMonths;
	private double interestRate;
	private List<PaybackPlanItem> itemList;
	
	protected static final DecimalFormat df = new DecimalFormat("0.00");
	
	protected PaybackPlanDTO(int loanAmount, int termInMonths, double interestRate, List<PaybackPlanItem> itemList) {
		super();
		this.loanAmount = loanAmount;
		this.termInMonths = termInMonths;
		this.interestRate = interestRate;
		this.itemList = itemList;
	}

	public PaybackPlanDTO() {
		super();
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

	public List<PaybackPlanItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PaybackPlanItem> itemList) {
		this.itemList = itemList;
	}

	public String getTotalPayment() {
		double payment = 0.0;
		for(PaybackPlanItem ppi: itemList) {
			payment+=ppi.getPayment();
		}
		return df.format(payment);
	}

	public String getTotalInterest() {
		double interest = 0.0;
		for(PaybackPlanItem ppi: itemList) {
			interest+=ppi.getInterest();
		}
		return df.format(interest);
	}

	public double getLoanAmountDuePerMonth() {
		return loanAmount/(double)termInMonths;
	}
	
	public List<DisplayPaybackPlanItem> getDisplayList(){
		
		List<DisplayPaybackPlanItem> displayList = new ArrayList<>();
		
		for(int i = 0; i<getItemList().size(); i++) {
			PaybackPlanItem item = getItemList().get(i);
			int id = i+1;
			String payment = df.format(item.getPayment());
			String interest = df.format(item.getInterest());
			String principalComponent = df.format(item.getPrincipalComponent());
			String amountOutstanding = df.format(getLoanAmount() - getLoanAmountDuePerMonth()*(i+1));
			
			displayList.add(new DisplayPaybackPlanItem(id, payment, interest, principalComponent, amountOutstanding));
		}
		
		return displayList;
		
	}

	public void printSchedule() {
		System.out.println();
		StringBuilder sb = new StringBuilder();
		sb.append("$").append(getLoanAmount()).append(" loan, ").append(getInterestRate()*100).append(" % interest rate, ")
		.append(getTermInMonths()).append(" monthly payments.");
		System.out.println(sb.toString());
		
		System.out.println("Loan Amount Due Per Month: $" + getLoanAmountDuePerMonth());
		
		System.out.println("For month" + "\t" + " Payment" + "\t"  + "Interest Component" + "\t" + "Principal Component" + "\t" + "Amount outstanding");
		
		for(int i = 0; i<getItemList().size(); i++) {
			PaybackPlanItem item = getItemList().get(i);
			System.out.println("\t" + (i+1) + "\t" + df.format(item.getPayment()) + "\t\t" + df.format(item.getInterest())
			+ "\t\t\t" + df.format(item.getPrincipalComponent())
			+ "\t\t\t" + df.format(getLoanAmount() - getLoanAmountDuePerMonth()*(i+1)));
	
		}
	
		System.out.println("Total payment: $" + getTotalPayment() + " Total interest: $" + getTotalInterest());
	}

}