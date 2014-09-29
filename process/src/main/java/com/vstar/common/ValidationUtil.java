package com.vstar.common;

public class ValidationUtil {
	
	public static boolean isNullEmpty(String value)
	{
		if(value==null) return true;
		else if(value.trim().length()==0) return true;
		else return false;
	}
}
