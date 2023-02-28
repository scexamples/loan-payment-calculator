
## Loan Payment Calculator - a web application that generates a loan payback schedule

## Technologies
 Spring Boot  
 Thymeleaf  
 Bootstrap

## App Features
i) A simple user interface to specify the loan type (housing, car, personal, business), duration, and payback scheme (series, balloon)  
ii) The interest rate varies by loan type and is configurable  
iii) The app generates a monthly payback plan based on the loan type, interest rate, duration, and payback scheme  
iv) Current implementation works for two loan types (housing and car) and two payback schemes (series and balloon) but it can easily be extended for other loan types with different interest rates and for other payback schemes 

## Use Case
- Access the app on localhost:8080  
- Specify the following in the form:  
	Loan Type: Car  
	Loan Amount: 24000  
	Term in Months: 12  
	Payback Scheme: Balloon
- Click on 'Calculate' to view the Payback Schedule. Car loan interest rate is configured to 0.25%


