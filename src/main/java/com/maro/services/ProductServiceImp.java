package com.maro.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.maro.domain.Product;

@Service
@Profile("map")
public class ProductServiceImp implements ProductService {
	
	private Map<Integer,Product> products;
	
	public ProductServiceImp() {
		this.loadProducts();
	}
	
	@Override
	public List<Product> listAll() {
		return new ArrayList<>(products.values());
	}
	
	private void loadProducts() {
		products = new HashMap<>();
		Product p1 = new Product();
		p1.setId(1);
		p1.setDescription("p1 desc");
		p1.setPrice(new BigDecimal("12.99"));
		p1.setImageURL("http://example.com/product1");
		Product p2 = new Product();
		p2.setId(2);
		p2.setDescription("p2 desc");
		p2.setPrice(new BigDecimal("2.99"));
		p2.setImageURL("http://example.com/product2");
		Product p3 = new Product();
		p3.setId(3);
		p3.setDescription("p3 desc");
		p3.setPrice(new BigDecimal("1.99"));
		p3.setImageURL("http://example.com/product3");
		Product p4 = new Product();
		p4.setId(4);
		p4.setDescription("p4 desc");
		p4.setPrice(new BigDecimal("0.99"));
		p4.setImageURL("http://example.com/product4");
		products.put(1, p1);
		products.put(2, p2);
		products.put(3, p3);
		products.put(4, p4);
	}

	@Override
	public Product getById(Integer id) {
		return this.products.get(id);
	}

	@Override
	public Product saveOrUpdate(Product product) {
		if (product != null) {
			if (product.getId() == null) {
				product.setId(getNextKey());
			}
			products.put(product.getId(),product);
			return product;
		} else {
			throw new RuntimeException("Product can't be null");
		}
	}
	
	private int getNextKey() {
		return Collections.max(products.keySet())+1;
	}

	@Override
	public void delete(Integer id) {
		products.remove(id);
	}
	
}
