package com.cd.repo;

public interface CdRepo {
	
	String seeCollection();
	
	String GotANewCd(String start);
	
	String AlterARecord(Long id, String CdToUpdate);
	
	String LostACd (Long id);

}
