package com.vstar.common;

/**
 * Property Purchase Type
 * i.e. property is for sale/rent.
 *
 */

public enum PropertyPurchaseTypeEnum 
{
	Sale(1, "Sale"), 
	Rent(2, "Rent Out");

	private int value;

	private String typeName;

	PropertyPurchaseTypeEnum(int value, String name) 
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

	public static PropertyPurchaseTypeEnum valueOf(int value) throws Exception 
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

	public static PropertyPurchaseTypeEnum valueOfString(String name) throws Exception 
	{
		PropertyPurchaseTypeEnum[] values = PropertyPurchaseTypeEnum.values();
		for (PropertyPurchaseTypeEnum changeType : values) {
			if (name.equals(changeType.typeName)) {
				return changeType;
			}
		}
		throw new Exception(
				"Could not find Policy Request Change Type for name:" + name);
	}
}
