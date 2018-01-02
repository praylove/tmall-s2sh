package com.tmall.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.tmall.beans.Property;
import com.tmall.dao.DAOimpl;
import com.tmall.util.Page;

@Transactional
public class PropertyService {

	private DAOimpl dao;
	private CategoryService categoryService;

	public void add(Property property, int cid) {
		property.setCategory(categoryService.get(cid));
		dao.add(property);
	}

	public void update(Property property, int cid) {
		property.setCategory(categoryService.get(cid));
		dao.update(property);
	}

	public void delete(Property property) {

		dao.delete(property);
	}

	public Property get(int id) {
		return (Property) dao.get(Property.class, id);
	}

	/**
	 * 获取当前分类的所有属性
	 * 
	 * @param int
	 * @return
	 */
	public List<Property> list(int cid) {
		String condition = "cid = " + cid;
		return (List<Property>) dao.list(Property.class, condition);
	}

	/**
	 * 根据page属性获取当前页面的当前分类的所有属性
	 * 
	 * @param page
	 * @param int
	 * @return
	 */
	public Page<Property> list(Page<Property> page, int cid) {
		int beg = (page.getCurrentPage() - 1) * page.getPageSize();
		if (beg < 0) {
			beg = 0;
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(Property.class);
		criteria.add(Restrictions.eq("category.id", cid));
		List<Property> ps = (List<Property>) dao.listForPage(criteria, beg, page.getPageSize());

		page.setTotalCount(dao.getTotal(Property.class));
		page.setParams(ps);

		return page;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public DAOimpl getDao() {
		return dao;
	}

	public void setDao(DAOimpl dao) {
		this.dao = dao;
	}
}
