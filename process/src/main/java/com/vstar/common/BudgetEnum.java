package com.vstar.common;

/**
 * Min & Max Budget Enum
 * for Rent & Sale
 *
 */
public enum BudgetEnum 
{
  FiveThousand(5000, "5000"), 
  TenThousand(10000, "10000"), 
  TwentyThousand(20000, "20000"),
  ThirtyThousand(30000, "30000"), 
  FortyThousand(40000, "40000"), 
  FiftyThousand(50000, "50000"),
  SixtyThousand(60000, "60000"),
  SeventyThousand(70000, "70000"), 
  EightyThousand(80000, "80000"), 
  NinetyThousand(90000, "90000"),
  OneLac(100000, "1 lac"), 
  TwoLacs(200000, "2 lacs"), 
  ThreeLacs(300000, "3 lacs"),
  FourLacs(400000, "4 lacs"),
	FiveLacs(500000, "5 lacs"), 
	TenLacs(1000000, "10 lacs"),
	TenFiveLacs(1500000, ">10 lacs"),
	TwentyLacs(2000000, "20 lacs"),
	ThirtyLacs(300000, "30 lacs"), 
  FortyLacs(4000000, "40 lacs"), 
  FiftyLacs(5000000, "50 lacs"),
  SixtyLacs(6000000, "60 lacs"),
  SeventyLacs(700000, "70 lacs"), 
  EightyLacs(8000000, "80 lacs"), 
  NinetyLacs(9000000, "90 lacs"),
  OneCrore(10000000, "1 crore"),
  OneFiveCrores(15000000, "1.5 crores"), 
  TwoCrores(20000000, "2 crores"), 
  TwoFiveCrores(25000000, "2.5 crores"),
  ThreeCrores(30000000, "3 crores"), 
  ThreeFiveCrores(35000000, "3.5 crores"), 
  FourCrores(40000000, "4 crores"),
  FourFiveCrores(45000000, "4.5 crores"), 
  FiveCrores(50000000, "5 crores"),
	GreaterFiveCrores(55000000, ">5 crores");

	private int value;

	private String typeName;

	BudgetEnum(int value, String name) 
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

	public static BudgetEnum valueOf(int value) throws Exception 
	{
		switch (value) 
		{
		  case 5000:
        return FiveThousand;
      case 10000:
        return TenThousand;
      case 20000:
        return TwentyThousand;
      case 30000:
        return ThirtyThousand;
      case 40000:
        return FortyThousand;
      case 50000:
        return FiftyThousand;
      case 60000:
        return SixtyThousand;
      case 70000:
        return SeventyThousand;
      case 80000:
        return EightyThousand;
      case 90000:
        return NinetyThousand;
      case 100000:
        return OneLac;
      case 200000:
        return TwoLacs;
      case 300000:
        return ThreeLacs;
      case 400000:
        return FourLacs;
			case 500000:
				return FiveLacs;
			case 1000000:
				return TenLacs;
			case 1500000:
        return TenFiveLacs;
			case 2000000:
				return TwentyLacs;
			case 3000000:
        return ThirtyLacs;
      case 4000000:
        return FortyLacs;
      case 5000000:
        return FiftyLacs;
      case 6000000:
        return SixtyLacs;
      case 7000000:
        return SeventyLacs;
      case 8000000:
        return EightyLacs;
      case 9000000:
        return NinetyLacs;
      case 10000000:
        return OneCrore;
      case 20000000:
        return TwoCrores;
      case 25000000:
        return TwoFiveCrores;
      case 30000000:
        return ThreeCrores;
      case 35000000:
        return ThreeFiveCrores;
      case 40000000:
        return FourCrores;
      case 45000000:
        return FourFiveCrores;
      case 50000000:
        return FiveCrores;
      case 55000000:
        return GreaterFiveCrores;
		}
		throw new Exception("Could not find Policy Request Change Type for Id:"
				+ value);
	}

	public static BudgetEnum valueOfString(String name) throws Exception 
	{
	  BudgetEnum[] values = BudgetEnum.values();
		for (BudgetEnum changeType : values) {
			if (name.equals(changeType.typeName)) {
				return changeType;
			}
		}
		throw new Exception(
				"Could not find Policy Request Change Type for name:" + name);
	}

}
