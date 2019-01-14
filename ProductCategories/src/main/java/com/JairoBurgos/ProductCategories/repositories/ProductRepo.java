package com.JairoBurgos.ProductCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.ProductCategories.models.Category;
import com.JairoBurgos.ProductCategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {
	List<Product> findByCategoriesNotContains(Category category);
}
