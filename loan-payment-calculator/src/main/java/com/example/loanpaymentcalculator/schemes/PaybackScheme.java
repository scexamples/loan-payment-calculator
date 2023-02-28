package com.example.loanpaymentcalculator.schemes;

import java.util.List;

import com.example.loanpaymentcalculator.models.PaybackPlanItem;
import com.example.loanpaymentcalculator.models.PaybackSchemeParameters;

public interface PaybackScheme {
		
	public List<PaybackPlanItem> calculateMonthlyPayment(PaybackSchemeParameters paybackSchemeParameters);

}
