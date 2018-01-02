package com.tmall.action;

import java.io.File;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;
import com.tmall.beans.Category;
import com.tmall.service.CategoryService;
import com.tmall.util.Page;

@SuppressWarnings("serial")
public class CategoryAction extends ActionSupport {
	private CategoryService categoryService;
	private Category category;
	private Page<Category> page;

	private File filepath;
	private String filepathFileName;
	private String filepathContextType;

	public String add() throws IOException {

		categoryService.add(category, filepath);

		return SUCCESS;
	}

	public String update() throws IOException {

		categoryService.update(category, filepath);

		return SUCCESS;
	}

	public String delete() {

		categoryService.delete(category);

		return SUCCESS;
	}

	public String list() {

		page = categoryService.list(page);

		return SUCCESS;
	}

	public String edit() {
		return SUCCESS;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Page<Category> getPage() {
		return page;
	}

	public void setPage(Page<Category> page) {
		this.page = page;
	}

	public void setFilepath(File filepath) {
		this.filepath = filepath;
	}

	public String getFilepathFileName() {
		return filepathFileName;
	}

	public void setFilepathFileName(String filepathFileName) {
		this.filepathFileName = filepathFileName;
	}

	public String getFilepathContextType() {
		return filepathContextType;
	}

	public void setFilepathContextType(String filepathContextType) {
		this.filepathContextType = filepathContextType;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public File getFilepath() {
		return filepath;
	}

}
