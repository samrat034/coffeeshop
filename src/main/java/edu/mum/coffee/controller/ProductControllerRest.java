package edu.mum.coffee.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductControllerRest {
	
	final static Logger logger = Logger.getLogger(ProductControllerRest.class);
	
	@Autowired
	ProductService productService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> product = productService.findAll();
		if (product.isEmpty()) {
			logger.debug("Product does not exists");
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Product product = productService.getProduct(id);
		if (product == null) {
			logger.debug("Product with id " + id + " does not exists");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Product:: " + product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		productService.save(product);
		logger.debug("Added:: " + product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
		Product existingProduct = productService.getProduct(product.getId());
		if (existingProduct == null) {
			logger.debug("Product with id " + product.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			productService.save(product);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	

}
