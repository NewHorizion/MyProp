package com.vstar.serivce;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

public interface PropertySearchService {
	@Transactional
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/search")
    public String getLocationMasterData ();
}
