package com.example.loanpaymentcalculator.models;

public enum LoanType {

	HOUSING("Housing"), CAR("Car"), PERSONAL("Personal"), BUSINESS("Business");
	
	private String loanTypeName;

	LoanType(String loanTypeName) {
       this.loanTypeName = loanTypeName;
    }

   @Override
   public String toString() {
    return this.loanTypeName;
   }
   
}
