/**
 * 
 */
package com.safwan.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author skarpe
 *
 */
@Entity
@Table (name="USER")
@XmlRootElement
public class User implements Serializable {
	
	public User() {
		
	}
	
	public User(String username, String password, String type) {
		this.username = username;
		this.password = password;
		this.type = type;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "userid", nullable = false)
	private int userid;
	
	private String username;
	
	private String password;
	
	private String type;
	
	private boolean admin;
	
	@OneToOne
	@JoinColumn(name="partyid", nullable = true)
	private PartyMaster party;
	
	@OneToOne
	@JoinColumn(name="employeeid", nullable = true)
	private Employee employee;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Column (name = "username", unique = true, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Transient
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public PartyMaster getParty() {
		return party;
	}

	public void setParty(PartyMaster party) {
		this.party = party;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
