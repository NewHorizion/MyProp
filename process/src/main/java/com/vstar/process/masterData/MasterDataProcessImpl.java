package com.vstar.process.masterData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.vstar.common.JAXBUtility;
import com.vstar.common.PropertyTypeEnum;
import com.vstar.dao.process.PropertiesConstants;
import com.vstar.process.jaxb.MasterData;
import com.vstar.process.jaxb.converters.MasterDataConverter;
import com.vstar.process.masterData.infoBean.PropCityInfo;
import com.vstar.process.masterData.infoBean.PropLocationDataProcessImpl;
import com.vstar.process.masterData.infoBean.PropLocationInfo;
import com.vstar.process.masterData.infoBean.PropStateInfo;

public class MasterDataProcessImpl implements MasterDataProcess {
	private Properties mergedProperties;
	private final String JAXB_MASTER_DATA_PACKAGE = "com.vstar.process.jaxb";
	private PropLocationDataProcessImpl propLocationDataProcessImpl;

	@Override
	public Map<String, Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>>> getLocationMasterData() {
	  Map<String, Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>>> countries = null;

		/*Map<String, List<String>> statesMap = new LinkedHashMap<String, List<String>>();
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
		countries.put("India", statesMap);*/
		countries = propLocationDataProcessImpl.getPropLocationData();
		return countries;
	}

	@Override
	public Map<Integer, PropertyTypeEnum> getPropertyTypes() {
		Map<Integer, PropertyTypeEnum> propertyTypes = new LinkedHashMap<Integer, PropertyTypeEnum>();
		for (PropertyTypeEnum propertyType : PropertyTypeEnum.values()) {
			propertyTypes.put(propertyType.getId(), propertyType);
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

  public PropLocationDataProcessImpl getPropLocationDataProcessImpl()
  {
    return propLocationDataProcessImpl;
  }

  public void setPropLocationDataProcessImpl(PropLocationDataProcessImpl propLocationDataProcessImpl)
  {
    this.propLocationDataProcessImpl = propLocationDataProcessImpl;
  }

}
