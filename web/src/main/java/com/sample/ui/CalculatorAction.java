package com.sample.ui;

import com.opensymphony.xwork2.ActionSupport;
import com.sample.service.CalculatorCXFService;
import com.sample.service.pojo.CalculatorParams;

public class CalculatorAction extends ActionSupport {
	
	private CalculatorCXFService calculatorClient;
	private CalculatorCXFService calculatortJMSClient;
    
	
	public String execute ()
	{  
		CalculatorParams calculatorParams = new CalculatorParams();
		calculatorParams.setVarA(20);
		calculatorParams.setVarB(10);
		int x = calculatorClient.addition(calculatorParams);
		int y = calculatortJMSClient.subtract(calculatorParams);
		//AttachementData attachementData = calculatorClient.getFile("test");
		return SUCCESS;
	}
	public CalculatorCXFService getCalculatorClient() {
		return calculatorClient;
	}

	public void setCalculatorClient(CalculatorCXFService calculatorClient) {
		this.calculatorClient = calculatorClient;
	} 
	
	public CalculatorCXFService getCalculatortJMSClient() {
		return calculatortJMSClient;
	}
	public void setCalculatortJMSClient(CalculatorCXFService calculatortJMSClient) {
		this.calculatortJMSClient = calculatortJMSClient;
	}
}
