package com.vstar.dao;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="prop_area"
    ,catalog="property_master"
)
public class PropArea  implements java.io.Serializable {


     private int areaId;
     private Integer coveredArea;
     private String measurement;
     private Integer plotArea;
     private Integer landArea;
     private Date createdDate;
     private String custom1;
     private String custom2;
     private String custom3;
     private String custom4;


    public PropArea() {
    }
   
    @Id 
    @Column(name="areaId", unique=true, nullable=false)
    public int getAreaId() {
        return this.areaId;
    }
    
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    
    @Column(name="coveredArea")
    public Integer getCoveredArea() {
        return this.coveredArea;
    }
    
    public void setCoveredArea(Integer coveredArea) {
        this.coveredArea = coveredArea;
    }
    
    @Column(name="measurement", length=6)
    public String getMeasurement() {
        return this.measurement;
    }
    
    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
    
    @Column(name="plotArea")
    public Integer getPlotArea() {
        return this.plotArea;
    }
    
    public void setPlotArea(Integer plotArea) {
        this.plotArea = plotArea;
    }
    
    @Column(name="landArea")
    public Integer getLandArea() {
        return this.landArea;
    }
    
    public void setLandArea(Integer landArea) {
        this.landArea = landArea;
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


