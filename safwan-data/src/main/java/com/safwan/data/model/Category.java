/**
 * 
 */
package com.safwan.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author skarpe
 *
 */
@Entity
@Table (name="CATEGORY")
@XmlRootElement
public class Category implements Serializable {
	
	public Category() {
		
	}
	
	public Category(String categoryname, Set<SubCategory> subcategories) {
		this.categoryname = categoryname;
		this.subcategories = subcategories;
	}

	private int categoryid;
	
	private String categoryname;
	
	private Set<SubCategory> subcategories = new HashSet<SubCategory>();
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "categoryid", nullable = false)
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	@Column (name = "categoryname", nullable = false)
	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@OneToMany (mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<SubCategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}
	
}
