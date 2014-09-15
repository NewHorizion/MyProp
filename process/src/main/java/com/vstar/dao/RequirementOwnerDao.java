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
@Table(name = "requirement_owner", catalog = "property_master")
@GenericGenerator(name = "RequirementOwnerInfo", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
    @Parameter(name = "segment_value", value = "Requirement_Owner"),
    @Parameter(name = "increment_size", value = "10"),
    @Parameter(name = "optimizer", value = "pooled")})
public class RequirementOwnerDao implements java.io.Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "RequirementOwnerInfo")
  @Column(name = "requirement_owner_id", unique = true, nullable = false)
  private int requirementOwnerId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_requirement_id", nullable = false)
  private PropRequirementDao propRequirementDao;
  @Column(name = "username", nullable = false)
  private String userName;

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  public int getRequirementOwnerId()
  {
    return requirementOwnerId;
  }

  public void setRequirementOwnerId(int requirementOwnerId)
  {
    this.requirementOwnerId = requirementOwnerId;
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
