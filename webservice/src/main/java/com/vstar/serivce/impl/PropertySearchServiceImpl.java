package com.vstar.serivce.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.vstar.process.property.search.PropertySearchProcess;
import com.vstar.serivce.PropertySearchService;

public class PropertySearchServiceImpl implements PropertySearchService {
	PropertySearchProcess propertySearchProcess;

	@Transactional
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/properties")
	public String getLocationMasterData() {
		List<Map<String,String>> searchProperties = propertySearchProcess.findProperty();
		Gson gson = new Gson();
		String json = gson.toJson(searchProperties);
		return json;
	}

	public PropertySearchProcess getPropertySearchProcess() {
		return propertySearchProcess;
	}

	public void setPropertySearchProcess(
			PropertySearchProcess propertySearchProcess) {
		this.propertySearchProcess = propertySearchProcess;
	}

}
