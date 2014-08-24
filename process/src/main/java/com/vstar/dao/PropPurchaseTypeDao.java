package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Property Purchase Type
 * Rent/Sale
 *
 */
@Entity
@Table(name = "prop_purchase_type", catalog = "property_master")
public class PropPurchaseTypeDao implements java.io.Serializable
{
  private static final long serialVersionUID = -8870123891198504897L;
  @Id
  @Column(name = "prop_purchase_id", unique = true, nullable = false)
  private Long propPurchaseId;
  @Column(name = "prop_purchase_desc", nullable = false, length = 20)
  private String propPurchaseDesc;

  public PropPurchaseTypeDao()
  {
  }

  public PropPurchaseTypeDao(Long propPurchaseId, String propPurchaseDesc)
  {
    this.propPurchaseId = propPurchaseId;
    this.propPurchaseDesc = propPurchaseDesc;
  }


  public String getPropPurchaseDesc()
  {
    return this.propPurchaseDesc;
  }

  public void setPropPurchaseDesc(String propPurchaseDesc)
  {
    this.propPurchaseDesc = propPurchaseDesc;
  }

public Long getPropPurchaseId() {
	return propPurchaseId;
}

public void setPropPurchaseId(Long propPurchaseId) {
	this.propPurchaseId = propPurchaseId;
}
}
