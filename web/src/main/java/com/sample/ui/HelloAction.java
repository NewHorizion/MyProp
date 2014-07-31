package com.sample.ui;

import com.opensymphony.xwork2.ActionSupport;
import com.sample.webserviceprocess.HelloProcess;

public class HelloAction extends ActionSupport {
	private HelloProcess helloProcess;
	public String execute() {
		helloProcess.sayHello();
		return SUCCESS;
	}

	public HelloProcess getHelloProcess() {
		return helloProcess;
	}

	public void setHelloProcess(HelloProcess helloProcess) {
		this.helloProcess = helloProcess;
	}
}
