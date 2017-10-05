package com.cog.springcassandra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cog.springcassandra.dao.ProductDao;
import com.cog.springcassandra.data.Product;
import com.cog.springcassandra.model.ProductForm;
import com.cog.springcassandra.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product createProduct(ProductForm product) {
		return productDao.createProduct(product);
		
	}

	@Override
	public List<Product> listAllProducts() {
		return productDao.listOfProducts();
	}
}
