package com.vstar.common;

public enum PropertyPurchaseType 
{
	Sale(1, "Sale"), 
	Rent(2, "Rent Out");

	private int value;

	private String typeName;

	PropertyPurchaseType(int value, String name) 
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

	public static PropertyPurchaseType valueOf(int value) throws Exception 
	{
		switch (value) 
		{
			case 1:
				return Sale;
			case 2:
				return Rent;	
		}
		throw new Exception("Could not find Policy Request Change Type for Id:"
				+ value);
	}

	public static PropertyPurchaseType valueOfString(String name) throws Exception 
	{
		PropertyPurchaseType[] values = PropertyPurchaseType.values();
		for (PropertyPurchaseType changeType : values) {
			if (name.equals(changeType.typeName)) {
				return changeType;
			}
		}
		throw new Exception(
				"Could not find Policy Request Change Type for name:" + name);
	}
}
