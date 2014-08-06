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
@Table(name="prop_image"
    ,catalog="property_master"
)
public class PropImage  implements java.io.Serializable {


     private int propImageId;
     private PropInfo propInfo;
     private String image;
     private String description;
     private Integer propInfoId;
     private Date createdDate;
     private String custom1;
     private String custom2;
     private String custom3;
     private String custom4;

    public PropImage() {
    }

	
   
    @Id 
    @Column(name="propImageId", unique=true, nullable=false)
    public int getPropImageId() {
        return this.propImageId;
    }
    
    public void setPropImageId(int propImageId) {
        this.propImageId = propImageId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="propImageId", unique=true, nullable=false, insertable=false, updatable=false)
    public PropInfo getPropInfo() {
        return this.propInfo;
    }
    
    public void setPropInfo(PropInfo propInfo) {
        this.propInfo = propInfo;
    }
    
    @Column(name="image", length=20)
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    @Column(name="description", length=50)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="propInfoId")
    public Integer getPropInfoId() {
        return this.propInfoId;
    }
    
    public void setPropInfoId(Integer propInfoId) {
        this.propInfoId = propInfoId;
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


