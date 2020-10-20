package com.example.demo.products;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long>{
	@Query("SELECT p FROM Product p WHERE p.id = :id ")
	Product find(@Param("id")  Long id);
	
	Product update();
}
