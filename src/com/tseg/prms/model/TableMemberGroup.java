package com.tseg.prms.model;

/**
 * TableMemberGroup entity. @author MyEclipse Persistence Tools
 */

public class TableMemberGroup implements java.io.Serializable {

	// Fields

	private Integer memberGroupId;
	private TableMember tableMember;
	private TableGroup tableGroup;
	private Integer authority;

	// Constructors

	/** default constructor */
	public TableMemberGroup() {
	}

	/** full constructor */
	public TableMemberGroup(Integer memberGroupId, TableMember tableMember,
			TableGroup tableGroup, Integer authority) {
		this.memberGroupId = memberGroupId;
		this.tableMember = tableMember;
		this.tableGroup = tableGroup;
		this.authority = authority;
	}

	// Property accessors

	public Integer getMemberGroupId() {
		return this.memberGroupId;
	}

	public void setMemberGroupId(Integer memberGroupId) {
		this.memberGroupId = memberGroupId;
	}

	public TableMember getTableMember() {
		return this.tableMember;
	}

	public void setTableMember(TableMember tableMember) {
		this.tableMember = tableMember;
	}

	public TableGroup getTableGroup() {
		return this.tableGroup;
	}

	public void setTableGroup(TableGroup tableGroup) {
		this.tableGroup = tableGroup;
	}

	public Integer getAuthority() {
		return this.authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

}