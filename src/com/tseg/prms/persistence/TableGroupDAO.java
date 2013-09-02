package com.tseg.prms.persistence;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tseg.prms.model.TableGroup;
import com.tseg.prms.model.TableProject;

/**
 * A data access object (DAO) providing persistence and search support for
 * TableGroup entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.tseg.prms.model.TableGroup
 * @author MyEclipse Persistence Tools
 */

public class TableGroupDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TableGroupDAO.class);
	// property constants
	public static final String GROUP_LEVEL = "groupLevel";
	public static final String GROUP_NAME = "groupName";
	public static final String GROUP_DESCRIPTION = "groupDescription";

	public void save(TableGroup transientInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("saving TableGroup instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		trans.commit();
	}

	public void delete(TableGroup persistentInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("deleting TableGroup instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		trans.commit();
	}
	
	public TableGroup findById(java.lang.String id) {
		return findById(Integer.parseInt(id));
	}

	public TableGroup findById(java.lang.Integer id) {
		log.debug("getting TableGroup instance with id: " + id);
		try {
			TableGroup instance = (TableGroup) getSession().get(
					"com.tseg.prms.model.TableGroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TableGroup instance) {
		log.debug("finding TableGroup instance by example");
		try {
			List results = getSession().createCriteria(
					"com.tseg.prms.model.TableGroup").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByProject(TableProject tp) {
		return findByProjectId(tp.getProjectId());
	}
	
	public List<TableGroup> findByProjectId(Integer Id) {
		log.debug("finding TableGroup instance with projcetId: ProjectId, value: " + Id);
		try {
			String queryString = "from TableGroup as model where model.tableProject.projectId"
					+ "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, Id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TableGroup instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TableGroup as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGroupLevel(Object groupLevel) {
		return findByProperty(GROUP_LEVEL, groupLevel);
	}

	public List findByGroupName(Object groupName) {
		return findByProperty(GROUP_NAME, groupName);
	}

	public List findByGroupDescription(Object groupDescription) {
		return findByProperty(GROUP_DESCRIPTION, groupDescription);
	}

	public List findAll() {
		log.debug("finding all TableGroup instances");
		try {
			String queryString = "from TableGroup";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TableGroup merge(TableGroup detachedInstance) {
		log.debug("merging TableGroup instance");
		try {
			TableGroup result = (TableGroup) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TableGroup instance) {
		log.debug("attaching dirty TableGroup instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TableGroup instance) {
		log.debug("attaching clean TableGroup instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}