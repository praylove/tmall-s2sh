package com.tmall.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.tmall.beans.Category;
import com.tmall.dao.DAOimpl;
import com.tmall.util.Page;

/**
 * 
 * @author sherl
 *
 */
@Transactional
public class CategoryService {

	private DAOimpl dao;

	public void setDao(DAOimpl dao) {
		this.dao = dao;
	}

	/**
	 * 增加分类
	 * 
	 * @param c
	 * @param filepath
	 * @throws IOException
	 */
	public void add(Category c, File filepath) throws IOException {
		dao.add(c);

		String floderPath = ServletActionContext.getServletContext().getRealPath("/image/category");
		File floder = new File(floderPath);
		if (!floder.exists()) {
			floder.mkdirs();
		}
		File img = new File(floder, c.getId() + ".jpg");

		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(filepath));
			os = new BufferedOutputStream(new FileOutputStream(img));
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) > 0) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}

		}
	}

	/**
	 * 修改分类
	 * 
	 * @param c
	 * @param filepath
	 * @throws IOException
	 */
	public void update(Category c, File filepath) throws IOException {
		dao.update(c);

		String floderPath = ServletActionContext.getServletContext().getRealPath("/image/category");
		File floder = new File(floderPath);
		if (!floder.exists()) {
			floder.mkdirs();
		}
		File img = new File(floder, c.getId() + ".jpg");

		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(filepath));
			os = new BufferedOutputStream(new FileOutputStream(img));
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) > 0) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}

		}
	}

	/**
	 * 删除分类
	 * 
	 * @param c
	 */
	public void delete(Category c) {
		String floderPath = ServletActionContext.getServletContext().getRealPath("/image/category");
		File floder = new File(floderPath);
		File img = new File(floder, c.getId() + ".jpg");
		img.delete();

		dao.delete(c);
	}

	/**
	 * 根据id获取分类
	 * 
	 * @param id
	 * @return
	 */
	public Category get(int id) {
		return (Category) dao.get(Category.class, id);
	}

	/**
	 * 获取所有分类
	 * 
	 * @return
	 */
	public List<Category> list() {
		return (List<Category>) dao.list(Category.class);
	}

	/**
	 * 根据page属性获取当前页面的所有分类
	 * 
	 * @param page
	 * @return
	 */
	public Page<Category> list(Page<Category> page) {
		int beg = (page.getCurrentPage() - 1) * page.getPageSize();
		if (beg < 0) {
			beg = 0;
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
		List<Category> cs = (List<Category>) dao.listForPage(criteria, beg, page.getPageSize());

		page.setTotalCount(dao.getTotal(Category.class));
		page.setParams(cs);

		return page;
	}
}
