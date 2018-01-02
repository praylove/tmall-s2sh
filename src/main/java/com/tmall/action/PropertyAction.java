package com.tmall.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tmall.beans.Category;
import com.tmall.beans.Property;
import com.tmall.service.CategoryService;
import com.tmall.service.PropertyService;

@SuppressWarnings("serial")
public class PropertyAction extends ActionSupport {
	private PropertyService propertyService;
	private CategoryService categoryService;
	private Property property;
	private List<Property> pts;
	private int cid;
	private Category c;

	public String add() {

		propertyService.add(property, cid);

		return SUCCESS;
	}

	public String update() {

		propertyService.update(property, cid);

		return SUCCESS;
	}

	public String delete() {

		propertyService.delete(property);

		return SUCCESS;
	}

	public String list() {

		pts = propertyService.list(cid);
		c = categoryService.get(cid);

		return SUCCESS;
	}

	public String edit() {
		return SUCCESS;
	}

	public PropertyService getPropertyService() {
		return propertyService;
	}

	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public List<Property> getPts() {
		return pts;
	}

	public void setPts(List<Property> pts) {
		this.pts = pts;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Category getC() {
		return c;
	}

	public void setC(Category c) {
		this.c = c;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
