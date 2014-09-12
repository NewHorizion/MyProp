package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Property Requirement Details
 */
@Entity
@Table(name = "prop_requirement", catalog = "property_master")
@GenericGenerator(name = "PropReqInfo", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
    @Parameter(name = "segment_value", value = "Prop_Req_Info"),
    @Parameter(name = "increment_size", value = "10"),
    @Parameter(name = "optimizer", value = "pooled")})
public class PropRequirementDao implements java.io.Serializable
{
  private static final long serialVersionUID = -1377011156147399065L;
  @Id
  @GeneratedValue(generator = "PropReqInfo")
  @Column(name = "prop_requirement_id", unique = true, nullable = false)
  private int propRequirementId;
  @Column(name = "min_covered_Area")
  private Integer minCoveredArea;
  @Column(name = "max_covered_Area")
  private Integer maxCoveredArea;
  @Column(name = "covered_area_unit", length = 15)
  private String coveredAreaUnit;
  @Column(name = "min_plot_Area")
  private Integer minPlotArea;
  @Column(name = "max_plot_Area")
  private Integer maxPlotArea;
  @Column(name = "plot_Area_Unit", length = 15)
  private String plotAreaUnit;
  @Column(name = "min_budget", precision = 18, scale = 0)
  private Long minBudget;
  @Column(name = "max_budget", precision = 18, scale = 0)
  private Long maxBudget;
  @Column(name = "min_bedrooms")
  private Integer minBedrooms;
  @Column(name = "max_bedrooms")
  private Integer maxBedrooms;
  @Column(name = "dealing_type")
  private Boolean dealingType;
  @Column(name = "prop_purchase_id")
  private Integer propPurchaseId;

  public int getPropRequirementId()
  {
    return propRequirementId;
  }

  public void setPropRequirementId(int propRequirementId)
  {
    this.propRequirementId = propRequirementId;
  }

  public Integer getMinCoveredArea()
  {
    return minCoveredArea;
  }

  public void setMinCoveredArea(Integer minCoveredArea)
  {
    this.minCoveredArea = minCoveredArea;
  }

  public Integer getMaxCoveredArea()
  {
    return maxCoveredArea;
  }

  public void setMaxCoveredArea(Integer maxCoveredArea)
  {
    this.maxCoveredArea = maxCoveredArea;
  }

  public String getCoveredAreaUnit()
  {
    return coveredAreaUnit;
  }

  public void setCoveredAreaUnit(String coveredAreaUnit)
  {
    this.coveredAreaUnit = coveredAreaUnit;
  }

  public Integer getMinPlotArea()
  {
    return minPlotArea;
  }

  public void setMinPlotArea(Integer minPlotArea)
  {
    this.minPlotArea = minPlotArea;
  }

  public Integer getMaxPlotArea()
  {
    return maxPlotArea;
  }

  public void setMaxPlotArea(Integer maxPlotArea)
  {
    this.maxPlotArea = maxPlotArea;
  }

  public String getPlotAreaUnit()
  {
    return plotAreaUnit;
  }

  public void setPlotAreaUnit(String plotAreaUnit)
  {
    this.plotAreaUnit = plotAreaUnit;
  }

  public Long getMinBudget()
  {
    return minBudget;
  }

  public void setMinBudget(Long minBudget)
  {
    this.minBudget = minBudget;
  }

  public Long getMaxBudget()
  {
    return maxBudget;
  }

  public void setMaxBudget(Long maxBudget)
  {
    this.maxBudget = maxBudget;
  }

  public Integer getMinBedrooms()
  {
    return minBedrooms;
  }

  public void setMinBedrooms(Integer minBedrooms)
  {
    this.minBedrooms = minBedrooms;
  }

  public Integer getMaxBedrooms()
  {
    return maxBedrooms;
  }

  public void setMaxBedrooms(Integer maxBedrooms)
  {
    this.maxBedrooms = maxBedrooms;
  }

  public Boolean getDealingType()
  {
    return dealingType;
  }

  public void setDealingType(Boolean dealingType)
  {
    this.dealingType = dealingType;
  }

  public Integer getPropPurchaseId()
  {
    return propPurchaseId;
  }

  public void setPropPurchaseId(Integer propPurchaseId)
  {
    this.propPurchaseId = propPurchaseId;
  }

}
