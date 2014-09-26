package com.vstar.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.aspose.cells.Cell;
import com.aspose.cells.Cells;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.Worksheets;
import com.opensymphony.xwork2.ActionSupport;

public class DataUploadAction extends ActionSupport implements ServletRequestAware
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private File dataFile;
  private String dataFileContentType;
  private String dataFileFileName;
  private HttpServletRequest servletRequest;
  private Worksheet xlSheet = null;
  private Cells xlCells = null;

  public String execute()
  {
    String filePath = servletRequest.getSession().getServletContext().getRealPath("/")
        .concat("dataFiles");
    System.out.println("Image Location:" + filePath);// see the server console
                                                     // for actual location
    File fileToCreate = new File(filePath, this.dataFileFileName);
    try
    {
      FileUtils.copyFile(this.dataFile, fileToCreate);
      try
      {
        importData(fileToCreate);
      }
      catch (Exception e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }// copying image in the new file
    return SUCCESS;
  }

  private void importData(File file) throws Exception
  {
    InputStream input = new FileInputStream(file);
    com.aspose.cells.Workbook workbook = null;
    try
    {
      workbook = new Workbook();
      workbook.open(input);
      Worksheets sheets = workbook.getWorksheets();
      boolean sheetFound = false;
      for (int x = 0; x < sheets.size(); x++)
      {
        xlSheet = workbook.getWorksheets().getSheet(x);
        if ("gurgaon".equalsIgnoreCase(xlSheet.getName()))
        {
          sheetFound = true;
          if (checkExcelSheetHeaders())
          {
            processExcelImport();
          }
        }
      }
    }
    finally
    {
      if (workbook != null)
      {
        // workbook.close();
      }
    }
  }

  private void processExcelImport()
  {
    long numRows = xlCells.getMaxRow();
    long numCols = xlCells.getMaxColumn();
    String currentLocation = null;
    int y;
    // initialize row to be 2 as first two are title and headers
    for (y = ExcelImportData.START_COL; y <= numRows; y++)
    {
      if (isBlankLine(y))
      {
        break;
      }
      for (int x = 0; x < ExcelImportData.MAX_COL_NUM; x++)
      {
        // this boolean allows validation to be stacked in appropriate way
        String content = null;
        Cell cell = xlCells.getCell(y, x);
        content = cell.getStringValue().trim();
        currentLocation = cell.getName();
        switch (x)
        {
          case 0 : {
           
            System.out.println(content+"  ");
            break;
          }
          case 1 : {
            System.out.println(content+"  ");
            break;
          }
          case 2 : {
            System.out.println(content+"  ");
            break;
          }
          case 3 : {
            System.out.println(content+"  ");
            break;
          }
          case 4 : {
            System.out.println(content+"  ");
            break;
          }
          case 5 : {
            System.out.println(content+"  ");
            break;
          }
          case 6 : {
            System.out.println(content+"  ");
            break;
          }
          case 7 : {
            System.out.println(content+"  ");
            break;
          }
          case 8 : {
            System.out.println(content+"  ");
            break;
          }
          case 9 : {
            System.out.println(content+"  ");
            break;
          }
          case 10 : {
            System.out.println(content+"  ");
            break;
          }
          case 11 : {
            System.out.println(content+"  ");
            break;
          }
          case 12 : {
            System.out.println(content+"  ");
            break;
          }
          case 13 : {
            System.out.println(content+"  ");
            break;
          }
          case 14 : {
            System.out.println(content+"  ");
            break;
          }
          case 15 : {
            System.out.println(content+"  ");
            break;
          }
          case 16 : {
            System.out.println(content+"  ");
            break;
          }
          case 17 : {
            System.out.println(content+"  ");
            break;
          }
          case 18 : {
            System.out.println(content+"  ");
            break;
          }
          case 19 : {
            System.out.println(content+"  ");
            break;
          }
          case 20 : {
            System.out.println(content+"  ");
            break;
          }
          case 21 : {
            System.out.println(content+"  ");
            break;
          }
          case 22 : {
            System.out.println(content+"  ");
            break;
          }
          case 23 : {
            System.out.println(content+"  ");
            break;
          }
          case 24 : {
            System.out.println(content+"  ");
            break;
          }
          case 25 : {
            System.out.println(content+"  ");
            break;
          }
          case 26 : {
            System.out.println(content+"  ");
            break;
          }
          case 27 : {
            System.out.println(content+"  ");
            break;
          }
          case 28 : {
            System.out.println(content+"  ");
            break;
          }
          case 29 : {
            System.out.println(content+"  ");
            break;
          }
          case 30 : {
            System.out.println(content+"  ");
            break;
          }
          case 31 : {
            System.out.println(content+"  ");
            break;
          }
          case 32 : {
            System.out.println(content+"  ");
            break;
          }
          case 33 : {
            System.out.println(content+"  ");
            break;
          }
          case 34 : {
            System.out.println(content+"  ");
            break;
          }
          case 35 : {
            System.out.println(content+"  ");
            break;
          }
          case 36 : {
            System.out.println(content+"  ");
            break;
          }
          case 37 : {
            System.out.println(content+"  ");
            break;
          }
          case 38 : {
            System.out.println(content+"  ");
            break;
          }
          case 39 : {
            System.out.println(content+"  ");
            break;
          }
        }
      }
      System.out.println("\n");
    }
  }

  private boolean isBlankLine(int rowNum)
  {
    boolean isBlank = true;
    for (int colNum = 0; colNum < ExcelImportData.MAX_COL_NUM; colNum++)
    {
      Cell cell = xlCells.getCell(rowNum, colNum);
      if (!cell.getStringValue().equals(""))
      {
        isBlank = false;
      }
    }
    return isBlank;
  }

  private boolean checkExcelSheetHeaders()
  {
    boolean returnVal = true;
    xlCells = xlSheet.getCells();
    for (int x = 0; x < ExcelImportData.MAX_COL_NUM; x++)
    {
      Cell currentCell = xlCells.getCell(0, x);
      String header = currentCell.getStringValue();
      switch (x)
      {
        case 0 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_1))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 1 : {
          if (!(header.equalsIgnoreCase(ExcelImportData.COLUMN_2)))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 2 : {
          if (!(header.equalsIgnoreCase(ExcelImportData.COLUMN_3)))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 3 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_4))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 4 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_5))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 5 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_6))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 6 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_7))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 7 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_8))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 8 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_9))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 9 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_10))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 10 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_11))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 11 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_12))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 12 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_13))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 13 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_14))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 14 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_15))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 15 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_16))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 16 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_17))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 17 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_18))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 18 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_19))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 19 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_20))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 20 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_21))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 21 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_22))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 22 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_23))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 23 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_24))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 24 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_25))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 25 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_26))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 26 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_27))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 27 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_28))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 28 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_29))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 29 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_30))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 30 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_31))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 31 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_32))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 32 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_33))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 33 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_34))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 34 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_35))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 35 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_36))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 36 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_37))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 37 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_38))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 38 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_39))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
        case 39 : {
          if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_40))
          {
            System.out.println(header);
            returnVal = false;
          }
          break;
        }
      }
    }
    return returnVal;
  }

  /**
   * @return the dataFile
   */
  public File getDataFile()
  {
    return dataFile;
  }

  /**
   * @param dataFile the dataFile to set
   */
  public void setDataFile(File dataFile)
  {
    this.dataFile = dataFile;
  }

  /**
   * @return the dataFileContentType
   */
  public String getDataFileContentType()
  {
    return dataFileContentType;
  }

  /**
   * @param dataFileContentType the dataFileContentType to set
   */
  public void setDataFileContentType(String dataFileContentType)
  {
    this.dataFileContentType = dataFileContentType;
  }

  /**
   * @return the dataFileFileName
   */
  public String getDataFileFileName()
  {
    return dataFileFileName;
  }

  /**
   * @param dataFileFileName the dataFileFileName to set
   */
  public void setDataFileFileName(String dataFileFileName)
  {
    this.dataFileFileName = dataFileFileName;
  }

  public void setServletRequest(HttpServletRequest servletRequest)
  {
    this.servletRequest = servletRequest;
  }
}