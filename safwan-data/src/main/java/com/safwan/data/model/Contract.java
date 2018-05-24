package com.safwan.data.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CONTRACTMASTER")
public class Contract {

	@Id
	@GeneratedValue
	@Column(name="contractid")
	private Long contractid;
	
	private Long contractcode;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contractEntryDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contractStartDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contractEndDate;
	
	private String contractType;
	
	private String activeStatus;
	
	private int frequency;
	
	@Transient
	private String contractstatus;
	
	@OneToOne
	@JoinColumn(name = "yearid", nullable = true)
	public SubCategory year;
	
	@OneToOne
	@JoinColumn(name = "partyid", nullable = false)
	private PartyMaster party;
	
	@OneToOne
	@JoinColumn(name = "employeeid", nullable = false)
	private Employee creator;
	
	@OneToOne
	@JoinColumn(name = "branchid", nullable = true)
	public SubCategory branch;

	public Long getContractid() {
		return contractid;
	}

	public void setContractid(Long contractid) {
		this.contractid = contractid;
	}

	public Long getContractcode() {
		return contractcode;
	}

	public void setContractcode(Long contractcode) {
		this.contractcode = contractcode;
	}

	public Date getContractEntryDate() {
		return contractEntryDate;
	}

	public void setContractEntryDate(Date contractEntryDate) {
		this.contractEntryDate = contractEntryDate;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public SubCategory getYear() {
		return year;
	}

	public void setYear(SubCategory year) {
		this.year = year;
	}

	public PartyMaster getParty() {
		return party;
	}

	public void setParty(PartyMaster party) {
		this.party = party;
	}

	public Employee getCreator() {
		return creator;
	}

	public void setCreator(Employee creator) {
		this.creator = creator;
	}

	public SubCategory getBranch() {
		return branch;
	}

	public void setBranch(SubCategory branch) {
		this.branch = branch;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getContractstatus() {
		return contractstatus;
	}

	public void setContractstatus(String contractstatus) {
		this.contractstatus = contractstatus;
	}
	
}

