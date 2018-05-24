package com.safwan.data.dao;

import java.util.List;

import com.safwan.data.model.Category;
import com.safwan.data.model.PartyMaster;

public interface PartyMasterDao {
	
	public List<PartyMaster> listAllParties();
	
	public void saveOrUpdate(PartyMaster party);
	
	public PartyMaster findPartyById(Long id);
	
	public void deletePartyMaster(Long id);
}
