package com.sample.ui.VstarProperty;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.vstar.dao.process.propertyUpload.PropertyUploadProcess;
import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;
import com.vstar.process.propertyDetailInfo.RequirementInfo;

public class UploadPropertyAction extends ActionSupport
{
  private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
  private PropertyFeatureInfo propertyFeatureInfo;
  private String data;
  private File[] files;
  private String[] filesContentType;
  private String[] filesFileName;
  private PropertyUploadProcess propertyUploadProcess;
  private RequirementInfo requirementInfo;
  private String propertyId;

  public String save()
  {
    int propertyId = propertyUploadProcess.savePropertyWithUserDetails(propertyFeatureInfo);
    jsonMap.put("propertyId", propertyId);
    return SUCCESS;
  }

  public String uploadFiles() throws IOException
  {
    if (null != files)
    {
      saveFile(propertyId);
    }
    return SUCCESS;
  }

  private void saveFile(String propertyId) throws IOException
  {
    String filePath = "E:\\PropertyImages\\" + propertyId + "\\";
    File fileToCreate = new File(filePath, filesFileName[0]);
    FileUtils.copyFile(this.files[0], fileToCreate);
    String fileName = filePath + filesFileName[0];
    propertyUploadProcess.savePropertyImageUrl(propertyId, fileName);
  }

  public String saveRequirement()
  {
    propertyUploadProcess.saveRequirementWithUserDetails(requirementInfo);
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

  public String getData()
  {
    return data;
  }

  public void setData(String data)
  {
    this.data = data;
  }

  public PropertyFeatureInfo getPropertyFeatureInfo()
  {
    return propertyFeatureInfo;
  }

  public void setPropertyFeatureInfo(PropertyFeatureInfo propertyFeatureInfo)
  {
    this.propertyFeatureInfo = propertyFeatureInfo;
  }

  public PropertyUploadProcess getPropertyUploadProcess()
  {
    return propertyUploadProcess;
  }

  public void setPropertyUploadProcess(PropertyUploadProcess propertyUploadProcess)
  {
    this.propertyUploadProcess = propertyUploadProcess;
  }

  public RequirementInfo getRequirementInfo()
  {
    return requirementInfo;
  }

  public void setRequirementInfo(RequirementInfo requirementInfo)
  {
    this.requirementInfo = requirementInfo;
  }

  public String[] getFilesContentType()
  {
    return filesContentType;
  }

  public void setFilesContentType(String[] filesContentType)
  {
    this.filesContentType = filesContentType;
  }

  public String[] getFilesFileName()
  {
    return filesFileName;
  }

  public void setFilesFileName(String[] filesFileName)
  {
    this.filesFileName = filesFileName;
  }

  public void setFiles(File[] files)
  {
    this.files = files;
  }

  public File[] getFiles()
  {
    return files;
  }

  public String getPropertyId()
  {
    return propertyId;
  }

  public void setPropertyId(String propertyId)
  {
    this.propertyId = propertyId;
  }

}
