package com.sample.ui.login;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import com.opensymphony.xwork2.ActionSupport;
import com.vstar.common.VstarConstants;
import com.vstar.dao.PropUsersDao;
import com.vstar.dao.process.propertyUpload.RegistrationProcess;
import com.vstar.dao.process.propertyUpload.UserProcess;
import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;
import com.vstar.process.propertyDetailInfo.RegistrationInfo;
import com.vstar.process.propertyDetailInfo.RequirementInfo;

public class LoginAction extends ActionSupport 
implements ServletResponseAware, ServletRequestAware{

	AuthenticationManager authenticationManager;
	private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
	private ApplicationEventPublisher eventPublisher;
	private RegistrationInfo registrationInfo;

	private SessionAuthenticationStrategy sas;
	
	private UserProcess userProcess;
	private PropertyFeatureInfo propertyFeatureInfo;
	private RequirementInfo requirementInfo;
	private RegistrationProcess registrationProcess;
	private transient HttpServletRequest request;
  private transient HttpServletResponse response;

	public String login () 
 {

		if (null != registrationInfo.getUserName() && null != registrationInfo.getPassword()) {
			try {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(
								registrationInfo.getUserName(), registrationInfo.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(
						authentication);
				if (authentication.isAuthenticated()) {
					PropUsersDao propUsersDao  = registrationProcess.getPropUserDaoExtnProcess().getPropUsersDaoExtnById(registrationInfo.getUserName());
					jsonMap.put("success", true);
					jsonMap.put("messages", "Welcome " + propUsersDao.getUserName() + "!!!!");
					jsonMap.put(VstarConstants.Authentication.AUTHORIZED_USER,true);
					jsonMap.put(VstarConstants.Authentication.USER_TYPE,propUsersDao.getUserType());
				}
				else
				{
				  jsonMap.put("Invalid user name or password !!", true);
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
		if (propertyFeatureInfo != null)
		{
			return VstarConstants.ActionResultTypes.PROPERTY;
		}
		if (requirementInfo != null)
		{
			return VstarConstants.ActionResultTypes.REQUIREMENT;
		}

		return SUCCESS;
	}
	
  /**
   * Log out
   */
  public void logout()
  {
    HttpSession session = request.getSession(false);
    if (session != null)
    {
      session.invalidate();
    }
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null)
    {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    SecurityContextHolder.getContext().setAuthentication(null);
  }
	
	public String welcome()
	{
	  return SUCCESS;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
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

	public RegistrationInfo getRegistrationInfo() {
		return registrationInfo;
	}

	public void setRegistrationInfo(RegistrationInfo registrationInfo) {
		this.registrationInfo = registrationInfo;
	}

	public UserProcess getUserProcess() {
		return userProcess;
	}

	public void setUserProcess(UserProcess userProcess) {
		this.userProcess = userProcess;
	}

	public PropertyFeatureInfo getPropertyFeatureInfo() {
		return propertyFeatureInfo;
	}

	public void setPropertyFeatureInfo(PropertyFeatureInfo propertyFeatureInfo) {
		this.propertyFeatureInfo = propertyFeatureInfo;
	}

	public RequirementInfo getRequirementInfo() {
		return requirementInfo;
	}

	public void setRequirementInfo(RequirementInfo requirementInfo) {
		this.requirementInfo = requirementInfo;
	}

	public RegistrationProcess getRegistrationProcess() {
		return registrationProcess;
	}

	public void setRegistrationProcess(RegistrationProcess registrationProcess) {
		this.registrationProcess = registrationProcess;
	}

  @Override
  public void setServletRequest(HttpServletRequest request)
  {
    this.request = request;
  }

  @Override
  public void setServletResponse(HttpServletResponse response)
  {
    this.response = response;
    
  }

}
