package com.sample.ui.VstarProperty;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.opensymphony.xwork2.ActionSupport;
import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;

public class UploadPropertyAction extends ActionSupport {
	private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
	private PropertyFeatureInfo propertyFeatureInfo;
	private String data; 
	private MultipartFile [] files;

	public String save() {
	     Gson gson = new Gson();
	    JsonElement jsonElement = gson.toJsonTree(data);
	     propertyFeatureInfo = gson.fromJson(data, PropertyFeatureInfo.class);
		return SUCCESS;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}


	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public PropertyFeatureInfo getPropertyFeatureInfo() {
		return propertyFeatureInfo;
	}

	public void setPropertyFeatureInfo(PropertyFeatureInfo propertyFeatureInfo) {
		this.propertyFeatureInfo = propertyFeatureInfo;
	}

}
