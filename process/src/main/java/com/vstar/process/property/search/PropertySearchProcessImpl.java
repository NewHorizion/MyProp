package com.vstar.process.property.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;
import com.vstar.common.StoredProcedureConstants;
import com.vstar.dao.PropInfoDao;
import com.vstar.dao.process.PropInfoDaoProcess;
import com.vstar.dao.process.PropertiesConstants;
import com.vstar.process.masterData.model.ImageGalleryModel;
import com.vstar.process.masterData.model.PropertyDetailsModel;
import com.vstar.process.propertyDetailInfo.RequirementInfo;

public class PropertySearchProcessImpl implements PropertySearchProcess {

	private Properties mergedProperties;
	private PropInfoDaoProcess propInfoDaoProcess;

	@Override
	public String findProperty(RequirementInfo requirementInfo) 
  {
    List<PropertyDetailsModel> searchProperties = null;
    StringBuffer whereClause = createWhereClause(requirementInfo);
    List<Object> customResults = propInfoDaoProcess.callingMainSearchSP(whereClause.toString());
    if (null != customResults && customResults.size() > 0)
    {
      searchProperties = ResultSetTransformProcess.transformMainSearch(customResults,
        mergedProperties);
    }
    Map<String, List<PropertyDetailsModel>> mapRecentProperties = new LinkedHashMap<String, List<PropertyDetailsModel>>();
    mapRecentProperties.put("searchProperties", searchProperties);
    Gson gson = new Gson();
    String json = gson.toJson(mapRecentProperties);
    return json;
  }

  /**
   * Creating whereClause with entered infos
   * 
   * @param requirementInfo
   * @return
   */
  private StringBuffer createWhereClause(RequirementInfo requirementInfo)
  {
    StringBuffer whereClause = new StringBuffer();

    whereClause.append(StoredProcedureConstants.MainSearchConstants.PROP_PURCHASE_PROP_PURCHASE_ID
      + requirementInfo.getPurchaseType());
    if (null != requirementInfo.getPropertyTypes() && requirementInfo.getPropertyTypes().length > 0)
    {
      whereClause.append(" and ");
      StringBuffer locationList = new StringBuffer();
      locationList.append(StoredProcedureConstants.MainSearchConstants.PROP_TYPE_PROP_TYPE_ID
        + " in (");
      int propTypelenght = requirementInfo.getPropertyTypes().length - 1;
      for (int i = 0; i <= propTypelenght; i++)
      {
        locationList.append(requirementInfo.getPropertyTypes()[i].getId());
        if (propTypelenght != i)
        {
          locationList.append(",");
        }
      }
      locationList.append(")");
      whereClause.append(locationList);
    }
    if (null != requirementInfo.getLocations() && requirementInfo.getLocations().length > 0)
    {
      whereClause.append(" and ");
      StringBuffer locationList = new StringBuffer();
      locationList.append(StoredProcedureConstants.MainSearchConstants.PROP_LOC_PROP_LOC_ID
        + " in (");
      int propLoclenght = requirementInfo.getLocations().length - 1;
      for (int i = 0; i <= propLoclenght; i++)
      {
        locationList.append(requirementInfo.getLocations()[i].getLocalityId());
        if (propLoclenght != i)
        {
          locationList.append(",");
        }
      }
      locationList.append(")");
      whereClause.append(locationList);
    }
    else
    {
      if (0 != requirementInfo.getCity())
      {
        whereClause.append(" and ");
        whereClause.append(StoredProcedureConstants.MainSearchConstants.PROP_CITY_PROP_CITY_ID
          + requirementInfo.getCity());
      }
    }
    if (null != requirementInfo.getMinBudget() && null != requirementInfo.getMaxBudget())
    {
      whereClause.append(" and ");
      whereClause.append(StoredProcedureConstants.MainSearchConstants.PROP_PRICE_EXPECTED_PRICE);
      whereClause.append(" between ");
      whereClause.append(requirementInfo.getMinBudget().getId());
      whereClause.append(" and ");
      whereClause.append(requirementInfo.getMaxBudget().getId());
    }
    if (null != requirementInfo.getMinBedrooms() && null != requirementInfo.getMaxBedrooms())
    {
      whereClause.append(" and ");
      whereClause.append(StoredProcedureConstants.MainSearchConstants.FEATURE_BED_ROOMS);
      whereClause.append(" between ");
      whereClause.append(requirementInfo.getMinBedrooms().getLabel());
      whereClause.append(" and ");
      whereClause.append(requirementInfo.getMaxBedrooms().getLabel());
    }
    return whereClause;
  }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vstar.process.property.search.PropertySearchProcess#findLatestProperties
	 * ()
	 */
	@Override
  public String findLatestProperties()
  {
    final String APPLICATION_CONTEXT_PATH = mergedProperties
      .getProperty(PropertiesConstants.APPLICATION_CONTEXR_PATH);
    final String OUTSIDE_WAR_IMAGES_PATH = mergedProperties
      .getProperty(PropertiesConstants.OUTSIDE_WAR_IMAGES_PATH);
    Map<String, Object> mapRecentProperties = new LinkedHashMap<String, Object>();
    List<PropertyDetailsModel> latestProperties = new ArrayList<PropertyDetailsModel>();
    ;
    List<PropInfoDao> propInfoDaos = propInfoDaoProcess.getAllPropInfoDaos();
    PropertyDetailsModel propertyDetailsModel = null;
    for (PropInfoDao propInfoDao : propInfoDaos)
    {
      propertyDetailsModel = new PropertyDetailsModel();
      try
      {
        /*propertyDetailsModel
          .setPropertyTitle(PropertyUtility.getTitle(propInfoDao.getPropFeatures().getBedRooms(),
            propInfoDao.getPropType(), propInfoDao.getPropInfoId()));*/
        propertyDetailsModel.setProjectName(propInfoDao.getPropTransaction().getTransactionType());
        propertyDetailsModel.setPropertyPrice(String.valueOf(propInfoDao.getPropPrice()
          .getExpectedPrice()));
        propertyDetailsModel.setPerSqFtRate(String.valueOf(propInfoDao.getPropPrice()
          .getExpectedPrice()));
        propertyDetailsModel.setPropertyImagePath(APPLICATION_CONTEXT_PATH
          + OUTSIDE_WAR_IMAGES_PATH + "/thumb.jpg");
        latestProperties.add(propertyDetailsModel);
      }
      catch (Exception e)
      {
        // Log the exception
      }
    }

    mapRecentProperties.put("latestProperties", latestProperties);
    Gson gson = new Gson();
    String json = gson.toJson(mapRecentProperties);
    return json;
  }
	

	@Override
	public String findPropertyImages(Long id) {
		Map<String, Object> mapRecentProperties = new LinkedHashMap<String, Object>();
		final String APPLICATION_CONTEXT_PATH = mergedProperties
				.getProperty(PropertiesConstants.APPLICATION_CONTEXR_PATH);
		final String OUTSIDE_WAR_IMAGES_PATH = mergedProperties
				.getProperty(PropertiesConstants.OUTSIDE_WAR_IMAGES_PATH);
		List<ImageGalleryModel> images = new ArrayList<ImageGalleryModel>();
		ImageGalleryModel image1  = new ImageGalleryModel();
		image1.setImageId(1);
		image1.setTitle("First");
		image1.setSummary("summary1");
		image1.setPath(APPLICATION_CONTEXT_PATH
				+ OUTSIDE_WAR_IMAGES_PATH + "/1.jpg");
		images.add(image1);
		ImageGalleryModel image2  = new ImageGalleryModel(); 
		image2.setImageId(2);
		image2.setTitle("Second");
		image2.setSummary("summary2");
		image2.setPath(APPLICATION_CONTEXT_PATH
				+ OUTSIDE_WAR_IMAGES_PATH + "/3.jpg");
		images.add(image2);
		ImageGalleryModel image3  = new ImageGalleryModel(); 
		image3.setImageId(1);
		image3.setTitle("third");
		image3.setSummary("summary3");
		image3.setPath(APPLICATION_CONTEXT_PATH
				+ OUTSIDE_WAR_IMAGES_PATH + "/2.jpg");
		images.add(image3);
		mapRecentProperties.put("images", images);
		Gson gson = new Gson();
		String json  = gson.toJson(mapRecentProperties);
		return json;
		
	}

	/**
	 * @return
	 */
	public Properties getMergedProperties() {
		return mergedProperties;
	}

	/**
	 * @param mergedProperties
	 */
	public void setMergedProperties(Properties mergedProperties) {
		this.mergedProperties = mergedProperties;
	}

	public PropInfoDaoProcess getPropInfoDaoProcess() {
		return propInfoDaoProcess;
	}

	public void setPropInfoDaoProcess(PropInfoDaoProcess propInfoDaoProcess) {
		this.propInfoDaoProcess = propInfoDaoProcess;
	}


}
