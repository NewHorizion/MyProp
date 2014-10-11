package com.vstar.common.impl;

import java.util.List;

import com.vstar.common.CreateConditionsProcess;
import com.vstar.process.propertyDetailInfo.ResidentialUnits;

public class ResidentialUnitsConditionProcessImpl implements CreateConditionsProcess<ResidentialUnits> {

	@Override
	public StringBuffer createInCondition(String columnName,
			List<ResidentialUnits> selectedValues) {
		int matchLoop = 0;
		StringBuffer whereClause = null;
		if (null != columnName && null != selectedValues) {
			whereClause = new StringBuffer();
				whereClause.append(" and ");
				StringBuffer inClauseList = new StringBuffer();
				inClauseList.append(columnName + " in (");
				for (ResidentialUnits residentialUnit : selectedValues) {
					if (matchLoop > 0) {
						inClauseList.append(",");
					}
					inClauseList.append(residentialUnit.getId());
					matchLoop++;
				}
				inClauseList.append(")");
				whereClause.append(inClauseList);
		}
		return whereClause;
	}

	@Override
	public StringBuffer createBetweenCondition(String columnName,
			List<ResidentialUnits> selectedValues) {
		StringBuffer whereClause = null;
		if (null != columnName && null != selectedValues) {
			whereClause = new StringBuffer();
			if (selectedValues.size() == 2) {
				whereClause.append(" and ");
				whereClause.append(columnName);
				whereClause.append(" between ");
				whereClause.append(selectedValues.get(0).getId());
				whereClause.append(" and ");
				whereClause.append(selectedValues.get(1).getId());
			}
		}
		return whereClause;
	}

}
