package com.sample.service.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Operands")
public class CalculatorParams {
     private int varA;
     private int varB;
	public int getVarA() {
		return varA;
	}
	public void setVarA(int varA) {
		this.varA = varA;
	}
	public int getVarB() {
		return varB;
	}
	public void setVarB(int varB) {
		this.varB = varB;
	}
     
}
