package com.vstar.serivce;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

public interface UserService { 
	@Transactional
	@GET
	@Produces("application/json")
	@Path("/profile")
    public String findUserProfileInfo ();
	
}
