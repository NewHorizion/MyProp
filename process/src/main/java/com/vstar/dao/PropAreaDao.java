package com.vstar.dao;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Property Area Details
 * 
 */
@Entity
@Table(name = "prop_area", catalog = "property_master")
@GenericGenerator(name = "PropAreaInfo", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
  @Parameter(name = "segment_value", value = "Prop_Area_Info"),
  @Parameter(name = "increment_size", value = "10"),
  @Parameter(name = "optimizer", value = "pooled")})
public class PropAreaDao implements java.io.Serializable
{
  private static final long serialVersionUID = -1377011156147399065L;
  @Id
  @GeneratedValue(generator = "PropAreaInfo")
  @Column(name = "prop_area_Id", unique = true, nullable = false)
  private int propAreaId;
  @Column(name = "covered_Area")
  private Integer coveredArea;
  @Column(name = "covered_area_unit", length = 15)
  private String coveredAreaUnit;
  @Column(name = "plot_Area")
  private Integer plotArea;
  @Column(name = "plot_Area_Unit", length = 15)
  private String plotAreaUnit;
  @Column(name = "land_Area")
  private Integer landArea;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  private Date createdDate;
  @Column(name = "custom1", length = 10)
  private String custom1;
  @Column(name = "custom2", length = 10)
  private String custom2;
  @Column(name = "custom3", length = 10)
  private String custom3;
  @Column(name = "custom4", length = 10)
  private String custom4;

  public PropAreaDao()
  {
  }

  /**
   * 
   * @param coveredArea
   * @param measurement
   * @param plotArea
   * @param landArea
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropAreaDao(Integer coveredArea, String coveredAreaUnit, Integer plotArea, String plotAreaUnit,
      Integer landArea, Date createdDate, String custom1, String custom2, String custom3,
      String custom4)
  {
    this.coveredArea = coveredArea;
    this.coveredAreaUnit = coveredAreaUnit;
    this.plotArea = plotArea;
    this.plotAreaUnit = plotAreaUnit;
    this.landArea = landArea;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  public int getPropAreaId()
  {
    return this.propAreaId;
  }

  public void setPropAreaId(int propAreaId)
  {
    this.propAreaId = propAreaId;
  }

  public Integer getCoveredArea()
  {
    return this.coveredArea;
  }

  public void setCoveredArea(Integer coveredArea)
  {
    this.coveredArea = coveredArea;
  }

  public Integer getPlotArea()
  {
    return this.plotArea;
  }

  public void setPlotArea(Integer plotArea)
  {
    this.plotArea = plotArea;
  }

  public Integer getLandArea()
  {
    return this.landArea;
  }

  public void setLandArea(Integer landArea)
  {
    this.landArea = landArea;
  }

  public Date getCreatedDate()
  {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
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

  public String getCoveredAreaUnit()
  {
    return coveredAreaUnit;
  }

  public void setCoveredAreaUnit(String coveredAreaUnit)
  {
    this.coveredAreaUnit = coveredAreaUnit;
  }

  public String getPlotAreaUnit()
  {
    return plotAreaUnit;
  }

  public void setPlotAreaUnit(String plotAreaUnit)
  {
    this.plotAreaUnit = plotAreaUnit;
  }
}
