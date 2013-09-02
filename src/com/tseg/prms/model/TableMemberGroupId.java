package com.tseg.prms.model;

/**
 * TableMemberGroupId entity. @author MyEclipse Persistence Tools
 */

public class TableMemberGroupId implements java.io.Serializable {

	// Fields

	private TableMember tableMember;
	private TableGroup tableGroup;

	// Constructors

	/** default constructor */
	public TableMemberGroupId() {
	}

	/** full constructor */
	public TableMemberGroupId(TableMember tableMember, TableGroup tableGroup) {
		this.tableMember = tableMember;
		this.tableGroup = tableGroup;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TableMemberGroupId))
			return false;
		TableMemberGroupId castOther = (TableMemberGroupId) other;

		return ((this.getTableMember() == castOther.getTableMember()) || (this
				.getTableMember() != null
				&& castOther.getTableMember() != null && this.getTableMember()
				.equals(castOther.getTableMember())))
				&& ((this.getTableGroup() == castOther.getTableGroup()) || (this
						.getTableGroup() != null
						&& castOther.getTableGroup() != null && this
						.getTableGroup().equals(castOther.getTableGroup())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTableMember() == null ? 0 : this.getTableMember()
						.hashCode());
		result = 37
				* result
				+ (getTableGroup() == null ? 0 : this.getTableGroup()
						.hashCode());
		return result;
	}

}