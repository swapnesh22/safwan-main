package com.safwan.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PARTYMASTER")
public class PartyMaster {

	@Id
	@GeneratedValue
	@Column(name="partyid")
	private Long partyId;
	
	@OneToOne
	@JoinColumn(name="subcategoryid")
	private SubCategory partytype;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="contactperson")
	private String contactperson;
	
	@Column(name="cellphone")
	private String cellphone;
	
	@Column(name="contactphone")
	private String contactphone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="activestatus")
	private boolean activestatus;
	
	@OneToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	
	@OneToOne
	@JoinColumn(name = "branchid", referencedColumnName="subcategoryid")
	public SubCategory branch;
	
	private User user;
	
	public PartyMaster() {
		
	}

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public SubCategory getPartytype() {
		return partytype;
	}

	public void setPartytype(SubCategory partytype) {
		this.partytype = partytype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActivestatus() {
		return activestatus;
	}

	public void setActivestatus(boolean activestatus) {
		this.activestatus = activestatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public SubCategory getBranch() {
		return branch;
	}

	public void setBranch(SubCategory branch) {
		this.branch = branch;
	}
}

