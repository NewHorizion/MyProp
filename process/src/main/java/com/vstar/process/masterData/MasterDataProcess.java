package com.vstar.process.masterData;

import java.util.List;
import java.util.Map;

import com.vstar.common.PropertyTypeEnum;
import com.vstar.common.BudgetEnum;
import com.vstar.process.masterData.infoBean.PropCityInfo;
import com.vstar.process.masterData.infoBean.PropLocationInfo;
import com.vstar.process.masterData.infoBean.PropStateInfo;

public interface MasterDataProcess {
    public   Map<String, Map<PropStateInfo, Map<PropCityInfo, List<PropLocationInfo>>>> getLocationMasterData ();
    public   Map<Integer, PropertyTypeEnum> getPropertyTypes ();
    public   Map<Integer, BudgetEnum> getRentBudgets ();
    public   Map<Integer, BudgetEnum> getSaleBudgets ();
    public String readMasterData();
}
