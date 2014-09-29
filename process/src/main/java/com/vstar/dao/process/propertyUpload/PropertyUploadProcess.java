package com.vstar.dao.process.propertyUpload;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;

import com.vstar.dao.PropAreaDao;
import com.vstar.dao.PropFeaturesDao;
import com.vstar.dao.PropInfoDao;
import com.vstar.dao.PropLocationInfoDao;
import com.vstar.dao.PropOwnerDao;
import com.vstar.dao.PropPriceDao;
import com.vstar.dao.PropRequirementDao;
import com.vstar.dao.PropTermsCondDao;
import com.vstar.dao.PropTransactionDao;
import com.vstar.dao.ReqPropTypeDao;
import com.vstar.dao.RequirementOwnerDao;
import com.vstar.dao.process.PropAreaDaoProcess;
import com.vstar.dao.process.PropFeaturesDaoProcess;
import com.vstar.dao.process.PropInfoDaoProcess;
import com.vstar.dao.process.PropLocationInfoDaoProcess;
import com.vstar.dao.process.PropOwnerDaoProcess;
import com.vstar.dao.process.PropPriceDaoProcess;
import com.vstar.dao.process.PropRequirementDaoProcess;
import com.vstar.dao.process.PropTermsCondDaoProcess;
import com.vstar.dao.process.PropTransactionDaoProcess;
import com.vstar.dao.process.ReqPropTypeDaoProcess;
import com.vstar.dao.process.RequirementOwnerDaoProcess;
import com.vstar.exception.GenericProcessException;
import com.vstar.process.masterData.model.LocalityModel;
import com.vstar.process.masterData.model.PropertyTypeModel;
import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;
import com.vstar.process.propertyDetailInfo.PropertyMandateInfo;
import com.vstar.process.propertyDetailInfo.RequirementInfo;
import com.vstar.process.propertyDetailInfo.ResidentialPropInfo;
import com.vstar.process.propertyDetailInfo.ResidentialUnits;

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
  private PropTermsCondDaoProcess propTermsCondDaoProcess;
  private PropInfoDao propInfoDao;
  private PropRequirementDao propRequirementDao;
  private ReqPropTypeDaoProcess reqPropTypeDaoProcess;
  private PropRequirementDaoProcess propRequirementDaoProcess;
  private RegistrationProcess registrationProcess;
  private PropOwnerDaoProcess propOwnerDaoProcess;
  private RequirementOwnerDaoProcess requirementOwnerDaoProcess;
  private UserProcess userProcess;
  protected Log logger = LogFactory.getLog(this.getClass());
  
  /**
   * Saving user info with property
   * @param propertyFeatureInfo
   * @return
   * @throws GenericProcessException
   */
  public boolean savePropertyWithUserDetails(PropertyFeatureInfo propertyFeatureInfo)
  	throws GenericProcessException
  {
    boolean savedSuccess = savePropertyDetails(propertyFeatureInfo);
    UserDetails userDetails = userProcess.findLoggedInUserId();
    if (userDetails instanceof UserDetails)
    {
      try
      {
    	PropOwnerDao propOwnerDao = new PropOwnerDao();
        propOwnerDao.setPropInfoDao(propInfoDao);
        propOwnerDao.setUserName(userDetails.getUsername());
        propOwnerDaoProcess.addUpdatePropOwnerDao(propOwnerDao);
      }
      catch (Exception e)
      {
    	logger.info("Exception in savePropertyWithUserDetails(): "+e);
        throw new GenericProcessException("Exception in savePropertyWithUserDetails() saving Property Owner details");
      }
    }
    return savedSuccess;
  }
  
  
  /**
   * Saving user info with requirement
   * @param requirementInfo
   * @throws GenericProcessException
   */
  public void saveRequirementWithUserDetails(RequirementInfo requirementInfo)
  	throws GenericProcessException
  {
    saveRequirementDetails(requirementInfo);
    UserDetails userDetails = userProcess.findLoggedInUserId();
    if (userDetails instanceof UserDetails)
    {
      try
      {
        RequirementOwnerDao requirementOwnerDao = new RequirementOwnerDao();
        requirementOwnerDao.setPropRequirementDao(propRequirementDao);
        requirementOwnerDao.setUserName(userDetails.getUsername());
        requirementOwnerDaoProcess.addUpdateRequirementOwnerDao(requirementOwnerDao);
      }
      catch (Exception e)
      {
    	logger.info("Exception in saveRequirementWithUserDetails(): "+e);
      	throw new GenericProcessException("Exception in saveRequirementWithUserDetails() saving Requirment Owner details");
      }
    }
  }
  
  /**
   * Save Property Details
   * @param propertyFeatureInfo
   * @return
   * @throws GenericProcessException
   */
  public boolean savePropertyDetails(PropertyFeatureInfo propertyFeatureInfo)
		  throws GenericProcessException
  {
    propInfoDao = new PropInfoDao();
    try
    {
      savePropertyMandateInfos(propertyFeatureInfo.getPropertyMandateInfo());
      savePropertyFeatureInfo(propertyFeatureInfo.getResidentialPropInfo());
    }
    catch(Exception e)
    {
    	logger.info("Exception in savePropertyDetails(): "+e);
    	throw new GenericProcessException("Exception in savePropertyDetails() saving Property Mandate info");
    }
    // Saving Property Master table
    try
    {
      propInfoDao = propInfoDaoProcess.addUpdatePropInfoDao(propInfoDao);
    }
    catch(Exception e)
    {
      logger.info("Exception in savePropertyDetails() in saving addUpdatePropInfoDao: "+e);
      throw new GenericProcessException("Exception in savePropertyDetails() saving Master Property info");
    }
    
    // Saving Property Location Info
    try
    {
      savePropertyLocationInfo(propertyFeatureInfo.getPropertyMandateInfo());
    }
    catch(GenericProcessException e)
    {
      logger.info("Exception in savePropertyDetails() in saving savePropertyLocationInfo: "+e);
      throw new GenericProcessException("Exception in savePropertyDetails() saving Property Location info");
    }
    return true;
  }
  
  /**
   * Saving Requirement Details
   * @param propertyMandateInfo
   * @return
   * @throws GenericProcessException
   */
  public boolean saveRequirementDetails(RequirementInfo requirementInfo)
  	throws GenericProcessException
  {
    try
    {
      propRequirementDao = new PropRequirementDao();
      savePropertyReqDetails(requirementInfo);
      createReqLocations(requirementInfo.getLocations(), requirementInfo.getCity());
      createReqPropTypes(requirementInfo.getPropertyTypes());
    }
    catch(Exception e)
    {
      logger.info("Exception in saveRequirementDetails() : "+e);
      throw new GenericProcessException("Exception in saveRequirementDetails() saving Requirement info");
    }
    return true;
  }
  
  /**
   * Creating Requirement Property Types Mapping
   * @param propertyTypes
   * @throws GenericProcessException
   */
  private void createReqPropTypes(PropertyTypeModel[] propertyTypes)
  	throws GenericProcessException
  {
	try
	{
      ReqPropTypeDao reqPropTypeDao = null;
      for(PropertyTypeModel propertyType : propertyTypes)
      {
        reqPropTypeDao = new ReqPropTypeDao();
        reqPropTypeDao.setPropRequirementDao(propRequirementDao);
        reqPropTypeDao.setPropTypeId(propertyType.getId());
        reqPropTypeDaoProcess.addUpdateReqPropTypeDao(reqPropTypeDao);
      }
	}
	catch(Exception e)
	{
	  logger.info("Exception in createReqPropTypes() : "+e);
	  throw new GenericProcessException("Exception in createReqPropTypes() saving Requirement Property Types");
	}
  }
  
  /**
   * Saving Property Requirement Details
   * @param requirementInfo
   * @throws GenericProcessException
   */
  private void savePropertyReqDetails(RequirementInfo requirementInfo)
  	throws GenericProcessException
  {
    try
    {
      propRequirementDao.setMinCoveredArea(requirementInfo.getMinCoveredArea());
      propRequirementDao.setMaxCoveredArea(requirementInfo.getMaxCoveredArea());
      propRequirementDao.setCoveredAreaUnit(requirementInfo.getCoveredAreaUnit() != null
        ? requirementInfo.getCoveredAreaUnit().getValue()
        : null);
      propRequirementDao.setMinPlotArea(requirementInfo.getMinPlotArea());
      propRequirementDao.setMaxPlotArea(requirementInfo.getMaxPlotArea());
      propRequirementDao.setPlotAreaUnit(requirementInfo.getPlotAreaUnit() != null ? requirementInfo
        .getPlotAreaUnit().getValue() : null);
      propRequirementDao.setMinBudget(Long.parseLong(requirementInfo.getMinBudget().getId()));
      propRequirementDao.setMaxBudget(Long.parseLong(requirementInfo.getMaxBudget().getId()));
      propRequirementDao.setDealingType(requirementInfo.getDealingType());
      propRequirementDao.setMinBedrooms(Integer.parseInt(requirementInfo.getMinBedrooms().getId()));
      propRequirementDao.setMaxBedrooms(Integer.parseInt(requirementInfo.getMaxBedrooms().getId()));
      propRequirementDao.setPropPurchaseId(requirementInfo.getPurchaseType());
      propRequirementDao = propRequirementDaoProcess.addUpdatePropRequirementDao(propRequirementDao);
	}
    catch(Exception e)
    {
      logger.info("Exception in savePropertyReqDetails() : "+e);
      throw new GenericProcessException("Exception in savePropertyReqDetails() saving Requirement Details");
    }
  }
  
  /**
   * Creating Requirement & Location Mapping
   * @param locations
   * @param cityId
   * @throws GenericProcessException
   */
  private void createReqLocations(LocalityModel[] locations, int cityId)
  	throws GenericProcessException
  {
    PropLocationInfoDao propLocationInfoDao = null;
    for(LocalityModel location : locations)
    {
      propLocationInfoDao = new PropLocationInfoDao();
      try
      {
          // Existing Location
        propLocationInfoDao.setPropLocationDao(location.getLocalityId());
        propLocationInfoDao.setPropRequirementDao(propRequirementDao);
        propLocationInfoDaoProcess.addUpdatePropAreaDao(propLocationInfoDao);
      }
      catch (Exception e)
      {
    	logger.info("Exception in createReqLocations() : "+e);
        throw new GenericProcessException("Exception in createReqLocations() saving Requirement Location infos");
      }
    }
    
    
  }
  
  /**
   * Saving Property Location Info
   * @param propertyMandateInfo
   * @throws GenericProcessException
   */
  private void savePropertyLocationInfo(PropertyMandateInfo propertyMandateInfo)
  	throws GenericProcessException
  {
    PropLocationInfoDao propLocationInfoDao = new PropLocationInfoDao();
    try
    {
      propLocationInfoDao.setPropAddress(propertyMandateInfo.getAddress());
      if (propertyMandateInfo.getLocality() != null)
      {
        // Existing Location
        propLocationInfoDao.setPropLocationDao(Long.parseLong(propertyMandateInfo.getLocality()));
      }
      else
      {
        // New Location
        propLocationInfoDao.setPropCityDao(Integer.parseInt(propertyMandateInfo.getCity()));
        propLocationInfoDao.setPropLocationName(propertyMandateInfo.getLocality());
      }
      propLocationInfoDao.setPropInfoDao(propInfoDao);
      propLocationInfoDaoProcess.addUpdatePropAreaDao(propLocationInfoDao);
    }
    catch (Exception e)
    {
      logger.info("Exception in savePropertyLocationInfo() : "+e);
      throw new GenericProcessException("Exception in createReqLocations() saving Property Location infos");
    }
  }
  
  /**
   * Saving Residential Property Info
   * @param residentialPropInfo
   * @throws GenericProcessException
   */
  public void savePropertyFeatureInfo(ResidentialPropInfo residentialPropInfo)
  {
    // Saving Property features
    PropFeaturesDao propFeaturesDao = new PropFeaturesDao();
    try
    {
      if (null != residentialPropInfo.getNoOfBedRooms()) 
      {
	    propFeaturesDao.setBedRooms(Integer.parseInt(residentialPropInfo.getNoOfBedRooms()
		  .getLabel()));
	  }
      if (null != residentialPropInfo.getNoOfBathRooms())
      {
    	propFeaturesDao.setBathRooms(Integer.parseInt(residentialPropInfo.getNoOfBathRooms()
    	  .getLabel()));  
      }
      if (null != residentialPropInfo.getNoOfBalonies())
      {
        propFeaturesDao.setBalconies(Integer.parseInt(residentialPropInfo.getNoOfBalonies()
          .getLabel()));
      }
      if (null != residentialPropInfo.getFurnishedStatus())
      {
        propFeaturesDao.setFurnished(residentialPropInfo.getFurnishedStatus().getValue());
      }
      if (null != residentialPropInfo.getFloorNumber())
      {
        propFeaturesDao.setAvailFloor(Integer.parseInt(residentialPropInfo.getFloorNumber()
          .getValue()));
      }
      if (null != residentialPropInfo.getTotalFloor())
      {
        propFeaturesDao.setTotalFloors(Integer.parseInt(residentialPropInfo.getTotalFloor()
          .getValue()));
      }
      StringBuffer amenBuffer = null;
      if (null != residentialPropInfo.getInHouseAmenities())
      {
    	amenBuffer = new StringBuffer();
        for (ResidentialUnits inhouseAmen : residentialPropInfo.getInHouseAmenities())
        {
    	  amenBuffer.append(inhouseAmen.getLabel() + ";");
        }
        propFeaturesDao.setInhouseAmenities(amenBuffer.toString());
      }
      if (null != residentialPropInfo.getExternalAmenities())
      {
    	amenBuffer = new StringBuffer();
        for (ResidentialUnits extAmen : residentialPropInfo.getExternalAmenities())
        {
    	  amenBuffer.append(extAmen.getLabel() + ";");
        }
        propFeaturesDao.setExternalAmenities(amenBuffer.toString());
      }
      propFeaturesDao = propFeaturesDaoProcess.addUpdatePropFeaturesDao(propFeaturesDao);
      propInfoDao.setPropFeatures(propFeaturesDao);
    }
    catch (Exception e)
    {
      logger.info("Exception in savePropertyFeatureInfo() in saving addUpdatePropFeaturesDao() : "+e);
      throw new GenericProcessException("Exception in savePropertyFeatureInfo() saving Property Feature infos");
    }

    // Saving Property transactions
    PropTransactionDao propTransactionDao = new PropTransactionDao();
    try
    {
      propTransactionDao.setPossessionStatus(residentialPropInfo.getPossessionStatus());
      propTransactionDao.setBuilderSociety(residentialPropInfo.getBuilderSociety());
      propTransactionDao = propTransactionDaoProcess
        .addUpdatePropTransactionDao(propTransactionDao);
      propInfoDao.setPropTransaction(propTransactionDao);
    }
    catch (Exception e)
    {
      logger.info("Exception in savePropertyFeatureInfo() in saving addUpdatePropTransactionDao() : "+e);
      throw new GenericProcessException("Exception in savePropertyFeatureInfo() saving Property Transaction infos");
    }

    // Saving Property TermsNConditions
    PropTermsCondDao propTermsCondDao = new PropTermsCondDao();
    try
    {
      propTermsCondDao.setDescription(residentialPropInfo.getPropertyDescription());
      propTermsCondDao.setLandmarks(residentialPropInfo.getLandmarks());
      propTermsCondDao.setTermNCond(residentialPropInfo.getTermsNConditions());
      propTermsCondDao = propTermsCondDaoProcess.addUpdatePropTermsCondDao(propTermsCondDao);
      propInfoDao.setPropTermsCond(propTermsCondDao);
    }
    catch (Exception e)
    {
      logger.info("Exception in savePropertyFeatureInfo() in saving addUpdatePropTermsCondDao() : "+e);
      throw new GenericProcessException("Exception in savePropertyFeatureInfo() saving Property Terms & Conditions");
    }
  }
  
  /**
   * Saving Property Mandatory Information
   * @param propertyMandateInfo
   * @throws GenericProcessException
   */
  public void savePropertyMandateInfos(PropertyMandateInfo propertyMandateInfo)
  	throws GenericProcessException
  {
    try
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
      if (null != propertyMandateInfo.getCoveredAreaUnit())
      {
    	  propAreaDao.setCoveredAreaUnit(propertyMandateInfo.getCoveredAreaUnit().getValue());
      }
      propAreaDao.setPlotArea(propertyMandateInfo.getPlotArea());
      if (null != propertyMandateInfo.getPlotAreaUnit())
      {
    	  propAreaDao.setPlotAreaUnit(propertyMandateInfo.getPlotAreaUnit().getValue());
      }
      if(null!=propertyMandateInfo.getNegotiable())
      {
    	  propInfoDao.setNegotiable(propertyMandateInfo.getNegotiable());
      }
      propAreaDao = propAreaDaoProcess.addUpdatePropAreaDao(propAreaDao);
      propInfoDao.setPropArea(propAreaDao);
    }
    catch (Exception e)
    {
      logger.info("Exception in savePropertyMandateInfos() : "+e);
      throw new GenericProcessException("Exception in savePropertyMandateInfos() saving Property Mandate infos");
    }

    try
    {
      // Saving Property Price Info
      PropPriceDao propPriceDao = new PropPriceDao();
      propPriceDao.setExpectedPrice(propertyMandateInfo.getPropPrice());
      propPriceDao = propPriceDaoProcess.addUpdatePropPriceDao(propPriceDao);
      propInfoDao.setPropPrice(propPriceDao);
    }
    catch (Exception e)
    {
      logger.info("Exception in savePropertyMandateInfos() in addUpdatePropPriceDao() : "+e);
      throw new GenericProcessException("Exception in savePropertyMandateInfos() saving Property Price infos");
    }
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

  public PropTermsCondDaoProcess getPropTermsCondDaoProcess()
  {
    return propTermsCondDaoProcess;
  }

  public void setPropTermsCondDaoProcess(PropTermsCondDaoProcess propTermsCondDaoProcess)
  {
    this.propTermsCondDaoProcess = propTermsCondDaoProcess;
  }

  public ReqPropTypeDaoProcess getReqPropTypeDaoProcess()
  {
    return reqPropTypeDaoProcess;
  }

  public void setReqPropTypeDaoProcess(ReqPropTypeDaoProcess reqPropTypeDaoProcess)
  {
    this.reqPropTypeDaoProcess = reqPropTypeDaoProcess;
  }

  public PropRequirementDaoProcess getPropRequirementDaoProcess()
  {
    return propRequirementDaoProcess;
  }

  public void setPropRequirementDaoProcess(PropRequirementDaoProcess propRequirementDaoProcess)
  {
    this.propRequirementDaoProcess = propRequirementDaoProcess;
  }

  public RegistrationProcess getRegistrationProcess()
  {
    return registrationProcess;
  }

  public void setRegistrationProcess(RegistrationProcess registrationProcess)
  {
    this.registrationProcess = registrationProcess;
  }


  public PropOwnerDaoProcess getPropOwnerDaoProcess()
  {
    return propOwnerDaoProcess;
  }


  public void setPropOwnerDaoProcess(PropOwnerDaoProcess propOwnerDaoProcess)
  {
    this.propOwnerDaoProcess = propOwnerDaoProcess;
  }


  public RequirementOwnerDaoProcess getRequirementOwnerDaoProcess()
  {
    return requirementOwnerDaoProcess;
  }


  public void setRequirementOwnerDaoProcess(RequirementOwnerDaoProcess requirementOwnerDaoProcess)
  {
    this.requirementOwnerDaoProcess = requirementOwnerDaoProcess;
  }


public UserProcess getUserProcess() {
	return userProcess;
}


public void setUserProcess(UserProcess userProcess) {
	this.userProcess = userProcess;
}

}
