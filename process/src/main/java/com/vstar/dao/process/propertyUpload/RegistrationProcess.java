package com.vstar.dao.process.propertyUpload;
import com.vstar.dao.PropUsersDao;
import com.vstar.dao.process.PropUserDaoExtnProcess;
import com.vstar.dao.process.PropUsersDaoProcess;
import com.vstar.exception.GenericProcessException;
import com.vstar.process.propertyDetailInfo.RegistrationInfo;

public class RegistrationProcess
{
  private PropUsersDaoProcess propUsersDaoProcess;
  private PropUserDaoExtnProcess propUserDaoExtnProcess;

  public String saveUserWithExtension(RegistrationInfo registrationInfo)
  {
    try
    {
      propUsersDaoProcess.createUser(registrationInfo.getEmailId(), registrationInfo.getPassword(),
        true, registrationInfo.getUserType());
      PropUsersDao userExtn = new PropUsersDao(registrationInfo.getEmailId(),
        registrationInfo.getUserType(), registrationInfo.getUserName(),
        registrationInfo.getMobileNumber(), registrationInfo.getLandlineNumber(),
        registrationInfo.getCityId());
      propUserDaoExtnProcess.addUpdatePropUsersDaoExtn(userExtn);
      return registrationInfo.getEmailId();
    }
    catch (GenericProcessException e)
    {
      // Log the exception
    }
    return null;
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
}
