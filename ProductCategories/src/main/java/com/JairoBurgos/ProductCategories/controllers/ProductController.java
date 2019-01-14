package com.JairoBurgos.ProductCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JairoBurgos.ProductCategories.models.Category;
import com.JairoBurgos.ProductCategories.models.CategoryProduct;
import com.JairoBurgos.ProductCategories.models.Product;
import com.JairoBurgos.ProductCategories.services.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/")
	public String notHere() {
		return"redirect:/products/new";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "jsp/addProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product")Product product,BindingResult result ) {
		if(result.hasErrors()) {
			return"jsp/addProduct.jsp";
		}
		else {
			productService.addProduct(product);
			return"redirect:/categories/new";
		}
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "jsp/addCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		if(result.hasErrors()) {
			return"jsp/addCategory";
		}
		else {
			productService.addCategory(category);
			return"redirect:/products/new";
		}
	}
	
	@GetMapping("/products/{productId}")
	public String productAddCategory(@ModelAttribute("categoryProduct")CategoryProduct categoryProduct,@PathVariable("productId")Long id,Model model) {
		model.addAttribute("product",productService.findProductById(id));
		model.addAttribute("categories",productService.allExcludeCategories(productService.findProductById(id)));
		return "jsp/productPage.jsp";
		
	}
	
	@PostMapping("/products/{productId}")
	public String addCategoryToProduct(@PathVariable("productId")Long Id,@ModelAttribute("categoryProduct")CategoryProduct categoryProduct, BindingResult result) {
		categoryProduct.setProduct(productService.findProductById(Id));
		productService.joinCategoryToProduct(categoryProduct);
		return"redirect:/products/"+Id;
		
	}
	
	@GetMapping("categories/{categoryId}")
	public String categoryAddProduct(@ModelAttribute("categoryProduct")CategoryProduct categoryProduct,@PathVariable("categoryId")Long id, Model model) {
		model.addAttribute("products",productService.allExcludeProducts(productService.findCategoryById(id)));
		model.addAttribute("category",productService.findCategoryById(id));
		return "jsp/categoryPage.jsp";
	}
	
	@PostMapping("categories/{categoryId}")
	public String addProductToCategory(@ModelAttribute("categoryProduct")CategoryProduct categoryProduct, @PathVariable("categoryId")Long id, Model model) {
		categoryProduct.setCategory(productService.findCategoryById(id));
		productService.joinCategoryToProduct(categoryProduct);
		return"redirect:/categories/"+id;
	}
}
