package com.vstar.common;


/**
 * Constants for the Stored Procedures
 */
public interface StoredProcedureConstants
{
  /**
   * Table Name Constants
   */
  public interface TableNames
  {
    public static final String PROP_INFO = "prop_info";
    public static final String PROP_FEATURES = "prop_features";
    public static final String PROP_LOCATION_INFO = "prop_location_info";
    public static final String PROP_LOCATION = "prop_location";
    public static final String PROP_TYPE = "prop_type";
    public static final String PROP_PRICE = "prop_price";
    public static final String PROP_AREA = "prop_area";
    public static final String PROP_PURCHASE_TYPE = "prop_purchase_type";
    public static final String PROP_IMAGE = "prop_image";
    public static final String PROP_TRANSACTION = "prop_transaction";
    public static final String PROP_CITY = "prop_city";
  }

  /**
   * Column Name Constants
   */
  public interface WhereClauseColumnNames
  {
    public static final String BED_ROOMS = ".bed_rooms";
    public static final String PROP_LOCATION_ID = ".prop_location_id";
    public static final String PROP_TYPE_ID = ".prop_type_id";
    public static final String EXPECTED_PRICE = ".expected_price";
    public static final String PROP_PURCHASE_ID = ".prop_purchase_id=";
    public static final String PROP_CITY_ID = ".prop_city_id=";
  }

  /**
   * MainSearch Stored Proc Constants
   */
  public interface MainSearchConstants
  {
    public static final String FEATURE_BED_ROOMS = TableNames.PROP_FEATURES
      + WhereClauseColumnNames.BED_ROOMS;
    public static final String PROP_LOC_PROP_LOC_ID = TableNames.PROP_LOCATION_INFO
      + WhereClauseColumnNames.PROP_LOCATION_ID;
    public static final String PROP_TYPE_PROP_TYPE_ID = TableNames.PROP_TYPE
      + WhereClauseColumnNames.PROP_TYPE_ID;
    public static final String PROP_PRICE_EXPECTED_PRICE = TableNames.PROP_PRICE
      + WhereClauseColumnNames.EXPECTED_PRICE;
    public static final String PROP_PURCHASE_PROP_PURCHASE_ID = TableNames.PROP_PURCHASE_TYPE
      + WhereClauseColumnNames.PROP_PURCHASE_ID;
    public static final String PROP_CITY_PROP_CITY_ID = TableNames.PROP_CITY
      + WhereClauseColumnNames.PROP_CITY_ID;
  }
}
