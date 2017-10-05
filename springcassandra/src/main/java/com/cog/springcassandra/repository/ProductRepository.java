package com.cog.springcassandra.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.cog.springcassandra.data.Product;

public interface ProductRepository extends CrudRepository<Product,UUID>{

}
