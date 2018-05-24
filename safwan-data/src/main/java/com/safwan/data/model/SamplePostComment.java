package com.safwan.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

@Entity(name = "SamplePostComment")
@Table(name = "samplepostcomment")
public class SamplePostComment {
 
	@Id
    @GeneratedValue
    private Long id;
 
    public SamplePostComment(String review) {
		super();
		this.review = review;
	}
    
    public SamplePostComment() {
    	
    }
    
	private String review;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private SamplePost post;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dup_post_id")
    private SamplePost duppost;
 
    //Constructors, getters and setters removed for brevity
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SamplePostComment )) return false;
        return id != null && id.equals(((SamplePostComment) o).id);
    }
    @Override
    public int hashCode() {
        return 31;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public SamplePost getPost() {
		return post;
	}
	public void setPost(SamplePost post) {
		this.post = post;
	}
	public SamplePost getDuppost() {
		return duppost;
	}
	public void setDuppost(SamplePost duppost) {
		this.duppost = duppost;
	}

}


