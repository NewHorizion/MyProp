package com.vstar.common;

/**
 * Property Types under Residential, Commercial and 
 * Agriculture property categories.
 * Mapped with: PROP_TYPE table
 * 
 */
public enum PropertyTypeEnum 
{
	MultistoreyApartment(1, "Multistorey Apartment", PropertyCategoryEnum.Residential), 
	BuilderFloorApartment(2, "Builder Floor Apartment", PropertyCategoryEnum.Residential), 
	ResidentialHouse(3, "Residential House", PropertyCategoryEnum.Residential), 
	Villa(4, "Villa", PropertyCategoryEnum.Residential), 
	ResidentialPlot(5, "Residential Plot", PropertyCategoryEnum.Residential), 
	Penthouse(6, "Penthouse", PropertyCategoryEnum.Residential), 
	StudioApartment(7, "Studio Apartment", PropertyCategoryEnum.Residential), 
	ServiceApartment(8, "Service Apartment", PropertyCategoryEnum.Residential),
	CommercialOfficeSpace(9, "Commercial Office Space", PropertyCategoryEnum.Commercial), 
	OfficeITParkSEZ(10, "Office in IT Park/ SEZ", PropertyCategoryEnum.Commercial), 
	CommercialShop(11, "Commercial Shop", PropertyCategoryEnum.Commercial), 
	SpaceShoppingMall(12, "Space in Shopping Mall", PropertyCategoryEnum.Commercial), 
	CommercialShowroom(13, "Commercial Showroom", PropertyCategoryEnum.Commercial), 
	Kiosk(14, "Kiosk", PropertyCategoryEnum.Commercial), 
	BusinessCentre(15, "Business Centre", PropertyCategoryEnum.Commercial), 
	CommercialLand(16, "Commercial Land", PropertyCategoryEnum.Commercial),
	WarehouseGodown(17, "Warehouse/ Godown", PropertyCategoryEnum.Commercial), 
	GuestHouse(18, "Guest House", PropertyCategoryEnum.Commercial), 
	Hotel(19, "Hotel", PropertyCategoryEnum.Commercial), 
	HotelSites(20, "Hotel Sites", PropertyCategoryEnum.Commercial), 
	IndustrialLand(21, "Industrial Land", PropertyCategoryEnum.Commercial), 
	IndustrialBuilding(22, "Industrial Building", PropertyCategoryEnum.Commercial), 
	IndustrialShed(23, "Industrial Shed", PropertyCategoryEnum.Commercial),
	AgriculturalLand(24, "Agricultural Land", PropertyCategoryEnum.Agriculture), 
	FarmHouse(25, "Farm House", PropertyCategoryEnum.Agriculture),
	Plot(26, "Plot", PropertyCategoryEnum.Residential),
	BuilderFloor(27, "Builder Floor", PropertyCategoryEnum.Residential);
	
	private int value;

	private String typeName;
	
	private PropertyCategoryEnum propertyCategoryEnum;

	PropertyTypeEnum(int value, String name, PropertyCategoryEnum propertyCategoryEnum) 
	{
		this.value = value;
		this.typeName = name;
		this.propertyCategoryEnum = propertyCategoryEnum;
	}

	public int getId() 
	{
		return value;
	}

	public String getName() 
	{
		return this.typeName;
	}

	public static PropertyTypeEnum valueOf(int value) throws Exception 
	{
		switch (value) 
		{
			case 1:
				return MultistoreyApartment;
			case 2:
				return BuilderFloorApartment;
			case 3:
				return ResidentialHouse;
			case 4:
				return Villa;
			case 5:
				return ResidentialPlot;
			case 6:
				return Penthouse;
			case 7:
				return StudioApartment;
			case 8:
				return ServiceApartment;
			case 9:
				return CommercialOfficeSpace;
			case 10:
				return OfficeITParkSEZ;
			case 11:
				return CommercialShop;
			case 12:
				return SpaceShoppingMall;
			case 13:
				return CommercialShowroom;
			case 14:
				return Kiosk;
			case 15:
				return BusinessCentre;
			case 16:
				return CommercialLand;
			case 17:
				return WarehouseGodown;
			case 18:
				return GuestHouse;
			case 19:
				return Hotel;
			case 20:
				return HotelSites;
			case 21:
				return IndustrialLand;
			case 22:
				return IndustrialBuilding;
			case 23:
				return IndustrialShed;
			case 24:
				return AgriculturalLand;
			case 25:
				return FarmHouse;
	
		}
		throw new Exception("Could not find Policy Request Change Type for Id:"
				+ value);
	}

	public static PropertyTypeEnum valueOfString(String name) throws Exception 
	{
		PropertyTypeEnum[] values = PropertyTypeEnum.values();
		for (PropertyTypeEnum changeType : values) {
			if (name.equals(changeType.typeName)) {
				return changeType;
			}
		}
		throw new Exception(
				"Could not find Policy Request Change Type for name:" + name);
	}

  public PropertyCategoryEnum getPropertyCategoryEnum()
  {
    return propertyCategoryEnum;
  }

  public void setPropertyCategoryEnum(PropertyCategoryEnum propertyCategoryEnum)
  {
    this.propertyCategoryEnum = propertyCategoryEnum;
  }

}
