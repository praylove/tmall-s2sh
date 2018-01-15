package com.tmall.beans;

import java.util.Date;
import java.util.Set;

public class Product {

	private int id;
	private String name;
	private String subTitle;
	private float orignalPrice;
	private float promotePrice;
	private int stock;
	private Date createDate;
	private Category category;
	private ProductImage firstProductImage;
	private Set<ProductImage> productImages;
	private Set<ProductImage> productSingleImages;
	private Set<ProductImage> productDetailsImages;
	private int reviewCount;
	private int saleCount;

	@Override
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public float getOrignalPrice() {
		return orignalPrice;
	}

	public void setOrignalPrice(float orignalPrice) {
		this.orignalPrice = orignalPrice;
	}

	public float getPromotePrice() {
		return promotePrice;
	}

	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductImage getFirstProductImage() {
		if (!productSingleImages.isEmpty())
			firstProductImage = productSingleImages.iterator().next();
		return firstProductImage;
	}

	public void setFirstProductImage(ProductImage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public Set<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public Set<ProductImage> getProductSingleImages() {
		return productSingleImages;
	}

	public void setProductSingleImages(Set<ProductImage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}

	public Set<ProductImage> getProductDetailsImages() {
		return productDetailsImages;
	}

	public void setProductDetailsImages(Set<ProductImage> productDetailsImages) {
		this.productDetailsImages = productDetailsImages;
	}
}