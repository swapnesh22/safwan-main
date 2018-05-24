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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author skarpe
 *
 */
@Entity
@Table (name="SUBCATEGORY")
@XmlRootElement
public class SubCategory implements Serializable {
	
	public SubCategory() {
		
	}
	
	public SubCategory(String subcategorydesc) {
		this.subcategorydesc = subcategorydesc;
	}

	private int subcategoryid;
	
	private Category category;
	
	private String subcategorydesc;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid", nullable = true)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "subcategoryid", nullable = false)
	public int getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(int subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	@Column (name = "subcategorydesc")
	public String getSubcategorydesc() {
		return subcategorydesc;
	}

	public void setSubcategorydesc(String subcategorydesc) {
		this.subcategorydesc = subcategorydesc;
	}
	
}
