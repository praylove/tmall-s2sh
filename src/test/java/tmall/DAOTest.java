package tmall;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmall.action.PropertyValueAction;
import com.tmall.action.UserAction;
import com.tmall.beans.Category;
import com.tmall.beans.Order;
import com.tmall.beans.Product;
import com.tmall.beans.Property;
import com.tmall.beans.PropertyValue;
import com.tmall.service.CategoryService;
import com.tmall.service.OrderService;
import com.tmall.service.ProductImageService;
import com.tmall.service.ProductService;
import com.tmall.service.PropertyService;
import com.tmall.service.PropertyValueService;
import com.tmall.util.Page;

public class DAOTest {

	// @Test
	// public void testDAO() {
	// ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
	// DAOimpl dao = (DAOimpl) context.getBean("dao");
	// String hql = "update PropertyValue ptv set ptv.value = 3 where ptv.id = 22";
	// int i = dao.update(hql);
	// System.out.println("update success and i = " + i);
	// }

	@Test
	public void testCategory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		CategoryService categoryService = (CategoryService) context.getBean("categoryService");
		Page<Category> page = (Page<Category>) context.getBean("page1");
		page = categoryService.list(page);
		System.out.println("add success!");
		System.out.println(page.getParams());
	}

	@Test
	public void testProperty() {
		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		PropertyService propertyService = (PropertyService) context.getBean("propertyService");
		Page<Property> page = (Page<Property>) context.getBean("page1");
		List<Property> ps = propertyService.list(3);
		System.out.println("list success!");
		System.out.println(ps.size());
	}

	@Test
	public void testProductImage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		ProductImageService imageService = (ProductImageService) context.getBean("imageService");
		ProductService productService = (ProductService) context.getBean("productService");
		Product p = productService.get(5);
		System.out.println(p.getCategory());

	}

	@Test
	public void testPropertyValue() {
		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		PropertyValueService propertyValueService = (PropertyValueService) context.getBean("propertyValueService");
		// PropertyValue ptv = new PropertyValue();
		// propertyValueService.add(ptv, 6, 6);
		PropertyValueAction propertyValueAction = (PropertyValueAction) context.getBean("propertyValueAction");
		propertyValueAction.setPid(6);
		System.out.println("------------------------");
		if (propertyValueAction.edit() == "success") {
			List<PropertyValue> ptvs = propertyValueAction.getPtvs();
			System.out.println("size=" + ptvs.size());
			for (PropertyValue ptv : ptvs) {
				System.out.println("property: " + ptv.getProperty().getName() + " value " + ptv.getValue());
				ptv.setValue("---");
			}
		}
		propertyValueAction.update();
		System.out.println("------------------------");
		if (propertyValueAction.edit() == "success") {
			List<PropertyValue> ptvs = propertyValueAction.getPtvs();
			System.out.println("size=" + ptvs.size());
			for (PropertyValue ptv : ptvs) {
				System.out.println("property: " + ptv.getProperty().getName() + " value " + ptv.getValue());
			}
		}
	}

	@Test
	public void testUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		UserAction ua = (UserAction) context.getBean("userAction");
		if (ua.list() == "success") {
			System.out.println(ua.getPage().getParams());
		} else {
			System.out.println("action fail");
		}
	}

	@Test
	public void testOrder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		OrderService orderService = (OrderService) context.getBean("orderService");
		Page<Order> page = (Page<Order>) context.getBean("page1");
		page = orderService.list(page);
		System.out.println(page.getParams().size());
	}

	@Test
	public void testSomeCode() {

	}

}
