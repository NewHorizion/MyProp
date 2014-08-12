package com.vstar.process.jaxb.converters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.vstar.process.jaxb.Cities;
import com.vstar.process.jaxb.Countries;
import com.vstar.process.jaxb.MasterData;
import com.vstar.process.jaxb.PropertyType;
import com.vstar.process.jaxb.States;
import com.vstar.process.masterData.model.LocationModel;
import com.vstar.process.masterData.model.PropertyTypeModel;

public class MasterDataConverter {
	/**
	 * Populate location master data. Country, State and Zip
	 * 
	 * @param masterData
	 * @param countries
	 */
	public static void convertLocationMasterData(MasterData masterData,
			Map<String, Map<String, List<String>>> countries) {
		// Extract countries key from countries map.
		Set<String> countriesSet = countries.keySet();
		Set<String> stateSet = null;
		Countries jaxbCountry = null;
		States jaxbState = null;
		Map<String, List<String>> mapStates = null;
		List<String> cities = null;
		for (String country : countriesSet) {
			jaxbCountry = new Countries();
			jaxbCountry.setCountryName(country);
			// Extract states from countries map using country as a key.
			mapStates = countries.get(country);
			stateSet = mapStates.keySet();
			for (String state : stateSet) {
				jaxbState = new States();
				jaxbState.setStateName(state);
				cities = mapStates.get(state);
				for (String city : cities) {
					Cities jaxbCity = new Cities();
					jaxbCity.setCityName(city);
					jaxbState.getCities().add(jaxbCity);
				}
				jaxbCountry.getStates().add(jaxbState);
			}
			masterData.getCountries().add(jaxbCountry);
		}

	}

	/**
	 * @param masterData
	 * @param propertyTypes
	 */
	public static void convertPropertyTypesMasterData(MasterData masterData,
			Map<Integer, String> propertyTypes) {
		// Extract countries key from countries map.
		Set<Integer> propertyTypeSet = propertyTypes.keySet();
		PropertyType jaxbPropertyType = null;
		for (Integer propertyTypeId : propertyTypeSet) {
			jaxbPropertyType = new PropertyType();
			jaxbPropertyType.setId(propertyTypeId);
			jaxbPropertyType.setType(propertyTypes.get(propertyTypeId));
			masterData.getPropertTypes().add(jaxbPropertyType);
		}

	}

	/**
	 * @param jaxbMasterData
	 */
	public static String converJaxbMasterDataToJSON(MasterData jaxbMasterData) {
		Map<String, Object> masterDataMap = new LinkedHashMap<String, Object>();
		if (null != jaxbMasterData) {
			List<PropertyType> jaxbPropertyTypes = jaxbMasterData
					.getPropertTypes();
			if (null != jaxbPropertyTypes && !jaxbPropertyTypes.isEmpty()) {
				List <PropertyTypeModel> propertyTypes = new ArrayList<PropertyTypeModel>(); 
				for (PropertyType jaxbPropertyType : jaxbPropertyTypes) {
					PropertyTypeModel propertyTypeModel = new PropertyTypeModel();
					propertyTypeModel.setId(jaxbPropertyType.getId());
					propertyTypeModel.setName(jaxbPropertyType.getType());
					propertyTypes.add(propertyTypeModel);
				}
				masterDataMap.put("propertyTypes", propertyTypes);
			}

			List<Countries> jaxbCountries = jaxbMasterData.getCountries();
			if (null != jaxbCountries && !jaxbCountries.isEmpty()) {
				for (Countries country : jaxbCountries) {
					List<States> jaxbStates = country.getStates();
					if (null != jaxbStates) {
						List<LocationModel> locations = new ArrayList<LocationModel>();
						for (States jaxbState : jaxbStates) {
							if (null != jaxbState.getCities()
									&& !jaxbState.getCities().isEmpty()) {
								for (Cities jaxbCity : jaxbState.getCities()) {
									LocationModel location = new LocationModel();
									location.setCityName(jaxbCity.getCityName());
									location.setStateName(jaxbState
											.getStateName());
									locations.add(location);
								}
							}
						}
						masterDataMap.put("locations", locations);
					}
				}
			}
			Gson gson = new Gson();
			String json = gson.toJson(masterDataMap);
			return json;
		}
		return null;
	}

}
