package com.tseg.prms.persistence;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tseg.prms.model.TableProject;

/**
 * A data access object (DAO) providing persistence and search support for
 * TableProject entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tseg.prms.model.TableProject
 * @author MyEclipse Persistence Tools
 */

public class TableProjectDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TableProjectDAO.class);
	// property constants
	public static final String PROJECT_NAME = "projectName";
	public static final String PROJECT_DESCRIPTION = "projectDescription";

	public void save(TableProject transientInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("saving TableProject instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		trans.commit();
	}

	public void delete(TableProject persistentInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("deleting TableProject instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		trans.commit();
	}
	public TableProject findById(java.lang.String id) {
		return findById(Integer.parseInt(id));
	}

	public TableProject findById(java.lang.Integer id) {
		log.debug("getting TableProject instance with id: " + id);
		try {
			TableProject instance = (TableProject) getSession().get(
					"com.tseg.prms.model.TableProject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TableProject instance) {
		log.debug("finding TableProject instance by example");
		try {
			List results = getSession().createCriteria(
					"com.tseg.prms.model.TableProject").add(
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
		log.debug("finding TableProject instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TableProject as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProjectName(Object projectName) {
		return findByProperty(PROJECT_NAME, projectName);
	}

	public List findByProjectDescription(Object projectDescription) {
		return findByProperty(PROJECT_DESCRIPTION, projectDescription);
	}

	public List findAll() {
		log.debug("finding all TableProject instances");
		try {
			String queryString = "from TableProject";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TableProject merge(TableProject detachedInstance) {
		log.debug("merging TableProject instance");
		try {
			TableProject result = (TableProject) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TableProject instance) {
		log.debug("attaching dirty TableProject instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TableProject instance) {
		log.debug("attaching clean TableProject instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}