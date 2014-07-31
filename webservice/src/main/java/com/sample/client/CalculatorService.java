package com.sample.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

@WebServiceClient(name = "CalculatorService", targetNamespace = "http://www.example.org/calculatorservice/", wsdlLocation = "http://localhost:8080/WebServiceProject/CalculatorService?wsdl")
public class CalculatorService extends Service {
	private final static URL CALCULATORSERVICE_WSDL_LOCATION;

	static {
		URL url = null;
		try {
			url = new URL(
					"http://localhost:8080/webservicesample/operations?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		CALCULATORSERVICE_WSDL_LOCATION = url;
	}

	public CalculatorService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public CalculatorService() {
		super(CALCULATORSERVICE_WSDL_LOCATION, new QName(
				"http://www.example.org/calculatorservice/", "CalculatorService"));
	}

	/**
	 * 
	 * @return returns CalculatorDelegate
	 */
	@WebEndpoint(name = "CalculatorPortType")
	public CalculatorDelegate getCalculatorPort() {
		return (CalculatorDelegate) super.getPort(new QName(
				"http://www.example.org/calculatorservice/", "calculatorservicePort"),
				CalculatorDelegate.class);
	}
}
