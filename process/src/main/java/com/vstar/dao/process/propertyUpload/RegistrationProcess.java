package com.vstar.dao.process.propertyUpload;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import com.google.gson.Gson;
import com.vstar.dao.PropCompanyDao;
import com.vstar.dao.PropUsersDao;
import com.vstar.dao.process.PropCompanyDaoProcess;
import com.vstar.dao.process.PropOwnerDaoProcess;
import com.vstar.dao.process.PropUserDaoExtnProcess;
import com.vstar.dao.process.PropUsersDaoProcess;
import com.vstar.process.propertyDetailInfo.RegistrationInfo;

public class RegistrationProcess
{
  private PropUsersDaoProcess propUsersDaoProcess;
  private PropUserDaoExtnProcess propUserDaoExtnProcess;
  private PropCompanyDaoProcess propCompanyDaoProcess;
  private PropOwnerDaoProcess propOwnerDaoProcess;
  private UserProcess userProcess;

  /**
   * Save & Update User info
   * 
   * @param registrationInfo
   * @return
   */
  public String saveUserWithExtension(RegistrationInfo registrationInfo)
  {
    UserDetails userDetails = userProcess.findLoggedInUserId();
    PropUsersDao userExtn = null;
    PropCompanyDao propCompanyDao = propCompanyDaoProcess.getPropCompanyDaoByName(registrationInfo
      .getCompanyName());
    if (userDetails instanceof UserDetails)
    {
      if (propCompanyDao != null)
      {
        //write logic for entering company
      }
      userExtn = propUserDaoExtnProcess.getPropUsersDaoExtnById(userDetails.getUsername());
      userExtn.setLandLineNo(registrationInfo.getLandlineNumber());
      userExtn.setMobileNo(registrationInfo.getMobileNumber());
    }
    else
    {
      propUsersDaoProcess.createUser(registrationInfo.getEmailId(), registrationInfo.getPassword(),
        true, registrationInfo.getUserType());
      if (propCompanyDao == null && null != registrationInfo.getCompanyName())
      {
        propCompanyDao = new PropCompanyDao(registrationInfo.getCompanyName(), new Date());
        propCompanyDao = propCompanyDaoProcess.addUpdatePropCompanyDao(propCompanyDao);
      }
      userExtn = new PropUsersDao(registrationInfo.getEmailId(),
        registrationInfo.getUserType(), registrationInfo.getUserName(),
        registrationInfo.getMobileNumber(), registrationInfo.getLandlineNumber(),
        registrationInfo.getCityId(), propCompanyDao);
    }
    
    propUserDaoExtnProcess.addUpdatePropUsersDaoExtn(userExtn);
    return registrationInfo.getEmailId();
  }
  
  /**
   * Fetch User extension info
   */
  public RegistrationInfo getUserProfileInfo()
  {
    UserDetails userDetails = userProcess.findLoggedInUserId();
    PropUsersDao userExtn = null;
    RegistrationInfo registrationInfo = null;
    if (userDetails instanceof UserDetails)
    {
      userExtn = propUserDaoExtnProcess.getPropUsersDaoExtnById(userDetails.getUsername());
      if (null != userExtn)
      {
        registrationInfo = new RegistrationInfo();
        registrationInfo.setCompanyName(userExtn.getPropCompanyDao().getCompanyName());
        registrationInfo.setLandlineNumber(userExtn.getLandLineNo());
        registrationInfo.setMobileNumber(userExtn.getMobileNo());
        registrationInfo.setUserType(userExtn.getUserType());
      }
    }
    /*Gson gson = new Gson();
    String json = gson.toJson(registrationInfo);
    return json;*/
    return registrationInfo; 
  }

  public PropUsersDaoProcess getPropUsersDaoProcess()
  {
    return propUsersDaoProcess;
  }

  public void setPropUsersDaoProcess(PropUsersDaoProcess propUsersDaoProcess)
  {
    this.propUsersDaoProcess = propUsersDaoProcess;
  }

  public PropUserDaoExtnProcess getPropUserDaoExtnProcess()
  {
    return propUserDaoExtnProcess;
  }

  public void setPropUserDaoExtnProcess(PropUserDaoExtnProcess propUserDaoExtnProcess)
  {
    this.propUserDaoExtnProcess = propUserDaoExtnProcess;
  }

public PropCompanyDaoProcess getPropCompanyDaoProcess() {
	return propCompanyDaoProcess;
}

public void setPropCompanyDaoProcess(PropCompanyDaoProcess propCompanyDaoProcess) {
	this.propCompanyDaoProcess = propCompanyDaoProcess;
}

public PropOwnerDaoProcess getPropOwnerDaoProcess()
{
  return propOwnerDaoProcess;
}

public void setPropOwnerDaoProcess(PropOwnerDaoProcess propOwnerDaoProcess)
{
  this.propOwnerDaoProcess = propOwnerDaoProcess;
}

public UserProcess getUserProcess()
{
  return userProcess;
}

public void setUserProcess(UserProcess userProcess)
{
  this.userProcess = userProcess;
}
  
}
