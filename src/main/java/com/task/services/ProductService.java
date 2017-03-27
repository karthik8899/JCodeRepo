package com.task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.task.dto.ProductPriceDto;
import com.task.exception.NotFoundBaseException;
import com.task.model.Price;
import com.task.model.Product;
import com.task.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<ProductPriceDto> getAllProducts(){
		return FluentIterable.from(productRepository.findAll()).transform(lengthFunction).toList(); 
	}

//	public ProductPriceDto getProductById(Long id) {
//		return createProductPriceDto(productRepository.findOne(id));
//	}
	
	public ProductPriceDto getProductById(Long id) {
		Product product = productRepository.findOne(id);
		if(product == null) {
			throw new NotFoundBaseException("Product not found with ID: " + id);
		}
		return createProductPriceDto(product);
	}
	
	public void saveOrUpdateProduct(ProductPriceDto productPriceDto){
		productRepository.save(new Product(productPriceDto.getSku(), productPriceDto.getName(), productPriceDto.getCategory(), productPriceDto.getLastUpdatedTmstp(), new Price(productPriceDto.getAmount())));
	}

	public void deleteProduct(Long id){
		productRepository.delete(id);
	}

	public List<ProductPriceDto> getProductsByCategory(String category){
		List<Product> products = productRepository.findByCategory(category);
		if(products == null || products.isEmpty()) {
			throw new NotFoundBaseException("Products not found with Category: " + category);
		}
		return FluentIterable.from(products).transform(lengthFunction).toList(); 
	}
	

	Function<Product, ProductPriceDto> lengthFunction = new Function<Product, ProductPriceDto>() {
		public ProductPriceDto apply(Product input) {
			ProductPriceDto productPriceDto = createProductPriceDto(input);
			return productPriceDto;
		}
	};

	private ProductPriceDto createProductPriceDto(Product productDAO) {
		if(productDAO == null) {
			return null;
		}
		ProductPriceDto productPriceDto = new ProductPriceDto();
		productPriceDto.setCategory(productDAO.getCategory());
		productPriceDto.setLastUpdatedTmstp(productDAO.getLastUpdatedTmstp());
		productPriceDto.setId(productDAO.getId());
		productPriceDto.setName(productDAO.getName());
		productPriceDto.setSku(productDAO.getSku());
		if(productDAO.getPrice() != null) {
			productPriceDto.setAmount(productDAO.getPrice().getAmount());
		}
		return productPriceDto;
	}

}
