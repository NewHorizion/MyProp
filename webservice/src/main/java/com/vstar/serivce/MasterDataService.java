package com.vstar.serivce;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;


@WebService
public interface MasterDataService {
	@Transactional
	@GET
	@Produces("application/json")
	@Path("/location")
    public String getLocationMasterData ();
}
