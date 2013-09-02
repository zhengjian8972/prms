package com.tseg.prms.persistence;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tseg.prms.model.TableMember;

/**
 * A data access object (DAO) providing persistence and search support for
 * TableMember entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tseg.prms.model.TableMember
 * @author MyEclipse Persistence Tools
 */

public class TableMemberDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TableMemberDAO.class);
	// property constants
	public static final String MEMBER_NAME = "memberName";
	public static final String PASSWORD = "password";

	public void save(TableMember transientInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("saving TableMember instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		trans.commit();
	}

	public void delete(TableMember persistentInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("deleting TableMember instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		trans.commit();
	}
	
	public void edit(TableMember persistentInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("edit TableMember instance");
		try {
			getSession().update(persistentInstance);
			log.debug("edit successful");
		} catch (RuntimeException re) {
			log.error("edit failed", re);
			throw re;
		}
		System.out.println("reste ok");
		trans.commit();
	}
	
	public TableMember findById(java.lang.String id) {
		return findById(Integer.parseInt(id));
	}

	public TableMember findById(java.lang.Integer id) {
		log.debug("getting TableMember instance with id: " + id);
		try {
			TableMember instance = (TableMember) getSession().get(
					"com.tseg.prms.model.TableMember", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TableMember instance) {
		log.debug("finding TableMember instance by example");
		try {
			List results = getSession().createCriteria(
					"com.tseg.prms.model.TableMember").add(
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
		log.debug("finding TableMember instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TableMember as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMemberName(Object memberName) {
		return findByProperty(MEMBER_NAME, memberName);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<TableMember> findAll() {
		log.debug("finding all TableMember instances");
		try {
			String queryString = "from TableMember";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TableMember merge(TableMember detachedInstance) {
		log.debug("merging TableMember instance");
		try {
			TableMember result = (TableMember) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TableMember instance) {
		log.debug("attaching dirty TableMember instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TableMember instance) {
		log.debug("attaching clean TableMember instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}