package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	PersonService personService;
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage() {
		return "login";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	
	@GetMapping({"/dashboard"})
	public String loadDashboard(){
		return "dashboard";
	}
	
	@GetMapping({"/logout"})
	public String getLoggedOut(){
		return "redirect:/";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
//    	model.addAttribute("product", new Product());
//    	model.setViewName("addProduct");
    	return "redirect:/admin/listPerson";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) {
//    	ModelAndView model = new ModelAndView();
//    	model.setViewName("productList");
//    	model.addAttribute("products", productService.findAll());
    	return "redirect:/user/listItems";
    }
    
    @RequestMapping(value="/registerUser", method=RequestMethod.GET)
	public String loadAddPerson( Model model){
		model.addAttribute("person", new Person());
		return "registerPage";
	}
	
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String savePerson(@ModelAttribute Person person, Model model){
		person.setRole("USER");
		person.setEnable("1");
		personService.savePerson(person);
		return "redirect:/";
	}
}
