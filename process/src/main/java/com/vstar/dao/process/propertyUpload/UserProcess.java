package com.vstar.dao.process.propertyUpload;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserProcess 
{
	/**
	 * Finding logged-in userDetails
	 * 
	 * @return
	 */
	public UserDetails findLoggedInUserId()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		HttpSession session=ServletActionContext.getRequest().getSession(true);
		Object test = session.getAttribute("SPRING_SECURITY_CONTEXT");
		UserDetails userDetails = null;
	    if (authentication != null)
	    {
	      if (authentication.isAuthenticated())
	      {
	    	  Object object = authentication.getPrincipal();
	    	  if (object instanceof UserDetails)
	    	  {
	    		  userDetails = (UserDetails)object;
	    	  }
	      }
	    }
	    return userDetails;
	}
}
