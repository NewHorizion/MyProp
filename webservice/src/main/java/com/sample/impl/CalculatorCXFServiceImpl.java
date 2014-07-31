package com.sample.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.sample.service.CalculatorCXFService;
import com.sample.service.pojo.AttachementData;
import com.sample.service.pojo.CalculatorParams;

public class CalculatorCXFServiceImpl implements CalculatorCXFService {

	@Override
	public int addition(CalculatorParams params) {
		
		return params.getVarA() + params.getVarB();
	}

	@Override
	public int subtract(CalculatorParams params) {
		return params.getVarA() - params.getVarB();
	}

	@Override
	public AttachementData getFile(String fileName) {
		
		try {
			File file = new File("c:\\temp\\GroupSetup.xml");
			FileInputStream fis = new FileInputStream(file);
		
			byte [] fileBytes = new byte [(int)file.length()];
			fis.read(fileBytes);
			fis.close();
			AttachementData attachementData = new AttachementData();
			attachementData.setByteData(fileBytes);
			return attachementData;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
