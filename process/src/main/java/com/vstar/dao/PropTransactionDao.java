package com.vstar.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author upendra.kumar
 * 
 */
@Entity
@Table(name = "prop_transaction", catalog = "property_master")
public class PropTransactionDao implements java.io.Serializable
{
  private int propTransactionId;
  private String transactionType;
  private String possessionStatus;
  private Date availableFrom;
  private Date createdDate;
  private String custom1;
  private String custom2;
  private String custom3;
  private String custom4;

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
      Date availableFrom, Date createdDate, String custom1, String custom2, String custom3,
      String custom4)
  {
    this.propTransactionId = propTransactionId;
    this.transactionType = transactionType;
    this.possessionStatus = possessionStatus;
    this.availableFrom = availableFrom;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  @Id
  @Column(name = "prop_transaction_Id", unique = true, nullable = false)
  public int getPropTransactionId()
  {
    return this.propTransactionId;
  }

  public void setPropTransactionId(int propTransactionId)
  {
    this.propTransactionId = propTransactionId;
  }

  @Column(name = "transaction_Type", length = 15)
  public String getTransactionType()
  {
    return this.transactionType;
  }

  public void setTransactionType(String transactionType)
  {
    this.transactionType = transactionType;
  }

  @Column(name = "possession_Status", length = 15)
  public String getPossessionStatus()
  {
    return this.possessionStatus;
  }

  public void setPossessionStatus(String possessionStatus)
  {
    this.possessionStatus = possessionStatus;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "available_From", length = 19)
  public Date getAvailableFrom()
  {
    return this.availableFrom;
  }

  public void setAvailableFrom(Date availableFrom)
  {
    this.availableFrom = availableFrom;
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
