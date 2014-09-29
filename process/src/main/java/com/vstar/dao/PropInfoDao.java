package com.vstar.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Property Details
 *
 */
@Entity
@Table(name = "prop_info", catalog = "property_master")
@GenericGenerator(name = "PropMasterInfo", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
  @Parameter(name = "segment_value", value = "Prop_Master_Info"),
  @Parameter(name = "increment_size", value = "10"),
  @Parameter(name = "optimizer", value = "pooled")})
public class PropInfoDao implements java.io.Serializable
{
  private static final long serialVersionUID = -2945416505526136789L;
  @Id
  @GeneratedValue(generator = "PropMasterInfo")
  @Column(name = "prop_Info_Id", unique = true, nullable = false)
  private int propInfoId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_sale_Price_Id")
  private PropPriceDao propPrice;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_term_Cond_Id", nullable = true)
  private PropTermsCondDao propTermsCond;
  @Column(name = "prop_purchase_id")
  private Integer propPurchaseType;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_feature_Id", nullable = true)
  private PropFeaturesDao propFeatures;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_area_Id")
  private PropAreaDao propArea;
  @Column(name = "prop_Type_Id")
  private Integer propType;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_transaction_Id", nullable = true)
  private PropTransactionDao propTransaction;
  @Column(name = "transaction_type", length = 20)
  private String transactionType;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  private Date createdDate;
  @Column(name = "custom1", length = 10)
  private String custom1;
  @Column(name = "custom2", length = 10)
  private String custom2;
  @Column(name = "custom3", length = 10)
  private String custom3;
  @Column(name = "custom4", length = 10)
  private String custom4;
  @Column(name = "negotiable", length = 15)
  private String negotiable;
  

  public PropInfoDao()
  {
  }

  public PropInfoDao(int propInfoId)
  {
    this.propInfoId = propInfoId;
  }

  /**
   * 
   * @param propInfoId
   * @param propPrice
   * @param propTermsCond
   * @param propLocation
   * @param propPurchaseType
   * @param propFeatures
   * @param propArea
   * @param propType
   * @param propTransaction
   * @param transactionType
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropInfoDao(int propInfoId, PropPriceDao propPrice, PropTermsCondDao propTermsCond,
      Integer propPurchaseType, PropFeaturesDao propFeatures, PropAreaDao propArea, Integer propType,
      PropTransactionDao propTransaction, String transactionType, String negotiable, Date createdDate, String custom1,
      String custom2, String custom3, String custom4)
  {
    this.propInfoId = propInfoId;
    this.propPrice = propPrice;
    this.propTermsCond = propTermsCond;
    this.propPurchaseType = propPurchaseType;
    this.propFeatures = propFeatures;
    this.propArea = propArea;
    this.propType = propType;
    this.propTransaction = propTransaction;
    this.transactionType = transactionType;
    this.createdDate = createdDate;
    this.negotiable=negotiable;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  public int getPropInfoId()
  {
    return this.propInfoId;
  }

  public void setPropInfoId(int propInfoId)
  {
    this.propInfoId = propInfoId;
  }

  public PropPriceDao getPropPrice()
  {
    return this.propPrice;
  }

  public void setPropPrice(PropPriceDao propPrice)
  {
    this.propPrice = propPrice;
  }

  public PropTermsCondDao getPropTermsCond()
  {
    return this.propTermsCond;
  }

  public void setPropTermsCond(PropTermsCondDao propTermsCond)
  {
    this.propTermsCond = propTermsCond;
  }

  public Integer getPropPurchaseType()
  {
    return this.propPurchaseType;
  }

  public void setPropPurchaseType(Integer propPurchaseType)
  {
    this.propPurchaseType = propPurchaseType;
  }

  public PropFeaturesDao getPropFeatures()
  {
    return this.propFeatures;
  }

  public void setPropFeatures(PropFeaturesDao propFeatures)
  {
    this.propFeatures = propFeatures;
  }

  public PropAreaDao getPropArea()
  {
    return this.propArea;
  }

  public void setPropArea(PropAreaDao propArea)
  {
    this.propArea = propArea;
  }

  public Integer getPropType()
  {
    return this.propType;
  }

  public void setPropType(Integer propType)
  {
    this.propType = propType;
  }

  public PropTransactionDao getPropTransaction()
  {
    return this.propTransaction;
  }

  public void setPropTransaction(PropTransactionDao propTransaction)
  {
    this.propTransaction = propTransaction;
  }

  public Date getCreatedDate()
  {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
  }

  public String getCustom1()
  {
    return this.custom1;
  }

  public void setCustom1(String custom1)
  {
    this.custom1 = custom1;
  }

  public String getCustom2()
  {
    return this.custom2;
  }

  public void setCustom2(String custom2)
  {
    this.custom2 = custom2;
  }

  public String getCustom3()
  {
    return this.custom3;
  }

  public void setCustom3(String custom3)
  {
    this.custom3 = custom3;
  }

  public String getCustom4()
  {
    return this.custom4;
  }

  public void setCustom4(String custom4)
  {
    this.custom4 = custom4;
  }

  public String getTransactionType()
  {
    return transactionType;
  }

  public void setTransactionType(String transactionType)
  {
    this.transactionType = transactionType;
  }

/**
 * @return the negotiable
 */
public String getNegotiable() {
	return negotiable;
}

/**
 * @param negotiable the negotiable to set
 */
public void setNegotiable(String negotiable) {
	this.negotiable = negotiable;
}
  
}
