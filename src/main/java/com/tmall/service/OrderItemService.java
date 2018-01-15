package com.tmall.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.tmall.beans.OrderItem;
import com.tmall.dao.DAOimpl;
import com.tmall.util.Page;

public class OrderItemService {
	private DAOimpl dao;

	public void setDao(DAOimpl dao) {
		this.dao = dao;
	}

	public void add(OrderItem oi) {
		dao.add(oi);
	}

	public void update(OrderItem oi) {
		dao.update(oi);
	}

	public void delete(OrderItem oi) {
		dao.delete(oi);
	}

	public void get(int id) {
		dao.get(OrderItem.class, id);
	}

	public List<OrderItem> list(int pid) {
		String condition = "pid = " + pid;
		return (List<OrderItem>) dao.list(getClass(), condition);
	}

	public Page<OrderItem> list(Page<OrderItem> page) {
		int beg = (page.getCurrentPage() - 1) * page.getPageSize();
		if (beg < 0) {
			beg = 0;
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(OrderItem.class);
		List<OrderItem> ois = (List<OrderItem>) dao.listForPage(criteria, beg, page.getPageSize());

		page.setTotalCount(dao.getTotal(OrderItem.class));
		page.setParams(ois);

		return page;
	}

}
