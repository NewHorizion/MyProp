package com.vstar.process.property.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;
import com.vstar.dao.process.PropertiesConstants;
import com.vstar.process.masterData.model.ImageGalleryModel;
import com.vstar.process.masterData.model.PropertyDetailsModel;

public class PropertySearchProcessImpl implements PropertySearchProcess {

	private Properties mergedProperties;

	@Override
	public List<Map<String, String>> findProperty() {
		final String APPLICATION_CONTEXT_PATH = mergedProperties
				.getProperty(PropertiesConstants.APPLICATION_CONTEXR_PATH);
		final String OUTSIDE_WAR_IMAGES_PATH = mergedProperties
				.getProperty(PropertiesConstants.OUTSIDE_WAR_IMAGES_PATH);
		List<Map<String, String>> searchProperties = new ArrayList<Map<String, String>>();
		Map<String, String> property1 = new LinkedHashMap<String, String>();
		property1.put("propertyTitle",
				"2 BHK Multistorey Apartment in Rajarajeshwari Nagar");
		property1.put("projectName", "Lavkins Shelter");
		property1.put("developerName", "VS Shelters");
		property1.put("propPrice", "42.85 Lac(s) (Negotiable)");
		property1.put("rateSqft", "3,860/Sq-ft");
		property1.put("propertyImagePath",APPLICATION_CONTEXT_PATH
				+ OUTSIDE_WAR_IMAGES_PATH + "/thumb.jpg");
		searchProperties.add(property1);
		Map<String, String> property2 = new LinkedHashMap<String, String>();
		property2.put("propertyTitle",
				"2 BHK Multistorey Apartment in Banashankari Stage 3");
		property2.put("projectName", "Sapthagiri Nagar");
		property2.put("developerName", "Bhagini Developers");
		property2.put("propPrice", "42.0 Lac(s)");
		property2.put("rateSqft", "3,677");
		property2.put("propertyImagePath",APPLICATION_CONTEXT_PATH
				+ OUTSIDE_WAR_IMAGES_PATH + "/thumb.jpg");
		searchProperties.add(property2);
		searchProperties.add(property2);
		searchProperties.add(property2);
		searchProperties.add(property2);
		searchProperties.add(property2);
		searchProperties.add(property2);
		searchProperties.add(property2);
		searchProperties.add(property2);
		searchProperties.add(property2);
		return searchProperties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vstar.process.property.search.PropertySearchProcess#findLatestProperties
	 * ()
	 */
	@Override
	public String findLatestProperties() {
		final String APPLICATION_CONTEXT_PATH = mergedProperties
				.getProperty(PropertiesConstants.APPLICATION_CONTEXR_PATH);
		final String OUTSIDE_WAR_IMAGES_PATH = mergedProperties
				.getProperty(PropertiesConstants.OUTSIDE_WAR_IMAGES_PATH);
		Map<String, Object> mapRecentProperties = new LinkedHashMap<String, Object>();
		List<PropertyDetailsModel> latestProperties = new ArrayList<PropertyDetailsModel>();
		PropertyDetailsModel property1 = new PropertyDetailsModel();
		property1.setDeveloperName("VS Shelters");
		property1.setPerSqFtRate("3,860/Sq-ft");
		property1.setProjectName("Lavkins Shelter");
		property1
				.setPropertyDescription("Cherished dreams, blissful mornings, laughter and memories. Shades of bliss overwhelm your shines");
		property1.setPropertyThumbImagePath(APPLICATION_CONTEXT_PATH
				+ OUTSIDE_WAR_IMAGES_PATH + "/thumb.jpg");
		property1
				.setPropertyTitle("2 BHK Multistorey Apartment in Rajarajeshwari Nagar");
		property1.setPropertyPrice("42.85 Lac(s) (Negotiable)");
		latestProperties.add(property1);
		
		PropertyDetailsModel property2 = new PropertyDetailsModel();
		property2.setDeveloperName("Bhagini Developers");
		property2.setPerSqFtRate("3,677/Sq-ft");
		property2.setProjectName("Sapthagiri Nagar");
		property2
				.setPropertyDescription("Cherished dreams, blissful mornings, laughter and memories. Shades of bliss overwhelm your shines");
		property2.setPropertyThumbImagePath(APPLICATION_CONTEXT_PATH
				+ OUTSIDE_WAR_IMAGES_PATH + "/thumb2.gif");
		property2
				.setPropertyTitle("2 BHK Multistorey Apartment in Banashankari Stage 3");
		property2.setPropertyPrice("42.85 Lac(s) (Negotiable)");
		latestProperties.add(property2	);
		latestProperties.add(property2	);
		latestProperties.add(property2	);
		
		
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


}
