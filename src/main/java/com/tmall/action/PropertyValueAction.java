package com.tmall.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tmall.beans.Product;
import com.tmall.beans.PropertyValue;
import com.tmall.service.ProductService;
import com.tmall.service.PropertyValueService;

public class PropertyValueAction extends ActionSupport {
	private PropertyValueService propertyValueService;
	private ProductService productService;
	private List<PropertyValue> ptvs;
	private Product p;
	private int pid;

	public String update() {
		System.out.println("isNULL?" + (ptvs == null));
		propertyValueService.update(ptvs, pid);
		return SUCCESS;
	}

	public String edit() {
		p = productService.get(pid);
		propertyValueService.fillEmptyPropertyValue(p);
		ptvs = propertyValueService.list(pid);

		return SUCCESS;
	}

	public PropertyValueService getPropertyValueService() {
		return propertyValueService;
	}

	public void setPropertyValueService(PropertyValueService propertyValueService) {
		this.propertyValueService = propertyValueService;
	}

	public List<PropertyValue> getPtvs() {
		return ptvs;
	}

	public void setPtvs(List<PropertyValue> ptvs) {
		this.ptvs = ptvs;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
