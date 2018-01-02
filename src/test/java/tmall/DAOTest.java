package tmall;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmall.beans.Category;
import com.tmall.beans.Product;
import com.tmall.beans.Property;
import com.tmall.service.CategoryService;
import com.tmall.service.ProductImageService;
import com.tmall.service.ProductService;
import com.tmall.service.PropertyService;
import com.tmall.util.Page;

public class DAOTest {

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
		imageService.fillImage(p);
		System.out.println(p.getCategory());

	}

}
