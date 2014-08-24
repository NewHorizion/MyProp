package com.sample.ui.login;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.eclipse.jetty.util.ajax.JSONObjectConvertor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	AuthenticationManager authenticationManager;
	private String username;
	private String password;
	private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
	private ApplicationEventPublisher eventPublisher;

	private SessionAuthenticationStrategy sas;

	public String login () 
 {

		if (null != username && null != password) {
			try {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(
								username, password));
				SecurityContextHolder.getContext().setAuthentication(
						authentication);
				if (authentication.isAuthenticated()) {
					jsonMap.put("success", true);
					jsonMap.put("messages", "Welcome " + username + "!!!!");
				}
			    // Fire auth event
			    if (this.eventPublisher != null)
			    {
			      eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authentication, this.getClass()));
			    }
			    
			    if (sas != null)
			    {
			      sas.onAuthentication(authentication, ServletActionContext.getRequest(), ServletActionContext.getResponse());			    }
			} catch (BadCredentialsException be) {
				jsonMap.put("success", false);
				jsonMap.put("errorName", "Invalid user name or password !!");
			}

			// seuritycontexcontextholde
		} else {
			jsonMap.put("success", false);
			jsonMap.put("errorName", "Invalid user name or password !!");
		}

		return SUCCESS;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public ApplicationEventPublisher getEventPublisher() {
		return eventPublisher;
	}

	public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public SessionAuthenticationStrategy getSas() {
		return sas;
	}

	public void setSas(SessionAuthenticationStrategy sas) {
		this.sas = sas;
	}

}
