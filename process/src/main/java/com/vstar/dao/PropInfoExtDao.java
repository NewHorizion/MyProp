package com.vstar.dao;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Property Extension Data
 * Searching purpose
 *
 */
@Entity
@Table(name = "prop_info_ext", catalog = "property_master")
public class PropInfoExtDao implements java.io.Serializable
{
  private static final long serialVersionUID = 7697251516527010610L;
  @Id
  @Column(name = "prop_Info_Id", unique = true, nullable = false)
  private int propInfoId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_Info_Id", unique = true, nullable = false, insertable = false, updatable = false)
  private PropInfoDao propInfo;
  @Column(name = "number_of_clicks")
  private Integer numberOfClicks;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_accessed", length = 19)
  private Date lastAccessed;
  @Column(name = "popularity")
  private Integer popularity;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  private Date createdDate;
  @Column(name = "custom1", length = 10)
  private String custom1;
  @Column(name = "custom2", length = 10)
  private String custom2;
  @Column(name = "custom3", length = 10)
  private String custom3;
  @Column(name = "custom4", length = 10)
  private String custom4;

  public PropInfoExtDao()
  {
  }

  public PropInfoExtDao(int propInfoId, PropInfoDao propInfo)
  {
    this.propInfoId = propInfoId;
    this.propInfo = propInfo;
  }

  /**
   * 
   * @param propInfoId
   * @param propInfo
   * @param numberOfClicks
   * @param lastAccessed
   * @param popularity
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropInfoExtDao(int propInfoId, PropInfoDao propInfo, Integer numberOfClicks,
      Date lastAccessed, Integer popularity, Date createdDate, String custom1, String custom2,
      String custom3, String custom4)
  {
    this.propInfoId = propInfoId;
    this.propInfo = propInfo;
    this.numberOfClicks = numberOfClicks;
    this.lastAccessed = lastAccessed;
    this.popularity = popularity;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  public int getPropInfoId()
  {
    return this.propInfoId;
  }

  public void setPropInfoId(int propInfoId)
  {
    this.propInfoId = propInfoId;
  }

  public PropInfoDao getPropInfo()
  {
    return this.propInfo;
  }

  public void setPropInfo(PropInfoDao propInfo)
  {
    this.propInfo = propInfo;
  }

  public Integer getNumberOfClicks()
  {
    return this.numberOfClicks;
  }

  public void setNumberOfClicks(Integer numberOfClicks)
  {
    this.numberOfClicks = numberOfClicks;
  }

  public Date getLastAccessed()
  {
    return this.lastAccessed;
  }

  public void setLastAccessed(Date lastAccessed)
  {
    this.lastAccessed = lastAccessed;
  }

  public Integer getPopularity()
  {
    return this.popularity;
  }

  public void setPopularity(Integer popularity)
  {
    this.popularity = popularity;
  }

  public Date getCreatedDate()
  {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
  }

  public String getCustom1()
  {
    return this.custom1;
  }

  public void setCustom1(String custom1)
  {
    this.custom1 = custom1;
  }

  public String getCustom2()
  {
    return this.custom2;
  }

  public void setCustom2(String custom2)
  {
    this.custom2 = custom2;
  }

  public String getCustom3()
  {
    return this.custom3;
  }

  public void setCustom3(String custom3)
  {
    this.custom3 = custom3;
  }

  public String getCustom4()
  {
    return this.custom4;
  }

  public void setCustom4(String custom4)
  {
    this.custom4 = custom4;
  }
}
