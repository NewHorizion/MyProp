package com.vstar.ui.registration;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.vstar.dao.process.propertyUpload.RegistrationProcess;
import com.vstar.process.propertyDetailInfo.RegistrationInfo;

@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport
{
  private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
  private RegistrationInfo registrationInfo;
  private RegistrationProcess registrationProcess;

  public String save()
  {
    registrationProcess.saveUserWithExtension(registrationInfo);
    jsonMap.put("success", true);
    jsonMap.put("messages", "Welcome " + registrationInfo.getUserName() + "!!!!");

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

  public RegistrationInfo getRegistrationInfo()
  {
    return registrationInfo;
  }

  public void setRegistrationInfo(RegistrationInfo registrationInfo)
  {
    this.registrationInfo = registrationInfo;
  }

  public RegistrationProcess getRegistrationProcess()
  {
    return registrationProcess;
  }

  public void setRegistrationProcess(RegistrationProcess registrationProcess)
  {
    this.registrationProcess = registrationProcess;
  }

}
