package com.safwan.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safwan.data.model.Category;
import com.safwan.data.model.PartyMaster;

@Repository
public class PartyMasterDaoImpl implements PartyMasterDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<PartyMaster> listAllParties() {
		Criteria criteria = getSession().createCriteria(PartyMaster.class);
		return criteria.list();
	}

	public void saveOrUpdate(PartyMaster party) {
		getSession().saveOrUpdate(party);
	}

	public PartyMaster findPartyById(Long id) {
		PartyMaster party = (PartyMaster) getSession().get(PartyMaster.class, id);
		return party;
	}

	public void deletePartyMaster(Long id) {
		PartyMaster party = (PartyMaster) getSession().get(PartyMaster.class, id);
		getSession().delete(party);
		//throw new CustomGenericException("GEN001","Error in deleting record");
	}

}
