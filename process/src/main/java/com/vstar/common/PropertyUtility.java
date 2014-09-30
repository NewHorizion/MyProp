package com.vstar.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vstar.process.masterData.MasterDataProcessImpl;
import com.vstar.process.masterData.infoBean.PropCityInfo;
import com.vstar.process.masterData.infoBean.PropLocationInfo;
import com.vstar.process.masterData.infoBean.PropStateInfo;

public class PropertyUtility
{
  public static String getTitle(Integer bedroom, String propertyType, String locationName) throws Exception
  {
    StringBuffer title = new StringBuffer();
    if (null != bedroom)
    {
      title.append(bedroom + " BHK ");
    }
    title.append(propertyType);
    title.append(" in " + locationName);
    return title.toString();
    /*Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>> stateMap = MasterDataProcessImpl.countries
      .get("India");
    Set<PropStateInfo> propStateInfos = stateMap.keySet();
    Map<PropCityInfo, List<PropLocationInfo>> cityMap = null;
    Set<PropCityInfo> propCityInfos = null;
    List<PropLocationInfo> locationInfos = null;
    PropLocationInfo locationInfo = new PropLocationInfo();
    locationInfo.setLocationId(locationId);
    PropLocationInfo propLocationInfo = null;
    for (PropStateInfo propStateInfo : propStateInfos)
    {
      cityMap = stateMap.get(propStateInfo);
      propCityInfos = cityMap.keySet();
      for (PropCityInfo propCityInfo : propCityInfos)
      {
        locationInfos = cityMap.get(propCityInfo);
        if (!locationInfos.contains(locationInfo))
        {
          continue;
        }
        propLocationInfo = locationInfos.get(locationInfos.indexOf(locationInfo));
        if (propLocationInfo != null)
          break;
      }
    }*/
  }
}
