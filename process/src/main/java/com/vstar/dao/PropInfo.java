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


@Entity
@Table(name="prop_info"
    ,catalog="property_master"
)
public class PropInfo  implements java.io.Serializable {


     private int propInfoId;
     private PropTransaction propTransaction;
     private PropArea propArea;
     private PropFeatures propFeatures;
     private PropPurchaseType propPurchaseType;
     private PropType propType;
     private PropTermsCond propTermsCond;
     private PropPrice propPrice;
     private PropLocation propLocation;
     private Date createdDate;
     private String custom1;
     private String custom2;
     private String custom3;
     private String custom4;
     

    public PropInfo() {
    }

	
   
   
    @Id 
    @Column(name="propInfoId", unique=true, nullable=false)
    public int getPropInfoId() {
        return this.propInfoId;
    }
    
    public void setPropInfoId(int propInfoId) {
        this.propInfoId = propInfoId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="transactionId")
    public PropTransaction getPropTransaction() {
        return this.propTransaction;
    }
    
    public void setPropTransaction(PropTransaction propTransaction) {
        this.propTransaction = propTransaction;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="areaId")
    public PropArea getPropArea() {
        return this.propArea;
    }
    
    public void setPropArea(PropArea propArea) {
        this.propArea = propArea;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="featureId")
    public PropFeatures getPropFeatures() {
        return this.propFeatures;
    }
    
    public void setPropFeatures(PropFeatures propFeatures) {
        this.propFeatures = propFeatures;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="prop_purchase_id")
    public PropPurchaseType getPropPurchaseType() {
        return this.propPurchaseType;
    }
    
    public void setPropPurchaseType(PropPurchaseType propPurchaseType) {
        this.propPurchaseType = propPurchaseType;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="propTypeId")
    public PropType getPropType() {
        return this.propType;
    }
    
    public void setPropType(PropType propType) {
        this.propType = propType;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="termCondId")
    public PropTermsCond getPropTermsCond() {
        return this.propTermsCond;
    }
    
    public void setPropTermsCond(PropTermsCond propTermsCond) {
        this.propTermsCond = propTermsCond;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="salePriceId")
    public PropPrice getPropPrice() {
        return this.propPrice;
    }
    
    public void setPropPrice(PropPrice propPrice) {
        this.propPrice = propPrice;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="locationId")
    public PropLocation getPropLocation() {
        return this.propLocation;
    }
    
    public void setPropLocation(PropLocation propLocation) {
        this.propLocation = propLocation;
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


