package com.vstar.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Property Terms and Conditions
 * 
 */
@Entity
@Table(name = "prop_terms_cond", catalog = "property_master")
public class PropTermsCondDao implements java.io.Serializable
{
  private static final long serialVersionUID = 914284802253705834L;
  @Id
  @Column(name = "prop_term_Cond_Id", unique = true, nullable = false)
  private int propTermCondId;
  @Column(name = "annual_Dues", precision = 18, scale = 0)
  private Long annualDues;
  @Column(name = "tax", precision = 18, scale = 0)
  private Long tax;
  @Column(name = "fees", precision = 18, scale = 0)
  private Long fees;
  @Column(name = "term_N_Cond", length = 50)
  private String termNCond;
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

  public int getPropTermCondId()
  {
    return this.propTermCondId;
  }

  public void setPropTermCondId(int propTermCondId)
  {
    this.propTermCondId = propTermCondId;
  }

  public Long getAnnualDues()
  {
    return this.annualDues;
  }

  public void setAnnualDues(Long annualDues)
  {
    this.annualDues = annualDues;
  }

  public Long getTax()
  {
    return this.tax;
  }

  public void setTax(Long tax)
  {
    this.tax = tax;
  }

  public Long getFees()
  {
    return this.fees;
  }

  public void setFees(Long fees)
  {
    this.fees = fees;
  }

  public String getTermNCond()
  {
    return this.termNCond;
  }

  public void setTermNCond(String termNCond)
  {
    this.termNCond = termNCond;
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
}
