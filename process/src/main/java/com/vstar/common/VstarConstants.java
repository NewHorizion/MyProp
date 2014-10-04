package com.vstar.common;

/**
 * Constants for the application
 *
 */
public interface VstarConstants 
{
	/**
	 * Property transaction types
	 *
	 */
	public interface TransationTypes
	{
		public static final String NEW_PROPERTY = "New Property";
		public static final String RESALE_PROPERTY = "Resale";
	}
	
	/**
	 * Purchase type Sale/Rent
	 *
	 */
	public interface PurchaseType
  {
    public static final String SALE = "Sale";
    public static final String RENT = "Rent Out";
  }
	
	/**
	 * Property possession status
	 *
	 */
	public interface PossessionStatus
	{
		public static final String UNDER_CONSTRUCTION = "Under Construction";
		public static final String READY_TO_MOVE = "Ready To Move";
	}
	
	/**
	 * Property posted by or
	 * Owner of the property
	 *
	 */
	public interface PropertyOwners
	{
		public static final String INDIVIDUAL = "Individual";
		public static final String OWNER = "Owner";
		public static final String BUILDER = "Builder";
		public static final String BROKER = "Broker";
	}
	
	/**
	 * Action Result Types
	 *
	 */
	public interface ActionResultTypes
	{
		public static final String REQUIREMENT = "requirement";
		public static final String PROPERTY = "property";
		public static final String REGISTRATION = "register";
		public static final String LOGIN = "login";
	}
	
	public interface Authentication
	{
		public static final String AUTHORIZED_USER = "isAuthorized";
		public static final String USER_TYPE = "userType";
	}
}
