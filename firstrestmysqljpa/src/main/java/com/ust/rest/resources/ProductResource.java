package com.ust.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.resource.Product;
import com.ust.rest.services.ProductService;



@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	@RestController
	@RequestMapping("/product/api.2.0")
	
	public class ProductResource {
		@Autowired
		ProductService service;
		@GetMapping("/retrieve/{productId}")
		
		public Product fetchProduct(@PathVariable long productId) {
			return service.getProduct(productId);
		
	}
		//@CrossOrigin
	@GetMapping
		@RequestMapping("/retrieve/all")
	
		public List<Product> fetchProducts(){
			return service.getProducts();
	}
	@PostMapping
	
	@RequestMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE,
									 produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> addProduct(@RequestBody Product product){
		Exception exception=null;
		Product tempProduct=null;
		try {
			tempProduct=service.add(product);
		}catch(Exception e) {
			exception=e;
		}
		if(tempProduct!=null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(tempProduct);
			}else {return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
			}
	}
	
		@PutMapping
		@RequestMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE,
										 produces=MediaType.APPLICATION_JSON_VALUE)
		public Product updateProduct(@RequestBody Product product) {
			return service.updateProduct(product);
		}
		@DeleteMapping
		@RequestMapping(value="/delete/{productId}")
		public void DeleteProduct(@PathVariable long productId) {
			service.deleteproduct(productId);
		}
		}

