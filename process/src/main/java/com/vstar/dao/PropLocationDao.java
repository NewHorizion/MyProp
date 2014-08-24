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
 * Property Location Info
 * 
 */
@Entity
@Table(name = "prop_location", catalog = "property_master")
public class PropLocationDao implements java.io.Serializable
{
  private static final long serialVersionUID = 4135668551140108761L;
  @Id
  @Column(name = "prop_Location_Id", unique = true, nullable = false)
  private Long propLocationId;
  @Column(name = "locality_Name", length = 25)
  private String localityName;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_city_Id")
  private PropCityDao propCityDao;
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
 
  public PropLocationDao ()
  {
	  
  }

  public PropLocationDao(long propLocationId, String localityName, PropCityDao propCityDao,
      Date createdDate, String custom1, String custom2, String custom3, String custom4)
  {
    this.propLocationId = propLocationId;
    this.localityName = localityName;
    this.propCityDao = propCityDao;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  public long getPropLocationId()
  {
    return this.propLocationId;
  }

  public void setPropLocationId(long propLocationId)
  {
    this.propLocationId = propLocationId;
  }

  public String getLocalityName()
  {
    return this.localityName;
  }

  public void setLocalityName(String localityName)
  {
    this.localityName = localityName;
  }

  public PropCityDao getPropCityDao() 
  {
	return propCityDao;
  }

  public void setPropCityDao(PropCityDao propCityDao) 
  {
	this.propCityDao = propCityDao;
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

public void setPropLocationId(Long propLocationId) {
	this.propLocationId = propLocationId;
}
}
