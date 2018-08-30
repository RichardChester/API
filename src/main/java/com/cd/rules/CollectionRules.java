package com.cd.rules;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.cd.repo.CdRepo;


@Default
public class CollectionRules implements ruleBook  {
	
	private static final Logger LOGGER = Logger.getLogger(ruleBook.class);
	
	@Inject
	private CdRepo repo ;

	public String SeeCollection() {
		LOGGER.info("In CollectionRules SeeCollection ");
		return repo.seeCollection();
	}

	public String GotANewCd(String Start) {
		return repo.GotANewCd(Start);
	}

	public String ChangeACd(Long id, String Start) {
		return repo.AlterARecord(id, Start);
	}

	public String LostACd(Long id) {
		return repo.LostACd(id);
	}

}
