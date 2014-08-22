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
 * State Information
 * 
 */
@Entity
@Table(name = "prop_state", catalog = "property_master")
public class PropStateDao implements java.io.Serializable
{
  private static final long serialVersionUID = 3942227844296108153L;
  @Id
  @Column(name = "prop_state_Id", unique = true, nullable = false)
  private long propStateId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_country_Id")
  private PropCountryDao propCountry;
  @Column(name = "state_Name", length = 50)
  private String stateName;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  private Date createdDate;

  public PropStateDao()
  {
  }

  public PropStateDao(long propStateId)
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
  public PropStateDao(long propStateId, PropCountryDao propCountry, String stateName,
      Date createdDate)
  {
    this.propStateId = propStateId;
    this.propCountry = propCountry;
    this.stateName = stateName;
    this.createdDate = createdDate;
  }

  public long getPropStateId()
  {
    return this.propStateId;
  }

  public void setPropStateId(long propStateId)
  {
    this.propStateId = propStateId;
  }

  public PropCountryDao getPropCountry()
  {
    return this.propCountry;
  }

  public void setPropCountry(PropCountryDao propCountry)
  {
    this.propCountry = propCountry;
  }

  public String getStateName()
  {
    return this.stateName;
  }

  public void setStateName(String stateName)
  {
    this.stateName = stateName;
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
