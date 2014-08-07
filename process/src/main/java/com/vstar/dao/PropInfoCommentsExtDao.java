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
 * Property comments, likes and rating
 *
 */
@Entity
@Table(name = "prop_info_comments_ext", catalog = "property_master")
public class PropInfoCommentsExtDao implements java.io.Serializable
{
  private static final long serialVersionUID = -2853064893592194790L;
  @Id
  @Column(name = "prop_info_Id", unique = true, nullable = false)
  private int propInfoId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prop_info_Id", unique = true, nullable = false, insertable = false, updatable = false)
  private PropInfoDao propInfo;
  @Column(name = "comments", length = 100)
  private String comments;
  @Column(name = "rating")
  private Integer rating;
  @Column(name = "likes")
  private Integer likes;
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

  public PropInfoCommentsExtDao()
  {
  }

  public PropInfoCommentsExtDao(int propInfoId, PropInfoDao propInfo)
  {
    this.propInfoId = propInfoId;
    this.propInfo = propInfo;
  }

  /**
   * 
   * @param propInfoId
   * @param propInfo
   * @param comments
   * @param rating
   * @param likes
   * @param createdDate
   * @param custom1
   * @param custom2
   * @param custom3
   * @param custom4
   */
  public PropInfoCommentsExtDao(int propInfoId, PropInfoDao propInfo, String comments,
      Integer rating, Integer likes, Date createdDate, String custom1, String custom2,
      String custom3, String custom4)
  {
    this.propInfoId = propInfoId;
    this.propInfo = propInfo;
    this.comments = comments;
    this.rating = rating;
    this.likes = likes;
    this.createdDate = createdDate;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
  }

  public int getPropInfoId()
  {
    return this.propInfoId;
  }

  public void setPropInfoId(int propInfoId)
  {
    this.propInfoId = propInfoId;
  }

  public PropInfoDao getPropInfo()
  {
    return this.propInfo;
  }

  public void setPropInfo(PropInfoDao propInfo)
  {
    this.propInfo = propInfo;
  }

  public String getComments()
  {
    return this.comments;
  }

  public void setComments(String comments)
  {
    this.comments = comments;
  }

  public Integer getRating()
  {
    return this.rating;
  }

  public void setRating(Integer rating)
  {
    this.rating = rating;
  }

  public Integer getLikes()
  {
    return this.likes;
  }

  public void setLikes(Integer likes)
  {
    this.likes = likes;
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
}
