package com.vstar.process.masterData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MasterDataProcessImpl implements MasterDataProcess {

	@Override
	public Map<String, Map<String, List<String>>> getLocationMasterData() {
		  Map<String, Map<String,List<String>>> countries = new LinkedHashMap<String, Map<String,List<String>>>();
	      
	      Map <String,List<String>> statesMap = new LinkedHashMap<String, List<String>>();
	      List<String> MaharashtraCities = new ArrayList<String>();
	      MaharashtraCities.add("Mumbai");
	      MaharashtraCities.add("Vidarbha");
	      MaharashtraCities.add("Pune");
	    
	      statesMap.put("Maharshtra",MaharashtraCities);
	      
	      Map <String,List<String>> UpstatesMap = new LinkedHashMap<String, List<String>>();
	      List<String> upCities = new ArrayList<String>();
	      upCities.add("Noida");
	      upCities.add("Luckhnow");
	      upCities.add("Kanpur");
	    
	      statesMap.put("Uttar Pradesh",upCities);
	      countries.put("India", statesMap);
	      return countries;
	}

}
