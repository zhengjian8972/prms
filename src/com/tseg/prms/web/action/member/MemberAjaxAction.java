package com.tseg.prms.web.action.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.tseg.prms.model.TableMember;
import com.tseg.prms.model.TableMemberGroup;
import com.tseg.prms.service.member.MemberService;

public class MemberAjaxAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberList;
	private String briefMemberList;
	private String delMemberId;
	private String resMemberId;
	private String resStatue;
	private String deleteStatue;

	// 导出所有成员的详细信息
	public String loadMemberList() {
		List<TableMember> members = new MemberService().getMembers();
		List<Map<String, String>> memListObject = new ArrayList<Map<String, String>>();
		for (TableMember member : members) {
			Map<String, String> memberMap = new HashMap<String, String>();
			memberMap.put("memberId", "" + member.getMemberId());
			memberMap.put("memberName", member.getMemberName());
			String projects = "";
			Set<TableMemberGroup> tgSet = member.getTableMemberGroups();
			if (tgSet.size() > 0) {
				Iterator<TableMemberGroup> itg = tgSet.iterator();
				while (itg.hasNext()) {
					TableMemberGroup memberGroup = itg.next();
					projects += (memberGroup.getTableGroup().getTableProject()
							.getProjectName() + ";	");
				}
				memberMap.put("memberProject",
						projects.substring(0, projects.length() - 1));
			} else
				memberMap.put("memberProject", "无");
			memListObject.add(memberMap);
		}
		JSONArray jo = JSONArray.fromObject(memListObject);
		this.memberList = jo.toString();
		System.out.println(memberList);
		return SUCCESS;
		// else return error;
	}

	public String loadBriefMemberList() {
		List<TableMember> members = new MemberService().getMembers();
		List<Map<String, String>> memListObject = new ArrayList<Map<String, String>>();
		for (TableMember member : members) {
			Map<String, String> memberMap = new HashMap<String, String>();
			memberMap.put("value",
					"" + member.getMemberId() + " (" + member.getMemberName()
							+ ")");
			memberMap.put("label", "用户ID：" + member.getMemberId());
			memberMap.put("desc", member.getMemberName());
			memListObject.add(memberMap);
		}
		JSONArray jo = JSONArray.fromObject(memListObject);
		this.briefMemberList = jo.toString();
		System.out.println(briefMemberList);
		return SUCCESS;
	}

	public String resMemberPsw() {
		System.out.println("reset" + resMemberId);
		new MemberService().resPassword(resMemberId);
		resStatue = "该用户密码重置为888888";
		return SUCCESS;
		// else return error;
	}

	public String deleteMember() {
		System.out.println("delete" + delMemberId);
		new MemberService().deleteMember(delMemberId);
		deleteStatue = "删除成功";
		return SUCCESS;
		// else return error;
	}

	public String getMemberList() {
		return memberList;
	}

	public void setMemberList(String memberList) {
		this.memberList = memberList;
	}

	public String getBriefMemberList() {
		return briefMemberList;
	}

	public void setBriefMemberList(String briefMemberList) {
		this.briefMemberList = briefMemberList;
	}

	public String getDelMemberId() {
		return delMemberId;
	}

	public void setDelMemberId(String delMemberId) {
		this.delMemberId = delMemberId;
	}

	public String getDeleteStatue() {
		return deleteStatue;
	}

	public void setDeleteStatue(String deleteStatue) {
		this.deleteStatue = deleteStatue;
	}

	public String getResMemberId() {
		return resMemberId;
	}

	public void setResMemberId(String resMemberId) {
		this.resMemberId = resMemberId;
	}

	public String getResStatue() {
		return resStatue;
	}

	public void setResStatue(String resStatue) {
		this.resStatue = resStatue;
	}
}
