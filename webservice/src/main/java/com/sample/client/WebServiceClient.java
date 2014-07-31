package com.sample.client;


public class WebServiceClient {
	public static void main(String[] args) { 
	    /* Create the service instance */ 
	    CalculatorService service = new CalculatorService(); 
	    CalculatorDelegate delegate = service.getCalculatorPort(); 

	    /* Using the web service, perform the 4 calculations */ 
	    System.out.println("1. 3+7=" + delegate.add(3, 7)); 
	    System.out.println("2. 12-2=" + delegate.subtract(12, 2));
	    //System.out.println("3. 9*9=" + delegate.multiply(9, 9)); 
	    //System.out.println("4. 40/2=" + delegate.divide(40, 2)); 
	} 

}
