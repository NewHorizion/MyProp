package com.vstar.common;

/**
 * 
 */
public class ExcelImportData
{
  /**
   * Blank indicator for messages that do not pertain to a cell location in
   * import Excel file.
   */
  public static final String NO_LOCATION = "-";
  // valid columns headers - must match column headers identically
  /***/
  public static final String COLUMN_1 = "Login Name";
  /***/
  public static final String COLUMN_2 = "User Name";
  /***/
  public static final String COLUMN_3 = "Company Name";
  /***/
  public static final String COLUMN_4 = "Email Id";
  /***/
  public static final String COLUMN_5 = "password";
  /***/
  public static final String COLUMN_6 = "Contact";
  /***/
  public static final String COLUMN_7 = "Landline Number";
  /***/
  public static final String COLUMN_8 = "State";
  /***/
  public static final String COLUMN_9 = "City";
  /***/
  public static final String COLUMN_10 = "User Type";
  /***/
  public static final String COLUMN_11 = "Purchase Type";
  /***/
  public static final String COLUMN_12 = "Property Type";
  /***/
  public static final String COLUMN_13 = "Transaction Type";
  /***/
  public static final String COLUMN_14 = "Property State";
  /***/
  public static final String COLUMN_15 = "Property City";
  /***/
  public static final String COLUMN_16 = "Location";
  /***/
  public static final String COLUMN_17 = "Builder/ Society";
  /***/
  public static final String COLUMN_18 = "Property Address";
  /***/
  public static final String COLUMN_19 = "Covered Area";
  /***/
  public static final String COLUMN_20 = "Covered Area Unit";
  /***/
  public static final String COLUMN_21 = "Plot Area";
  /***/
  public static final String COLUMN_22 = "Plot Area Unit";
  /***/
  public static final String COLUMN_23 = "Expected Price";
  /***/
  public static final String COLUMN_24 = "Unit Price";
  /***/
  public static final String COLUMN_25 = "Negotiable";
  /***/
  public static final String COLUMN_26 = "No of Bedrooms";
  /***/
  public static final String COLUMN_27 = "No of Bathrooms";
  /***/
  public static final String COLUMN_28 = "No of Balconies";
  /***/
  public static final String COLUMN_29 = "Furnished Status";
  /***/
  public static final String COLUMN_30 = "Floor No";
  /***/
  public static final String COLUMN_31 = "Facing";
  /***/
  public static final String COLUMN_32 = "Total Floor";
  /***/
  public static final String COLUMN_33 = "Possession Status";
  /***/
  public static final String COLUMN_34 = "Possession By";
  /***/
  public static final String COLUMN_35 = "Deal with Agent";
  /***/
  public static final String COLUMN_36 = "Brief Description";
  /***/
  public static final String COLUMN_37 = "Landmarks";
  /***/
  public static final String COLUMN_38 = "Terms & Conditions";
  /***/
  public static final String COLUMN_39 = "InHouse Amenities";
  /***/
  public static final String COLUMN_40 = "External Amenities";
  // String array containing all headers
  /***/
  public static String[] COLUMN_HEADERS = {COLUMN_1, COLUMN_2, COLUMN_3, COLUMN_4, COLUMN_5,
      COLUMN_6, COLUMN_7, COLUMN_8, COLUMN_9, COLUMN_10, COLUMN_11, COLUMN_12, COLUMN_13,
      COLUMN_14, COLUMN_15, COLUMN_16, COLUMN_17, COLUMN_18, COLUMN_19, COLUMN_20, COLUMN_21,
      COLUMN_22, COLUMN_23, COLUMN_24, COLUMN_25, COLUMN_26, COLUMN_27, COLUMN_28, COLUMN_29,
      COLUMN_30, COLUMN_31, COLUMN_32, COLUMN_33, COLUMN_34, COLUMN_35, COLUMN_36, COLUMN_37,
      COLUMN_38};
  /**
   * Column start row for data in Excel file. Offset for Title and Header rows.
   * Assumption is to begin at 0.
   * 
   * A1 == (0,0) B1 == (0,1) A3 == (2,0)
   */
  public static final int START_COL = 2;
  /**
   * Max number of Columns. Assumption is to begin at 0.
   */
  public static final int MAX_COL_NUM = 37;
  /**
   * Max number of Rows. Assumption is to begin at START_COL.
   */
  public static final int MAX_ROW_NUM = 999;
}
