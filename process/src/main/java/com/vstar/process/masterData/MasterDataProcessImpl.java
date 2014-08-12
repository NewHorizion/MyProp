package com.vstar.process.masterData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.vstar.common.JAXBUtility;
import com.vstar.common.PropertyTypeEnum;
import com.vstar.dao.process.PropertiesConstants;
import com.vstar.process.jaxb.MasterData;
import com.vstar.process.jaxb.converters.MasterDataConverter;

public class MasterDataProcessImpl implements MasterDataProcess {
	private Properties mergedProperties;
	private final String JAXB_MASTER_DATA_PACKAGE = "com.vstar.process.jaxb";

	@Override
	public Map<String, Map<String, List<String>>> getLocationMasterData() {
		Map<String, Map<String, List<String>>> countries = new LinkedHashMap<String, Map<String, List<String>>>();

		Map<String, List<String>> statesMap = new LinkedHashMap<String, List<String>>();
		List<String> MaharashtraCities = new ArrayList<String>();
		MaharashtraCities.add("Mumbai");
		MaharashtraCities.add("Vidarbha");
		MaharashtraCities.add("Pune");

		statesMap.put("Maharshtra", MaharashtraCities);
		Map<String, List<String>> UpstatesMap = new LinkedHashMap<String, List<String>>();
		List<String> upCities = new ArrayList<String>();
		upCities.add("Noida");
		upCities.add("Luckhnow");
		upCities.add("Kanpur");

		statesMap.put("Uttar Pradesh", upCities);
		countries.put("India", statesMap);
		return countries;
	}

	@Override
	public Map<Integer, String> getPropertyTypes() {
		Map<Integer, String> propertyTypes = new LinkedHashMap<Integer, String>();
		for (PropertyTypeEnum propertyType : PropertyTypeEnum.values()) {
			propertyTypes.put(propertyType.getId(), propertyType.getName());
		}
		return propertyTypes;
	}

	/**
	 * @return
	 */
	public String readMasterData()
	{
		MasterData jaxbMasterData =  (MasterData) JAXBUtility.getUnmarshalledOnbject(mergedProperties
				.getProperty(PropertiesConstants.MASTER_DATA_FILE_LOCATION),
				JAXB_MASTER_DATA_PACKAGE);
		String json = MasterDataConverter.converJaxbMasterDataToJSON(jaxbMasterData);
		return json;
	}

	public Properties getMergedProperties() {
		return mergedProperties;
	}

	public void setMergedProperties(Properties mergedProperties) {
		this.mergedProperties = mergedProperties;
	}

}
