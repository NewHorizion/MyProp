package com.vstar.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * State Information
 * 
 */
@Entity
@Table(name = "prop_company", catalog = "property_master")
public class PropCompanyDao implements java.io.Serializable {
	private static final long serialVersionUID = 3942227844296108153L;
	@Id
	@Column(name = "companyId", unique = true, nullable = false)
	private Long companyId;
	@Column(name = "companyName", length = 45)
	private String companyName;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate", length = 19)
	private Date createdDate;
	@Column(name = "custom1", length = 45)
	private String custom1;
	@Column(name = "custom2", length = 45)
	private String custom2;
	@Column(name = "custom3", length = 45)
	private String custom3;
	@Column(name = "custom4", length = 45)
	private String custom4;

	public PropCompanyDao() {
	}

	public PropCompanyDao(Long companyId, String companyName, Date createdDate,
			String custom1, String custom2, String custom3, String custom4) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.createdDate = createdDate;
		this.custom1 = custom1;
		this.custom2 = custom2;
		this.custom3 = custom3;
		this.custom4 = custom4;
	}

	
	public PropCompanyDao(String companyName, Date createdDate) {
		this.companyName = companyName;
		this.createdDate = createdDate;
	}

	public PropCompanyDao(long companyId) {
		this.companyId = companyId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustom1() {
		return custom1;
	}

	public void setCustom1(String custom1) {
		this.custom1 = custom1;
	}

	public String getCustom2() {
		return custom2;
	}

	public void setCustom2(String custom2) {
		this.custom2 = custom2;
	}

	public String getCustom3() {
		return custom3;
	}

	public void setCustom3(String custom3) {
		this.custom3 = custom3;
	}

	public String getCustom4() {
		return custom4;
	}

	public void setCustom4(String custom4) {
		this.custom4 = custom4;
	}

}
