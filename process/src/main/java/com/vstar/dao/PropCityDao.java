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

@Entity
@Table(name = "prop_city", catalog = "property_master")
public class PropCityDao implements java.io.Serializable
{
  private int propCityId;
  private PropStateDao propState;
  private String cityName;
  private Date createdDate;

  public PropCityDao()
  {
  }

  public PropCityDao(int propCityId)
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
  public PropCityDao(int propCityId, PropStateDao propState, String cityName, Date createdDate)
  {
    this.propCityId = propCityId;
    this.propState = propState;
    this.cityName = cityName;
    this.createdDate = createdDate;
  }

  @Id
  @Column(name = "prop_City_Id", unique = true, nullable = false)
  public int getPropCityId()
  {
    return this.propCityId;
  }

  public void setPropCityId(int propCityId)
  {
    this.propCityId = propCityId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_state_Id")
  public PropStateDao getPropState()
  {
    return this.propState;
  }

  public void setPropState(PropStateDao propState)
  {
    this.propState = propState;
  }

  @Column(name = "city_Name", length = 50)
  public String getCityName()
  {
    return this.cityName;
  }

  public void setCityName(String cityName)
  {
    this.cityName = cityName;
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
}
