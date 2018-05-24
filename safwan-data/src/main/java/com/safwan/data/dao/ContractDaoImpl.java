package com.safwan.data.dao;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safwan.data.model.Contract;

@Repository
public class ContractDaoImpl implements ContractDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Set<Contract> listAllContracts() {
		Criteria criteria = getSession().createCriteria(Contract.class);
		Set<Contract> contracts = new HashSet<Contract>();
		contracts.addAll(criteria.list());
		contracts = updateContractStatus(contracts);
		return contracts;
	}

	public void saveOrUpdate(Contract contract) {
		getSession().saveOrUpdate(contract);		
		
	}

	public Contract findContractById(Long id) {
		Contract contract = (Contract) getSession().get(Contract.class, id);
		return contract;
	}

	public void deleteContract(Long id) {
		Contract contract = (Contract) getSession().get(Contract.class, id);
		getSession().delete(contract);
	}
	
	private Set <Contract> updateContractStatus(Set<Contract> contracts) {
		
		for (Contract contract : contracts) {
			int numberOfMonths;
			contract.getContractStartDate();
			contract.getContractEndDate();
			
			numberOfMonths = compareDates(contract.getContractStartDate(), contract.getContractEndDate());
			/*int status = (contract.getContractStartDate()).compareTo(contract.getContractEndDate());
			//(contract.getContractStartDate()).
			if (status == 0) {
				System.out.println("SAME DATE");
			}
			if (status < 0) {
				System.out.println("START DATE IS OLDER THEN END DATE");
			}
			if (status > 0) {
				System.out.println("START DATE IS NEWER THEN END DATE");
			}*/
			if (numberOfMonths >= 6 && numberOfMonths < 12) {
				contract.setContractstatus("Amber");
			} else if (numberOfMonths == 12) {
				contract.setContractstatus("Red");
			}
			System.out.println("CONTRACTSTATUS IS =========>>>>>>>>> "+contract.getContractstatus());
		}
		
		return contracts;
	}
	
	private int compareDates(Date startDate, Date endDate) {
		int numberOfMonth;
		DateTime date1 = new DateTime (startDate.getTime());
		DateTime date2 = new DateTime (endDate.getTime());
		System.out.println("Months between two dates "+Months.monthsBetween(date1, date2).getMonths());
		numberOfMonth = Months.monthsBetween(date1, date2).getMonths();
		return numberOfMonth;
	}

}
