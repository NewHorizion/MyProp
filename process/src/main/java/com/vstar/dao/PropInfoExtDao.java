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
 * @author upendra.kumar
 *
 */
@Entity
@Table(name = "prop_info_ext", catalog = "property_master")
public class PropInfoExtDao implements java.io.Serializable
{
  private int propInfoId;
  private PropInfoDao propInfo;
  private Integer numberOfClicks;
  private Date lastAccessed;
  private Integer popularity;
  private Date createdDate;
  private String custom1;
  private String custom2;
  private String custom3;
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

  @Id
  @Column(name = "prop_Info_Id", unique = true, nullable = false)
  public int getPropInfoId()
  {
    return this.propInfoId;
  }

  public void setPropInfoId(int propInfoId)
  {
    this.propInfoId = propInfoId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_Info_Id", unique = true, nullable = false, insertable = false, updatable = false)
  public PropInfoDao getPropInfo()
  {
    return this.propInfo;
  }

  public void setPropInfo(PropInfoDao propInfo)
  {
    this.propInfo = propInfo;
  }

  @Column(name = "number_of_clicks")
  public Integer getNumberOfClicks()
  {
    return this.numberOfClicks;
  }

  public void setNumberOfClicks(Integer numberOfClicks)
  {
    this.numberOfClicks = numberOfClicks;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_accessed", length = 19)
  public Date getLastAccessed()
  {
    return this.lastAccessed;
  }

  public void setLastAccessed(Date lastAccessed)
  {
    this.lastAccessed = lastAccessed;
  }

  @Column(name = "popularity")
  public Integer getPopularity()
  {
    return this.popularity;
  }

  public void setPopularity(Integer popularity)
  {
    this.popularity = popularity;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  public Date getCreatedDate()
  {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
  }

  @Column(name = "custom1", length = 10)
  public String getCustom1()
  {
    return this.custom1;
  }

  public void setCustom1(String custom1)
  {
    this.custom1 = custom1;
  }

  @Column(name = "custom2", length = 10)
  public String getCustom2()
  {
    return this.custom2;
  }

  public void setCustom2(String custom2)
  {
    this.custom2 = custom2;
  }

  @Column(name = "custom3", length = 10)
  public String getCustom3()
  {
    return this.custom3;
  }

  public void setCustom3(String custom3)
  {
    this.custom3 = custom3;
  }

  @Column(name = "custom4", length = 10)
  public String getCustom4()
  {
    return this.custom4;
  }

  public void setCustom4(String custom4)
  {
    this.custom4 = custom4;
  }
}
