package com.cog.springcassandra.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cog.springcassandra.data.Product;
import com.cog.springcassandra.model.ProductForm;

@Component
public class ProductFormToProduct implements Converter<ProductForm,Product>{

	@Override
	public Product convert(ProductForm productForm) {
		Product product = new Product();
		if(productForm.getId()!=null && !StringUtils.isEmpty(productForm.getId())) {
		
			product.setId(productForm.getId());
			product.setDetail(productForm.getDetail());
			product.setMainFeatures(productForm.getMainFeatures());
			product.setName(productForm.getName());
			product.setMoreDetail(productForm.getMoreDetail());
			product.setProductId(productForm.getProductId());
			product.setTag(productForm.getTag());
		}
		return product;
	}

}
