package com.JairoBurgos.ProductCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JairoBurgos.ProductCategories.models.Category;
import com.JairoBurgos.ProductCategories.models.CategoryProduct;
import com.JairoBurgos.ProductCategories.models.Product;
import com.JairoBurgos.ProductCategories.repositories.CategoryProductRepo;
import com.JairoBurgos.ProductCategories.repositories.CategoryRepo;
import com.JairoBurgos.ProductCategories.repositories.ProductRepo;

@Service
public class ProductService {
	
	private final ProductRepo pR;
	private final CategoryRepo cR;
	private final CategoryProductRepo cPR;
	
	public ProductService(ProductRepo pR, CategoryRepo cR, CategoryProductRepo cPR) {
		
		this.pR = pR;
		this.cR = cR;
		this.cPR = cPR;
	}
	
	public Product addProduct(Product product) {
		return pR.save(product);
	}
	
	public Category addCategory(Category category) {
		return cR.save(category);
	}
	
	public CategoryProduct joinCategoryToProduct(CategoryProduct categoryProduct) {
		return cPR.save(categoryProduct);
	}
	
	public Product findProductById(Long id) {
		Optional<Product> check =  pR.findById(id);
		if (check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}
	
	public List<Category> allCatergories(){
		return cR.findAll();
	}
	
	public List<Category> allExcludeCategories(Product product){
		return cR.findByProductsNotContains(product);
	}
	
	public List<Product> allExcludeProducts(Category category){
		return pR.findByCategoriesNotContains(category);
	}
	
	public Category findCategoryById(Long Id) {
		Optional<Category> check = cR.findById(Id);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}

}
