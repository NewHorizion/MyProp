package com.vstar.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Property Location Mapping
 */
@Entity
@Table(name = "prop_location_info", catalog = "property_master")
@GenericGenerator(name = "PropLocationInfo", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
  @Parameter(name = "segment_value", value = "Prop_Location_Info"),
  @Parameter(name = "increment_size", value = "10"),
  @Parameter(name = "optimizer", value = "pooled")})
public class PropLocationInfoDao implements java.io.Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "PropLocationInfo")
  @Column(name = "prop_Location_info_Id", unique = true, nullable = false)
  private Long propLocationInfoId;
  @Column(name = "prop_location_Name", length = 25)
  private String propLocationName;
  @Column(name = "prop_city_Id", nullable = true)
  private Integer propCityDao;
  @Column(name = "prop_location_Id", nullable = true)
  private Long propLocationDao;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_info_Id", nullable = true)
  private PropInfoDao propInfoDao;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_requirement_id", nullable = true)
  private PropRequirementDao propRequirementDao;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  private Date createdDate;
  @Column(name = "prop_address", length = 25)
  private String propAddress;

  public Long getPropLocationInfoId()
  {
    return propLocationInfoId;
  }

  public void setPropLocationInfoId(Long propLocationInfoId)
  {
    this.propLocationInfoId = propLocationInfoId;
  }

  public String getPropLocationName()
  {
    return propLocationName;
  }

  public void setPropLocationName(String propLocationName)
  {
    this.propLocationName = propLocationName;
  }

  public Integer getPropCityDao()
  {
    return propCityDao;
  }

  public void setPropCityDao(Integer propCityDao)
  {
    this.propCityDao = propCityDao;
  }

  public Long getPropLocationDao()
  {
    return propLocationDao;
  }

  public void setPropLocationDao(Long propLocationDao)
  {
    this.propLocationDao = propLocationDao;
  }

  public PropInfoDao getPropInfoDao()
  {
    return propInfoDao;
  }

  public void setPropInfoDao(PropInfoDao propInfoDao)
  {
    this.propInfoDao = propInfoDao;
  }

  public Date getCreatedDate()
  {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
  }

  public String getPropAddress()
  {
    return propAddress;
  }

  public void setPropAddress(String propAddress)
  {
    this.propAddress = propAddress;
  }

  public PropRequirementDao getPropRequirementDao()
  {
    return propRequirementDao;
  }

  public void setPropRequirementDao(PropRequirementDao propRequirementDao)
  {
    this.propRequirementDao = propRequirementDao;
  }

}
