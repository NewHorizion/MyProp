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
@Table(name = "prop_price", catalog = "property_master")
public class PropPriceDao implements java.io.Serializable
{
  private int propSalePriceId;
  private Long expectedPrice;
  private Long pricePerSqrFt;
  private Date createdDate;
  private String custom1;
  private String custom2;
  private String custom3;
  private String custom4;

  public PropPriceDao()
  {
  }

  public PropPriceDao(int propSalePriceId)
  {
    this.propSalePriceId = propSalePriceId;
  }

  /**
   * 
   * @param propSalePriceId
   * @param expectedPrice
   * @param pricePerSqrFt
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropPriceDao(int propSalePriceId, Long expectedPrice, Long pricePerSqrFt,
      Date createdDate, String custom1, String custom2, String custom3, String custom4)
  {
    this.propSalePriceId = propSalePriceId;
    this.expectedPrice = expectedPrice;
    this.pricePerSqrFt = pricePerSqrFt;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  @Id
  @Column(name = "prop_sale_Price_Id", unique = true, nullable = false)
  public int getPropSalePriceId()
  {
    return this.propSalePriceId;
  }

  public void setPropSalePriceId(int propSalePriceId)
  {
    this.propSalePriceId = propSalePriceId;
  }

  @Column(name = "expected_Price", precision = 18, scale = 0)
  public Long getExpectedPrice()
  {
    return this.expectedPrice;
  }

  public void setExpectedPrice(Long expectedPrice)
  {
    this.expectedPrice = expectedPrice;
  }

  @Column(name = "price_Per_Sqr_Ft", precision = 18, scale = 0)
  public Long getPricePerSqrFt()
  {
    return this.pricePerSqrFt;
  }

  public void setPricePerSqrFt(Long pricePerSqrFt)
  {
    this.pricePerSqrFt = pricePerSqrFt;
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
