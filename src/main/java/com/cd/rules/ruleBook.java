package com.cd.rules;

public interface ruleBook {
	
	String SeeCollection();
	
	String GotANewCd(String Start);
	
	String ChangeACd (Long id, String Start);
	
	String LostACd(Long id);

}
