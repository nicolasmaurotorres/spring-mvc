package com.maro.jpabootstrap;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.maro.domain.Product;
import com.maro.services.ProductService;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProducts();
		
	}

	private void loadProducts() {
		Product p1 = new Product();
		p1.setDescription("p1 desc");
		p1.setPrice(new BigDecimal("12.99"));
		p1.setImageURL("http://example.com/product1");
		Product p2 = new Product();
		p2.setDescription("p2 desc");
		p2.setPrice(new BigDecimal("2.99"));
		p2.setImageURL("http://example.com/product2");
		Product p3 = new Product();
		p3.setDescription("p3 desc");
		p3.setPrice(new BigDecimal("1.99"));
		p3.setImageURL("http://example.com/product3");
		Product p4 = new Product();
		p4.setDescription("p4 desc");
		p4.setPrice(new BigDecimal("0.99"));
		p4.setImageURL("http://example.com/product4");
		productService.saveOrUpdate(p1);
		productService.saveOrUpdate(p2);
		productService.saveOrUpdate(p3);
		productService.saveOrUpdate(p4);
	}
	
	
	
	
	
}
