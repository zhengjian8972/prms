package com.tseg.prms.persistence;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tseg.prms.model.TableGroup;
import com.tseg.prms.model.TableMember;
import com.tseg.prms.model.TableMemberGroup;

/**
 * A data access object (DAO) providing persistence and search support for
 * TableMemberGroup entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tseg.prms.model.TableMemberGroup
 * @author MyEclipse Persistence Tools
 */

public class TableMemberGroupDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TableMemberGroupDAO.class);
	// property constants
	public static final String AUTHORITY = "authority";

	public void save(TableMemberGroup transientInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("saving TableMemberGroup instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		trans.commit();
	}

	public void delete(TableMemberGroup persistentInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("deleting TableMemberGroup instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		trans.commit();
	}

	public TableMemberGroup findById(java.lang.Integer id) {
		log.debug("getting TableMemberGroup instance with id: " + id);
		try {
			TableMemberGroup instance = (TableMemberGroup) getSession().get(
					"com.tseg.prms.model.TableMemberGroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TableMemberGroup instance) {
		log.debug("finding TableMemberGroup instance by example");
		try {
			List results = getSession()
					.createCriteria("com.tseg.prms.model.TableMemberGroup")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TableMemberGroup instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TableMemberGroup as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMember(TableMember tp) {
		return findByMemberId(tp.getMemberId());
	}

	public List<TableMemberGroup> findByMemberId(Integer Id) {
		log.debug("finding TableMemberGroup instance with memberId: MemberId, value: "
				+ Id);
		try {
			String queryString = "from TableMemberGroup as model where model.tableMember.memberId"
					+ "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, Id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGroup(TableGroup tg) {
		return findByGroupId(tg.getGroupId());
	}

	public List findByGroupId(Integer Id) {
		log.debug("finding TableMemberGroup instance with groupId: GroupId, value: "
				+ Id);
		try {
			String queryString = "from TableMemberGroup as model where model.tableGroup.groupId"
					+ "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, Id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAuthority(Object authority) {
		return findByProperty(AUTHORITY, authority);
	}

	public List findAll() {
		log.debug("finding all TableMemberGroup instances");
		try {
			String queryString = "from TableMemberGroup";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TableMemberGroup merge(TableMemberGroup detachedInstance) {
		log.debug("merging TableMemberGroup instance");
		try {
			TableMemberGroup result = (TableMemberGroup) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TableMemberGroup instance) {
		log.debug("attaching dirty TableMemberGroup instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TableMemberGroup instance) {
		log.debug("attaching clean TableMemberGroup instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}