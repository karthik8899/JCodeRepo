package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.ProductPriceDto;
import com.task.exception.BaseException;
import com.task.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="*", method=RequestMethod.GET)
	public String defaultPath(){
		return "REST Path not mapped or configured";
	}
	
	/**
	 * Shows all products with related price info
	 * @return
	 */
	@RequestMapping("/products")
	public List<ProductPriceDto> getProducts(){
		return productService.getAllProducts();
	}

	/**
	 * Returns product and price records based on id
	 * @param id
	 * @return
	 * @throws BaseException 
	 */
	@RequestMapping("/products/{id}")
	public ProductPriceDto getProductsById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	/**
	 * Returns product and price records based on category
	 * @param category
	 * @return
	 * @throws BaseException 
	 */
	@RequestMapping("/products/category/{category}")
	public List<ProductPriceDto> getProductsByCategory(@PathVariable String category) throws BaseException{
	   
		if(org.apache.commons.lang3.StringUtils.isNumeric(category)) {
			throw new BaseException("Category is not String");
		}
		return productService.getProductsByCategory(category);
	}
	
	/**
	 * Persist product and price records
	 * @param productPriceDto
	 */
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public void createProduct(@RequestBody ProductPriceDto productPriceDto){
		productService.saveOrUpdateProduct(productPriceDto);
	}

	/**
	 * Update product and price records
	 * @param productPriceDto
	 */
	@RequestMapping(value="/products", method=RequestMethod.PUT)
	public void updateProduct(@RequestBody ProductPriceDto productPriceDto){
		productService.saveOrUpdateProduct(productPriceDto);
	}
	
	/**
	 * Deletes product and price records based on primary key id
	 * @param id
	 */
	@RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
	}
	
}