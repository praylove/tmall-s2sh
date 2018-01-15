package com.tmall.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tmall.beans.Product;
import com.tmall.beans.Property;
import com.tmall.beans.PropertyValue;
import com.tmall.dao.DAOimpl;

@Transactional
public class PropertyValueService {
	private DAOimpl dao;
	private ProductService productService;
	private PropertyService propertyService;

	public void add(PropertyValue ptv, int pid, int ptid) {
		ptv.setProduct(productService.get(pid));
		ptv.setProperty(propertyService.get(ptid));
		dao.add(ptv);
	}

	// public void update(PropertyValue ptv, int pid, int ptid) {
	// ptv.setProduct(productService.get(pid));
	// ptv.setProperty(propertyService.get(ptid));
	// dao.update(ptv);
	// }

	public void update(List<PropertyValue> ptvs, int pid) {
		List<PropertyValue> old_ptvs = list(pid);
		for (int i = 0; i < ptvs.size(); ++i) {
			PropertyValue old_ptv = old_ptvs.get(i);
			old_ptv.setValue(ptvs.get(i).getValue());
			dao.update(old_ptv);
		}
	}

	public List<PropertyValue> list(int pid) {
		String content = " pid = " + pid;
		return (List<PropertyValue>) dao.list(PropertyValue.class, content);
	}

	public DAOimpl getDao() {
		return dao;
	}

	public void setDao(DAOimpl dao) {
		this.dao = dao;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public PropertyService getPropertyService() {
		return propertyService;
	}

	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	public void fillEmptyPropertyValue(Product p) {
		int pid = p.getId();
		int cid = p.getCategory().getId();
		List<PropertyValue> ptvs = list(pid);
		List<Property> pts = propertyService.list(cid);

		if (ptvs.size() == pts.size()) {
			return;
		}

		for (Property pt : pts) {
			boolean flag = true;
			for (PropertyValue ptv : ptvs) {
				if (ptv.getProperty() != null && ptv.getProperty().getName().equals(pt.getName())) {
					flag = false;
				}
			}
			if (flag) {
				PropertyValue propertyValue = new PropertyValue();
				propertyValue.setValue("");
				add(propertyValue, pid, pt.getId());
			}
		}
	}

}
