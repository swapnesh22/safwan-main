package com.safwan.services.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safwan.data.dao.UserDao;
import com.safwan.data.exception.CustomException;
import com.safwan.data.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	UserDao userDao;
		
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}

	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	public List<User> listAllUsers() {
		return userDao.listAllUsers();
	}

	public boolean validateLogin(User user) throws CustomException {
		return userDao.validateLogin(user);
	}
	
	public User getUserDetails(User user) {
		return userDao.getUserDetails(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}
}
