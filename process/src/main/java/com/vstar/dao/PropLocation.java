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
@Table(name="prop_location"
    ,catalog="property_master"
)
public class PropLocation  implements java.io.Serializable {


     private int locationId;
     private PropCity propCity;
     private PropLocality propLocality;
     private String societyProject;
     private Date createdDate;
     private String cutsom1;
     private String custom2;
     private String custom3;
     private String custom4;


    public PropLocation() {
    }

	
    public PropLocation(int locationId) {
        this.locationId = locationId;
    }
    public PropLocation(int locationId, PropCity propCity, PropLocality propLocality, String societyProject, Date createdDate, String cutsom1, String custom2, String custom3, String custom4) {
       this.locationId = locationId;
       this.propCity = propCity;
       this.propLocality = propLocality;
       this.societyProject = societyProject;
       this.createdDate = createdDate;
       this.cutsom1 = cutsom1;
       this.custom2 = custom2;
       this.custom3 = custom3;
       this.custom4 = custom4;

    }
   
    @Id 
    @Column(name="locationId", unique=true, nullable=false)
    public int getLocationId() {
        return this.locationId;
    }
    
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="propCityId")
    public PropCity getPropCity() {
        return this.propCity;
    }
    
    public void setPropCity(PropCity propCity) {
        this.propCity = propCity;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="propLocalityId")
    public PropLocality getPropLocality() {
        return this.propLocality;
    }
    
    public void setPropLocality(PropLocality propLocality) {
        this.propLocality = propLocality;
    }
    
    @Column(name="societyProject", length=20)
    public String getSocietyProject() {
        return this.societyProject;
    }
    
    public void setSocietyProject(String societyProject) {
        this.societyProject = societyProject;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdDate", length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name="cutsom1", length=10)
    public String getCutsom1() {
        return this.cutsom1;
    }
    
    public void setCutsom1(String cutsom1) {
        this.cutsom1 = cutsom1;
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


