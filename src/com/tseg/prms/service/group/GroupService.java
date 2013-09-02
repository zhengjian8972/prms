package com.tseg.prms.service.group;

import java.util.List;
import java.util.Random;

import com.tseg.prms.model.TableGroup;
import com.tseg.prms.model.TableProject;
import com.tseg.prms.persistence.TableGroupDAO;
import com.tseg.prms.persistence.TableProjectDAO;

public class GroupService {

	public final static int ADMIN = 0;
	public final static int NORMAL = 1;

	public String addGroup(int level, String name, String desc, int projectId) {
		TableProjectDAO tpd = new TableProjectDAO();
		TableProject tp = tpd.findById(projectId);
		if (tp == null)
			return "noproject";
		return addGroup(level, name, desc, tp);
	}

	public String addGroup(int level, String name, String desc, TableProject tp) {
		TableGroupDAO tgd = new TableGroupDAO();
		int id = createId();
		while (tgd.findById(id) != null) {
			id = createId();
		}
		TableGroup tg = new TableGroup(id, tp, level, name);
		if (desc != null && !desc.isEmpty()) {
			tg.setGroupDescription(desc);
		}

		tgd.save(tg);
		return id + "";
	}

	public List<TableGroup> findGroupByProjectId(int projectId) {
		TableGroupDAO tgd = new TableGroupDAO();
		return tgd.findByProjectId(projectId);
	}

	private int createId() {
		Random rd = new Random();
		return rd.nextInt(1000000);
	}
}
