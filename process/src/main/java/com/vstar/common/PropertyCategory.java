package com.vstar.common;

/**
 * Property Categories for post property
 * Mapped with: PROP_CATEGORY table
 *
 */
public enum PropertyCategory 
{
	Residential(1, "Residential"), 
	Commercial(2, "Commercial"), 
	Agriculture(3, "Agriculture");

	private int value;

	private String typeName;

	PropertyCategory(int value, String name) 
	{
		this.value = value;
		this.typeName = name;
	}

	public int getId() 
	{
		return value;
	}

	public String getName() 
	{
		return this.typeName;
	}

	public static PropertyCategory valueOf(int value) throws Exception 
	{
		switch (value) 
		{
			case 1:
				return Residential;
			case 2:
				return Commercial;
			case 3:
				return Agriculture;	
		}
		throw new Exception("Could not find Policy Request Change Type for Id:"
				+ value);
	}

	public static PropertyCategory valueOfString(String name) throws Exception 
	{
		PropertyCategory[] values = PropertyCategory.values();
		for (PropertyCategory changeType : values) {
			if (name.equals(changeType.typeName)) {
				return changeType;
			}
		}
		throw new Exception(
				"Could not find Policy Request Change Type for name:" + name);
	}

}
