package com.example.loanpaymentcalculator.displaymodels;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.loanpaymentcalculator.models.PaybackPlanItem;

@Component(value="BalloonPaybackPlanDTO")
public class BalloonPaybackPlanDTO extends PaybackPlanDTO {
	
	private double balloonAmount;
		
	public BalloonPaybackPlanDTO() {
		
	}

	public BalloonPaybackPlanDTO(int loanAmount, int termInMonths, double interestRate,
			double balloonAmount, List<PaybackPlanItem> itemList) {
		
		super(loanAmount, termInMonths, interestRate, itemList);		
		this.balloonAmount = balloonAmount;
		
	}

	public double getBalloonAmount() {
		return balloonAmount;
	}

	public void setBalloonAmount(double balloonAmount) {
		this.balloonAmount = balloonAmount;
	}

	@Override
	public String getTotalPayment() {
		double payment = 0.0;
		for(PaybackPlanItem ppi: getItemList()) {
			payment+=ppi.getPayment();
		}
		return df.format(payment+=balloonAmount);
	}
	
	@Override
	public double getLoanAmountDuePerMonth() {
		return (getLoanAmount()-balloonAmount)/(double)getTermInMonths();
	}
	
	@Override
	public void printSchedule() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("$").append(getLoanAmount()).append(" loan, ").append(getInterestRate()*100).append(" % interest rate on ")
		.append("$").append(getLoanAmount()-balloonAmount).append(" over ").append(getTermInMonths()).append(" monthly payments.");
		System.out.println(sb.toString());
		sb.setLength(0);;
		sb.append("Balloon payment of $").append(df.format(balloonAmount)).append(" after ").append(getTermInMonths()).append(" months.");
		System.out.println(sb.toString());
		
		System.out.println("Loan Amount Due Per Month: $" + getLoanAmountDuePerMonth());
		
		System.out.println("For month" + "\t" + " Payment" + "\t"  + "Interest Component" + "\t" + "Principal Component" + "\t" + "Amount outstanding");
		
		for(int i = 0; i<getItemList().size(); i++) {
			PaybackPlanItem item = getItemList().get(i);
			System.out.println("\t" + (i+1) + "\t" + df.format(item.getPayment()) + "\t\t" + df.format(item.getInterest())
			+ "\t\t\t" + df.format(item.getPrincipalComponent())
			+ "\t\t\t" + df.format((getLoanAmount() - getBalloonAmount()) - getLoanAmountDuePerMonth()*(i+1)));

		}
		
		System.out.println("Balloon payment due: $" + df.format(balloonAmount));
		System.out.println("Total payment: $" + getTotalPayment() + " Total interest: $" + getTotalInterest());
	}
	

}
