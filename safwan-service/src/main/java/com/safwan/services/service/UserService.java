package com.safwan.services.service;

import java.util.List;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.User;

public interface UserService {
	
	public List<User> listAllUsers();
	
	public void saveOrUpdate(User user);
	
	public User findUserById(int id);
	
	public void deleteUser(int id);
	
	public boolean validateLogin(User user)throws CustomException ;
	
	public User getUserDetails(User user);
}
