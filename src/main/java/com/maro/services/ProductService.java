package com.maro.services;

import java.util.List;

import com.maro.domain.Product;

public interface ProductService {
	public List<Product> listAllProducts();
	public Product getProductById(Integer id);
	public Product saveOrUpdateProduct(Product product);
	public void deteleProduct(Integer id);
}
