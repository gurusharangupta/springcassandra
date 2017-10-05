package com.cog.springcassandra.dao;

import java.util.List;

import com.cog.springcassandra.data.Product;
import com.cog.springcassandra.model.ProductForm;

public interface ProductDao {

	
	Product createProduct(ProductForm product);

	List<Product> listOfProducts();
	
}
