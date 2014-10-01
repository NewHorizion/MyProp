package com.vstar.serivce.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.vstar.process.property.search.PropertySearchProcess;
import com.vstar.process.propertyDetailInfo.RequirementInfo;
import com.vstar.serivce.PropertySearchService;

public class PropertySearchServiceImpl implements PropertySearchService {
	PropertySearchProcess propertySearchProcess;

	@Transactional
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/properties")
	public String findProperties(String propertyTypes) {
	  Gson gson = new Gson();
	  RequirementInfo info = gson.fromJson(propertyTypes, RequirementInfo.class);
		return propertySearchProcess
				.findProperty(info);
	}

	@Transactional
	@GET
	@Produces("application/json")
	@Path("/latest")
	public String getLatestProperties() {
		return propertySearchProcess.findLatestProperties();
	}
	
	@Override
	public String getPropertyImages(long propertyId) {
		return propertySearchProcess.findPropertyImages(propertyId);
	}

	@Override
	public String getRentedProperties() {
		return propertySearchProcess.findLatestProperties();
	}

	@Override
	public String getSellProperties() {
		return propertySearchProcess.findLatestProperties();
	}

	@Override
	public String getHotProperties() {
		return propertySearchProcess.findLatestProperties();
	}

	public PropertySearchProcess getPropertySearchProcess() {
		return propertySearchProcess;
	}

	public void setPropertySearchProcess(
			PropertySearchProcess propertySearchProcess) {
		this.propertySearchProcess = propertySearchProcess;
	}

}
