package com.vstar.dao;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="prop_transaction"
    ,catalog="property_master"
)
public class PropTransaction  implements java.io.Serializable {


     private int transactionId;
     private String transactionType;
     private String possessionStatus;
     private Date availableFrom;
     private Date createdDate;
     private String custom1;
     private String custom2;
     private String custom3;
     private String custom4;
     

    public PropTransaction() {
    }

	
   
   
    @Id 
    @Column(name="transactionId", unique=true, nullable=false)
    public int getTransactionId() {
        return this.transactionId;
    }
    
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    
    @Column(name="transactionType", length=15)
    public String getTransactionType() {
        return this.transactionType;
    }
    
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    @Column(name="possessionStatus", length=15)
    public String getPossessionStatus() {
        return this.possessionStatus;
    }
    
    public void setPossessionStatus(String possessionStatus) {
        this.possessionStatus = possessionStatus;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="availableFrom", length=19)
    public Date getAvailableFrom() {
        return this.availableFrom;
    }
    
    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
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


