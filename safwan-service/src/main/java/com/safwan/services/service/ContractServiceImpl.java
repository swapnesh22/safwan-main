package com.safwan.services.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safwan.data.dao.ContractDao;
import com.safwan.data.model.Contract;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {
	
	ContractDao cantractDao;
	
	@Autowired
	public void setContractDao(ContractDao cantractDao) {
		this.cantractDao = cantractDao;
	}

	public Set<Contract> listAllContracts() {
		return cantractDao.listAllContracts();
	}

	public void saveOrUpdate(Contract contract) {
		cantractDao.saveOrUpdate(contract);
		
	}

	public Contract findContractById(Long id) {
		return cantractDao.findContractById(id);
	}

	public void deleteContract(Long id) {
		cantractDao.deleteContract(id);	
	}

}
