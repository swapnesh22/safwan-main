package com.safwan.data.dao;

import java.util.List;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.User;

public interface UserDao {
	
	public void saveOrUpdate(User user);
	
	public User findUserById(int UserId);
	
	public User getUserDetails(User user);
	
	public void deleteUser(int id) throws CustomException;
	
	public boolean validateLogin(User user) throws CustomException;
	
	public List<User> listAllUsers();
}
