package com.cd.repo;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.cd.start.Start;
import com.cd.util.JSONUtil;





@Transactional(SUPPORTS)
@Default
public class CdDataBase implements CdRepo {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
    public String seeCollection() {   	    			    			
    	Query query = manager.createQuery("Select a FROM Account a");
    	Collection<Start> CDS = (Collection<Start>) query.getResultList();
    	return util.getJSONForObject(CDS);   	
    }
	
    @Transactional(REQUIRED)
    public String GotANewCd (String start) {
    	Start anAccount = util.getObjectForJSON(start, Start.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
    @Transactional(REQUIRED)
    public String AlterARecord(Long id, String CdToUpdate) {

    		Start updatedcollection = util.getObjectForJSON(CdToUpdate, Start.class);
    		Start collectionFromDB = findMyCD(id);
    		if (CdToUpdate != null) {
    			collectionFromDB = updatedcollection;
    			manager.merge(collectionFromDB);
    		}
    		return "{\"message\": \"account sucessfully updated\"}";
    }
	
    @Transactional(REQUIRED)
    public String LostACd (Long id) {
    	Start accountInDB = findMyCD(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
    
    private Start findMyCD(Long id) {
		return manager.find(Start.class, id);
	}
}

