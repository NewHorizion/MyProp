package com.vstar.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="prop_type"
    ,catalog="property_master"
)
public class PropType  implements java.io.Serializable {


     private int propTypeId;
     private PropCategry propCategry;
     private String typeDesc;
     

    public PropType() {
    }

	
   
    @Id 
    @Column(name="propTypeId", unique=true, nullable=false)
    public int getPropTypeId() {
        return this.propTypeId;
    }
    
    public void setPropTypeId(int propTypeId) {
        this.propTypeId = propTypeId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categry_id")
    public PropCategry getPropCategry() {
        return this.propCategry;
    }
    
    public void setPropCategry(PropCategry propCategry) {
        this.propCategry = propCategry;
    }
    
    @Column(name="typeDesc", length=30)
    public String getTypeDesc() {
        return this.typeDesc;
    }
    
    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

}


