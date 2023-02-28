package com.example.loanpaymentcalculator.displaymodels;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.loanpaymentcalculator.models.PaybackPlanItem;

@Component(value="SeriesPaybackPlanDTO")
public class SeriesPaybackPlanDTO extends PaybackPlanDTO {
	
	public SeriesPaybackPlanDTO() {
		
	}

	public SeriesPaybackPlanDTO(int loanAmount, int termInMonths, double interestRate, List<PaybackPlanItem> itemList) {
		super(loanAmount, termInMonths, interestRate, itemList);
	}
	
}
