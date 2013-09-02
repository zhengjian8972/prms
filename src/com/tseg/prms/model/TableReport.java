package com.tseg.prms.model;

import java.util.Date;

/**
 * TableReport entity. @author MyEclipse Persistence Tools
 */

public class TableReport implements java.io.Serializable {

	// Fields

	private Long reportId;
	private TableMember tableMember;
	private TableProject tableProject;
	private Date buildDate;
	private String content;
	private Integer reportType;

	// Constructors

	/** default constructor */
	public TableReport() {
	}

	/** full constructor */
	public TableReport(Long reportId, TableMember tableMember,
			TableProject tableProject, Date buildDate, String content,
			Integer reportType) {
		this.reportId = reportId;
		this.tableMember = tableMember;
		this.tableProject = tableProject;
		this.buildDate = buildDate;
		this.content = content;
		this.reportType = reportType;
	}

	// Property accessors

	public Long getReportId() {
		return this.reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public TableMember getTableMember() {
		return this.tableMember;
	}

	public void setTableMember(TableMember tableMember) {
		this.tableMember = tableMember;
	}

	public TableProject getTableProject() {
		return this.tableProject;
	}

	public void setTableProject(TableProject tableProject) {
		this.tableProject = tableProject;
	}

	public Date getBuildDate() {
		return this.buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReportType() {
		return this.reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

}