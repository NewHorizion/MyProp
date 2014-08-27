package com.sample.ui.VstarProperty;

import java.util.LinkedHashMap;
import java.util.Map;

import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;

public class UploadPropertyAction
{
  private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
  private PropertyFeatureInfo propertyFeatureInfo;
  
  
  
  public Map<String, Object> getJsonMap()
  {
    return jsonMap;
  }
  public void setJsonMap(Map<String, Object> jsonMap)
  {
    this.jsonMap = jsonMap;
  }
  public PropertyFeatureInfo getPropertyFeatureInfo()
  {
    return propertyFeatureInfo;
  }
  public void setPropertyFeatureInfo(PropertyFeatureInfo propertyFeatureInfo)
  {
    this.propertyFeatureInfo = propertyFeatureInfo;
  }
}
