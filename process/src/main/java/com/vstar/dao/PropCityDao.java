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
 * City Information
 *
 */
@Entity
@Table(name = "prop_city", catalog = "property_master")
public class PropCityDao implements java.io.Serializable
{
  private static final long serialVersionUID = -6770999383173196275L;
  @Id
  @Column(name = "prop_City_Id", unique = true, nullable = false)
  private long propCityId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_state_Id")
  private PropStateDao propState;
  @Column(name = "city_Name", length = 50)
  private String cityName;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  private Date createdDate;

  public PropCityDao()
  {
  }

  public PropCityDao(long propCityId)
  {
    this.propCityId = propCityId;
  }

  /**
   * 
   * @param propCityId
   * @param propState
   * @param cityName
   * @param createdDate
   */
  public PropCityDao(long propCityId, PropStateDao propState, String cityName, Date createdDate)
  {
    this.propCityId = propCityId;
    this.propState = propState;
    this.cityName = cityName;
    this.createdDate = createdDate;
  }

  public long getPropCityId()
  {
    return this.propCityId;
  }

  public void setPropCityId(long propCityId)
  {
    this.propCityId = propCityId;
  }

  public PropStateDao getPropState()
  {
    return this.propState;
  }

  public void setPropState(PropStateDao propState)
  {
    this.propState = propState;
  }

  public String getCityName()
  {
    return this.cityName;
  }

  public void setCityName(String cityName)
  {
    this.cityName = cityName;
  }

  public Date getCreatedDate()
  {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
  }
}
