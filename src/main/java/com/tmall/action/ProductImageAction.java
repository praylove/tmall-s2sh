package com.tmall.action;

import java.io.File;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;
import com.tmall.beans.Product;
import com.tmall.beans.ProductImage;
import com.tmall.service.ProductImageService;
import com.tmall.service.ProductService;

public class ProductImageAction extends ActionSupport {
	// private List<ProductImage> singleImgs;
	// private List<ProductImage> detailImgs;
	private ProductImageService imageService;
	private ProductService productService;
	private Product product;
	private ProductImage image;
	private int pid;

	private File filepath;
	private String filepathFileName;
	private String filepathContextType;

	public String add() throws IOException {
		imageService.add(image, pid, filepath);
		return SUCCESS;
	}

	public String delete() {
		System.out.println("image id:" + image.getId());
		imageService.delete(image, pid);

		return SUCCESS;
	}

	public String list() {
		System.out.println("pid=" + pid);
		product = productService.get(pid);

		return SUCCESS;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductImage getImage() {
		return image;
	}

	public void setImage(ProductImage image) {
		this.image = image;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public File getFilepath() {
		return filepath;
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

	public ProductImageService getImageService() {
		return imageService;
	}

	public void setImageService(ProductImageService imageService) {
		this.imageService = imageService;
	}

}
