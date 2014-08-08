package com.vstar.process.property.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PropertySearchProcessImpl implements PropertySearchProcess {

	@Override
	public List<Map<String, String>> findProperty() {
		List<Map<String, String>> searchProperties = new ArrayList<Map<String, String>>();
		Map<String, String> property1 = new LinkedHashMap<String, String>();
		property1.put("propertyTitle", "2 BHK Multistorey Apartment in Rajarajeshwari Nagar");
		property1.put("projectName", "Lavkins Shelter");
		property1.put("developerName", "VS Shelters");
		property1.put("propPrice", "42.85 Lac(s) (Negotiable)");
		property1.put("rateSqft", "3,860/Sq-ft");
		searchProperties.add(property1);
		Map<String, String> property2 = new LinkedHashMap<String, String>();
		property2.put("propertyTitle", "2 BHK Multistorey Apartment in Banashankari Stage 3");
		property2.put("projectName", "Sapthagiri Nagar ");
		property2.put("developerName", "Bhagini Developers");
		property2.put("propPrice", "42.0 Lac(s)");
		property2.put("rateSqft", "3,677");
		searchProperties.add(property2);
		return searchProperties;
	}

}
