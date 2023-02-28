package com.example.loanpaymentcalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.loanpaymentcalculator.displaymodels.BalloonPaybackPlanDTO;
import com.example.loanpaymentcalculator.displaymodels.PaybackPlanDTO;
import com.example.loanpaymentcalculator.displaymodels.SeriesPaybackPlanDTO;
import com.example.loanpaymentcalculator.loans.CarLoan;
import com.example.loanpaymentcalculator.loans.HousingLoan;
import com.example.loanpaymentcalculator.loans.Loan;
import com.example.loanpaymentcalculator.models.LoanType;
import com.example.loanpaymentcalculator.models.PaybackPlanItem;
import com.example.loanpaymentcalculator.models.PaybackSchemeParameters;
import com.example.loanpaymentcalculator.models.PaybackSchemeParametersFactory;
import com.example.loanpaymentcalculator.models.PaybackSchemeType;
import com.example.loanpaymentcalculator.schemes.BalloonLoanScheme;
import com.example.loanpaymentcalculator.schemes.PaybackScheme;
import com.example.loanpaymentcalculator.schemes.SeriesLoanScheme;

@Controller
public class LoanController {
	
	@Autowired
	private Environment env;	
	
    @GetMapping("/")
    public String home(){
    	
    	return "index";
    	
    }
    
    @PostMapping("/display")
    public String calculate(
    		@RequestBody MultiValueMap<String,String> inputData,
    		Model model
    		){
    	
    	//Initialize fields based on user input from submitted form
    	String inputLoanType = inputData.getFirst("loanTypeOpt");
    	int loanAmount = Integer.parseInt(inputData.getFirst("loanAmount"));		
		int termInMonths = Integer.parseInt(inputData.getFirst("termInMonths"));
		String inputPaybackSchemeType = inputData.getFirst("paybackSchemeTypeOpt");
		PaybackScheme paybackScheme = inputPaybackSchemeType.equalsIgnoreCase("Series") ? new SeriesLoanScheme() : new BalloonLoanScheme();

		Loan loan = null;
		double interestRate = 0.0;
		PaybackPlanDTO paybackdto = null;
		List<PaybackPlanItem> paybackPlan = null;
		PaybackSchemeParameters paybackSchemeParameters = null;
		
		//Retrieve relevant properties from config file and create appropriate Loan object based on user input
		if(LoanType.HOUSING.toString().equals(inputLoanType)) {
			
			 interestRate = Double.parseDouble(env.getProperty("housingInterestRate"));
			 loan = new HousingLoan(loanAmount, termInMonths, interestRate, paybackScheme);
			 
		} else if(LoanType.CAR.toString().equals(inputLoanType)) {
			
			 interestRate = Double.parseDouble(env.getProperty("carInterestRate"));
			 loan = new CarLoan(loanAmount, termInMonths, interestRate, paybackScheme);
		}

		if(PaybackSchemeType.SERIES.toString().equalsIgnoreCase(inputPaybackSchemeType)){

			paybackSchemeParameters = PaybackSchemeParametersFactory.getParameters(PaybackSchemeType.SERIES, loanAmount, termInMonths, interestRate);
			paybackPlan = loan.generatePaymentPlan(paybackSchemeParameters);

			paybackdto = new SeriesPaybackPlanDTO(loanAmount, termInMonths, interestRate, paybackPlan);
		

		} else if(PaybackSchemeType.BALLOON.toString().equalsIgnoreCase(inputPaybackSchemeType)){
			
			double balloonAmount = loanAmount-(loanAmount*Double.parseDouble(env.getProperty("balloonPercent")));

			paybackSchemeParameters = PaybackSchemeParametersFactory.getParameters(PaybackSchemeType.BALLOON, loanAmount, termInMonths, interestRate, balloonAmount);
			paybackPlan = loan.generatePaymentPlan(paybackSchemeParameters);
			
			paybackdto = new BalloonPaybackPlanDTO(loanAmount, termInMonths, interestRate, balloonAmount, paybackPlan);
			
			model.addAttribute("balloonAmount", balloonAmount);
			
		}
			
		//Add attributes to Model object which is available in the template for UI display
		model.addAttribute("loanType", inputLoanType);
		model.addAttribute("paybackSchemeType", inputPaybackSchemeType);
		model.addAttribute("paybackdto", paybackdto);
		
		//Also print to console
		paybackdto.printSchedule();
		
		//Render template
        return "payback-schedule";
    }

}
