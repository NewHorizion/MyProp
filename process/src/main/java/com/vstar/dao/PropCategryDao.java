package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Property Categories
 * 
 */
@Entity
@Table(name = "prop_categry", catalog = "property_master")
public class PropCategryDao implements java.io.Serializable
{
  private static final long serialVersionUID = -76485736005477641L;
  @Id
  @Column(name = "categry_id", unique = true, nullable = false)
  private int categryId;
  @Column(name = "categry_type", nullable = false, length = 30)
  private String categryType;

  public PropCategryDao()
  {
  }

  /**
   * 
   * @param categryId
   * @param categryType
   */
  public PropCategryDao(int categryId, String categryType)
  {
    this.categryId = categryId;
    this.categryType = categryType;
  }

  public int getCategryId()
  {
    return this.categryId;
  }

  public void setCategryId(int categryId)
  {
    this.categryId = categryId;
  }

  public String getCategryType()
  {
    return this.categryType;
  }

  public void setCategryType(String categryType)
  {
    this.categryType = categryType;
  }
}
