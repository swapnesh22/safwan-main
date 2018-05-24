package com.safwan.data.dao;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.safwan.data.model.Category;
import com.safwan.data.model.Employee;
import com.safwan.data.model.PartyMaster;
import com.safwan.data.model.SamplePost;
import com.safwan.data.model.SamplePostComment;
import com.safwan.data.model.SubCategory;
import com.safwan.data.model.User;

//Temporary class which is for testing purpose
public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			//createPartyMaster(session);
			
			//createCategory(session);
			
			//createEmployee(session);
			
			//createUser(session);
			
			presistPostAndPostComment(session);
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private static void createEmployee(Session session) {
		Employee emp = new Employee();
		
		emp.setActivestatus(true);
		emp.setAddress("Mumbai");
		emp.setBranch(null);
		emp.setCellphone("9987383710");
		emp.setContactphone("1234567");
		emp.setDepartment(null);
		
		SubCategory catm = new SubCategory();
		Category cat1 = new Category();
		cat1.setCategoryid(193);
		cat1.setCategoryname("Designation");
		session.save(cat1);
		
		catm.setCategory(cat1);
		catm.setSubcategorydesc("AC");
		session.save(catm);
		emp.setDesignation(catm);
		
		emp.setDob(new Date(1980,8,22));
		emp.setDoj(new Date(2007,6,8));
		emp.setEmail("swkarpe@gmail.com");
		emp.setEmployeeId(new Long(11338));
		emp.setFirstname("Swapnesh");
		emp.setLastname("Karpe");
		
		session.save(emp);
	}

	private static void createCategory(Session session) {
		Category cat = new Category();
		cat.setCategoryname("Domain");
		session.save(cat);

		SubCategory catm1 = new SubCategory("d1");
		SubCategory catm2 = new SubCategory("d2");
		SubCategory catm3 = new SubCategory("d3");

		catm1.setCategory(cat);
		catm2.setCategory(cat);
		catm3.setCategory(cat);

		session.save(catm1);
		session.save(catm2);
		session.save(catm3);
	}

	private static void createPartyMaster(Session session) {
		
		PartyMaster pm = new PartyMaster();
		pm.setActivestatus(true);
		pm.setAddress("Address");
		pm.setBranch(null);
		pm.setCellphone("1234");
		pm.setContactphone("1234");
		pm.setEmail("abc");
		pm.setEmployee(null);
		pm.setName("Capgemini");
		pm.setPartytype(new SubCategory());
		
		User user = new User();
		user.setUsername("Test");
		user.setPassword("test");
		user.setType("AppUser");
		session.save(user);
		pm.setUser(user);
		
		session.save(pm);
	}
	
	private static void createUser(Session session) {
		User user = new User();
		user.setUsername("swapnesh");
		user.setPassword("swapnesh");
		session.save(user);
	}
	
	private static void presistPostAndPostComment(Session session) {
		SamplePost post = new SamplePost("First post");
		 
		post.addComment(
		    new SamplePostComment("My first review")
		);
		post.addComment(
		    new SamplePostComment("My second review")
		);
		post.addComment(
		    new SamplePostComment("My third review")
		);
		session.save(post);
	}
	
}
