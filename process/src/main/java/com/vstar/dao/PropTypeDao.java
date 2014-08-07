package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Property Types like Residential Plot/Flat
 * 
 */
@Entity
@Table(name = "prop_type", catalog = "property_master")
public class PropTypeDao implements java.io.Serializable
{
  private static final long serialVersionUID = -6261006342019880313L;
  @Id
  @Column(name = "prop_Type_Id", unique = true, nullable = false)
  private int propTypeId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categry_id")
  private PropCategryDao propCategry;
  @Column(name = "type_Desc", length = 30)
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

  public int getPropTypeId()
  {
    return this.propTypeId;
  }

  public void setPropTypeId(int propTypeId)
  {
    this.propTypeId = propTypeId;
  }

  public PropCategryDao getPropCategry()
  {
    return this.propCategry;
  }

  public void setPropCategry(PropCategryDao propCategry)
  {
    this.propCategry = propCategry;
  }

  public String getTypeDesc()
  {
    return this.typeDesc;
  }

  public void setTypeDesc(String typeDesc)
  {
    this.typeDesc = typeDesc;
  }
}
