package com.vstar.ui.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.aspose.cells.Cell;
import com.aspose.cells.Cells;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.Worksheets;
import com.opensymphony.xwork2.ActionSupport;
import com.vstar.common.PropertyPurchaseTypeEnum;
import com.vstar.common.PropertyTypeEnum;
import com.vstar.common.ValidationUtil;
import com.vstar.dao.PropCityDao;
import com.vstar.dao.PropStateDao;
import com.vstar.dao.process.PropCityDaoProcess;
import com.vstar.dao.process.PropStateDaoProcess;
import com.vstar.dao.process.propertyUpload.PropertyUploadProcess;
import com.vstar.dao.process.propertyUpload.RegistrationProcess;
import com.vstar.process.masterData.infoBean.PropLocationInfo;
import com.vstar.process.propertyDetailInfo.PropertyFeatureInfo;
import com.vstar.process.propertyDetailInfo.PropertyMandateInfo;
import com.vstar.process.propertyDetailInfo.RegistrationInfo;
import com.vstar.process.propertyDetailInfo.ResidentialPropInfo;
import com.vstar.process.propertyDetailInfo.ResidentialUnits;

public class DataUploadAction extends ActionSupport implements
		ServletRequestAware {
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
	private RegistrationProcess registrationProcess;
	private PropertyUploadProcess propertyUploadProcess;
	private PropStateDaoProcess propStateDaoProcess;
	private PropCityDaoProcess propCityDaoProcess;
	private static final String DOMAIN_NAME = "@prop.com";
	private static final String PASSWORD = "Welcome@123";
	
	public String execute() {
		String filePath = servletRequest.getSession().getServletContext()
				.getRealPath("/").concat("dataFiles");
		System.out.println("Image Location:" + filePath);// see the server
															// console
															// for actual
															// location
		File fileToCreate = new File(filePath, this.dataFileFileName);
		try {
			FileUtils.copyFile(this.dataFile, fileToCreate);
			try {
				importData(fileToCreate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// copying image in the new file
		return SUCCESS;
	}

	private void importData(File file) throws Exception {
		InputStream input = new FileInputStream(file);
		com.aspose.cells.Workbook workbook = null;
		try {
			workbook = new Workbook();
			workbook.open(input);
			Worksheets sheets = workbook.getWorksheets();
			boolean sheetFound = false;
			List<DataRowBean> totalRows = null;
			for (int x = 0; x < sheets.size(); x++) {
				xlSheet = workbook.getWorksheets().getSheet(x);
				if ("gurgaon".equalsIgnoreCase(xlSheet.getName())) {
					sheetFound = true;
					if (checkExcelSheetHeaders()) {
						totalRows = processExcelImport();
					}
					if(totalRows!=null && totalRows.size()>0)
					{
						loadData(totalRows);
					}
				}
			}
		} finally {
			if (workbook != null) {
				// Do nothing
			}
		}
	}

	private void loadData(List<DataRowBean> totalRows) throws Exception
	{
		for(DataRowBean row : totalRows)
		{
			// Create user registration 
			RegistrationInfo registrationInfo = new RegistrationInfo();
			long cityId = createCity(row.getState(),row.getCity());
			if(cityId!=0)
			{
				registrationInfo.setCityId((int)cityId);
			}
			registrationInfo.setEmailId(createEmail(row));
			registrationInfo.setLandlineNumber(row.getLandlineNumber());
			registrationInfo.setMobileNumber(row.getContact());
			registrationInfo.setNewUser(true);
			if(!ValidationUtil.isNullEmpty(row.getPassword()))
			{
				registrationInfo.setPassword(row.getPassword());
			}
			else
			{
				registrationInfo.setPassword(PASSWORD);
			}
			registrationInfo.setUserName(row.getUserName());
			registrationInfo.setUserType(row.getUserType());
			registrationInfo.setCompanyName(row.getCompanyName());
			registrationProcess.saveUserWithExtension(registrationInfo);
			// Create PropertyFeatureInfo
			PropertyMandateInfo propertyMandateInfo = new PropertyMandateInfo();
			propertyMandateInfo.setAddress(row.getPropertyAddress());
			long propCityId = createCity(row.getPropertyState(),row.getPropertyCity());
			propertyMandateInfo.setCity(String.valueOf(propCityId));
			if(!ValidationUtil.isNullEmpty(row.getCoveredArea()))
			{
				propertyMandateInfo.setCoveredArea(Integer.valueOf(row.getCoveredArea()));
			}
			ResidentialUnits coveredUnit = new ResidentialUnits();
			coveredUnit.setValue(row.getCoveredAreaUnit());
			propertyMandateInfo.setCoveredAreaUnit(coveredUnit);
			//TODO: location
			propertyMandateInfo.setLocality(null);
			if(!ValidationUtil.isNullEmpty(row.getPlotArea()))
			{
				propertyMandateInfo.setPlotArea(Integer.parseInt(row.getPlotArea()));
			}
			ResidentialUnits areaUnit = new ResidentialUnits();
			areaUnit.setValue(row.getPlotAreaUnit());
			propertyMandateInfo.setPlotAreaUnit(areaUnit);
			if(!ValidationUtil.isNullEmpty(row.getPropertyType()))
			{
				propertyMandateInfo.setPropertyTypeId(PropertyTypeEnum.valueOfString(row.getPropertyType()).getId());		
			}
			
			//TODO: set location
			PropLocationInfo propLocationInfo = new PropLocationInfo();
			propLocationInfo.setLocationName(row.getLocation());
			propertyMandateInfo.setPropLocationInfo(propLocationInfo);
			propertyMandateInfo.setPropPrice(formatMoney(row.getExpectedPrice()));
			
			if(!ValidationUtil.isNullEmpty(row.getPurchaseType()))
			{
				propertyMandateInfo.setPurchaseType(PropertyPurchaseTypeEnum.valueOfString(row.getPurchaseType()).getId());
			}
			propertyMandateInfo.setTransactionType(row.getTransactionType());
			propertyMandateInfo.setNegotiable(row.getNegotiable());
			
			ResidentialPropInfo residentialPropInfo = new ResidentialPropInfo();
			residentialPropInfo.setAvailableFrom(row.getPossessionBy());
			if(!ValidationUtil.isNullEmpty(row.getDealwithAgent()))
			{
				if("No".equalsIgnoreCase(row.getDealwithAgent()))
					residentialPropInfo.setDealingType(false);
				else
					residentialPropInfo.setDealingType(true);
			}
			else
			{
				residentialPropInfo.setDealingType(false);
			}
			ResidentialUnits externalAmenities = new ResidentialUnits();
			externalAmenities.setValue(row.getExternalAmenities());
			residentialPropInfo.setExternalAmenities(new ResidentialUnits[]{externalAmenities});
			ResidentialUnits floorNo = new ResidentialUnits();
			floorNo.setValue(row.getFloorNo());
			residentialPropInfo.setFloorNumber(floorNo);
			ResidentialUnits furnishedSts = new ResidentialUnits();
			furnishedSts.setValue(row.getFurnishedStatus());
			residentialPropInfo.setFurnishedStatus(furnishedSts);
			ResidentialUnits inHouseAmenities = new ResidentialUnits();
			inHouseAmenities.setValue(row.getInHouseAmenities());
			residentialPropInfo.setInHouseAmenities(new ResidentialUnits[]{inHouseAmenities});
			residentialPropInfo.setLandmarks(row.getLandmarks());
			ResidentialUnits balonies = new ResidentialUnits();
			balonies.setValue(row.getNoofBalconies());
			residentialPropInfo.setNoOfBalonies(balonies);
			ResidentialUnits bathrooms = new ResidentialUnits();
			bathrooms.setValue(row.getNoofBathrooms());
			residentialPropInfo.setNoOfBathRooms(bathrooms);
			
			ResidentialUnits bedRooms = new ResidentialUnits();
			bedRooms.setValue(row.getNoofBedrooms());
			residentialPropInfo.setNoOfBedRooms(bedRooms);
			
			residentialPropInfo.setPossessionStatus(row.getPossessionStatus());
			residentialPropInfo.setPropertyDescription(row.getBriefDescription());
			residentialPropInfo.setTermsNConditions(row.getTermsConditions());
			ResidentialUnits totalFlr = new ResidentialUnits();
			totalFlr.setValue(row.getTotalFloor());
			residentialPropInfo.setTotalFloor(totalFlr);
			residentialPropInfo.setBuilderSociety(row.getBuilderSociety());
			
			PropertyFeatureInfo propertyFeatureInfo = new PropertyFeatureInfo();
			propertyFeatureInfo.setPropertyMandateInfo(propertyMandateInfo);
			propertyFeatureInfo.setResidentialPropInfo(residentialPropInfo);
			
			boolean propertyCreated = propertyUploadProcess.savePropertyDetails(propertyFeatureInfo);
			
		}
	}
	
	private long formatMoney(String moneyInput)
	{
		long money = 0;
		if(!ValidationUtil.isNullEmpty(moneyInput))
		{
			long crDigit = 10000000;
			long lacDigit = 100000;
			if(moneyInput.contains("Cr"))
			{
				double cr = Double.valueOf(moneyInput.replace("Cr", "").replace(",", "").replace(" ", ""));
				money = (long)cr*crDigit;
			}
			else
			{
				double lacs = Double.valueOf(moneyInput.replace("Lacs", "").replace(",", "").replace(" ", ""));
				money = (long)lacs*lacDigit;
			}
		}
		return money;
	}
	
	private String createEmail(DataRowBean row)
	{
		if(row!=null)
		{
			if(!ValidationUtil.isNullEmpty(row.getEmailId()))
			{
				return row.getEmailId(); 
				
			}else if(!ValidationUtil.isNullEmpty(row.getUserName()))
			{
				return row.getUserName().replace(" ", "")+DOMAIN_NAME;
			}
		}
		return null;
	}
	// generate city id based on state .If state is not exist create new state and city
	private long createCity(String stateName, String cityName)
 {
		long cityId = 0;
		if (!ValidationUtil.isNullEmpty(stateName)
				&& !ValidationUtil.isNullEmpty(cityName)) {
			PropStateDao propStateDao = propStateDaoProcess
					.getPropStateDaoByName(stateName);
			if (propStateDao == null) {
				propStateDao = new PropStateDao(0, null, stateName, new Date());
				propStateDao = propStateDaoProcess
						.addUpdatePropStateDao(propStateDao);
			}
			if (propStateDao != null) {
				PropCityDao propCityDao = propCityDaoProcess
						.getPropCityByStateIdCityName(
								propStateDao.getPropStateId(), cityName);
				if (propCityDao != null) {
					cityId = propCityDao.getPropCityId();
				} else {
					propCityDao = new PropCityDao(0, propStateDao, cityName,
							new Date());
					propCityDao = propCityDaoProcess
							.addUpdatePropCityDao(propCityDao);
					cityId = propCityDao.getPropCityId();
				}
			}
		}
		return cityId;
	}
	
	private List<DataRowBean> processExcelImport() {
		long numRows = xlCells.getMaxRow();
		int y;
		List<DataRowBean> totalRows = new ArrayList<DataRowBean>();
		// initialize row to be 2 as first two are title and headers
		for (y = ExcelImportData.START_COL; y <= numRows; y++) {
			if (isBlankLine(y)) {
				break;
			}
			DataRowBean dataRowBean = new DataRowBean();
			for (int x = 0; x < ExcelImportData.MAX_COL_NUM; x++) {
				// this boolean allows validation to be stacked in appropriate
				// way
				String content = null;
				Cell cell = xlCells.getCell(y, x);
				content = cell.getStringValue().trim();
				switch (x) {
				case 0: {

					dataRowBean.setLoginName(content);
					break;
				}
				case 1: {
					dataRowBean.setUserName(content);
					break;
				}
				case 2: {
					dataRowBean.setCompanyName(content);
					break;
				}
				case 3: {
					dataRowBean.setEmailId(content);
					break;
				}
				case 4: {
					dataRowBean.setPassword(content);
					break;
				}
				case 5: {
					dataRowBean.setContact(content);
					break;
				}
				case 6: {
					dataRowBean.setLandlineNumber(content);
					break;
				}
				case 7: {
					dataRowBean.setState(content);
					break;
				}
				case 8: {
					dataRowBean.setCity(content);
					break;
				}
				case 9: {
					dataRowBean.setUserType(content);
					break;
				}
				case 10: {
					dataRowBean.setPurchaseType(content);
					break;
				}
				case 11: {
					dataRowBean.setPropertyType(content);
					break;
				}
				case 12: {
					dataRowBean.setTransactionType(content);
					break;
				}
				case 13: {
					dataRowBean.setPropertyState(content);
					break;
				}
				case 14: {
					dataRowBean.setPropertyCity(content);
					break;
				}
				case 15: {
					dataRowBean.setLocation(content);
					break;
				}
				case 16: {
					dataRowBean.setBuilderSociety(content);
					break;
				}
				case 17: {
					dataRowBean.setPropertyAddress(content);
					break;
				}
				case 18: {
					dataRowBean.setCoveredArea(content);
					break;
				}
				case 19: {
					dataRowBean.setCoveredAreaUnit(content);
					break;
				}
				case 20: {
					dataRowBean.setPlotArea(content);
					break;
				}
				case 21: {
					dataRowBean.setPlotAreaUnit(content);
					break;
				}
				case 22: {
					dataRowBean.setExpectedPrice(content);
					break;
				}
				case 23: {
					dataRowBean.setUnitPrice(content);
					break;
				}
				case 24: {
					dataRowBean.setNegotiable(content);
					break;
				}
				case 25: {
					dataRowBean.setNoofBedrooms(content);
					break;
				}
				case 26: {
					dataRowBean.setNoofBathrooms(content);
					break;
				}
				case 27: {
					dataRowBean.setNoofBalconies(content);
					break;
				}
				case 28: {
					dataRowBean.setFurnishedStatus(content);
					break;
				}
				case 29: {
					dataRowBean.setFloorNo(content);
					break;
				}
				case 30: {
					dataRowBean.setFacing(content);
					break;
				}
				case 31: {
					dataRowBean.setTotalFloor(content);
					break;
				}
				case 32: {
					dataRowBean.setPossessionStatus(content);
					break;
				}
				case 33: {
					dataRowBean.setPossessionBy(content);
					break;
				}
				case 34: {
					dataRowBean.setDealwithAgent(content);
					break;
				}
				case 35: {
					dataRowBean.setBriefDescription(content);
					break;
				}
				case 36: {
					dataRowBean.setLandmarks(content);
					break;
				}
				case 37: {
					dataRowBean.setTermsConditions(content);
					break;
				}
				case 38: {
					dataRowBean.setInHouseAmenities(content);
					break;
				}
				case 39: {
					dataRowBean.setExternalAmenities(content);
					break;
				}
				}
			}
			totalRows.add(dataRowBean);
		}
		return totalRows;
	}

	private boolean isBlankLine(int rowNum) {
		boolean isBlank = true;
		for (int colNum = 0; colNum < ExcelImportData.MAX_COL_NUM; colNum++) {
			Cell cell = xlCells.getCell(rowNum, colNum);
			if (!cell.getStringValue().equals("")) {
				isBlank = false;
			}
		}
		return isBlank;
	}

	private boolean checkExcelSheetHeaders() {
		boolean returnVal = true;
		xlCells = xlSheet.getCells();
		for (int x = 0; x < ExcelImportData.MAX_COL_NUM; x++) {
			Cell currentCell = xlCells.getCell(0, x);
			String header = currentCell.getStringValue();
			switch (x) {
			case 0: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_1)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 1: {
				if (!(header.equalsIgnoreCase(ExcelImportData.COLUMN_2))) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 2: {
				if (!(header.equalsIgnoreCase(ExcelImportData.COLUMN_3))) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 3: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_4)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 4: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_5)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 5: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_6)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 6: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_7)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 7: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_8)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 8: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_9)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 9: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_10)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 10: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_11)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 11: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_12)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 12: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_13)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 13: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_14)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 14: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_15)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 15: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_16)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 16: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_17)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 17: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_18)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 18: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_19)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 19: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_20)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 20: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_21)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 21: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_22)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 22: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_23)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 23: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_24)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 24: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_25)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 25: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_26)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 26: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_27)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 27: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_28)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 28: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_29)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 29: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_30)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 30: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_31)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 31: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_32)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 32: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_33)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 33: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_34)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 34: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_35)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 35: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_36)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 36: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_37)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 37: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_38)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 38: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_39)) {
					System.out.println(header);
					returnVal = false;
				}
				break;
			}
			case 39: {
				if (!header.equalsIgnoreCase(ExcelImportData.COLUMN_40)) {
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
	public File getDataFile() {
		return dataFile;
	}

	/**
	 * @param dataFile
	 *            the dataFile to set
	 */
	public void setDataFile(File dataFile) {
		this.dataFile = dataFile;
	}

	/**
	 * @return the dataFileContentType
	 */
	public String getDataFileContentType() {
		return dataFileContentType;
	}

	/**
	 * @param dataFileContentType
	 *            the dataFileContentType to set
	 */
	public void setDataFileContentType(String dataFileContentType) {
		this.dataFileContentType = dataFileContentType;
	}

	/**
	 * @return the dataFileFileName
	 */
	public String getDataFileFileName() {
		return dataFileFileName;
	}

	/**
	 * @param dataFileFileName
	 *            the dataFileFileName to set
	 */
	public void setDataFileFileName(String dataFileFileName) {
		this.dataFileFileName = dataFileFileName;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	/**
	 * @return the registrationProcess
	 */
	public RegistrationProcess getRegistrationProcess() {
		return registrationProcess;
	}

	/**
	 * @param registrationProcess the registrationProcess to set
	 */
	public void setRegistrationProcess(RegistrationProcess registrationProcess) {
		this.registrationProcess = registrationProcess;
	}

	/**
	 * @return the propertyUploadProcess
	 */
	public PropertyUploadProcess getPropertyUploadProcess() {
		return propertyUploadProcess;
	}

	/**
	 * @param propertyUploadProcess the propertyUploadProcess to set
	 */
	public void setPropertyUploadProcess(PropertyUploadProcess propertyUploadProcess) {
		this.propertyUploadProcess = propertyUploadProcess;
	}

	public PropStateDaoProcess getPropStateDaoProcess() {
		return propStateDaoProcess;
	}

	public void setPropStateDaoProcess(PropStateDaoProcess propStateDaoProcess) {
		this.propStateDaoProcess = propStateDaoProcess;
	}

	public PropCityDaoProcess getPropCityDaoProcess() {
		return propCityDaoProcess;
	}

	public void setPropCityDaoProcess(PropCityDaoProcess propCityDaoProcess) {
		this.propCityDaoProcess = propCityDaoProcess;
	}
	
}