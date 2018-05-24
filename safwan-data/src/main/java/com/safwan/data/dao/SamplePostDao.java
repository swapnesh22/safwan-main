package com.safwan.data.dao;

import java.util.List;

import com.safwan.data.model.SamplePost;
import com.safwan.data.model.SamplePostComment;

public interface SamplePostDao {
	
	public void saveOrUpdate(SamplePost post);
	
	public void saveOrUpdate(SamplePostComment postComment);
	
	public List<SamplePost> listAllPosts();
	
	public List<SamplePostComment> listAllPostComments();
	
	public SamplePost findPostById(Long postId);
}
