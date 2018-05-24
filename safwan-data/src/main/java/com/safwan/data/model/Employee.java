package com.safwan.data.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="employeeid")
	private Long employeeId;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="cellphone")
	private String cellphone;
	
	@Column(name="contactphone")
	private String contactphone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="doj")
	private Date doj;
	
	//@Email
	@Column(name="email")
	private String email;
	
	@Column(name="activestatus")
	private boolean activestatus;
	
	@Column (name = "creator")
	private String creatorname; //username
	
	/*@ManyToOne
	@JoinColumn(name="departmentid", nullable = true)
	private Department department;*/
	
	@OneToOne
	@JoinColumn(name = "departmentid", nullable = true)
	public SubCategory department;
	
	@OneToOne
	@JoinColumn(name = "designationid", nullable = true)
	public SubCategory designation;
	
	@OneToOne
	@JoinColumn(name = "branchid", nullable = true)
	public SubCategory branch;
	
	public Employee() {
		
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
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

	public SubCategory getDepartment() {
		return department;
	}

	public void setDepartment(SubCategory department) {
		this.department = department;
	}

	public SubCategory getDesignation() {
		return designation;
	}

	public void setDesignation(SubCategory designation) {
		this.designation = designation;
	}

	public SubCategory getBranch() {
		return branch;
	}

	public void setBranch(SubCategory branch) {
		this.branch = branch;
	}

	public String getCreatorname() {
		return creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}
}

