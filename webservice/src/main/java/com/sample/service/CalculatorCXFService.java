package com.sample.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.sample.service.pojo.AttachementData;
import com.sample.service.pojo.CalculatorParams;

//service end point interface
@WebService
public interface CalculatorCXFService {
	@WebMethod  
    public int addition (CalculatorParams params);
	@WebMethod
	public int subtract (CalculatorParams params);
	@WebMethod
	public AttachementData getFile (String fileName);
	
}
