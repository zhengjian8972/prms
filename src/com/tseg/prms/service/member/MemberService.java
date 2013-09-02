package com.tseg.prms.service.member;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.tseg.prms.model.TableGroup;
import com.tseg.prms.model.TableMember;
import com.tseg.prms.model.TableMemberGroup;
import com.tseg.prms.model.TableProject;
import com.tseg.prms.persistence.TableGroupDAO;
import com.tseg.prms.persistence.TableMemberDAO;
import com.tseg.prms.persistence.TableMemberGroupDAO;

public class MemberService {

	public final static int ADMIN = 0;
	public final static int NORMAL = 1;
	
	//判断是否登录成功
	public String loginSucc(String id, String pwd) {
		TableMemberDAO tmd = new TableMemberDAO();
		TableMember tm = tmd.findById(id);
		if(tm == null)
			return com.opensymphony.xwork2.Action.NONE;
		if(tm.getPassword().equals(pwd))
			return com.opensymphony.xwork2.Action.SUCCESS;
		return com.opensymphony.xwork2.Action.ERROR;
	}
	
	
	//根据用户ID获取用户名
	public String getMemberName(String id) {
		TableMemberDAO tmd = new TableMemberDAO();
		TableMember tm = tmd.findById(id);
		return tm.getMemberName();
	}
	
	//根据用户ID获取邮箱
	public String getMemberEmail(String id) {
		TableMemberDAO tmd = new TableMemberDAO();
		TableMember tm = tmd.findById(id);
		return tm.getEmail();
	}
	
	//添加成员
	public String addMember(String id, String name, String pwd,String email) {
		TableMemberDAO tmd = new TableMemberDAO();
		TableMember tm = tmd.findById(id);
		if(tm != null) {
			return "repeat";
		}
		
		tm = new TableMember();
		tm.setMemberId(Integer.parseInt(id));
		tm.setMemberName(name);
		tm.setPassword(pwd);
		tm.setEmail(email);
		
		tmd.save(tm);
		return "success";
	}
	
	//添加用户到组
	public String addMemberToGroup(String memberId, String GroupId, int level) {
		TableMemberGroupDAO tmgd = new TableMemberGroupDAO();
		TableMember tm = new TableMemberDAO().findById(memberId);
		if(tm == null) 
			return "nomember";
		TableGroup tg = new TableGroupDAO().findById(GroupId);
		if(tg == null) 
			return "nogroup";
		
		int mgId = createId();
		while(tmgd.findById(mgId) != null) {
			mgId = createId();
		}
		
		TableMemberGroup tmg = new TableMemberGroup(mgId, tm, tg, level);
		tmgd.save(tmg);
		return "success";
	}
	
	//根据用户ID获取用户所在项目信息
	public Set<TableProject> getProjects(Integer memberId) {
		Set<TableProject> result = new HashSet<TableProject>();
		Set<TableGroup> groups = getGroups(memberId);
		for(TableGroup group: groups) {
			result.add(group.getTableProject());
			System.out.println("get 1");
		}
		return result;
	}
	
	//根据用户ID获取用户所在组信息
	public Set<TableGroup> getGroups(Integer memberId) {
		Set<TableGroup> result = new HashSet<TableGroup>();
		List<TableMemberGroup> groups = new TableMemberGroupDAO().findByMemberId(memberId);
		for(TableMemberGroup group : groups) {
			result.add(group.getTableGroup());
		}
		return result;
	}
	
	private int createId() {
		Random rd = new Random();
		return  rd.nextInt(1000000);
	}
	
	//获取所有用户
	public List<TableMember> getMembers(){
		List<TableMember> groups = new TableMemberDAO().findAll();
		return groups;
	}
	
	//重置用户密码
	public void resPassword(String resMemberId){
		TableMemberDAO tmd =new TableMemberDAO();
		TableMember tm = tmd.findById(resMemberId);
		tm.setPassword("888888");
		tmd.edit(tm);
	}
	
	//删除用户
	public void deleteMember(String delMemberId){
		TableMemberDAO tmd =new TableMemberDAO();
		TableMember tm = tmd.findById(delMemberId);
		new TableMemberDAO().delete(tm);
	}
}
