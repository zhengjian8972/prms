package com.tseg.prms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TableGroup entity. @author MyEclipse Persistence Tools
 */

public class TableGroup implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer groupId;
	private TableProject tableProject;
	private Integer groupLevel;
	private String groupName;
	private String groupDescription;
	private Set<TableMemberGroup> tableMemberGroups = new HashSet<TableMemberGroup>(0);

	// Constructors

	/** default constructor */
	public TableGroup() {
	}

	/** minimal constructor */
	public TableGroup(Integer groupId, TableProject tableProject,
			Integer groupLevel, String groupName) {
		this.groupId = groupId;
		this.tableProject = tableProject;
		this.groupLevel = groupLevel;
		this.groupName = groupName;
	}

	/** full constructor */
	public TableGroup(Integer groupId, TableProject tableProject,
			Integer groupLevel, String groupName, String groupDescription,
			Set<TableMemberGroup> tableMemberGroups) {
		this.groupId = groupId;
		this.tableProject = tableProject;
		this.groupLevel = groupLevel;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.tableMemberGroups = tableMemberGroups;
	}

	// Property accessors

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public TableProject getTableProject() {
		return this.tableProject;
	}

	public void setTableProject(TableProject tableProject) {
		this.tableProject = tableProject;
	}

	public Integer getGroupLevel() {
		return this.groupLevel;
	}

	public void setGroupLevel(Integer groupLevel) {
		this.groupLevel = groupLevel;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return this.groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public Set<TableMemberGroup> getTableMemberGroups() {
		return this.tableMemberGroups;
	}

	public void setTableMemberGroups(Set<TableMemberGroup> tableMemberGroups) {
		this.tableMemberGroups = tableMemberGroups;
	}

}