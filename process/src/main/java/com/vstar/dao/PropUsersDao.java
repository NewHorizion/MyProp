package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PropUsersDao
 * 
 */
@Entity
@Table(name = "prop_users", catalog = "property_master")
public class PropUsersDao implements java.io.Serializable
{
  private static final long serialVersionUID = -6261006342019880313L;
  @Id
  @Column(name = "userId", unique = true, nullable = false)
  private String userId;
  @Column(name = "userType")
  private String userType;
  @Column(name = "userName")
  private String userName;
  @Column(name = "mobileNo")
  private String mobileNo;
  @Column(name = "landLineNo")
  private String landLineNo;
  @Column(name = "prop_city_Id")
  private long propCityId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyId")
  private PropCompanyDao propCompanyDao;
  

  public PropUsersDao()
  {
  }

  public PropUsersDao(String userId)
  {
    this.userId = userId;
  }

  public PropUsersDao(String userId, String userType, String userName, String mobileNo,
      String landLineNo, long propCityId, PropCompanyDao propCompanyDao)
  {
    this.userId = userId;
    this.userType = userType;
    this.userName = userName;
    this.mobileNo = mobileNo;
    this.landLineNo = landLineNo;
    this.propCityId = propCityId;
    this.propCompanyDao = propCompanyDao;
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
   * @return the userType
   */
  public String getUserType()
  {
    return userType;
  }

  /**
   * @param userType the userType to set
   */
  public void setUserType(String userType)
  {
    this.userType = userType;
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
   * @return the mobileNo
   */
  public String getMobileNo()
  {
    return mobileNo;
  }

  /**
   * @param mobileNo the mobileNo to set
   */
  public void setMobileNo(String mobileNo)
  {
    this.mobileNo = mobileNo;
  }

  /**
   * @return the landLineNo
   */
  public String getLandLineNo()
  {
    return landLineNo;
  }

  /**
   * @param landLineNo the landLineNo to set
   */
  public void setLandLineNo(String landLineNo)
  {
    this.landLineNo = landLineNo;
  }

  /**
   * @return the propCityId
   */
  public long getPropCityId()
  {
    return propCityId;
  }

  /**
   * @param propCityId the propCityId to set
   */
  public void setPropCityId(long propCityId)
  {
    this.propCityId = propCityId;
  }

  /**
   * @return the propCompanyDao
   */
  public PropCompanyDao getPropCompanyDao()
  {
    return propCompanyDao;
  }

  /**
   * @param propCompanyDao the propCompanyDao to set
   */
  public void setPropCompanyDao(PropCompanyDao propCompanyDao)
  {
    this.propCompanyDao = propCompanyDao;
  }


  
}
