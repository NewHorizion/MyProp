package com.vstar.process.masterData;

import java.util.List;
import java.util.Map;

public interface MasterDataProcess {
    public   Map<String, Map<String,List<String>>> getLocationMasterData ();
    public   Map<Integer, String> getPropertyTypes ();
    public String readMasterData();
}
