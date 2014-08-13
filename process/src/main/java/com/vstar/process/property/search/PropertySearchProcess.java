package com.vstar.process.property.search;

import java.util.List;
import java.util.Map;

public interface PropertySearchProcess {
   public List<Map<String,String>> findProperty ();
   public String findLatestProperties ();
}
