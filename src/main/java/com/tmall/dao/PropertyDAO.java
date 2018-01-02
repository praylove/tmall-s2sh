package com.tmall.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.tmall.beans.Property;

public class PropertyDAO extends DAOimpl {

	@SuppressWarnings("unchecked")
	public List<Property> list(int cid) {
		return (List<Property>) getHibernateTemplate().find("from Property where cid=?", cid);
	}

	@SuppressWarnings("unchecked")
	public List<Property> listForPage(int cid, int beg, int len) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Property.class);
		criteria.add(Restrictions.eq("cid", cid));
		criteria.addOrder(Order.asc("id"));
		return (List<Property>) getHibernateTemplate().findByCriteria(criteria, beg, len);
	}

	public int getTotal() {

		int total = getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(*) from Property";
				Long l = (Long) session.createQuery(hql).uniqueResult();
				if (l == null) {
					return 0;
				}
				return l.intValue();
			}

		});

		return total;
	}

}
