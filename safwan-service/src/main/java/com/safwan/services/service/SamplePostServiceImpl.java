package com.safwan.services.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safwan.data.dao.SamplePostDao;
import com.safwan.data.model.SamplePost;
import com.safwan.data.model.SamplePostComment;

@Service
@Transactional
public class SamplePostServiceImpl implements SamplePostService {

	SamplePostDao samplePostDao;
		
	@Autowired
	public void setSamplePostDao(SamplePostDao samplePostDao) {
		this.samplePostDao = samplePostDao;
	}

	public void saveOrUpdate(SamplePost post) {
		samplePostDao.saveOrUpdate(post);
	}

	public void saveOrUpdate(SamplePostComment postComment) {
		samplePostDao.saveOrUpdate(postComment);
	}

	public List<SamplePost> listAllPosts() {
		return samplePostDao.listAllPosts();
	}

	public List<SamplePostComment> listAllPostComments() {
		return samplePostDao.listAllPostComments();
	}
	
	public SamplePost findPostById(Long postId) {
		return samplePostDao.findPostById(postId);
	}
	
}
