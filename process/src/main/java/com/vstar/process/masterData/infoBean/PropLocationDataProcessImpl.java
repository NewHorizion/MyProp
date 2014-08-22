package com.vstar.process.masterData.infoBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vstar.dao.PropCityDao;
import com.vstar.dao.PropLocationDao;
import com.vstar.dao.PropStateDao;
import com.vstar.dao.process.PropCityDaoProcess;
import com.vstar.dao.process.PropLocationDaoProcess;
import com.vstar.dao.process.PropStateDaoProcess;
import com.vstar.exception.GenericProcessException;

public class PropLocationDataProcessImpl implements PropLocationDataProcess
{
  private PropStateDaoProcess propStateDaoProcess;
  private PropCityDaoProcess propCityDaoProcess;
  private PropLocationDaoProcess propLocationDaoProcess;

  /**
   * Creating Country Map upto Location Details
   * 
   * @return
   */
  public Map<String, Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>>> getPropLocationData()
    throws GenericProcessException
  {
    Map<String, Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>>> countries = new LinkedHashMap<String, Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>>>();
    Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>> statesMap = new LinkedHashMap<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>>();
    Map<PropCityInfo, List<PropLocationInfo>> citiesMap = new LinkedHashMap<PropCityInfo, List<PropLocationInfo>>();

    List<PropLocationInfo> propLocationInfos = null;

    List<PropStateDao> propStateDaos = propStateDaoProcess.getAllPropStateDaos();
    List<PropCityDao> propCityDaos = null;
    List<PropLocationDao> propLocationDaos = null;

    PropStateInfo propStateInfo = null;
    PropCityInfo propCityInfo = null;
    PropLocationInfo propLocationInfo = null;

    for (PropStateDao propStateDao : propStateDaos)
    {
      propStateInfo = new PropStateInfo();
      propStateInfo.setStateId(propStateDao.getPropStateId());
      propStateInfo.setStateName(propStateDao.getStateName());

      propCityDaos = propCityDaoProcess.getAllPropCitiesByStateId(propStateDao.getPropStateId());
      for (PropCityDao propCityDao : propCityDaos)
      {
        propLocationInfos = new ArrayList<PropLocationInfo>();
        propCityInfo = new PropCityInfo();
        propCityInfo.setCityName(propCityDao.getCityName());
        propCityInfo.setCityId(propCityDao.getPropCityId());

        propLocationDaos = propLocationDaoProcess.getAllPropLocationsByCityId(propCityDao
          .getPropCityId());
        for (PropLocationDao propLocationDao : propLocationDaos)
        {
          propLocationInfo = new PropLocationInfo();
          propLocationInfo.setLocationId(propLocationDao.getPropLocationId());
          propLocationInfo.setLocationName(propLocationDao.getLocalityName());
          propLocationInfos.add(propLocationInfo);
        }
        citiesMap.put(propCityInfo, propLocationInfos);
      }
      statesMap.put(propStateInfo, citiesMap);
    }
    countries.put("India", statesMap);
    return countries;
  }

  /* (non-Javadoc)
   * @see com.vstar.process.masterData.infoBean.PropLocationDataProcess#getPropStateInfo()
   */
  public List<PropStateInfo> getPropStateInfo() throws GenericProcessException
  {
    List<PropStateInfo> propStateInfos = new ArrayList<PropStateInfo>();
    List<PropStateDao> propStateDaos = propStateDaoProcess.getAllPropStateDaos();
    PropStateInfo propStateInfo = null;
    for (PropStateDao propStateDao : propStateDaos)
    {
      propStateInfo = new PropStateInfo();
      propStateInfo.setStateName(propStateDao.getStateName());
      propStateInfo.setStateId(propStateDao.getPropStateId());
      propStateInfos.add(propStateInfo);
    }
    return propStateInfos;
  }

  /* (non-Javadoc)
   * @see com.vstar.process.masterData.infoBean.PropLocationDataProcess#getPropStateCityInfo(long)
   */
  public List<PropCityInfo> getPropStateCityInfo(long stateId) throws GenericProcessException
  {
    List<PropCityInfo> propCityInfos = new ArrayList<PropCityInfo>();
    List<PropCityDao> propCityDaos = propCityDaoProcess.getAllPropCitiesByStateId(stateId);
    PropCityInfo propCityInfo = null;
    for (PropCityDao propCityDao : propCityDaos)
    {
      propCityInfo = new PropCityInfo();
      propCityInfo.setCityId(propCityDao.getPropCityId());
      propCityInfo.setCityName(propCityDao.getCityName());
      propCityInfos.add(propCityInfo);
    }
    return propCityInfos;
  }

  
  /* (non-Javadoc)
   * @see com.vstar.process.masterData.infoBean.PropLocationDataProcess#getPropCityLocationInfo(long)
   */
  public List<PropLocationInfo> getPropCityLocationInfo(long cityId) throws GenericProcessException
  {
    List<PropLocationInfo> propLocationInfos = new ArrayList<PropLocationInfo>();
    List<PropLocationDao> propLocationDaos = propLocationDaoProcess
      .getAllPropLocationsByCityId(cityId);
    PropLocationInfo propLocationInfo = null;
    for (PropLocationDao propLocationDao : propLocationDaos)
    {
      propLocationInfo = new PropLocationInfo();
      propLocationInfo.setLocationId(propLocationDao.getPropLocationId());
      propLocationInfo.setLocationName(propLocationDao.getLocalityName());
      propLocationInfos.add(propLocationInfo);
    }
    return propLocationInfos;
  }

  public PropStateDaoProcess getPropStateDaoProcess()
  {
    return propStateDaoProcess;
  }

  public void setPropStateDaoProcess(PropStateDaoProcess propStateDaoProcess)
  {
    this.propStateDaoProcess = propStateDaoProcess;
  }

  public PropCityDaoProcess getPropCityDaoProcess()
  {
    return propCityDaoProcess;
  }

  public void setPropCityDaoProcess(PropCityDaoProcess propCityDaoProcess)
  {
    this.propCityDaoProcess = propCityDaoProcess;
  }

  public PropLocationDaoProcess getPropLocationDaoProcess()
  {
    return propLocationDaoProcess;
  }

  public void setPropLocationDaoProcess(PropLocationDaoProcess propLocationDaoProcess)
  {
    this.propLocationDaoProcess = propLocationDaoProcess;
  }
}
