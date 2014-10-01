package com.vstar.common;


public class PropertyUtility
{
  public static String getTitle(String bedroom, String propertyType, String locationName) throws Exception
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
