package com.safwan.services.service;

import java.util.Set;

import com.safwan.data.model.Contract;

public interface ContractService {
	
	public Set<Contract> listAllContracts();
	
	public void saveOrUpdate(Contract contract);
	
	public Contract findContractById(Long id);
	
	public void deleteContract(Long id);
}
