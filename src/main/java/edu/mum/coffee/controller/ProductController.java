package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/admin/addProduct", method=RequestMethod.GET)
	public String loadAddProduct( Model model){
		model.addAttribute("product", new Product());
		return "addProduct";
	}

	@RequestMapping(value="/admin/addProduct", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product, Model model){
		productService.save(product);
		return "redirect:/admin/listProduct";
	}
	
	@RequestMapping(value="/admin/listProduct", method=RequestMethod.GET)
	public String listProduct(Model model){
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("products",productList);
		return "productList";
	}
	
	@RequestMapping(value="/deleteProduct/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") int id){
		productService.delete(productService.getProduct(id));
		return "redirect:/admin/listProduct";
	}
	
	@RequestMapping(value="/updateProduct/{id}", method=RequestMethod.GET)
	public String loadUpdateProduct(@PathVariable("id") int id, Model model){
		model.addAttribute("product", productService.getProduct(id));
		return "addProduct";
	}
	
	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.POST)
	public String saveEditedUser(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, 
			@RequestParam(value="id") int id, @ModelAttribute("product") Product product) {
		if (cancel != null) {
			return "redirect:/admin/listProduct";
		} else {
			productService.save(product, id);
		}
		return "redirect:/admin/listProduct";
	}
}
