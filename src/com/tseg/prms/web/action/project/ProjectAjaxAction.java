package com.tseg.prms.web.action.project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tseg.prms.model.TableGroup;
import com.tseg.prms.model.TableMember;
import com.tseg.prms.model.TableMemberGroup;
import com.tseg.prms.model.TableProject;
import com.tseg.prms.model.TableReport;
import com.tseg.prms.service.member.MemberService;
import com.tseg.prms.service.project.ProjectService;
import com.tseg.prms.service.report.ReportService;


public class ProjectAjaxAction extends ActionSupport {
	private String userProjects;
	private String allProjects;
	private String selectedProject;
	private String projectId;
	
	public String loadUserProjects(){
		String memberId = (String) ActionContext.getContext().getSession().get(
		"USER_ID");
		Set<TableProject> projects = new MemberService().getProjects(Integer.parseInt(memberId));
		List<Map> projectsInfo =new ArrayList<Map>();
		for(TableProject project :projects){
			Map projectMap = new HashMap();
			projectMap.put("value", project.getProjectId()+" ("+project.getProjectName()+")");
			projectMap.put("label", "项目ID："+project.getProjectId());
			projectMap.put("desc",project.getProjectName());
			projectsInfo.add(projectMap);
		}
		JSONArray jo = JSONArray.fromObject(projectsInfo);
		this.userProjects = jo.toString();
		System.out.println(userProjects);
		return SUCCESS;
	}
	
	public String loadAllProjects(){
		List<TableProject> projectList = new ProjectService().getProjects();
		List<Map> projects =new ArrayList<Map>();
		for(TableProject project : projectList){
			Map projectMap = new HashMap();
			projectMap.put("projectName", project.getProjectName());
			projectMap.put("desc", project.getProjectDescription());
			int memberNum = 0;
			String projectAdmin="";
			for(TableGroup group : project.getTableGroups()){
				memberNum+= group.getTableMemberGroups().size();
				if(group.getGroupLevel()==0)
				{
					Set<TableMemberGroup> mgs = group.getTableMemberGroups();
					for(TableMemberGroup mg :mgs){
						projectAdmin += mg.getTableMember().getMemberName();
						projectAdmin +=";";
					}
				}
			}
			projectMap.put("projectId", project.getProjectId());
			projectMap.put("memberNum", memberNum+"");
			projectMap.put("projectAdmin", projectAdmin);
			projects.add(projectMap);
		}
		JSONArray jo = JSONArray.fromObject(projects);
		this.allProjects = jo.toString();
		System.out.println(allProjects);
	return SUCCESS;
	}
	
	public String loadProject(){
		ActionContext.getContext().getSession().put("CURRENT_PROJECT",projectId );
		selectedProject="";
		return SUCCESS;
	}
	
	public String getUserProjects() {
		return userProjects;
	}
	public void setUserProjects(String userProjects) {
		this.userProjects = userProjects;
	}

	public String getAllProjects() {
		return allProjects;
	}

	public void setAllProjects(String allProjects) {
		this.allProjects = allProjects;
	}

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
