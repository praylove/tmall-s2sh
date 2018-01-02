package com.tmall.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * DAO的基础实现
 * 
 * @author sherl
 *
 */

public class DAOimpl implements DAO {
	private HibernateTemplate hibernateTemplate; // spring 的 hibernate模板

	@Override
	public void add(Object o) {
		hibernateTemplate.save(o);
	}

	@Override
	public void update(Object o) {
		hibernateTemplate.update(o);
	}

	@Override
	public void delete(Object o) {
		hibernateTemplate.delete(o);
	}

	@Override
	public Object get(Class<?> c, int id) {
		return hibernateTemplate.get(c, id);
	}

	public List<?> list(Class<?> clazz) {
		String hql = "from " + clazz.getName();
		return getHibernateTemplate().find(hql);
	}

	public List<?> list(Class<?> clazz, String condition) {
		String hql = "from " + clazz.getName() + " where " + condition;
		return getHibernateTemplate().find(hql);
	}

	public List<?> listForPage(DetachedCriteria criteria, int beg, int len) {
		criteria.addOrder(Order.asc("id"));
		return getHibernateTemplate().findByCriteria(criteria, beg, len);
	}

	public int getTotal(Class<?> clazz) {

		int total = getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(*) from " + clazz.getName();
				Long l = (Long) session.createQuery(hql).uniqueResult();
				if (l == null) {
					return 0;
				}
				return l.intValue();
			}

		});

		return total;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
