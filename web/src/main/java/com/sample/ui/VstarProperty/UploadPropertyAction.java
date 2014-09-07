package com.sample.ui.VstarProperty;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.opensymphony.xwork2.ActionSupport;
import com.vstar.dao.process.propertyUpload.PropertyUploadProcess;
import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;

public class UploadPropertyAction extends ActionSupport
{
  private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
  private PropertyFeatureInfo propertyFeatureInfo;
  private String data;
  private MultipartFile[] files;
  private PropertyUploadProcess propertyUploadProcess;

  public String save()
  {
    boolean savedSuccess = propertyUploadProcess.savePropertyDetails(propertyFeatureInfo);
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

  public MultipartFile[] getFiles()
  {
    return files;
  }

  public void setFiles(MultipartFile[] files)
  {
    this.files = files;
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

}
