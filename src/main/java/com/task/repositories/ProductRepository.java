package com.task.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.task.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	public List<Product> findByCategory(String category);
}
