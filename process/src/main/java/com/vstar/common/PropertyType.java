package com.vstar.common;

/**
 * Property Types under Residential, Commercial and 
 * Agriculture property categories.
 * Mapped with: PROP_TYPE table
 * 
 */
public enum PropertyType 
{
	MultistoreyApartment(1, "Multistorey Apartment"), 
	BuilderFloorApartment(2, "Builder Floor Apartment"), 
	ResidentialHouse(3, "Residential House"), 
	Villa(4, "Villa"), 
	ResidentialPlot(5, "Residential Plot"), 
	Penthouse(6, "Penthouse"), 
	StudioApartment(7, "Studio Apartment"), 
	ServiceApartment(8, "Service Apartment"),
	CommercialOfficeSpace(9, "Commercial Office Space"), 
	OfficeITParkSEZ(10, "Office in IT Park/ SEZ"), 
	CommercialShop(11, "Commercial Shop"), 
	SpaceShoppingMall(12, "Space in Shopping Mall"), 
	CommercialShowroom(13, "Commercial Showroom"), 
	Kiosk(14, "Kiosk"), 
	BusinessCentre(15, "Business Centre"), 
	CommercialLand(16, "Commercial Land"),
	WarehouseGodown(17, "Warehouse/ Godown"), 
	GuestHouse(18, "Guest House"), 
	Hotel(19, "Hotel"), 
	HotelSites(20, "Hotel Sites"), 
	IndustrialLand(21, "Industrial Land"), 
	IndustrialBuilding(22, "Industrial Building"), 
	IndustrialShed(23, "Industrial Shed"),
	AgriculturalLand(24, "Agricultural Land"), 
	FarmHouse(25, "Farm House");

	private int value;

	private String typeName;

	PropertyType(int value, String name) 
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

	public static PropertyType valueOf(int value) throws Exception 
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

	public static PropertyType valueOfString(String name) throws Exception 
	{
		PropertyType[] values = PropertyType.values();
		for (PropertyType changeType : values) {
			if (name.equals(changeType.typeName)) {
				return changeType;
			}
		}
		throw new Exception(
				"Could not find Policy Request Change Type for name:" + name);
	}
}
