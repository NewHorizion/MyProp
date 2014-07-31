package com.sample.impl;

import javax.jws.WebService;

import com.sample.impl.CalculatorType;

@WebService(serviceName = "CalculatorService", portName = "calculatorservicePort", endpointInterface = "com.sample.impl.CalculatorType", wsdlLocation = "WEB-INF/wsdl/CalculatorService.wsdl", targetNamespace = "http://www.example.org/calculatorservice/")
public class Calculator implements CalculatorType {
	public int add(int a, int b) {
		return (a + b);
	}

	public int subtract(int a, int b) {
		return (a - b);
	}

}
