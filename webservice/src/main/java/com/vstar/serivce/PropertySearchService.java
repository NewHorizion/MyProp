package com.vstar.serivce;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.transaction.annotation.Transactional;

import com.vstar.process.propertyDetailInfo.RequirementInfo;

public interface PropertySearchService {
	final String PROPERTY_ID ="propertyId"; 
	@Transactional
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/search")
    public String findProperties (String info);
	
	@Transactional
	@GET
	@Produces("application/json")
	@Path("/latest")
    public String getLatestProperties ();
	
	@Transactional
	@GET
	@Produces("application/json")
	@Path("/Rent")
    public String getRentedProperties ();
	
	@Transactional
	@GET
	@Produces("application/json")
	@Path("/Buy")
    public String getSellProperties ();
	
	@Transactional
	@GET
	@Produces("application/json")
	@Path("/Hot")
    public String getHotProperties ();
	
	@Transactional
	@GET
	@Produces("application/json")
	@Path("/listImages")
	public String getPropertyImages (@QueryParam("id") long propertyId);
	
	
}
