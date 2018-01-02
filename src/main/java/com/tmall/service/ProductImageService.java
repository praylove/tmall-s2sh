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
import org.springframework.transaction.annotation.Transactional;

import com.tmall.beans.Product;
import com.tmall.beans.ProductImage;
import com.tmall.dao.DAOimpl;

/**
 * 
 * @author sherl
 *
 */
@Transactional
public class ProductImageService {

	private DAOimpl dao;
	// private Product product;

	private ProductService productService;

	/**
	 * 新增图片
	 * 
	 * @param productImage
	 * @param pid
	 * @param filepath
	 * @throws IOException
	 */
	public void add(ProductImage productImage, int pid, File filepath) throws IOException {
		productImage.setProduct(productService.get(pid));
		dao.add(productImage);

		String floderPath = ServletActionContext.getServletContext().getRealPath("/image/product/" + pid);
		File floder = new File(floderPath);
		if (!floder.exists()) {
			floder.mkdirs();
		}
		File img = new File(floder, productImage.getId() + ".jpg");

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

	// public void update(ProductImage productImage, int pid) {
	// productImage.setProduct(productService.get(pid));
	// dao.update(productImage);
	// }

	/**
	 * 删除图片
	 * 
	 * @param productImage
	 * @param pid
	 */
	public void delete(ProductImage productImage, int pid) {

		String floderPath = ServletActionContext.getServletContext().getRealPath("/image/product/" + pid);
		File floder = new File(floderPath);
		File img = new File(floder, productImage.getId() + ".jpg");
		img.delete();

		productImage = get(productImage.getId());
		dao.delete(productImage);

	}

	public ProductImage get(int id) {
		return (ProductImage) dao.get(ProductImage.class, id);
	}

	/**
	 * 获取当前产品的所有图片
	 * 
	 * @param int
	 * @return
	 */
	public List<ProductImage> list(int pid) {
		String condition = "pid = " + pid;
		return (List<ProductImage>) dao.list(ProductImage.class, condition);
	}

	/**
	 * 获取当前类型的当前产品的所有产品图片
	 * 
	 * @param pid
	 * @param type
	 * @return
	 */
	public List<ProductImage> list(int pid, String type) {
		String condition = "pid = " + pid + " and type = " + type;
		return (List<ProductImage>) dao.list(ProductImage.class, condition);
	}

	/**
	 * 填充产品内的产品图片
	 * 
	 * @param p
	 */
	public void fillImage(Product p) {
		System.out.println(p == null);
		p.setProductImages(list(p.getId()));
		p.setProductDetailsImages(list(p.getId(), "'details'"));
		List<ProductImage> singleImgs = list(p.getId(), "'single'");
		p.setProductSingleImages(singleImgs);
		if (!singleImgs.isEmpty()) {
			p.setFirstProductImage(singleImgs.get(0));
		}
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public DAOimpl getDao() {
		return dao;
	}

	public void setDao(DAOimpl dao) {
		this.dao = dao;
	}
}
