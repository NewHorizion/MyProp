package com.vstar.process.property.search;

import com.vstar.process.propertyDetailInfo.RequirementInfo;


public interface PropertySearchProcess {
   public String findProperty (RequirementInfo requirementInfo);
   public String findLatestProperties ();
   public String findPropertyImages (Long id);
}
