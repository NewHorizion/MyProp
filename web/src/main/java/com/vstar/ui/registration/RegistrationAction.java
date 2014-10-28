package com.vstar.ui.registration;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.vstar.dao.process.propertyUpload.RegistrationProcess;
import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;
import com.vstar.process.propertyDetailInfo.RegistrationInfo;
import com.vstar.process.propertyDetailInfo.RequirementInfo;

@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport
{
  private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
  private RegistrationInfo registrationInfo;
  private RegistrationProcess registrationProcess;
  private PropertyFeatureInfo propertyFeatureInfo;
  private RequirementInfo requirementInfo;

  public String save()
  {
    registrationProcess.saveUserWithExtension(registrationInfo);
    jsonMap.put("success", true);
    jsonMap.put("messages", "Welcome " + registrationInfo.getUserName() + "!!!!");
    return SUCCESS;
  }
  
  public String profile()
  {
    registrationInfo = registrationProcess.getUserProfileInfo();
    registrationInfo = new RegistrationInfo();
    registrationInfo.setLandlineNumber("10000000");
    registrationInfo.setMobileNumber("9898000000");
    registrationInfo.setCityId(1);
    registrationInfo.setUserType("agent");
    jsonMap.put("registrationInfo", registrationInfo);
    return SUCCESS;
  }
  
  public String updateProfile()
  {
    registrationProcess.saveUserWithExtension(registrationInfo);
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

public PropertyFeatureInfo getPropertyFeatureInfo() {
	return propertyFeatureInfo;
}

public void setPropertyFeatureInfo(PropertyFeatureInfo propertyFeatureInfo) {
	this.propertyFeatureInfo = propertyFeatureInfo;
}

public RequirementInfo getRequirementInfo() {
	return requirementInfo;
}

public void setRequirementInfo(RequirementInfo requirementInfo) {
	this.requirementInfo = requirementInfo;
}

}
