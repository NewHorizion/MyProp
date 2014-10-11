package com.vstar.common.impl;

import java.util.List;

import com.vstar.process.propertyDetailInfo.ResidentialUnits;

public class CreateConditionObjectFactory {
	  public StringBuffer createInCondition (String columnName, List<? extends Object> obj)
	  {
		  StringBuffer whereClause = null; 
		  if (null!=obj && !obj.isEmpty() && obj.get(0) instanceof ResidentialUnits)
		  {
			  List<ResidentialUnits> residentialUnit = (List<ResidentialUnits>) obj;
			  ResidentialUnitsConditionProcessImpl conditionProcessor = new ResidentialUnitsConditionProcessImpl();
			  whereClause = conditionProcessor.createInCondition(columnName, residentialUnit);
		  }
		  return whereClause;
	  }
	  
	  public StringBuffer createBetweenCondition (String columnName, List<? extends Object> obj)
	  {
		  StringBuffer whereClause = null; 
		  if (null!=obj && !obj.isEmpty() && obj.get(0) instanceof ResidentialUnits)
		  {
			  List<ResidentialUnits> residentialUnit = (List<ResidentialUnits>) obj;
			  ResidentialUnitsConditionProcessImpl conditionProcessor = new ResidentialUnitsConditionProcessImpl();
			  whereClause = conditionProcessor.createBetweenCondition(columnName, residentialUnit);
		  }
		  return whereClause;
	  }
	  
}
