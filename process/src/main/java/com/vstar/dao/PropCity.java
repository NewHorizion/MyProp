package com.vstar.dao;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="prop_city"
    ,catalog="property_master"
)
public class PropCity  implements java.io.Serializable {


     private int propCityId;
     private String cityName;
     private Date createdDate;
     private String custom1;
     private String custom2;
     private String custom3;
     private String custom4;


    public PropCity() {
    }

	
   
   
    @Id 
    @Column(name="propCityId", unique=true, nullable=false)
    public int getPropCityId() {
        return this.propCityId;
    }
    
    public void setPropCityId(int propCityId) {
        this.propCityId = propCityId;
    }
    
    @Column(name="cityName", length=20)
    public String getCityName() {
        return this.cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
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


