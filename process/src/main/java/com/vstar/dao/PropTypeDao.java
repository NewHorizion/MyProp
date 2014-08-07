package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author upendra.kumar
 * 
 */
@Entity
@Table(name = "prop_type", catalog = "property_master")
public class PropTypeDao implements java.io.Serializable
{
  private int propTypeId;
  private PropCategryDao propCategry;
  private String typeDesc;

  public PropTypeDao()
  {
  }

  public PropTypeDao(int propTypeId)
  {
    this.propTypeId = propTypeId;
  }

  /**
   * 
   * @param propTypeId
   * @param propCategry
   * @param typeDesc
   */
  public PropTypeDao(int propTypeId, PropCategryDao propCategry, String typeDesc)
  {
    this.propTypeId = propTypeId;
    this.propCategry = propCategry;
    this.typeDesc = typeDesc;
  }

  @Id
  @Column(name = "prop_Type_Id", unique = true, nullable = false)
  public int getPropTypeId()
  {
    return this.propTypeId;
  }

  public void setPropTypeId(int propTypeId)
  {
    this.propTypeId = propTypeId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categry_id")
  public PropCategryDao getPropCategry()
  {
    return this.propCategry;
  }

  public void setPropCategry(PropCategryDao propCategry)
  {
    this.propCategry = propCategry;
  }

  @Column(name = "type_Desc", length = 30)
  public String getTypeDesc()
  {
    return this.typeDesc;
  }

  public void setTypeDesc(String typeDesc)
  {
    this.typeDesc = typeDesc;
  }
}
