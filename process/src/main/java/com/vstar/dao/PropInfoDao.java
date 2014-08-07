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
@Table(name = "prop_info", catalog = "property_master")
public class PropInfoDao implements java.io.Serializable
{
  private int propInfoId;
  private PropPriceDao propPrice;
  private PropTermsCondDao propTermsCond;
  private PropLocationDao propLocation;
  private PropPurchaseTypeDao propPurchaseType;
  private PropFeaturesDao propFeatures;
  private PropAreaDao propArea;
  private PropTypeDao propType;
  private PropTransactionDao propTransaction;
  private String societyProject;
  private Date createdDate;
  private String custom1;
  private String custom2;
  private String custom3;
  private String custom4;

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
   * @param societyProject
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropInfoDao(int propInfoId, PropPriceDao propPrice, PropTermsCondDao propTermsCond,
      PropLocationDao propLocation, PropPurchaseTypeDao propPurchaseType,
      PropFeaturesDao propFeatures, PropAreaDao propArea, PropTypeDao propType,
      PropTransactionDao propTransaction, String societyProject, Date createdDate, String custom1,
      String custom2, String custom3, String custom4)
  {
    this.propInfoId = propInfoId;
    this.propPrice = propPrice;
    this.propTermsCond = propTermsCond;
    this.propLocation = propLocation;
    this.propPurchaseType = propPurchaseType;
    this.propFeatures = propFeatures;
    this.propArea = propArea;
    this.propType = propType;
    this.propTransaction = propTransaction;
    this.societyProject = societyProject;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  @Id
  @Column(name = "prop_Info_Id", unique = true, nullable = false)
  public int getPropInfoId()
  {
    return this.propInfoId;
  }

  public void setPropInfoId(int propInfoId)
  {
    this.propInfoId = propInfoId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_sale_Price_Id")
  public PropPriceDao getPropPrice()
  {
    return this.propPrice;
  }

  public void setPropPrice(PropPriceDao propPrice)
  {
    this.propPrice = propPrice;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_term_Cond_Id")
  public PropTermsCondDao getPropTermsCond()
  {
    return this.propTermsCond;
  }

  public void setPropTermsCond(PropTermsCondDao propTermsCond)
  {
    this.propTermsCond = propTermsCond;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_location_Id")
  public PropLocationDao getPropLocation()
  {
    return this.propLocation;
  }

  public void setPropLocation(PropLocationDao propLocation)
  {
    this.propLocation = propLocation;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_purchase_id")
  public PropPurchaseTypeDao getPropPurchaseType()
  {
    return this.propPurchaseType;
  }

  public void setPropPurchaseType(PropPurchaseTypeDao propPurchaseType)
  {
    this.propPurchaseType = propPurchaseType;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_feature_Id")
  public PropFeaturesDao getPropFeatures()
  {
    return this.propFeatures;
  }

  public void setPropFeatures(PropFeaturesDao propFeatures)
  {
    this.propFeatures = propFeatures;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_area_Id")
  public PropAreaDao getPropArea()
  {
    return this.propArea;
  }

  public void setPropArea(PropAreaDao propArea)
  {
    this.propArea = propArea;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_Type_Id")
  public PropTypeDao getPropType()
  {
    return this.propType;
  }

  public void setPropType(PropTypeDao propType)
  {
    this.propType = propType;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_transaction_Id")
  public PropTransactionDao getPropTransaction()
  {
    return this.propTransaction;
  }

  public void setPropTransaction(PropTransactionDao propTransaction)
  {
    this.propTransaction = propTransaction;
  }

  @Column(name = "society_Project", length = 20)
  public String getSocietyProject()
  {
    return this.societyProject;
  }

  public void setSocietyProject(String societyProject)
  {
    this.societyProject = societyProject;
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

  @Column(name = "custom1", length = 10)
  public String getCustom1()
  {
    return this.custom1;
  }

  public void setCustom1(String custom1)
  {
    this.custom1 = custom1;
  }

  @Column(name = "custom2", length = 10)
  public String getCustom2()
  {
    return this.custom2;
  }

  public void setCustom2(String custom2)
  {
    this.custom2 = custom2;
  }

  @Column(name = "custom3", length = 10)
  public String getCustom3()
  {
    return this.custom3;
  }

  public void setCustom3(String custom3)
  {
    this.custom3 = custom3;
  }

  @Column(name = "custom4", length = 10)
  public String getCustom4()
  {
    return this.custom4;
  }

  public void setCustom4(String custom4)
  {
    this.custom4 = custom4;
  }
}
