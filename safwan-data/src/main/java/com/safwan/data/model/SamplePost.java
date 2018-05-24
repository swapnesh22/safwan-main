package com.safwan.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

@Entity(name = "SamplePost")
@Table(name = "samplepost")
public class SamplePost {

	public SamplePost(String title) {
		super();
		this.title = title;
	}
	
	public SamplePost() {
	}

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SamplePostComment> comments = new ArrayList<SamplePostComment>();

	@OneToMany(mappedBy = "duppost", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SamplePostComment> comments1 = new ArrayList<SamplePostComment>();

	// Constructors, getters and setters removed for brevity

	public void addComment(SamplePostComment comment) {
		comments.add(comment);
		comments1.add(comment);
		comment.setPost(this);
		comment.setDuppost(this);
	}

	public void removeComment(SamplePostComment comment) {
		comments.remove(comment);
		comments1.remove(comment);
		comment.setPost(null);
		comment.setDuppost(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<SamplePostComment> getComments() {
		return comments;
	}

	public void setComments(List<SamplePostComment> comments) {
		this.comments = comments;
	}

	public List<SamplePostComment> getComments1() {
		return comments1;
	}

	public void setComments1(List<SamplePostComment> comments1) {
		this.comments1 = comments1;
	}

}
