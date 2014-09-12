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
 * Requirement & Property Type Mapping table
 */
@Entity
@Table(name = "req_prop_type", catalog = "property_master")
@GenericGenerator(name = "ReqPropTypeInfo", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
    @Parameter(name = "segment_value", value = "Prop_Req_Prop_Info"),
    @Parameter(name = "increment_size", value = "10"),
    @Parameter(name = "optimizer", value = "pooled")})
public class ReqPropTypeDao implements java.io.Serializable
{
  private static final long serialVersionUID = -1377011156147399065L;
  @Id
  @GeneratedValue(generator = "ReqPropTypeInfo")
  @Column(name = "req_prop_type_Id", unique = true, nullable = false)
  private int reqPropTypeId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_requirement_Id")
  private PropRequirementDao propRequirementDao;
  @Column(name = "prop_type_id")
  private Integer propTypeId;

  public int getReqPropTypeId()
  {
    return reqPropTypeId;
  }

  public void setReqPropTypeId(int reqPropTypeId)
  {
    this.reqPropTypeId = reqPropTypeId;
  }

  public PropRequirementDao getPropRequirementDao()
  {
    return propRequirementDao;
  }

  public void setPropRequirementDao(PropRequirementDao propRequirementDao)
  {
    this.propRequirementDao = propRequirementDao;
  }

  public Integer getPropTypeId()
  {
    return propTypeId;
  }

  public void setPropTypeId(Integer propTypeId)
  {
    this.propTypeId = propTypeId;
  }

}
