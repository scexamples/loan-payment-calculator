
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

## Use Case 1 - Housing Loan with the Series Payback Scheme
- Access the app on localhost:8080  

![img0formdropdown](https://user-images.githubusercontent.com/15854708/221764038-844120e7-5c37-4b8b-acb3-cffd13b4259c.JPG)  

- Specify the following in the form:  
	Loan Type: Housing  
	Loan Amount: 12000  
	Term in Months: 12  
	Payback Scheme: Series  
	
![img2Series1200012m](https://user-images.githubusercontent.com/15854708/221764079-dc562ba4-3204-4b20-893e-03270503dbd6.JPG)  

- Click on 'Calculate' to view the Payback Schedule  

![img3output](https://user-images.githubusercontent.com/15854708/221764098-bfa455a0-b98a-427f-9e21-c5bbedcd8a22.JPG)  

## Use Case 2 - Car Loan with the Balloon Payback Scheme

- Specify the following in the form:  
	Loan Type: Car  
	Loan Amount: 24000  
	Term in Months: 6  
	Payback Scheme: Balloon 
	
![img6CarBaloon6m](https://user-images.githubusercontent.com/15854708/221764133-6208982e-dfcc-4638-a609-9d083e39e3d6.JPG)  

- Click on 'Calculate' to view the Payback Schedule

![img7output](https://user-images.githubusercontent.com/15854708/221764151-8a58d162-3a02-4612-ba46-ae5f9991bdf6.JPG)

