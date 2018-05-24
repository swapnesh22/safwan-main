package com.safwan.data.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Calllog;
import com.safwan.data.model.User;

@Repository
public class CalllogDaoImpl implements CalllogDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Set<Calllog> listAllCalllogs() throws CustomException {//exception handling
		Set<Calllog> calllogs = new HashSet<Calllog>();
		try {
			Criteria criteria = getSession().createCriteria(Calllog.class);
			calllogs.addAll(criteria.list());
		} catch (Exception e) {
			CustomException ce = new CustomException();
			ce.setErrMsg(e.getMessage());
			throw ce;
		}
		return calllogs;
	}

	public void saveOrUpdate(Calllog calllog) {
		getSession().saveOrUpdate(calllog);		
		
	}

	public Calllog findCalllogById(Long id) {
		Calllog calllog = (Calllog) getSession().get(Calllog.class, id);
		return calllog;
	}

	public void deleteCalllog(Long id) {
		Calllog calllog = (Calllog) getSession().get(Calllog.class, id);
		getSession().delete(calllog);
	}

	public Set<Calllog> listCalllogByUser(User user) {
		Criteria criteria = getSession().createCriteria(Calllog.class)
				   .add(Restrictions.eq("creator.employeeId", user.getEmployee().getEmployeeId()));
		
		System.out.println("CallLog size ==========>>>>>>>>>>>"+criteria.list().size());
		
		List calllogs = criteria.list();
		Set<Calllog> calls = new HashSet<Calllog>(calllogs);
		return calls;
	}
}
