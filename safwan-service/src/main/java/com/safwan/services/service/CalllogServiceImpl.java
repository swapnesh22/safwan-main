package com.safwan.services.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safwan.data.dao.CalllogDao;
import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Calllog;
import com.safwan.data.model.User;

@Service
@Transactional
public class CalllogServiceImpl implements CalllogService {
	
	CalllogDao calllogDao;
	
	@Autowired
	public void setCalllogDao(CalllogDao calllogDao) {
		this.calllogDao = calllogDao;
	}

	public Set<Calllog> listAllCalllogs() throws CustomException {
		return calllogDao.listAllCalllogs();
	}

	public void saveOrUpdate(Calllog calllog) {
		calllogDao.saveOrUpdate(calllog);
		
	}

	public Calllog findCalllogById(Long id) {
		return calllogDao.findCalllogById(id);
	}

	public void deleteCalllog(Long id) {
		//calllogDao.deleteCalllog(id);
		throw new CustomException("GEN001","Error in deleting record");
	}

	public Set<Calllog> listCalllogByUser(User user) {
		return calllogDao.listCalllogByUser(user);
	}
}
