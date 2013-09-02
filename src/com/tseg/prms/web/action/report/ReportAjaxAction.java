package com.tseg.prms.web.action.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tseg.prms.model.TableReport;
import com.tseg.prms.service.report.ReportService;

public class ReportAjaxAction extends ActionSupport {

	private String reportList;
	private String reportId; // 用于存放进行操作的报告ID
	private String reportContent; // 用于存放报告内容
	private String deleteStatue;

	public String loadPrivateReports() {
		String memberId = (String) ActionContext.getContext().getSession().get(
				"USER_ID");
		List<TableReport> reports = new ReportService().findById(Integer
				.parseInt(memberId));
		List<Map> reListObject = new ArrayList<Map>();
		for (TableReport report : reports) {
			Map<String,String> reportMap = new HashMap<String,String>();
			reportMap.put("reportType", ""+report.getReportType());
			reportMap.put("projectName", report.getTableProject()
					.getProjectName());
			reportMap.put("date", report.getBuildDate().toString().substring(0,10));
			reportMap.put("reportId", ""+report.getReportId());
			reListObject.add(reportMap);
		}
		JSONArray jo = JSONArray.fromObject(reListObject);
		this.reportList = jo.toString();
		System.out.println(reportList);
		return SUCCESS;
		// else return error;
	}

	public String deleteReport() {
		// 删除某个报告 报告的ID是 this.reportId
		new ReportService().deleteReport(Long.parseLong(reportId));
		deleteStatue = "ok";
		return SUCCESS;
		// else return error;
	}

	public String getReport(){
		reportContent= new ReportService().getReport(Long.parseLong(reportId));
		System.out.println(reportContent);
		return SUCCESS;
	}
	
	public String getReportContent() {
		return this.reportContent;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportList() {
		return reportList;
	}

	public void setReportList(String reportList) {
		this.reportList = reportList;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getDeleteStatue() {
		return deleteStatue;
	}

	public void setDeleteStatue(String deleteStatue) {
		this.deleteStatue = deleteStatue;
	}
}
