package com.vstar.dao.process.propertyUpload;

import com.vstar.dao.PropAreaDao;
import com.vstar.dao.PropFeaturesDao;
import com.vstar.dao.PropInfoDao;
import com.vstar.dao.PropLocationInfoDao;
import com.vstar.dao.PropPriceDao;
import com.vstar.dao.PropTransactionDao;
import com.vstar.dao.process.PropAreaDaoProcess;
import com.vstar.dao.process.PropFeaturesDaoProcess;
import com.vstar.dao.process.PropInfoDaoProcess;
import com.vstar.dao.process.PropLocationInfoDaoProcess;
import com.vstar.dao.process.PropPriceDaoProcess;
import com.vstar.dao.process.PropTransactionDaoProcess;
import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;
import com.vstar.process.propertyDetailInfo.PropertyMandateInfo;
import com.vstar.process.propertyDetailInfo.ResidentialPropInfo;

/**
 * Process for saving property details
 *
 */
public class PropertyUploadProcess
{
  private PropAreaDaoProcess propAreaDaoProcess;
  private PropFeaturesDaoProcess propFeaturesDaoProcess;
  private PropInfoDaoProcess propInfoDaoProcess;
  private PropPriceDaoProcess propPriceDaoProcess;
  private PropTransactionDaoProcess propTransactionDaoProcess;
  private PropLocationInfoDaoProcess propLocationInfoDaoProcess;
  private PropInfoDao propInfoDao;
  
  /**
   * Save Property Details
   * @param propertyFeatureInfo
   * @return
   */
  public boolean savePropertyDetails(PropertyFeatureInfo propertyFeatureInfo)
  {
    propInfoDao = new PropInfoDao();
    savePropertyMandateInfos(propertyFeatureInfo.getPropertyMandateInfo());
    savePropertyFeatureInfo(propertyFeatureInfo.getResidentialPropInfo());
    // Saving Property Master table
    propInfoDao = propInfoDaoProcess.addUpdatePropInfoDao(propInfoDao);
    
    // Saving Property Location Info
    savePropertyLocationInfo(propertyFeatureInfo.getPropertyMandateInfo());
    return true;
  }
  
  /**
   * Saving Property Location Info
   * @param propertyMandateInfo
   */
  private void savePropertyLocationInfo(PropertyMandateInfo propertyMandateInfo)
  {
    PropLocationInfoDao propLocationInfoDao = new PropLocationInfoDao();
    propLocationInfoDao.setPropAddress(propertyMandateInfo.getAddress());
    if (propertyMandateInfo.getLocality() != null)
    {
      propLocationInfoDao.setPropLocationDao(Long.parseLong(propertyMandateInfo.getLocality()));
    }
    else
    {
      propLocationInfoDao.setPropCityDao(Integer.parseInt(propertyMandateInfo.getCity()));
      propLocationInfoDao.setPropLocationName(propertyMandateInfo.getLocality());
    }
    propLocationInfoDao.setPropInfoDao(propInfoDao);
    propLocationInfoDaoProcess.addUpdatePropAreaDao(propLocationInfoDao);
  }
  
  /**
   * Saving Residential Property Info
   * @param residentialPropInfo
   */
  public void savePropertyFeatureInfo(ResidentialPropInfo residentialPropInfo)
  {
    // Saving Property features
    PropFeaturesDao propFeaturesDao = new PropFeaturesDao();
    propFeaturesDao.setBedRooms(Integer.parseInt(residentialPropInfo.getNoOfBedRooms().getValue()));
    propFeaturesDao.setBathRooms(Integer.parseInt(residentialPropInfo.getNoOfBathRooms().getValue()));
    propFeaturesDao.setBalconies(Integer.parseInt(residentialPropInfo.getNoOfBalonies().getValue()));
    propFeaturesDao.setFurnished(residentialPropInfo.getFurnishedStatus().getValue());
    propFeaturesDao.setAvailFloor(Integer.parseInt(residentialPropInfo.getFloorNumber().getValue()));
    propFeaturesDao.setTotalFloors(Integer.parseInt(residentialPropInfo.getTotalFloor().getValue()));
    propFeaturesDao = propFeaturesDaoProcess.addUpdatePropFeaturesDao(propFeaturesDao);
    propInfoDao.setPropFeatures(propFeaturesDao);
    
    // Saving Property transactions
    PropTransactionDao propTransactionDao = new PropTransactionDao();
    propTransactionDao.setPossessionStatus(residentialPropInfo.getPossessionStatus());
    propTransactionDao = propTransactionDaoProcess.addUpdatePropTransactionDao(propTransactionDao);
    propInfoDao.setPropTransaction(propTransactionDao);
  }
  
  /**
   * Saving Property Mandatory Information
   * @param propertyMandateInfo
   */
  public void savePropertyMandateInfos(PropertyMandateInfo propertyMandateInfo)
  {
    // Setting Property Purchase type
    propInfoDao.setPropPurchaseType(propertyMandateInfo.getPurchaseType());
    // Setting Property Transaction type
    propInfoDao.setTransactionType(propertyMandateInfo.getTransactionType());
    // Setting Property Type Info
    propInfoDao.setPropType(propertyMandateInfo.getPropertyTypeId());
    // Saving Property Area Info
    PropAreaDao propAreaDao = new PropAreaDao();
    propAreaDao.setCoveredArea(propertyMandateInfo.getCoveredArea());
    propAreaDao.setCoveredAreaUnit(propertyMandateInfo.getCoveredAreaUnit().getValue());
    propAreaDao.setPlotArea(propertyMandateInfo.getPlotArea());
    propAreaDao.setPlotAreaUnit(propertyMandateInfo.getPlotAreaUnit().getValue());
    propAreaDao = propAreaDaoProcess.addUpdatePropAreaDao(propAreaDao);
    propInfoDao.setPropArea(propAreaDao);
    
    // Saving Property Price Info
    PropPriceDao propPriceDao = new PropPriceDao();
    propPriceDao.setExpectedPrice(propertyMandateInfo.getPropPrice());
    propPriceDao = propPriceDaoProcess.addUpdatePropPriceDao(propPriceDao);
    propInfoDao.setPropPrice(propPriceDao);
    
  }

  public PropAreaDaoProcess getPropAreaDaoProcess()
  {
    return propAreaDaoProcess;
  }

  public void setPropAreaDaoProcess(PropAreaDaoProcess propAreaDaoProcess)
  {
    this.propAreaDaoProcess = propAreaDaoProcess;
  }

  public PropFeaturesDaoProcess getPropFeaturesDaoProcess()
  {
    return propFeaturesDaoProcess;
  }

  public void setPropFeaturesDaoProcess(PropFeaturesDaoProcess propFeaturesDaoProcess)
  {
    this.propFeaturesDaoProcess = propFeaturesDaoProcess;
  }

  public PropInfoDaoProcess getPropInfoDaoProcess()
  {
    return propInfoDaoProcess;
  }

  public void setPropInfoDaoProcess(PropInfoDaoProcess propInfoDaoProcess)
  {
    this.propInfoDaoProcess = propInfoDaoProcess;
  }

  public PropPriceDaoProcess getPropPriceDaoProcess()
  {
    return propPriceDaoProcess;
  }

  public void setPropPriceDaoProcess(PropPriceDaoProcess propPriceDaoProcess)
  {
    this.propPriceDaoProcess = propPriceDaoProcess;
  }

  public PropTransactionDaoProcess getPropTransactionDaoProcess()
  {
    return propTransactionDaoProcess;
  }

  public void setPropTransactionDaoProcess(PropTransactionDaoProcess propTransactionDaoProcess)
  {
    this.propTransactionDaoProcess = propTransactionDaoProcess;
  }

  public PropLocationInfoDaoProcess getPropLocationInfoDaoProcess()
  {
    return propLocationInfoDaoProcess;
  }

  public void setPropLocationInfoDaoProcess(PropLocationInfoDaoProcess propLocationInfoDaoProcess)
  {
    this.propLocationInfoDaoProcess = propLocationInfoDaoProcess;
  }

}
