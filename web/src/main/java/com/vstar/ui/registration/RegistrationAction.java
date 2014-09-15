package com.vstar.ui.registration;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.vstar.dao.PropUsersDao;
import com.vstar.dao.process.PropUserDaoExtnProcess;
import com.vstar.dao.process.PropUsersDaoProcess;
import com.vstar.process.propertyDetailInfo.RegistrationInfo;

@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport {
	private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
	/*private String userType;
	private String displayName;
	private String email;
	private String password;
	private long propCityId;
	private String mobileNo;
	private String landLineNo;*/
	private RegistrationInfo registrationInfo;
	private PropUsersDaoProcess propUsersDaoProcess;
	private PropUserDaoExtnProcess propUserDaoExtnProcess;

	public String save() {
		propUsersDaoProcess.createUser(registrationInfo.getEmailId(), registrationInfo.getPassword(), true , registrationInfo.getUserType());
		jsonMap.put("success", true);
		jsonMap.put("messages", "Welcome " + registrationInfo.getUserName() + "!!!!");
		PropUsersDao userExtn = new PropUsersDao(registrationInfo.getEmailId(), registrationInfo.getUserType(), registrationInfo.getUserName(), registrationInfo.getMobileNumber(), registrationInfo.getLandlineNumber(), registrationInfo.getCityId());
		propUserDaoExtnProcess.addUpdatePropUsersDaoExtn(userExtn);
		return SUCCESS;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	
	/**
	 * @return the propUsersDaoProcess
	 */
	public PropUsersDaoProcess getPropUsersDaoProcess() {
		return propUsersDaoProcess;
	}

	/**
	 * @param propUsersDaoProcess
	 *            the propUsersDaoProcess to set
	 */
	public void setPropUsersDaoProcess(PropUsersDaoProcess propUsersDaoProcess) {
		this.propUsersDaoProcess = propUsersDaoProcess;
	}

	/**
	 * @return the propUserDaoExtnProcess
	 */
	public PropUserDaoExtnProcess getPropUserDaoExtnProcess() {
		return propUserDaoExtnProcess;
	}

	/**
	 * @param propUserDaoExtnProcess the propUserDaoExtnProcess to set
	 */
	public void setPropUserDaoExtnProcess(
			PropUserDaoExtnProcess propUserDaoExtnProcess) {
		this.propUserDaoExtnProcess = propUserDaoExtnProcess;
	}

	public RegistrationInfo getRegistrationInfo() {
		return registrationInfo;
	}

	public void setRegistrationInfo(RegistrationInfo registrationInfo) {
		this.registrationInfo = registrationInfo;
	}
	
	
}
