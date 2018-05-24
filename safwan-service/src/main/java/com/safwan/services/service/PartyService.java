package com.safwan.services.service;

import java.util.List;

import com.safwan.data.model.Category;
import com.safwan.data.model.PartyMaster;

public interface PartyService {
	
	public List<PartyMaster> listAllParties();
	
	public void saveOrUpdate(PartyMaster party);
	
	public PartyMaster findPartyById(Long id);
	
	public void deleteParty(Long id);
}
