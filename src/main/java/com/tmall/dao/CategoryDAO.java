package com.tmall.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.transaction.annotation.Transactional;

import com.tmall.beans.Category;

@Transactional
public class CategoryDAO extends DAOimpl {

	@SuppressWarnings("unchecked")
	public List<Category> list() {
		return (List<Category>) getHibernateTemplate().find("from Category");
	}

	@SuppressWarnings("unchecked")
	public List<Category> listForPage(int beg, int len) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
		criteria.addOrder(Order.asc("id"));
		return (List<Category>) getHibernateTemplate().findByCriteria(criteria, beg, len);
	}

	public int getTotal() {

		int total = getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "select count(*) from Category";
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
