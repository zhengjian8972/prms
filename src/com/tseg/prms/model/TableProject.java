package com.tseg.prms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TableProject entity. @author MyEclipse Persistence Tools
 */

public class TableProject implements java.io.Serializable {

	// Fields

	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private Set tableReports = new HashSet(0);
	private Set<TableGroup> tableGroups = new HashSet(0);

	// Constructors

	/** default constructor */
	public TableProject() {
	}

	/** minimal constructor */
	public TableProject(Integer projectId, String projectName) {
		this.projectId = projectId;
		this.projectName = projectName;
	}

	/** full constructor */
	public TableProject(Integer projectId, String projectName,
			String projectDescription, Set tableReports, Set tableGroups) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.tableReports = tableReports;
		this.tableGroups = tableGroups;
	}

	// Property accessors

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return this.projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Set getTableReports() {
		return this.tableReports;
	}

	public void setTableReports(Set tableReports) {
		this.tableReports = tableReports;
	}

	public Set<TableGroup> getTableGroups() {
		return tableGroups;
	}

	public void setTableGroups(Set<TableGroup> tableGroups) {
		this.tableGroups = tableGroups;
	}

	

}