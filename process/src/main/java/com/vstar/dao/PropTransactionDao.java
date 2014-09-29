package com.vstar.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Property Transaction details
 * 
 */
@Entity
@Table(name = "prop_transaction", catalog = "property_master")
public class PropTransactionDao implements java.io.Serializable
{
  private static final long serialVersionUID = 1140634619377853385L;
  @Id
  @Column(name = "prop_transaction_Id", unique = true, nullable = false)
  private int propTransactionId;
  @Column(name = "society_project", length = 20)
  private String transactionType;
  @Column(name = "possession_Status", length = 15)
  private String possessionStatus;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "available_From", length = 19)
  private Date availableFrom;
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
  @Column(name = "builderSociety", length = 45)
  private String builderSociety;

  public PropTransactionDao()
  {
  }

  public PropTransactionDao(int propTransactionId)
  {
    this.propTransactionId = propTransactionId;
  }

  /**
   * 
   * @param propTransactionId
   * @param transactionType
   * @param possessionStatus
   * @param availableFrom
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropTransactionDao(int propTransactionId, String transactionType, String possessionStatus,
      Date availableFrom, String builderSociety, Date createdDate, String custom1, String custom2, String custom3,
      String custom4)
  {
    this.propTransactionId = propTransactionId;
    this.transactionType = transactionType;
    this.possessionStatus = possessionStatus;
    this.availableFrom = availableFrom;
    this.builderSociety = builderSociety;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  public int getPropTransactionId()
  {
    return this.propTransactionId;
  }

  public void setPropTransactionId(int propTransactionId)
  {
    this.propTransactionId = propTransactionId;
  }

  public String getTransactionType()
  {
    return this.transactionType;
  }

  public void setTransactionType(String transactionType)
  {
    this.transactionType = transactionType;
  }

  public String getPossessionStatus()
  {
    return this.possessionStatus;
  }

  public void setPossessionStatus(String possessionStatus)
  {
    this.possessionStatus = possessionStatus;
  }

  public Date getAvailableFrom()
  {
    return this.availableFrom;
  }

  public void setAvailableFrom(Date availableFrom)
  {
    this.availableFrom = availableFrom;
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

/**
 * @return the builderSociety
 */
public String getBuilderSociety() {
	return builderSociety;
}

/**
 * @param builderSociety the builderSociety to set
 */
public void setBuilderSociety(String builderSociety) {
	this.builderSociety = builderSociety;
}
  
}
