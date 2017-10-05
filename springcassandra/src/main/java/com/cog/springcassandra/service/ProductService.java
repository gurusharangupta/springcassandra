package com.cog.springcassandra.service;

import java.util.List;

import com.cog.springcassandra.data.Product;
import com.cog.springcassandra.model.ProductForm;

public interface ProductService {
	
	Product createProduct(ProductForm product);

	List<Product> listAllProducts();

}
