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
@Table(name = "prop_terms_cond", catalog = "property_master")
public class PropTermsCondDao implements java.io.Serializable
{
  private int propTermCondId;
  private Long annualDues;
  private Long tax;
  private Long fees;
  private String termNCond;
  private Date createdDate;
  private String custom1;
  private String custom2;
  private String custom3;
  private String custom4;

  public PropTermsCondDao()
  {
  }

  public PropTermsCondDao(int propTermCondId)
  {
    this.propTermCondId = propTermCondId;
  }

  /**
   * 
   * @param propTermCondId
   * @param annualDues
   * @param tax
   * @param fees
   * @param termNCond
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropTermsCondDao(int propTermCondId, Long annualDues, Long tax, Long fees,
      String termNCond, Date createdDate, String custom1, String custom2, String custom3,
      String custom4)
  {
    this.propTermCondId = propTermCondId;
    this.annualDues = annualDues;
    this.tax = tax;
    this.fees = fees;
    this.termNCond = termNCond;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  @Id
  @Column(name = "prop_term_Cond_Id", unique = true, nullable = false)
  public int getPropTermCondId()
  {
    return this.propTermCondId;
  }

  public void setPropTermCondId(int propTermCondId)
  {
    this.propTermCondId = propTermCondId;
  }

  @Column(name = "annual_Dues", precision = 18, scale = 0)
  public Long getAnnualDues()
  {
    return this.annualDues;
  }

  public void setAnnualDues(Long annualDues)
  {
    this.annualDues = annualDues;
  }

  @Column(name = "tax", precision = 18, scale = 0)
  public Long getTax()
  {
    return this.tax;
  }

  public void setTax(Long tax)
  {
    this.tax = tax;
  }

  @Column(name = "fees", precision = 18, scale = 0)
  public Long getFees()
  {
    return this.fees;
  }

  public void setFees(Long fees)
  {
    this.fees = fees;
  }

  @Column(name = "term_N_Cond", length = 50)
  public String getTermNCond()
  {
    return this.termNCond;
  }

  public void setTermNCond(String termNCond)
  {
    this.termNCond = termNCond;
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
