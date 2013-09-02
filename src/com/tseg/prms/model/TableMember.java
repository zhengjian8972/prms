package com.tseg.prms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TableMember entity. @author MyEclipse Persistence Tools
 */

public class TableMember implements java.io.Serializable {

	// Fields

	private Integer memberId;
	private String memberName;
	private String password;
	private String email;
	private Set<TableReport> tableReports = new HashSet(0);
	private Set<TableMemberGroup> tableMemberGroups = new HashSet(0);

	// Constructors

	/** default constructor */
	public TableMember() {
	}

	/** minimal constructor */
	public TableMember(Integer memberId, String memberName, String password,String email) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.password = password;
		this.email= email;
	}

	/** full constructor */
	public TableMember(Integer memberId, String memberName, String password,String email,
			Set<TableReport> tableReports, Set<TableMemberGroup> tableMemberGroups) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.password = password;
		this.email = email;
		this.tableReports = tableReports;
		this.tableMemberGroups = tableMemberGroups;
	}

	// Property accessors

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<TableReport> getTableReports() {
		return this.tableReports;
	}

	public void setTableReports(Set<TableReport> tableReports) {
		this.tableReports = tableReports;
	}

	public Set<TableMemberGroup> getTableMemberGroups() {
		return this.tableMemberGroups;
	}

	public void setTableMemberGroups(Set<TableMemberGroup> tableMemberGroups) {
		this.tableMemberGroups = tableMemberGroups;
	}

}