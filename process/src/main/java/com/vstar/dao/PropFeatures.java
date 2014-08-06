package com.vstar.dao;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="prop_features"
    ,catalog="property_master"
)
public class PropFeatures  implements java.io.Serializable {


     private int featureId;
     private Integer bedRooms;
     private Integer bathRooms;
     private Integer balconies;
     private Byte furnished;
     private String ageOfConst;
     private Integer availFloor;
     private Integer totalFloors;
     private String custom1;
     private String custom2;
     private String custom3;
     private String custom4;


    public PropFeatures() {
    }

	
  
   
    @Id 
    @Column(name="featureId", unique=true, nullable=false)
    public int getFeatureId() {
        return this.featureId;
    }
    
    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }
    
    @Column(name="bedRooms")
    public Integer getBedRooms() {
        return this.bedRooms;
    }
    
    public void setBedRooms(Integer bedRooms) {
        this.bedRooms = bedRooms;
    }
    
    @Column(name="bathRooms")
    public Integer getBathRooms() {
        return this.bathRooms;
    }
    
    public void setBathRooms(Integer bathRooms) {
        this.bathRooms = bathRooms;
    }
    
    @Column(name="balconies")
    public Integer getBalconies() {
        return this.balconies;
    }
    
    public void setBalconies(Integer balconies) {
        this.balconies = balconies;
    }
    
    @Column(name="furnished")
    public Byte getFurnished() {
        return this.furnished;
    }
    
    public void setFurnished(Byte furnished) {
        this.furnished = furnished;
    }
    
    @Column(name="ageOfConst", length=10)
    public String getAgeOfConst() {
        return this.ageOfConst;
    }
    
    public void setAgeOfConst(String ageOfConst) {
        this.ageOfConst = ageOfConst;
    }
    
    @Column(name="availFloor")
    public Integer getAvailFloor() {
        return this.availFloor;
    }
    
    public void setAvailFloor(Integer availFloor) {
        this.availFloor = availFloor;
    }
    
    @Column(name="totalFloors")
    public Integer getTotalFloors() {
        return this.totalFloors;
    }
    
    public void setTotalFloors(Integer totalFloors) {
        this.totalFloors = totalFloors;
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


