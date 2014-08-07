package com.vstar.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Country Information
 *
 */
@Entity
@Table(name = "prop_country", catalog = "property_master")
public class PropCountryDao implements java.io.Serializable
{
  private static final long serialVersionUID = 7422788475417443480L;
  @Id
  @Column(name = "prop_country_Id", unique = true, nullable = false)
  private int propCountryId;
  @Column(name = "country_Name", length = 50)
  private String countryName;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  private Date createdDate;

  public PropCountryDao()
  {
  }

  public PropCountryDao(int propCountryId)
  {
    this.propCountryId = propCountryId;
  }

  public PropCountryDao(int propCountryId, String countryName, Date createdDate)
  {
    this.propCountryId = propCountryId;
    this.countryName = countryName;
    this.createdDate = createdDate;
  }

  public int getPropCountryId()
  {
    return this.propCountryId;
  }

  public void setPropCountryId(int propCountryId)
  {
    this.propCountryId = propCountryId;
  }

  public String getCountryName()
  {
    return this.countryName;
  }

  public void setCountryName(String countryName)
  {
    this.countryName = countryName;
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
