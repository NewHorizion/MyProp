package com.vstar.process.property.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;
import com.vstar.dao.PropInfoDao;
import com.vstar.dao.process.PropInfoDaoProcess;
import com.vstar.dao.process.PropertiesConstants;
import com.vstar.process.masterData.model.ImageGalleryModel;
import com.vstar.process.masterData.model.PropertyDetailsModel;

public class PropertySearchProcessImpl implements PropertySearchProcess {

	private Properties mergedProperties;
	private PropInfoDaoProcess propInfoDaoProcess;

	@Override
	public String findProperty() 
	{
		List<PropertyDetailsModel> searchProperties = null;
		
		String whereClause = "prop_price.expected_price between 800000 and 1000000";
		List<Object> customResults = propInfoDaoProcess.callingMainSearchSP(whereClause);
    if (null != customResults && customResults.size() > 0)
    {
      searchProperties = ResultSetTransformProcess.transformMainSearch(customResults, mergedProperties);
    }
		Map<String, List<PropertyDetailsModel>> mapRecentProperties = new LinkedHashMap<String, List<PropertyDetailsModel>>();
		mapRecentProperties.put("searchProperties", searchProperties);
    Gson gson = new Gson();
    String json = gson.toJson(mapRecentProperties);
		return json;
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
	public String findPropertyImages(long id) {
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
