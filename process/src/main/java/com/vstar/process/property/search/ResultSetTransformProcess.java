package com.vstar.process.property.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.vstar.common.PropertyUtility;
import com.vstar.dao.process.PropertiesConstants;
import com.vstar.process.masterData.model.PropertyDetailsModel;

public class ResultSetTransformProcess
{
  public static List<PropertyDetailsModel> transformMainSearch(List<Object> customResults, Properties mergedProperties)
  {
    final String APPLICATION_CONTEXT_PATH = mergedProperties
      .getProperty(PropertiesConstants.APPLICATION_CONTEXR_PATH);
    final String OUTSIDE_WAR_IMAGES_PATH = mergedProperties
      .getProperty(PropertiesConstants.OUTSIDE_WAR_IMAGES_PATH);
    List<PropertyDetailsModel> propertyDetailModels = new ArrayList<PropertyDetailsModel>();
    PropertyDetailsModel propertyDetailsModel = null;
    Object[] resultRow = null;
    for (int i = 0; i < customResults.size(); i++)
    {
      resultRow = (Object[]) customResults.get(i);
      propertyDetailsModel = new PropertyDetailsModel();
      try
      {
        propertyDetailsModel.setPropertyTitle(PropertyUtility.getTitle((String.valueOf(resultRow[0])),
          (String) resultRow[1], (String) resultRow[2]));
        propertyDetailsModel.setProjectName((String) resultRow[3]);
        propertyDetailsModel.setPropertyPrice(String.valueOf(resultRow[4]));
        propertyDetailsModel.setPerSqFtRate(String.valueOf(resultRow[5]));
        propertyDetailsModel.setCoveredArea(String.valueOf(resultRow[6]));
        propertyDetailsModel.setPlotArea(String.valueOf(resultRow[7]));
        propertyDetailsModel.setPropertyImagePath(APPLICATION_CONTEXT_PATH
          + OUTSIDE_WAR_IMAGES_PATH + "/"+ resultRow[9]);
        propertyDetailModels.add(propertyDetailsModel);
      }
      catch (Exception e)
      {
    	  System.out.println("SdsDsdsd");
        // Log the exception
      }
    }
    return propertyDetailModels;
  }
  
}
