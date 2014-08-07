package com.vstar.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author upendra.kumar
 * 
 */
@Entity
@Table(name = "prop_location", catalog = "property_master")
public class PropLocationDao implements java.io.Serializable
{
  private int propLocationId;
  private String localityName;
  private Integer propCityId;
  private Date createdDate;
  private String custom1;
  private String custom2;
  private String custom3;
  private String custom4;

  public PropLocationDao()
  {
  }

  public PropLocationDao(int propLocationId)
  {
    this.propLocationId = propLocationId;
  }

  public PropLocationDao(int propLocationId, String localityName, Integer propCityId,
      Date createdDate, String custom1, String custom2, String custom3, String custom4)
  {
    this.propLocationId = propLocationId;
    this.localityName = localityName;
    this.propCityId = propCityId;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  @Id
  @Column(name = "prop_Location_Id", unique = true, nullable = false)
  public int getPropLocationId()
  {
    return this.propLocationId;
  }

  public void setPropLocationId(int propLocationId)
  {
    this.propLocationId = propLocationId;
  }

  @Column(name = "locality_Name", length = 25)
  public String getLocalityName()
  {
    return this.localityName;
  }

  public void setLocalityName(String localityName)
  {
    this.localityName = localityName;
  }

  @Column(name = "prop_City_Id")
  public Integer getPropCityId()
  {
    return this.propCityId;
  }

  public void setPropCityId(Integer propCityId)
  {
    this.propCityId = propCityId;
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
