package com.tmall.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.tmall.beans.User;
import com.tmall.dao.DAOimpl;
import com.tmall.util.Page;

@Transactional
public class UserService {
	private DAOimpl dao;

	public void add(User user) {
		dao.add(user);
	}

	public void update(User user) {
		dao.update(user);
	}

	public void delete(User user) {
		dao.delete(user);
	}

	public Page<User> list(Page<User> page) {
		int beg = (page.getCurrentPage() - 1) * page.getPageSize();
		if (beg < 0) {
			beg = 0;
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		List<User> us = (List<User>) dao.listForPage(criteria, beg, page.getPageSize());

		page.setTotalCount(dao.getTotal(User.class));
		page.setParams(us);

		return page;
	}

	public DAOimpl getDao() {
		return dao;
	}

	public void setDao(DAOimpl dao) {
		this.dao = dao;
	}

}
