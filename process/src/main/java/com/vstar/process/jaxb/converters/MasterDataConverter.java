package com.vstar.process.jaxb.converters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.vstar.common.BudgetEnum;
import com.vstar.common.PropertyCategoryEnum;
import com.vstar.common.PropertyTypeEnum;
import com.vstar.common.VstarConstants;
import com.vstar.process.jaxb.Cities;
import com.vstar.process.jaxb.Countries;
import com.vstar.process.jaxb.Localities;
import com.vstar.process.jaxb.MasterData;
import com.vstar.process.jaxb.PropertyType;
import com.vstar.process.jaxb.RentBudget;
import com.vstar.process.jaxb.SaleBudget;
import com.vstar.process.jaxb.States;
import com.vstar.process.masterData.infoBean.PropCityInfo;
import com.vstar.process.masterData.infoBean.PropLocationInfo;
import com.vstar.process.masterData.infoBean.PropStateInfo;
import com.vstar.process.masterData.model.BudgetModel;
import com.vstar.process.masterData.model.LocalityModel;
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
	  Map<String, Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>>> countries) {
		// Extract countries key from countries map.
		Set<String> countriesSet = countries.keySet();
		Set<PropStateInfo> stateSet = null;
		Set<PropCityInfo> citySet = null;
		  
		Countries jaxbCountry = null;
		States jaxbState = null;
		Cities jaxbCity = null;
		Localities jaxbLocalities = null;
		
		Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>> mapStates = null;
		Map<PropCityInfo, List<PropLocationInfo>> cities = null;
		List<PropLocationInfo> propLocationInfos = null; 
		
		for (String country : countriesSet) {
			jaxbCountry = new Countries();
			jaxbCountry.setCountryName(country);
			// Extract states from countries map using country as a key.
			mapStates = countries.get(country);
			stateSet = mapStates.keySet();
			for (PropStateInfo state : stateSet) {
				jaxbState = new States();
				jaxbState.setStateName(state.getStateName());
				jaxbState.setStateId(state.getStateId());
				
				cities = mapStates.get(state);
				citySet = cities.keySet();
				for (PropCityInfo city : citySet) {
					jaxbCity = new Cities();
					jaxbCity.setCityName(city.getCityName());
					jaxbCity.setCityId(city.getCityId());
					
					propLocationInfos = cities.get(city);
					for (PropLocationInfo propLocationInfo : propLocationInfos)
					{
					  jaxbLocalities = new Localities();
					  jaxbLocalities.setLocId(propLocationInfo.getLocationId());
					  jaxbLocalities.setLocName(propLocationInfo.getLocationName());
					  jaxbCity.getLocalities().add(jaxbLocalities);
					}
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
			Map<Integer, PropertyTypeEnum> propertyTypes) {
		// Extract countries key from countries map.
		Set<Integer> propertyTypeSet = propertyTypes.keySet();
		PropertyType jaxbPropertyType = null;
		PropertyTypeEnum propertyTypeEnum = null;
		for (Integer propertyTypeId : propertyTypeSet) {
			jaxbPropertyType = new PropertyType();
			propertyTypeEnum = propertyTypes.get(propertyTypeId);
			jaxbPropertyType.setId(propertyTypeEnum.getId());
			jaxbPropertyType.setType(propertyTypeEnum.getName());
			jaxbPropertyType.setCategoryName(propertyTypeEnum.getPropertyCategoryEnum().getName());
			masterData.getPropertTypes().add(jaxbPropertyType);
		}

	}
	
	/**
   * @param masterData
   * @param rentBudgets
   */
  public static void convertRentBudgetMasterData(MasterData masterData,
      Map<Integer, BudgetEnum> rentBudgets) {
    Set<Integer> rentBudgetSet = rentBudgets.keySet();
    RentBudget jaxbRentBudget = null;
    BudgetEnum rentBudgetEnum = null;
    for (Integer rentBudgetId : rentBudgetSet) {
      jaxbRentBudget = new RentBudget();
      rentBudgetEnum = rentBudgets.get(rentBudgetId);
      jaxbRentBudget.setId(rentBudgetEnum.getId());
      jaxbRentBudget.setType(rentBudgetEnum.getName());
      masterData.getRentBudgets().add(jaxbRentBudget);
    }
  }
  
  /**
   * @param masterData
   * @param saleBudgets
   */
  public static void convertSaleBudgetMasterData(MasterData masterData,
    Map<Integer, BudgetEnum> saleBudgets) {
  Set<Integer> saleBudgetSet = saleBudgets.keySet();
  SaleBudget jaxbSaleBudget = null;
  BudgetEnum saleBudgetEnum = null;
  for (Integer saleBudgetId : saleBudgetSet) {
    jaxbSaleBudget = new SaleBudget();
    saleBudgetEnum = saleBudgets.get(saleBudgetId);
    jaxbSaleBudget.setId(saleBudgetEnum.getId());
    jaxbSaleBudget.setType(saleBudgetEnum.getName());
    masterData.getSaleBudgets().add(jaxbSaleBudget);
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
					propertyTypeModel.setLabel(jaxbPropertyType.getType());
					propertyTypeModel.setCategoryName(jaxbPropertyType.getCategoryName());
					propertyTypeModel.setTicket(false);
					propertyTypes.add(propertyTypeModel);
				}
				masterDataMap.put("propertyTypes", propertyTypes);
			}
			
			List<RentBudget> jaxbRentBudgets = jaxbMasterData
        .getRentBudgets();
      if (null != jaxbRentBudgets && !jaxbRentBudgets.isEmpty())
      {
        List<BudgetModel> rentBudgets = new ArrayList<BudgetModel>();
        BudgetModel rentBudgetModel = null;
        for (RentBudget jaxbRentBudget : jaxbRentBudgets)
        {
          rentBudgetModel = new BudgetModel();
          rentBudgetModel.setId(jaxbRentBudget.getId());
          rentBudgetModel.setValue(jaxbRentBudget.getType());
          rentBudgetModel.setLabel(jaxbRentBudget.getType());
          rentBudgetModel.setDisabled(false);
          rentBudgetModel.setTicked(false);
          rentBudgetModel.setBudgetType(VstarConstants.PurchaseType.RENT);
          rentBudgets.add(rentBudgetModel);
        }
        masterDataMap.put("rentBudgets", rentBudgets);
      }
      
      List<SaleBudget> jaxbSaleBudgets = jaxbMasterData
        .getSaleBudgets();
      if (null != jaxbSaleBudgets && !jaxbSaleBudgets.isEmpty())
      {
        List<BudgetModel> saleBudgets = new ArrayList<BudgetModel>();
        BudgetModel saleBudgetModel = null;
        for (SaleBudget jaxbSaleBudget : jaxbSaleBudgets)
        {
          saleBudgetModel = new BudgetModel();
          saleBudgetModel.setId(jaxbSaleBudget.getId());
          saleBudgetModel.setValue(jaxbSaleBudget.getType());
          saleBudgetModel.setLabel(jaxbSaleBudget.getType());
          saleBudgetModel.setTicked(false);
          saleBudgetModel.setBudgetType(VstarConstants.PurchaseType.SALE);
          saleBudgets.add(saleBudgetModel);
        }
        masterDataMap.put("saleBudgets", saleBudgets);
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
									location.setCityId(jaxbCity.getCityId());
									if (null!=jaxbCity.getLocalities() && jaxbCity.getLocalities().size()>0)
									{
										List<LocalityModel> localities  = new ArrayList<LocalityModel>();
										for (Localities jaxbLocality:jaxbCity.getLocalities())
										{
											LocalityModel localityModel = new LocalityModel();
											localityModel.setCityName(jaxbCity.getCityName());
											localityModel.setLocalityId(jaxbLocality.getLocId());
											localityModel.setLabel(jaxbLocality.getLocName());
											localities.add(localityModel);
										}
										location.setLocalities(localities);
									}
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
