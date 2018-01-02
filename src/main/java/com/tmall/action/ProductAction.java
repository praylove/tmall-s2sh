package com.tmall.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tmall.beans.Category;
import com.tmall.beans.Product;
import com.tmall.service.CategoryService;
import com.tmall.service.ProductService;
import com.tmall.util.Page;

public class ProductAction extends ActionSupport {
	private ProductService productService;
	private CategoryService categoryService;
	private Page<Product> page;
	private Product product;
	private Category category;
	private int cid;

	public String add() {

		productService.add(product, cid);

		return SUCCESS;
	}

	public String update() {

		productService.update(product, cid);

		return SUCCESS;
	}

	public String delete() {

		productService.delete(product);

		return SUCCESS;
	}

	public String list() {

		page = productService.list(page, cid);
		category = categoryService.get(cid);

		return SUCCESS;
	}

	public String edit() {
		return SUCCESS;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Page<Product> getPage() {
		return page;
	}

	public void setPage(Page<Product> page) {
		this.page = page;
	}

	public CategoryService getCategoryService() {
		return categoryService;
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

}
