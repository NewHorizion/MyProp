package com.vstar.common;

public enum PropertyUserGroupEnum {
	Admin(1,"admin"),
	Owner(2,"owner"),
	Agent(3,"agent"),
	Builder(4,"builder"),
	Reviewer(5,"reviewer");
	
	private int value;
	private String typeName;

	PropertyUserGroupEnum(int value, String name) 
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

	public static PropertyUserGroupEnum valueOf(int value) throws Exception 
	{
		switch (value) 
		{
			case 1:
				return Admin;
			case 2:
				return Owner;
			case 3:
				return Agent;
			case 4:
				return Builder;
			case 5:
				return Reviewer;
		}
		throw new Exception("Could not find Property User Type for Id:"
				+ value);
	}

	public static PropertyUserGroupEnum valueOfString(String name) throws Exception 
	{
		PropertyUserGroupEnum[] values = PropertyUserGroupEnum.values();
		for (PropertyUserGroupEnum changeType : values) {
			if (name.equals(changeType.typeName)) {
				return changeType;
			}
		}
		throw new Exception(
				"Could not find Property User Type for name:" + name);
	}
	
}
