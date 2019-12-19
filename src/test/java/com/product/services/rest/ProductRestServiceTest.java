package com.product.services.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.product.common.AbstractTest;
import com.product.entities.Product;

public class ProductRestServiceTest extends AbstractTest {

	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   @Test
	   public void getProductsList() throws Exception {
	      String uri = "/v1/products/productsByCategory?";
	      
	      MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
	      paramMap.add("category", "apparel");
	      paramMap.add("page", "1");
	      paramMap.add("size", "10");
	      
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).params(paramMap)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Product[] productlist = super.mapFromJson(content, Product[].class);
	      assertTrue(productlist.length > 0);
	   }
	   @Test
	   public void createProduct() throws Exception {
	      String uri = "/v1/products/product";
	      List<String> tags = new ArrayList<>();
	      tags.add("red");
	      tags.add("shirt");
	      tags.add("slim fit");
	      Product product = new Product();
	      product.setName("Red Shirt");
	      product.setDescription("Red hugo boss shirt");
	      product.setBrand("Hugo Boss");
	      product.setTags(tags);
	      product.setCategory("apparel");
	      String inputJson = super.mapToJson(product);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	   }
	
}
