package com.tseg.prms.persistence;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tseg.prms.model.TableMember;
import com.tseg.prms.model.TableProject;
import com.tseg.prms.model.TableReport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TableReport entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tseg.prms.model.TableReport
 * @author MyEclipse Persistence Tools
 */

public class TableReportDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TableReportDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String REPORT_TYPE = "reportType";

	public void save(TableReport transientInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("saving TableReport instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		trans.commit();
	}

	public void delete(TableReport persistentInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("deleting TableReport instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		trans.commit();
	}

	public TableReport findById(java.lang.Long id) {
		log.debug("getting TableReport instance with id: " + id);
		try {
			TableReport instance = (TableReport) getSession().get(
					"com.tseg.prms.model.TableReport", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TableReport instance) {
		log.debug("finding TableReport instance by example");
		try {
			List results = getSession().createCriteria(
					"com.tseg.prms.model.TableReport").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TableReport instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TableReport as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByMember(TableMember tm) {
		return findByMemberId(tm.getMemberId());
	}
	
	public List<TableReport> findByMemberId(Integer Id) {
		log.debug("finding TableReport instance with memberId: MemberId, value: " + Id);
		try {
			String queryString = "from TableReport as model where model.tableMember.memberId"
					+ "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, Id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProject(TableProject tp) {
		return findByProjectId(tp.getProjectId());
	}
	
	public List findByProjectId(Integer Id) {
		log.debug("finding TableReport instance with projectId: ProjectId, value: " + Id);
		try {
			String queryString = "from TableReport as model where model.tableProject.projectId"
					+ "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, Id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<TableReport> findByMemberIdAndProjectId(Integer memberId, Integer projectId) {
		log.debug("finding TableReport instance with projectId: ProjectId, value: " + projectId +
				"MemberId: MemberId,value" + memberId);
		try {
			String queryString = "from TableReport as model where model.tableProject.projectId"
					+ "= ? and model.tableMember.memberId= ?" ;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, projectId);
			queryObject.setParameter(1, memberId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByReportType(Object reportType) {
		return findByProperty(REPORT_TYPE, reportType);
	}

	public List findAll() {
		log.debug("finding all TableReport instances");
		try {
			String queryString = "from TableReport";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TableReport merge(TableReport detachedInstance) {
		log.debug("merging TableReport instance");
		try {
			TableReport result = (TableReport) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TableReport instance) {
		log.debug("attaching dirty TableReport instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TableReport instance) {
		log.debug("attaching clean TableReport instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}