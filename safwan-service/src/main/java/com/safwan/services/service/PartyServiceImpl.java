package com.safwan.services.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safwan.data.dao.PartyMasterDao;
import com.safwan.data.model.Category;
import com.safwan.data.model.PartyMaster;

@Service
@Transactional
public class PartyServiceImpl implements PartyService {

	PartyMasterDao partyDao;
		
	@Autowired
	public void setCustomerDao(PartyMasterDao partyDao) {
		this.partyDao = partyDao;
	}

	public List<PartyMaster> listAllParties() {
		return partyDao.listAllParties();
	}

	public void saveOrUpdate(PartyMaster party) {
		partyDao.saveOrUpdate(party);
	}

	public PartyMaster findPartyById(Long id) {
		return partyDao.findPartyById(id);
	}

	public void deleteParty(Long id) {
		partyDao.deletePartyMaster(id);
		//throw new CustomGenericException("GEN001","Error in deleting record");
	}

	
}
