package com.sample.ui.login;

import org.springframework.security.authentication.AuthenticationManager;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	AuthenticationManager authenticationManager; 
	public String login () 
	{   
		
		return SUCCESS;
	}

}
