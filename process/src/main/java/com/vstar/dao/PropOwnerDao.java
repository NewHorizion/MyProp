package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Property Owner Mapping table
 */
@Entity
@Table(name = "prop_owner", catalog = "property_master")
@GenericGenerator(name = "PropOwnerInfo", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
    @Parameter(name = "segment_value", value = "Prop_Owner"),
    @Parameter(name = "increment_size", value = "10"),
    @Parameter(name = "optimizer", value = "pooled")})
public class PropOwnerDao implements java.io.Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "PropOwnerInfo")
  @Column(name = "prop_owner_id", unique = true, nullable = false)
  private int propOwnerId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_info_id", nullable = false)
  private PropInfoDao propInfoDao;
  @Column(name = "username", nullable = false)
  private String userName;

  public int getPropOwnerId()
  {
    return propOwnerId;
  }

  public void setPropOwnerId(int propOwnerId)
  {
    this.propOwnerId = propOwnerId;
  }

  public PropInfoDao getPropInfoDao()
  {
    return propInfoDao;
  }

  public void setPropInfoDao(PropInfoDao propInfoDao)
  {
    this.propInfoDao = propInfoDao;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }
}
