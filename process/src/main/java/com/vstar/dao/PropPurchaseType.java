package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="prop_purchase_type"
    ,catalog="property_master"
)
public class PropPurchaseType  implements java.io.Serializable {


     private int propPurchaseId;
     private String propPurchaseDesc;
     

    public PropPurchaseType() {
    }

	
    public PropPurchaseType(int propPurchaseId, String propPurchaseDesc) {
        this.propPurchaseId = propPurchaseId;
        this.propPurchaseDesc = propPurchaseDesc;
    }
    
     @Id 
    @Column(name="prop_purchase_id", unique=true, nullable=false)
    public int getPropPurchaseId() {
        return this.propPurchaseId;
    }
    
    public void setPropPurchaseId(int propPurchaseId) {
        this.propPurchaseId = propPurchaseId;
    }
    
    @Column(name="prop_purchase_desc", nullable=false, length=20)
    public String getPropPurchaseDesc() {
        return this.propPurchaseDesc;
    }
    
    public void setPropPurchaseDesc(String propPurchaseDesc) {
        this.propPurchaseDesc = propPurchaseDesc;
    }
}


