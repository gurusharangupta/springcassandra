package com.cog.springcassandra.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cog.springcassandra.converter.ProductFormToProduct;
import com.cog.springcassandra.converter.UserFormToUser;
import com.cog.springcassandra.dao.ProductDao;
import com.cog.springcassandra.data.Product;
import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.ProductForm;
import com.cog.springcassandra.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao{

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Autowired
	private ProductFormToProduct productFormToProduct;
	
	@Override
	public Product createProduct(ProductForm productForm) {
	
		return productRepository.save(productFormToProduct.convert(productForm));
	}

	@Override
	public List<Product> listOfProducts() {
		 return (List<Product>) productRepository.findAll();
	}
	
	

}
