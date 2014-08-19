package com.vstar.ui.registration;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.vstar.dao.PropUsersDao;
import com.vstar.dao.process.PropUsersDaoProcess;

@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport
{
  private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
  private String userName;
  private String userId;
  private String password;
  private String userMobile;
  private PropUsersDaoProcess propUsersDaoProcess;

  public String save()
  {
    propUsersDaoProcess.createUser(userId,password,true);
    jsonMap.put("success", true);
    jsonMap.put("messages", "Welcome " + userName + "!!!!");
    return SUCCESS;
  }

  public Map<String, Object> getJsonMap()
  {
    return jsonMap;
  }

  public void setJsonMap(Map<String, Object> jsonMap)
  {
    this.jsonMap = jsonMap;
  }

  /**
   * @return the userName
   */
  public String getUserName()
  {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  /**
   * @return the userId
   */
  public String getUserId()
  {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  /**
   * @return the password
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password)
  {
    this.password = password;
  }

  /**
   * @return the userMobile
   */
  public String getUserMobile()
  {
    return userMobile;
  }

  /**
   * @param userMobile the userMobile to set
   */
  public void setUserMobile(String userMobile)
  {
    this.userMobile = userMobile;
  }

  /**
   * @return the propUsersDaoProcess
   */
  public PropUsersDaoProcess getPropUsersDaoProcess()
  {
    return propUsersDaoProcess;
  }

  /**
   * @param propUsersDaoProcess the propUsersDaoProcess to set
   */
  public void setPropUsersDaoProcess(PropUsersDaoProcess propUsersDaoProcess)
  {
    this.propUsersDaoProcess = propUsersDaoProcess;
  }
}
