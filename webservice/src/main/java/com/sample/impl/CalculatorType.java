package com.sample.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "CalculatorPortType", targetNamespace = "http://www.example.org/calculatorservice/", wsdlLocation="WEB-INF/wsdl/CalculatorService.wsdl")
public interface CalculatorType {

    /**
     * 
     * @param requestHeader
     * @param parameters
     * @return
     *     returns com.mg.ws.AccountDetailsTO
     * @throws AccountDetailsFault_Exception
     */
    @WebMethod(action = "add")
    @WebResult(name = "addResponse", targetNamespace = "http://www.example.org/calculatorservice/", partName = "parameters")
    @RequestWrapper(localName = "addRequest", targetNamespace = "http://www.example.org/calculatorservice/", className = "com.sample.impl.jaxws.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://www.example.org/calculatorservice/", className = "com.sample.impl.jaxws.AddResponse")
    public int add(
        @WebParam(name = "arg0", targetNamespace = "http://www.example.org/calculatorservice/", partName = "parameters")
        int a,
        @WebParam(name = "arg1", targetNamespace = "http://www.example.org/calculatorservice/", partName = "parameters")
        int b)
    ;
    
    @WebMethod(action = "subtract")
    @WebResult(name = "subtractResponse", targetNamespace = "http://www.example.org/calculatorservice/", partName = "parameters")
    @RequestWrapper(localName = "subtract", targetNamespace = "http://www.example.org/calculatorservice/", className = "com.sample.impl.jaxws.Subtract")
    @ResponseWrapper(localName = "subtractResponse", targetNamespace = "http://www.example.org/calculatorservice/", className = "com.sample.impl.jaxws.SubtractResponse")
    public int subtract(
        @WebParam(name = "arg0", targetNamespace = "http://www.example.org/calculatorservice/", partName = "parameters")
        int a,
        @WebParam(name = "arg1", targetNamespace = "http://www.example.org/calculatorservice/", partName = "parameters")
        int b)
    ;

}
