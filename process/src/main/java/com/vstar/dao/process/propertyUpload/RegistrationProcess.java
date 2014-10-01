package com.vstar.dao.process.propertyUpload;
import java.util.Date;

import com.vstar.dao.PropCompanyDao;
import com.vstar.dao.PropUsersDao;
import com.vstar.dao.process.PropCompanyDaoProcess;
import com.vstar.dao.process.PropUserDaoExtnProcess;
import com.vstar.dao.process.PropUsersDaoProcess;
import com.vstar.process.propertyDetailInfo.RegistrationInfo;

public class RegistrationProcess
{
  private PropUsersDaoProcess propUsersDaoProcess;
  private PropUserDaoExtnProcess propUserDaoExtnProcess;
  private PropCompanyDaoProcess propCompanyDaoProcess;

  public String saveUserWithExtension(RegistrationInfo registrationInfo)
  {
      PropCompanyDao propCompanyDao  = propCompanyDaoProcess.getPropCompanyDaoByName(registrationInfo.getCompanyName());
      if(propCompanyDao==null && null!=registrationInfo.getCompanyName())
      {
    	  propCompanyDao = new PropCompanyDao(registrationInfo.getCompanyName(),new Date());
    	  propCompanyDao = propCompanyDaoProcess.addUpdatePropCompanyDao(propCompanyDao);
      }
      propUsersDaoProcess.createUser(registrationInfo.getEmailId(), registrationInfo.getPassword(),
        true, registrationInfo.getUserType());
      PropUsersDao userExtn = new PropUsersDao(registrationInfo.getEmailId(),
        registrationInfo.getUserType(), registrationInfo.getUserName(),
        registrationInfo.getMobileNumber(), registrationInfo.getLandlineNumber(),
        registrationInfo.getCityId(),propCompanyDao);
      propUserDaoExtnProcess.addUpdatePropUsersDaoExtn(userExtn);
      return registrationInfo.getEmailId();
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
  
}
