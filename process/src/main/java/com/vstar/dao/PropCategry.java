package com.vstar.dao;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prop_categry"
    ,catalog="property_master"
)
public class PropCategry  implements java.io.Serializable {


     private int categryId;
     private String categryType;
     

    public PropCategry() {
    }

	
    public PropCategry(int categryId, String categryType) {
        this.categryId = categryId;
        this.categryType = categryType;
    }
 
    @Id 
    @Column(name="categry_id", unique=true, nullable=false)
    public int getCategryId() {
        return this.categryId;
    }
    
    public void setCategryId(int categryId) {
        this.categryId = categryId;
    }
    
    @Column(name="categry_type", nullable=false, length=30)
    public String getCategryType() {
        return this.categryType;
    }
    
    public void setCategryType(String categryType) {
        this.categryType = categryType;
    }

}


