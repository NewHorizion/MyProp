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
@Table(name = "prop_state", catalog = "property_master")
public class PropStateDao implements java.io.Serializable
{
  private int propStateId;
  private PropCountryDao propCountry;
  private String stateName;
  private Date createdDate;

  public PropStateDao()
  {
  }

  public PropStateDao(int propStateId)
  {
    this.propStateId = propStateId;
  }

  /**
   * 
   * @param propStateId
   * @param propCountry
   * @param stateName
   * @param createdDate
   */
  public PropStateDao(int propStateId, PropCountryDao propCountry, String stateName,
      Date createdDate)
  {
    this.propStateId = propStateId;
    this.propCountry = propCountry;
    this.stateName = stateName;
    this.createdDate = createdDate;
  }

  @Id
  @Column(name = "prop_state_Id", unique = true, nullable = false)
  public int getPropStateId()
  {
    return this.propStateId;
  }

  public void setPropStateId(int propStateId)
  {
    this.propStateId = propStateId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_country_Id")
  public PropCountryDao getPropCountry()
  {
    return this.propCountry;
  }

  public void setPropCountry(PropCountryDao propCountry)
  {
    this.propCountry = propCountry;
  }

  @Column(name = "state_Name", length = 50)
  public String getStateName()
  {
    return this.stateName;
  }

  public void setStateName(String stateName)
  {
    this.stateName = stateName;
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
