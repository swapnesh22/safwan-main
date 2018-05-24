package com.safwan.data.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safwan.data.exception.CustomException;
import com.safwan.data.hash.PassSecureUtil;
import com.safwan.data.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	public static final String SALT = "SAF_PASS_WAN_WORD";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(User user) {
		user.setPassword(getHashedPassword(user));
		getSession().saveOrUpdate(user);
	}

	public User findUserById(int userId) {
		User user = (User) getSession().get(User.class, userId);
		return user;
	}
	
	private User findUserByUserName(User user) {
		Criteria criteria = getSession().createCriteria(User.class)
				   .add(Restrictions.like("username", user.getUsername().trim()));
		User user1 = null;
		for (Iterator it = criteria.list().iterator(); it.hasNext();) {
			user1 = (User)it.next();
		}
		return user1;
	}

	public boolean validateLogin(User user) throws CustomException {
		System.out.println("INSIDE VALIDATELOGIN");
		boolean status = false;
		String userEnteredWithHash = getHashedPassword(user);
		
		user = findUserByUserName(user);
		
		if (user != null 
				&& userEnteredWithHash.equals(user.getPassword())) {
			status = true;
		}
		return status;
	}
	
	private String getHashedPassword(User user) {
		String passwordToHash = SALT + user.getPassword();
		PassSecureUtil hash = new PassSecureUtil();
		String hashedPass = hash.getSHA1SecurePassword(passwordToHash);
		System.out.println("HasedPassword "+hashedPass);
		return hashedPass;
	}
	
	public User getUserDetails(User user) {
		System.out.println("INSIDE GETUSERDETAILS");
		Criteria criteria = getSession().createCriteria(User.class)
				   .add(Restrictions.like("username", user.getUsername()));
		
		User user1 = null;
		for (Iterator it = criteria.list().iterator(); it.hasNext();) {
			user1 = (User)it.next();
			if (user1.getType() != null && user1.getType().equals("Admin")) {
				user1.setAdmin(true);
			} else {
				user1.setAdmin(false);
			}
		}
		
		return user1;
	}

	public void deleteUser(int id) throws CustomException {
		User user = (User) getSession().get(User.class, id);
		getSession().delete(user);
		
	}

	public List<User> listAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return criteria.list();
	}
}
