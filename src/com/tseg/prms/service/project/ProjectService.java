package com.tseg.prms.service.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tseg.prms.model.TableGroup;
import com.tseg.prms.model.TableMember;
import com.tseg.prms.model.TableProject;
import com.tseg.prms.persistence.TableGroupDAO;
import com.tseg.prms.persistence.TableMemberDAO;
import com.tseg.prms.persistence.TableProjectDAO;
import com.tseg.prms.service.group.GroupService;
import com.tseg.prms.service.member.MemberService;

public class ProjectService {
	
	public String addProject(String name, String admin, String desc) {
		TableMemberDAO tmd = new TableMemberDAO();
		TableMember tm = tmd.findById(admin);
		if(tm == null) return "noadmin";
		System.out.print("you zhege ren a ");
		String projectId = addProject(name, desc);
		GroupService gs = new GroupService();
		String groupId = gs.addGroup(GroupService.ADMIN, "admin", "管理员", Integer.parseInt(projectId));
		MemberService ms = new MemberService();
		ms.addMemberToGroup(admin, groupId, MemberService.ADMIN);
		return projectId ;
	}

	public String addMemberToProject(String projectId, String memberId,int groupLevel){
		TableMemberDAO tmd = new TableMemberDAO();
		TableMember tm = tmd.findById(memberId);
		if(tm == null) return "noadmin";
		System.out.print("you zhege ren a ");
		TableGroupDAO tg = new TableGroupDAO();
		List<TableGroup> gl = new ArrayList();
		gl = tg.findByProjectId(Integer.parseInt(projectId));
		for(TableGroup g : gl){
			if(g.getGroupLevel() == (groupLevel))
				{MemberService ms = new MemberService();
				ms.addMemberToGroup(memberId, g.getGroupId()+"", MemberService.ADMIN);
				break;}
		}
		
		return projectId ;
	}
	
	public String addProject(String name, String desc) {
		
		TableProjectDAO tpd  = new TableProjectDAO();
		int id = createId();
		while(tpd.findById(id) != null) {
			id = createId();
		}
		
 		TableProject tp = new TableProject(id, name);
		if(desc != null && !desc.isEmpty()) {
			tp.setProjectDescription(desc);
		}
		tpd.save(tp);
		return id + "";
	}
	
	public List<TableProject> getProjects(){
		TableProjectDAO tpd  = new TableProjectDAO();
		List<TableProject> tp = tpd.findAll();
		return tp;
	}
	
	private int createId() {
		Random rd = new Random();
		return  rd.nextInt(1000000);
	}
	
	public String getProjectName(String id){
		TableProjectDAO tpd = new TableProjectDAO();
		TableProject tp = tpd.findById(id);
		String projectName = tp.getProjectName();
		return projectName;
	}
}
