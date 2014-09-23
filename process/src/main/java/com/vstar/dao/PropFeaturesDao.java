package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Property features
 *
 */
@Entity
@Table(name = "prop_features", catalog = "property_master")
@GenericGenerator(name = "PropFeatureInfo", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
  @Parameter(name = "segment_value", value = "Prop_Feature_Info"),
  @Parameter(name = "increment_size", value = "10"),
  @Parameter(name = "optimizer", value = "pooled")})
public class PropFeaturesDao implements java.io.Serializable
{
  private static final long serialVersionUID = -4329916729253167714L;
  @Id
  @GeneratedValue(generator = "PropFeatureInfo")
  @Column(name = "prop_feature_Id", unique = true, nullable = false)
  private int propFeatureId;
  @Column(name = "bed_Rooms")
  private Integer bedRooms;
  @Column(name = "bath_Rooms")
  private Integer bathRooms;
  @Column(name = "balconies")
  private Integer balconies;
  @Column(name = "furnished")
  private String furnished;
  @Column(name = "age_Of_Const", length = 10)
  private String ageOfConst;
  @Column(name = "avail_Floor")
  private Integer availFloor;
  @Column(name = "total_Floors")
  private Integer totalFloors;
  @Column(name = "custom1", length = 10)
  private String custom1;
  @Column(name = "custom2", length = 10)
  private String custom2;
  @Column(name = "custom3", length = 10)
  private String custom3;
  @Column(name = "custom4", length = 10)
  private String custom4;
  @Column(name = "inhouse_amenities", length = 500)
  private String inhouseAmenities;
  @Column(name = "external_amenities", length = 1000)
  private String externalAmenities;
  

  public PropFeaturesDao()
  {
  }

  public PropFeaturesDao(int propFeatureId)
  {
    this.propFeatureId = propFeatureId;
  }

  /**
   * 
   * @param propFeatureId
   * @param bedRooms
   * @param bathRooms
   * @param balconies
   * @param furnished
   * @param ageOfConst
   * @param availFloor
   * @param totalFloors
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropFeaturesDao(int propFeatureId, Integer bedRooms, Integer bathRooms, Integer balconies,
      String furnished, String ageOfConst, Integer availFloor, Integer totalFloors, String custom1,
      String custom2, String custom3, String custom4)
  {
    this.propFeatureId = propFeatureId;
    this.bedRooms = bedRooms;
    this.bathRooms = bathRooms;
    this.balconies = balconies;
    this.furnished = furnished;
    this.ageOfConst = ageOfConst;
    this.availFloor = availFloor;
    this.totalFloors = totalFloors;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  public int getPropFeatureId()
  {
    return this.propFeatureId;
  }

  public void setPropFeatureId(int propFeatureId)
  {
    this.propFeatureId = propFeatureId;
  }

  public Integer getBedRooms()
  {
    return this.bedRooms;
  }

  public void setBedRooms(Integer bedRooms)
  {
    this.bedRooms = bedRooms;
  }

  public Integer getBathRooms()
  {
    return this.bathRooms;
  }

  public void setBathRooms(Integer bathRooms)
  {
    this.bathRooms = bathRooms;
  }

  public Integer getBalconies()
  {
    return this.balconies;
  }

  public void setBalconies(Integer balconies)
  {
    this.balconies = balconies;
  }

  public String getFurnished()
  {
    return this.furnished;
  }

  public void setFurnished(String furnished)
  {
    this.furnished = furnished;
  }

  public String getAgeOfConst()
  {
    return this.ageOfConst;
  }

  public void setAgeOfConst(String ageOfConst)
  {
    this.ageOfConst = ageOfConst;
  }

  public Integer getAvailFloor()
  {
    return this.availFloor;
  }

  public void setAvailFloor(Integer availFloor)
  {
    this.availFloor = availFloor;
  }

  public Integer getTotalFloors()
  {
    return this.totalFloors;
  }

  public void setTotalFloors(Integer totalFloors)
  {
    this.totalFloors = totalFloors;
  }

  public String getCustom1()
  {
    return this.custom1;
  }

  public void setCustom1(String custom1)
  {
    this.custom1 = custom1;
  }

  public String getCustom2()
  {
    return this.custom2;
  }

  public void setCustom2(String custom2)
  {
    this.custom2 = custom2;
  }

  public String getCustom3()
  {
    return this.custom3;
  }

  public void setCustom3(String custom3)
  {
    this.custom3 = custom3;
  }

  public String getCustom4()
  {
    return this.custom4;
  }

  public void setCustom4(String custom4)
  {
    this.custom4 = custom4;
  }

public String getInhouseAmenities() {
	return inhouseAmenities;
}

public void setInhouseAmenities(String inhouseAmenities) {
	this.inhouseAmenities = inhouseAmenities;
}

public String getExternalAmenities() {
	return externalAmenities;
}

public void setExternalAmenities(String externalAmenities) {
	this.externalAmenities = externalAmenities;
}
}
