package com.vstar.dao;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="prop_terms_cond"
    ,catalog="property_master"
)
public class PropTermsCond  implements java.io.Serializable {


     private int termCondId;
     private Long annualDues;
     private Long tax;
     private Long fees;
     private String termNcond;
     private Date createdDate;
     private String custom1;
     private String custom2;
     private String custom3;
     private String custom4;
     

    public PropTermsCond() {
    }

	
    public PropTermsCond(int termCondId) {
        this.termCondId = termCondId;
    }
    public PropTermsCond(int termCondId, Long annualDues, Long tax, Long fees, String termNcond, Date createdDate, String custom1, String custom2, String custom3, String custom4) {
       this.termCondId = termCondId;
       this.annualDues = annualDues;
       this.tax = tax;
       this.fees = fees;
       this.termNcond = termNcond;
       this.createdDate = createdDate;
       this.custom1 = custom1;
       this.custom2 = custom2;
       this.custom3 = custom3;
       this.custom4 = custom4;
       
    }
   
    @Id 
    @Column(name="termCondId", unique=true, nullable=false)
    public int getTermCondId() {
        return this.termCondId;
    }
    
    public void setTermCondId(int termCondId) {
        this.termCondId = termCondId;
    }
    
    @Column(name="annualDues", precision=18, scale=0)
    public Long getAnnualDues() {
        return this.annualDues;
    }
    
    public void setAnnualDues(Long annualDues) {
        this.annualDues = annualDues;
    }
    
    @Column(name="tax", precision=18, scale=0)
    public Long getTax() {
        return this.tax;
    }
    
    public void setTax(Long tax) {
        this.tax = tax;
    }
    
    @Column(name="fees", precision=18, scale=0)
    public Long getFees() {
        return this.fees;
    }
    
    public void setFees(Long fees) {
        this.fees = fees;
    }
    
    @Column(name="termNCond", length=50)
    public String getTermNcond() {
        return this.termNcond;
    }
    
    public void setTermNcond(String termNcond) {
        this.termNcond = termNcond;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdDate", length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name="custom1", length=10)
    public String getCustom1() {
        return this.custom1;
    }
    
    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }
    
    @Column(name="custom2", length=10)
    public String getCustom2() {
        return this.custom2;
    }
    
    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }
    
    @Column(name="custom3", length=10)
    public String getCustom3() {
        return this.custom3;
    }
    
    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }
    
    @Column(name="custom4", length=10)
    public String getCustom4() {
        return this.custom4;
    }
    
    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

}


