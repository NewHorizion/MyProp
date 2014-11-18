package com.vstar.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PropUsersDao
 * 
 */
@Entity
@Table(name = "users", catalog = "property_master")
public class PropUsersDao implements java.io.Serializable
{
  private static final long serialVersionUID = -6261006342019880313L;
  @Id
  @Column(name = "username", unique = true, nullable = false, length = 50)
  private String userId;
  @Column(name = "password", length = 50)
  private String password;
  @Column(name = "enabled")
  private Byte enabled;

  public PropUsersDao()
  {
  }

  public PropUsersDao(String userId)
  {
    this.userId = userId;
  }

  public PropUsersDao(String userId, String password, Byte enabled)
  {
    this.userId = userId;
    this.password = password;
    this.enabled = enabled;
  }

  /**
   * @return the userId
   */
  public String getUserId()
  {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  /**
   * @return the password
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password)
  {
    this.password = password;
  }

  /**
   * @return the enabled
   */
  public Byte getEnabled()
  {
    return enabled;
  }

  /**
   * @param enabled the enabled to set
   */
  public void setEnabled(Byte enabled)
  {
    this.enabled = enabled;
  }
}
