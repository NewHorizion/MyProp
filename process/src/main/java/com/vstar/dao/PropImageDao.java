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

/**
 * @author upendra.kumar
 *
 */
@Entity
@Table(name = "prop_image", catalog = "property_master")
public class PropImageDao implements java.io.Serializable
{
  private int propImageId;
  private PropInfoDao propInfo;
  private String image;
  private String description;
  private Date createdDate;
  private String custom1;
  private String custom2;
  private String custom3;
  private String custom4;

  public PropImageDao()
  {
  }

  public PropImageDao(int propImageId)
  {
    this.propImageId = propImageId;
  }

  /**
   * @param propImageId
   * @param propInfo
   * @param image
   * @param description
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropImageDao(int propImageId, PropInfoDao propInfo, String image, String description,
      Date createdDate, String custom1, String custom2, String custom3, String custom4)
  {
    this.propImageId = propImageId;
    this.propInfo = propInfo;
    this.image = image;
    this.description = description;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  @Id
  @Column(name = "prop_Image_Id", unique = true, nullable = false)
  public int getPropImageId()
  {
    return this.propImageId;
  }

  public void setPropImageId(int propImageId)
  {
    this.propImageId = propImageId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_Info_Id")
  public PropInfoDao getPropInfo()
  {
    return this.propInfo;
  }

  public void setPropInfo(PropInfoDao propInfo)
  {
    this.propInfo = propInfo;
  }

  @Column(name = "image", length = 20)
  public String getImage()
  {
    return this.image;
  }

  public void setImage(String image)
  {
    this.image = image;
  }

  @Column(name = "description", length = 50)
  public String getDescription()
  {
    return this.description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_Date", length = 19)
  public Date getCreatedDate()
  {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
  }

  @Column(name = "custom1", length = 10)
  public String getCustom1()
  {
    return this.custom1;
  }

  public void setCustom1(String custom1)
  {
    this.custom1 = custom1;
  }

  @Column(name = "custom2", length = 10)
  public String getCustom2()
  {
    return this.custom2;
  }

  public void setCustom2(String custom2)
  {
    this.custom2 = custom2;
  }

  @Column(name = "custom3", length = 10)
  public String getCustom3()
  {
    return this.custom3;
  }

  public void setCustom3(String custom3)
  {
    this.custom3 = custom3;
  }

  @Column(name = "custom4", length = 10)
  public String getCustom4()
  {
    return this.custom4;
  }

  public void setCustom4(String custom4)
  {
    this.custom4 = custom4;
  }
}
