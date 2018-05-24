package com.safwan.data.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CALLLOG")
public class Calllog {

	@Id
	@GeneratedValue
	@Column(name="calllogid")
	private Long calllogid;
	
	private Long calllognumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date callLogDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date visitDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date callAssignDate;
	
	private Time visitTime;
	
	private String reasonVisit;
	
	private String activeStatus;
	
	private String callType;
	
	@OneToOne
	@JoinColumn(name = "contractid", nullable = true)
	public Contract contract;
	
	@OneToOne
	@JoinColumn(name = "yearid", nullable = true)
	public SubCategory year;
	
	@OneToOne
	@JoinColumn(name = "partyid", nullable = false)
	private PartyMaster party;
	
	@OneToOne
	@JoinColumn(name = "employeeid", nullable = true)
	private Employee creator;
	
	@OneToOne
	@JoinColumn(name = "branchid", nullable = true)
	public SubCategory branch;

	public Long getCalllogid() {
		return calllogid;
	}

	public void setCalllogid(Long calllogid) {
		this.calllogid = calllogid;
	}

	public Long getCalllognumber() {
		return calllognumber;
	}

	public void setCalllognumber(Long calllognumber) {
		this.calllognumber = calllognumber;
	}

	public Date getCallLogDate() {
		return callLogDate;
	}

	public void setCallLogDate(Date callLogDate) {
		this.callLogDate = callLogDate;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Time getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Time visitTime) {
		this.visitTime = visitTime;
	}

	public String getReasonVisit() {
		return reasonVisit;
	}

	public void setReasonVisit(String reasonVisit) {
		this.reasonVisit = reasonVisit;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
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

	public Date getCallAssignDate() {
		return callAssignDate;
	}

	public void setCallAssignDate(Date callAssignDate) {
		this.callAssignDate = callAssignDate;
	}

	
}

