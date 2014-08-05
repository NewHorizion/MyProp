package com.vstar.process.jaxb.converters;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vstar.process.jaxb.Cities;
import com.vstar.process.jaxb.Countries;
import com.vstar.process.jaxb.MasterData;
import com.vstar.process.jaxb.States;

public class LocationDataConverter {
     /**
      * Populate location master data.
      * Country, State and Zip
     * @param masterData
     * @param countries
     */
    public static void convertLocationMasterData (MasterData masterData,Map<String, Map<String,List<String>>> countries  )
     {
    	 // Extract countries key from countries map.
    	 Set<String> countriesSet = countries.keySet(); 
    	 Set<String> stateSet = null;
    	 Countries jaxbCountry = null;
    	 States jaxbState = null;
    	 Map<String,List<String>> mapStates = null; 
    	 List<String> cities  = null;
    	 for (String country : countriesSet)
    	 {   
    		 jaxbCountry = new Countries(); 
    		 jaxbCountry.setCountryName(country);
    		 //Extract states from countries map using country as a key.
    		 mapStates = countries.get(country);
    		 stateSet = mapStates.keySet();
    		 for (String state : stateSet)
    		 {
    			 jaxbState = new States();
    			 jaxbState.setStateName(state);
    			 cities = mapStates.get(state);
    			 for (String city : cities)
    			 {
    				Cities jaxbCity = new Cities();
    				jaxbCity.setCityName(city);
    				jaxbState.getCities().add(jaxbCity);
    			 }
    			 jaxbCountry.getStates().add(jaxbState);
    		 }
    		 masterData.getCountries().add(jaxbCountry);
    	 }
    		
     }
     
}
