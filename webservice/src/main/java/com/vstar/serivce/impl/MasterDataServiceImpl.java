package com.vstar.serivce.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.vstar.process.masterData.MasterDataProcess;
import com.vstar.serivce.MasterDataService;

public class MasterDataServiceImpl implements MasterDataService {
	private MasterDataProcess masterDataProcess;

	@Transactional
	@GET
	@Produces("application/json")
	@Path("/location")
	public String getLocationMasterData() {
		Map<String, Map<String,List<String>>> locations = masterDataProcess.getLocationMasterData();
		Gson gson = new Gson();
		String json = "Countries:" + gson.toJson(locations);
		return json;
	}

	public MasterDataProcess getMasterDataProcess() {
		return masterDataProcess;
	}

	public void setMasterDataProcess(MasterDataProcess masterDataProcess) {
		this.masterDataProcess = masterDataProcess;
	}

}
