package com.vstar.common;

import java.util.List;

public interface CreateConditionsProcess<T> {
	public StringBuffer createInCondition(String columnName,
			List<T> selectedValues);
	public StringBuffer createBetweenCondition(String columnName,
			List<T> selectedValues);
}
