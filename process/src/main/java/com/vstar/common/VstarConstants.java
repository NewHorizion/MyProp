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
}
