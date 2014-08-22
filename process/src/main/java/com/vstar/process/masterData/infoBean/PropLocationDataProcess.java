package com.vstar.process.masterData.infoBean;

import java.util.List;

import com.vstar.exception.GenericProcessException;

public interface PropLocationDataProcess
{
  /**
   * Fetching all State Data
   * 
   * @return
   * @throws GenericProcessException
   */
  public List<PropStateInfo> getPropStateInfo() throws GenericProcessException;

  /**
   * Returning City Infos by StateId
   * 
   * @param stateId
   * @return
   * @throws GenericProcessException
   */
  public List<PropCityInfo> getPropStateCityInfo(long stateId) throws GenericProcessException;

  /**
   * Returning Location Infos by CityId
   * 
   * @param cityId
   * @return
   * @throws GenericProcessException
   */
  public List<PropLocationInfo> getPropCityLocationInfo(long cityId) throws GenericProcessException;
}
