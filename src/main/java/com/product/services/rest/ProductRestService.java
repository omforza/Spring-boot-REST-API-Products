package com.product.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.ProductRepository;
import com.product.entities.Product;

/**
 * 
 * REST API to add a product and get products by category 
 * 
 *  @author karimh
 */

@RestController
@RequestMapping(value="/v1/products",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

public class ProductRestService {
	@Autowired
	private ProductRepository productRepository;

	/**
	 * 
	 * Add a product 
	 * 
	 */
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public Product save(@RequestBody Product p){
		
		return productRepository.save(p);
	}

	/**
	 * 
	 * Get products by category  
	 * 
	 */
	@RequestMapping(value="/productsByCategory", method=RequestMethod.GET) 
	public Page<Product> getProducts(@RequestParam(name="category") String category, @RequestParam(name="page") int page, @RequestParam(name="size") int size) { 
		  
		return productRepository.productsByCategory(category, PageRequest.of(page, size, Sort.by("created_at").descending()));
	}
}
