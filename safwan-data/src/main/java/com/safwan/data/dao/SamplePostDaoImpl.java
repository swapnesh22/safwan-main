package com.safwan.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safwan.data.model.Category;
import com.safwan.data.model.SamplePost;
import com.safwan.data.model.SamplePostComment;

@Repository
public class SamplePostDaoImpl implements SamplePostDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(SamplePost post) {
		getSession().saveOrUpdate(post);
	}

	public void saveOrUpdate(SamplePostComment postComment) {
		getSession().saveOrUpdate(postComment);
	}
	
	public List<SamplePost> listAllPosts() {
		Criteria criteria = getSession().createCriteria(SamplePost.class);
		return criteria.list();
	}
	
	public List<SamplePostComment> listAllPostComments() {
		Criteria criteria = getSession().createCriteria(SamplePostComment.class);
		return criteria.list();
	}
	
	public SamplePost findPostById(Long postId) {
		SamplePost samplePost = (SamplePost)getSession().get(SamplePost.class, postId);
		//To lazily load the object and avoid LazyInitialization exception
		Hibernate.initialize(samplePost.getComments());
		return samplePost;
	}
	
}
