package com.vstar.process.masterData.infoBean;

/**
 * Info Bean for passing State Data
 *
 */
public class PropStateInfo
{
  private long stateId;
  private String stateName;

  public PropStateInfo()
  {

  }

  public PropStateInfo(long stateId, String stateName)
  {
    this.stateId = stateId;
    this.stateName = stateName;
  }

  public long getStateId()
  {
    return stateId;
  }

  public void setStateId(long stateId)
  {
    this.stateId = stateId;
  }

  public String getStateName()
  {
    return stateName;
  }

  public void setStateName(String stateName)
  {
    this.stateName = stateName;
  }
}
