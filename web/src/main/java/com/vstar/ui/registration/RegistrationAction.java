package com.vstar.ui.registration;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.vstar.dao.PropUsersDao;
import com.vstar.dao.process.PropUserDaoExtnProcess;
import com.vstar.dao.process.PropUsersDaoProcess;

@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport {
	private Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
	private String userType;
	private String displayName;
	private String email;
	private String password;
	private long propCityId;
	private String mobileNo;
	private String landLineNo;
	private PropUsersDaoProcess propUsersDaoProcess;
	private PropUserDaoExtnProcess propUserDaoExtnProcess;

	public String save() {
		propUsersDaoProcess.createUser(email, password, true);
		jsonMap.put("success", true);
		jsonMap.put("messages", "Welcome " + displayName + "!!!!");
		PropUsersDao userExtn = new PropUsersDao(email, userType, displayName, mobileNo, landLineNo, propCityId);
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the propCityId
	 */
	public long getPropCityId() {
		return propCityId;
	}

	/**
	 * @param propCityId
	 *            the propCityId to set
	 */
	public void setPropCityId(long propCityId) {
		this.propCityId = propCityId;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the landLineNo
	 */
	public String getLandLineNo() {
		return landLineNo;
	}

	/**
	 * @param landLineNo
	 *            the landLineNo to set
	 */
	public void setLandLineNo(String landLineNo) {
		this.landLineNo = landLineNo;
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
	
}
