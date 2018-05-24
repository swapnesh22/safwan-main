package com.safwan.data.dao;

import java.util.Set;

import com.safwan.data.model.Contract;

public interface ContractDao {
	
	public Set<Contract> listAllContracts();
	
	public void saveOrUpdate(Contract contract);
	
	public Contract findContractById(Long id);
	
	public void deleteContract(Long id);
}
