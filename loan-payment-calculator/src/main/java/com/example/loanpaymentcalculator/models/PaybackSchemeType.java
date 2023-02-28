package com.example.loanpaymentcalculator.models;

public enum PaybackSchemeType {

	SERIES("Series"), BALLOON("Balloon");
	
	private String paybackSchemeTypeName;

	PaybackSchemeType(String paybackSchemeTypeName) {
       this.paybackSchemeTypeName = paybackSchemeTypeName;
    }

   @Override
   public String toString() {
    return this.paybackSchemeTypeName;
   }
   
}
