package com.tseg.prms.service.report;

import java.util.Date;
import java.util.List;

import com.tseg.prms.model.TableMember;
import com.tseg.prms.model.TableProject;
import com.tseg.prms.model.TableReport;
import com.tseg.prms.persistence.TableMemberDAO;
import com.tseg.prms.persistence.TableProjectDAO;
import com.tseg.prms.persistence.TableReportDAO;

public class ReportService {
	public static final int WEEK_REPORT = 0;
	public static final int MONTH_REPORT = 1;
	public static final int YEAR_REPORT = 2;

	public void writeReport(String projectId, String memberId, String date,
			String content, int type) {
		long id = System.currentTimeMillis();
		TableProject tp = new TableProjectDAO().findById(projectId);
		if (tp == null)
			return;
		TableMember tm = new TableMemberDAO().findById(memberId);
		if (tm == null)
			return;

		TableReport tr = new TableReport();
		tr.setReportId(id);
		tr.setTableProject(tp);
		tr.setTableMember(tm);
		tr.setBuildDate(new Date(date));
		tr.setContent(content);
		tr.setReportType(type);

		TableReportDAO trd = new TableReportDAO();
		trd.save(tr);
	}

	// 删除周报
	public void deleteReport(long id) {
		TableReportDAO trd = new TableReportDAO();
		System.out.println("DELETE GO");
		TableReport tr = trd.findById(id);

		trd.delete(tr);
	}

	// 根据周报ID获取周报内容
	public String getReport(long id) {
		TableReportDAO trd = new TableReportDAO();
		TableReport tr = trd.findById(id);
		return tr.getContent();
	}

	// 根据用户获取周报
	public List<TableReport> findById(Integer memberId) {
		return new TableReportDAO().findByMemberId(memberId);
	}

	// 根据用户获取周报数量
	public int getReportsNum(Integer memberId) {
		return findById(memberId).size() + 0;
	}

	// 根据用户及项目获取周报
	public List<TableReport> findById(Integer memberId, Integer projectId) {
		return new TableReportDAO().findByMemberIdAndProjectId(memberId,
				projectId);
	}

	// 根据用户及项目获取周报数量
	public int getReportsNum(Integer memberId, Integer projectId) {
		return findById(memberId, projectId).size();
	}
}
