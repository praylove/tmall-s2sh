package com.tmall.service;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.tmall.beans.Product;
import com.tmall.dao.DAOimpl;
import com.tmall.util.Page;

@Transactional
public class ProductService {
	private DAOimpl dao;
	private CategoryService categoryService;
	private ProductImageService imageService;

	public void add(Product product, int cid) {
		product.setCategory(categoryService.get(cid));
		product.setCreateDate(new Date());
		dao.add(product);
	}

	public void update(Product product, int cid) {
		product.setCategory(categoryService.get(cid));
		dao.update(product);
	}

	public void delete(Product product) {

		dao.delete(product);
	}

	public Product get(int id) {
		Product p = (Product) dao.get(Product.class, id);
		return p;
	}

	/**
	 * 获取所有分类
	 * 
	 * @return
	 */
	public List<Product> list(int cid) {
		String condition = "cid = " + cid;
		return (List<Product>) dao.list(Product.class, condition);
	}

	/**
	 * 根据page属性获取当前页面的所有分类
	 * 
	 * @param page
	 * @return
	 */
	public Page<Product> list(Page<Product> page, int cid) {
		int beg = (page.getCurrentPage() - 1) * page.getPageSize();
		if (beg < 0) {
			beg = 0;
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("category.id", cid));
		List<Product> ps = (List<Product>) dao.listForPage(criteria, beg, page.getPageSize());
		for (Product p : ps) {
			imageService.fillImage(p);
		}

		page.setTotalCount(dao.getTotal(Product.class));
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

	public ProductImageService getImageService() {
		return imageService;
	}

	public void setImageService(ProductImageService imageService) {
		this.imageService = imageService;
	}

}
