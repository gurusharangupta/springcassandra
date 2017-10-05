package com.cog.springcassandra.controller;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cog.springcassandra.data.Product;
import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.ProductForm;
import com.cog.springcassandra.model.UserForm;
import com.cog.springcassandra.service.ProductService;
import com.datastax.driver.core.utils.UUIDs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@Component
@Path("/products")
@Api(value = "Product resource", produces = "application/json")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	@ApiOperation(value = "Creates Product resource. Accepts : ProductData as input ", response = Product.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Product resource created", responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Product.class)
			}),
			@ApiResponse(code = 404, message = "Failed to create User resource ")
	})	
	public Response create(ProductForm productForm) {
		UUID id = UUIDs.timeBased();
		productForm.setId(id);
		Product product = productService.createProduct(productForm);
		return Response.status(200).entity(product).build();
	}
	
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@ApiOperation(value = "Lists all the products available ", response = Product.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of All Products", responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve resource", response = Product.class)
			}),
			@ApiResponse(code = 404, message = "Failed to to get list of products")
	})	
	public Response listAllProducts() {
		
		List<Product> productList = productService.listAllProducts();
		return Response.status(200).entity(productList).build();
	}
}
